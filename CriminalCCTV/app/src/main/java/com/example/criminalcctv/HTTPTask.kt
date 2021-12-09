package com.example.criminalcctv

import android.util.Log
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONArray
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.lang.Exception
import java.lang.StringBuilder
import java.net.HttpURLConnection
import java.net.URL

object HTTPTask {

    private object RES {
        val DEV_KEY = "HJGVGr90METjyp2CXImquifQLs4eOdNEkTGf31Da6kqByBCIbkbn8FxO%2BgxrKvAaNzQx7FpjSqNvZCSzBIOY9Q%3D%3D"

        val crimeREQ = "https://api.odcloud.kr/api/2894825/v1/uddi:bbf84340-7640-4c1c-bc43-d18707a78a05_201711241726?page=1&perPage=50&serviceKey=${DEV_KEY}"
        val cctvREQ = "http://api.data.go.kr/openapi/tn_pubr_public_cctv_api?serviceKey=${DEV_KEY}"
    }

    /**
     * getJsonResponse(String)
     *
     * json 응답을 받아주는 함수
     */
    private fun getJsonResponse(src : String) : String? {
        var response : String? = null
        val url = URL(src)
        val conn: HttpURLConnection = url.openConnection() as HttpURLConnection
        conn.requestMethod = "GET"

        val inputStream: InputStream = conn.inputStream
        val builder = StringBuilder()
        val reader = BufferedReader(InputStreamReader(inputStream, "UTF-8"))
        var line: String?
        while (reader.readLine().also { line = it } != null) {
            builder.append(line)
        }
        response = builder.toString()
        return response
    }

    private fun getJsonArray(jsonResponse : String, keyword : String) : JsonArray {
        return JsonParser.parseString(jsonResponse).asJsonObject.getAsJsonArray(keyword)
    }

    /**
     * parseCityName
     *
     * 2010년. 절도 유형 범죄에 해당하는 jsonArray를 이용.
     * 해당 오픈 api가 제공하는 도시명 리스트 반환.
     */
    private fun parseCityName(jsonObj : JsonObject) : ArrayList<String> {
        var resultList : ArrayList<String> = arrayListOf()
        var input : String = jsonObj.toString()
        var temp = input.split(",")
        for (i in 1 until temp.size) {
            resultList.add(temp[i].split(":").get(0).replace("\"", ""))
        }
        return resultList
    }

    /**
     * parseCityName(jsonObject)
     *
     * crimeType에 해당하는 도시별 범죄 횟수 리스트 반환
     */
    private fun parseCityCrime(jsonArray : JsonArray, crimeType : String) : ArrayList<String> {
        var resultList : ArrayList<String> = arrayListOf()
        for (i in 0 until jsonArray.size()) {
            if (jsonArray[i].asJsonObject.get("2010년").asString == crimeType) {
                var temp = jsonArray[i].asJsonObject.toString().split(",")
                for (i in 1 until temp.size) {
                    resultList.add(temp[i].split(": ").get(1).replace("\"", ""))
                }
                break
            }
        }
        return resultList
    }

    /**
     * getCityNameList()
     *
     * RES.crimeREQ src를 이용하여 해당 오픈api가 정보를 제공하는 지역명을 크롤링
     */
    fun getCityNameList() : ArrayList<String> {
        var cityNameList : ArrayList<String> = arrayListOf()
        try {
            var jsonResponse = getJsonResponse(RES.crimeREQ)
            var jsonArray = getJsonArray(jsonResponse!!, "data")
            cityNameList = parseCityName(jsonArray[0].asJsonObject)
        } catch (e :Exception) {
            e.printStackTrace()
        }
        return cityNameList
    }

    /**
     * getCityCrimeList()
     *
     * RES.crimeREQ src를 이용하여 해당 오픈 api가 제공하는 범죄유형별 도시 범죄회수 리스트 반환
     */
    fun getCityCrimeList(crimeType : String) : ArrayList<String> {
        var cityCrimeList : ArrayList<String> = arrayListOf()
        try {
            var jsonResponse = getJsonResponse(RES.crimeREQ)
            var jsonArray = getJsonArray(jsonResponse!!, "data")
            cityCrimeList = parseCityCrime(jsonArray, crimeType)
        } catch (e : Exception) {
            e.printStackTrace()
        }
        return cityCrimeList
    }

}