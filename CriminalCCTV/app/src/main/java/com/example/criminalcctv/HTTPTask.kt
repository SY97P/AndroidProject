package com.example.criminalcctv

import android.util.Log
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
        val AUTH_KEY = "HJGVGr90METjyp2CXImquifQLs4eOdNEkTGf31Da6kqByBCIbkbn8FxO%2BgxrKvAaNzQx7FpjSqNvZCSzBIOY9Q%3D%3D"
        val CRIME_REQ = "https://api.odcloud.kr/api/2894825/v1/uddi:bbf84340-7640-4c1c-bc43-d18707a78a05_201711241726?page=1&perPage=50&returnType=JSON&serviceKey=$AUTH_KEY"
        val CCTV_REQ = ""
    }

    private fun getJsonArray(src : String) : JsonArray? {
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
            jsonArray = JsonParser.parseString(builder.toString()).asJsonObject.getAsJsonArray("data")
        } catch (e : Exception) {
            e.printStackTrace()
        }
        return jsonArray
    }

    fun getCityName() : ArrayList<String> {
        val cityNameList : ArrayList<String> = arrayListOf()
        val cityNameRes : String = getJsonArray(RES.CRIME_REQ)!!.get(0).toString()
        val temp = cityNameRes.split(",")
        for (i in 1 until temp.size) {
            cityNameList.add(temp[i].split(": ").get(0).replace("\"", ""))
        }
        return cityNameList
    }

    fun getCityCrimeCount(index : Int) : ArrayList<CrimeTypeData> {
        val cityCrimeCountList : ArrayList<CrimeTypeData> = arrayListOf()
        val cityCrimeRes : String = getJsonArray(RES.CRIME_REQ)!!.get(index).toString()
        val temp = cityCrimeRes.split(",")
        val crime = temp[0].split(": ").get(0).split(":").get(1).replace("\"", "").trim()
        for (i in 1 until temp.size) {
            val info = temp[i].split(": ")
            try {
                cityCrimeCountList.add(CrimeTypeData(crime, info.get(0).replace("\"", ""),
                    info.get(1).replace("\"", "").toInt()))
            } catch (e : Exception) {
                continue
            }
        }
        return cityCrimeCountList
    }
}