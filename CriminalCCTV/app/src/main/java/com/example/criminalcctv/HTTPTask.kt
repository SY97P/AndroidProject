package com.example.criminalcctv

import java.net.HttpURLConnection
import java.net.URL

object HTTPTask {

    private object RES {
        val DEV_KEY = "HJGVGr90METjyp2CXImquifQLs4eOdNEkTGf31Da6kqByBCIbkbn8FxO%2BgxrKvAaNzQx7FpjSqNvZCSzBIOY9Q%3D%3D"

        val crimeREQ = "https://api.odcloud.kr/api/2894825/v1/uddi:bbf84340-7640-4c1c-bc43-d18707a78a05_201711241726?page=1&perPage=10&serviceKey=${DEV_KEY}"
        val cctvREQ = "http://api.data.go.kr/openapi/tn_pubr_public_cctv_api?serviceKey=${DEV_KEY}"
    }

    // 전국 모든 CCTV데이터를 json string response로 수용
    fun getCCTVResponse(src : String) {
        val url = URL(RES.cctvREQ)
        val conn : HttpURLConnection = url.openConnection() as HttpURLConnection


    }
}