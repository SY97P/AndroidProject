package com.example.criminalcctv

import android.content.res.AssetManager
import android.util.Log
import com.example.criminalcctv.databinding.ActivityLoadingBinding
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

        // 설계 난항으로 src는 미사용.
        // open api에서 추출한 src/main/assets/cctvJson.json 파일을 사용했음.
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
//            Log.d("PSY", "builder.toString() check : ${builder.toString()}")
            Log.d("PSY", "crimeREQ JsonObj : ${JsonParser.parseString(builder.toString()).asJsonObject}")
            if (jsonArray == null) {
                jsonArray = JsonParser.parseString(builder.toString()).asJsonObject.getAsJsonArray("data")
            } else {
                jsonArray.addAll(JsonParser.parseString(builder.toString()).asJsonObject.getAsJsonArray("data"))
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
            val city = temp[i].split(":").get(0).replace("\"", "")
            if (city.contains("서울")) {
                cityNameList.add(city)
            }
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
                if (info.get(0).contains("서울")) {
                    cityCrimeCountList.add(CrimeTypeData(crime, info.get(0).replace("\"", ""),
                        info.get(1).replace("\"", "").toInt()))
                }
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
    fun getCCTVdata(assetManager: AssetManager, jsonKeyWord : String): ArrayList<CCTVData> {
        val cctvDataList : ArrayList<CCTVData> = arrayListOf()
        try {
            val inputStream = assetManager.open("cctvJson.json")
            val builder = StringBuilder()
            val reader = BufferedReader(InputStreamReader(inputStream, "UTF-8"))
            var line : String?
            while (reader.readLine().also { line = it } != null) {
                builder.append(line)
            }

            val jsonObject : JsonObject = JsonParser.parseString(builder.toString()).asJsonObject
            Log.d("PSY", "cctvREQ JsonObj : $jsonObject")
            val jsonData : JsonObject = jsonObject.getAsJsonObject("data")
            val jsonArray : JsonArray = jsonData.getAsJsonArray(jsonKeyWord)
            // val jsonArray : JsonArray = JsonParser.parseString(builder.toString()).asJsonObject.getAsJsonObject("data").getAsJsonArray(jsonKeyWord)
            for (i in 0 until jsonArray.size()) {
                Log.d("PSY", "cctvData loading : $i / ${jsonArray.size()}")
                val item : JsonObject = jsonArray[i].asJsonObject
                val position : LatLng = LatLng(item.get("WGS84위도").asDouble, item.get("WGS84경도").asDouble)
                val location : String = item.get("소재지도로명주소").asString
                val info : String = item.get("관리기관전화번호").asString
                cctvDataList.add(CCTVData(position, location, info))
            }
            inputStream.close()
        } catch (e : Exception) {
            e.printStackTrace()
        }
        return cctvDataList
    }
}