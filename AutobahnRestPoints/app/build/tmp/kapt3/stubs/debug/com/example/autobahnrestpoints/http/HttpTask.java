package com.example.autobahnrestpoints.http;

import java.lang.System;

/**
 * @property AUTH_KEY
 * @property REQ_MESSAGE
 *
 * @function getUrl         : str(default) -> str(wanted)
 * @function getResponse    : str -> json Object
 */
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0012\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000e\u001a\u00020\u0004J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\tJ\u0016\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/example/autobahnrestpoints/http/HttpTask;", "", "()V", "AUTH_KEY", "", "REQ_MESSAGE", "addModelList", "", "jsonObject", "Lorg/json/JSONObject;", "getJsonArray", "Lorg/json/JSONArray;", "jsonRes", "getResponse", "src", "getRouteName", "getUrl", "date", "hour", "app_debug"})
public final class HttpTask {
    @org.jetbrains.annotations.NotNull()
    public static final com.example.autobahnrestpoints.http.HttpTask INSTANCE = null;
    private static final java.lang.String AUTH_KEY = "5986964392";
    private static final java.lang.String REQ_MESSAGE = "http://data.ex.co.kr/openapi/restinfo/restWeatherList?key=5986964392&type=json&sdate=20210101&stdHour=10";
    
    private HttpTask() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUrl(@org.jetbrains.annotations.NotNull()
    java.lang.String date, @org.jetbrains.annotations.NotNull()
    java.lang.String hour) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getResponse(@org.jetbrains.annotations.NotNull()
    java.lang.String src) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final org.json.JSONArray getJsonArray(@org.jetbrains.annotations.Nullable()
    java.lang.String jsonRes) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getRouteName(@org.jetbrains.annotations.NotNull()
    org.json.JSONObject jsonObject) {
        return null;
    }
    
    public final void addModelList(@org.jetbrains.annotations.NotNull()
    org.json.JSONObject jsonObject) {
    }
}