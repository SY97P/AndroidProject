package com.example.criminalcctv

import android.util.Log
import com.google.android.gms.maps.model.LatLng
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Exception
import java.lang.StringBuilder
import java.net.HttpURLConnection
import java.net.URL
import java.nio.Buffer

object HTTPTask {

    private object RES {
        val PAGE_NO : Int = 0
        val NUM_OF_ROWS : Int = 100
        val AUTH_KEY = "HJGVGr90METjyp2CXImquifQLs4eOdNEkTGf31Da6kqByBCIbkbn8FxO%2BgxrKvAaNzQx7FpjSqNvZCSzBIOY9Q%3D%3D"
        val CRIME_REQ = "https://api.odcloud.kr/api/2894825/v1/uddi:bbf84340-7640-4c1c-bc43-d18707a78a05_201711241726?page=1&perPage=50&returnType=JSON&serviceKey=$AUTH_KEY"
        val CCTV_REQ = "http://api.data.go.kr/openapi/tn_pubr_public_cctv_api?serviceKey=$AUTH_KEY&pageNo=$PAGE_NO&numOfRows=$NUM_OF_ROWS&type=json&institutionNm=서울특별시%20중구"
    }

    private fun getJsonArray(src : String, isCCTV : Boolean) : JsonArray? {
        var jsonArray : JsonArray? = null
        try {
            val url = URL(src)
            val conn : HttpURLConnection = url.openConnection() as HttpURLConnection
            val inputStream = conn.inputStream
            val builder = StringBuilder()
            val reader = BufferedReader(InputStreamReader(inputStream, "UTF-8"))
            var line : String?
            while (reader.readLine().also { line = it } != null) {
                builder.append(line)
            }
            if (jsonArray == null) {
                when (isCCTV) {
                    false -> jsonArray = JsonParser.parseString(builder.toString()).asJsonObject.getAsJsonArray("data")
                    else -> {
                        jsonArray = JsonParser.parseString(builder.toString()).asJsonObject.getAsJsonObject("response").getAsJsonObject("body").getAsJsonArray("items")
                    }
                }

            } else {
                when (isCCTV) {
                    false -> jsonArray.addAll(JsonParser.parseString(builder.toString()).asJsonObject.getAsJsonArray("data"))
                    else -> {
                        jsonArray.addAll(
                            JsonParser.parseString(builder.toString()).asJsonObject.getAsJsonObject("response").getAsJsonObject("body").getAsJsonArray("items")
                        )
                    }
                }

            }
        } catch (e : Exception) {
            e.printStackTrace()
        }
        return jsonArray
    }

    fun getCityName() : ArrayList<String> {
        val cityNameList : ArrayList<String> = arrayListOf()
        val cityNameRes : String = getJsonArray(RES.CRIME_REQ, isCCTV = false)!!.get(0).toString()
        val temp = cityNameRes.split(",")
        for (i in 1 until temp.size) {
            cityNameList.add(temp[i].split(":").get(0).replace("\"", ""))
        }
        return cityNameList
    }

    fun getCityCrimeCount(index : Int) : ArrayList<CrimeTypeData> {
        val cityCrimeCountList : ArrayList<CrimeTypeData> = arrayListOf()
        val cityCrimeRes : String = getJsonArray(RES.CRIME_REQ, isCCTV = false)!!.get(index).toString()
        val temp = cityCrimeRes.split(",")
        val crime = temp[0].split(":").get(1).replace("\"", "").replace("}", "").trim()
        for (i in 1 until temp.size) {
            val info = temp[i].split(":")
            try {
                cityCrimeCountList.add(CrimeTypeData(crime, info.get(0).replace("\"", ""),
                    info.get(1).replace("\"", "").toInt()))
            } catch (e : Exception) {
                continue
            }
        }
        return cityCrimeCountList
    }

    /**
     * getCCTVdata(ArrayList<String>)
     *
     * lv2List에 있는 String을 cctvREQ에 파라미터로 추가하여 검색
     * 여러 번의 검색이 필요하므로 response를 배열로 받는 것이 좋아보임.
     */
    fun getCCTVdata(lv2List : ArrayList<String>): ArrayList<CCTVData> {
        var result : ArrayList<CCTVData> = arrayListOf()
        var responseArray : JsonArray? = null
        for (i in 0 until lv2List.size) {
            var srcCCTV : String = RES.CCTV_REQ
            srcCCTV = srcCCTV.run {
                replace("서울특별시%20중구", "${lv2List[i].replace(" ", "%20")}")
            }
            Log.d("PSY", "CCTV_REQ : ${RES.CCTV_REQ}")
            Log.d("PSY", "srcCCTV : $srcCCTV")
            if (responseArray == null) {
                responseArray = getJsonArray(srcCCTV, isCCTV = true)
            } else {
                responseArray.addAll(getJsonArray(srcCCTV, isCCTV = true))
            }
        }
        try {
            //Log.d("PSY", "responseArray size : ${responseArray!!.size()}")
            for (i in 0 until responseArray!!.size()) {
                //Log.d("PSY", "reponseArray loading : $i / ${responseArray.size()}")
                var item : JsonObject = responseArray.get(i).asJsonObject
                //Log.d("PSY", "item : $item")
                var position: LatLng = LatLng(
                    item.get("latitude").asDouble,
                    item.get("longitude").asDouble
                )
                //Log.d("PSY", "position : $position")
                var location: String = item.get("rdnmadr").asString
                var info: String = item.get("phoneNumber").asString
                Log.d("PSY", "item -> position : $position, location : $location, info : $info")
                result.add(CCTVData(position, location, info))
            }
        } catch (e : Exception) {
            e.printStackTrace()
        }
        return result
    }
}