package com.example.vaccinationcenter.network;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0013\u001a\u00020\u0004J\u000e\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0004J \u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000R!\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u001b"}, d2 = {"Lcom/example/vaccinationcenter/network/HttpTask;", "", "()V", "DEVELOP_KEY", "", "REQ_MESSAGE", "SERVICE_KEY", "TOTAL_COUNT", "", "searchList", "Ljava/util/ArrayList;", "Lcom/google/gson/JsonObject;", "Lkotlin/collections/ArrayList;", "getSearchList", "()Ljava/util/ArrayList;", "getJsonArray", "Lcom/google/gson/JsonArray;", "jsonRes", "getResponse", "src", "getUrl", "pageIndex", "setWantedItem", "", "jsonArray", "stateName", "cityName", "app_debug"})
public final class HttpTask {
    @org.jetbrains.annotations.NotNull()
    public static final com.example.vaccinationcenter.network.HttpTask INSTANCE = null;
    private static final java.lang.String DEVELOP_KEY = "zua1imi%2F74fkzPmdzhWhKPCRxrtbYbDwrvZO4H11utjZs7AgGAqQBvLQeChxhoPptfpFILnup3yobdLtC1Nmzg%3D%3D";
    private static final java.lang.String SERVICE_KEY = "data-portal-test-key";
    private static final java.lang.String REQ_MESSAGE = "https://api.odcloud.kr/api/15077586/v1/centers?page=1&perPage=10&serviceKey=zua1imi%2F74fkzPmdzhWhKPCRxrtbYbDwrvZO4H11utjZs7AgGAqQBvLQeChxhoPptfpFILnup3yobdLtC1Nmzg%3D%3D";
    public static final int TOTAL_COUNT = 284;
    @org.jetbrains.annotations.NotNull()
    private static final java.util.ArrayList<com.google.gson.JsonObject> searchList = null;
    
    private HttpTask() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.google.gson.JsonObject> getSearchList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUrl(@org.jetbrains.annotations.NotNull()
    java.lang.String pageIndex) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getResponse(@org.jetbrains.annotations.NotNull()
    java.lang.String src) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.google.gson.JsonArray getJsonArray(@org.jetbrains.annotations.Nullable()
    java.lang.String jsonRes) {
        return null;
    }
    
    public final void setWantedItem(@org.jetbrains.annotations.Nullable()
    com.google.gson.JsonArray jsonArray, @org.jetbrains.annotations.NotNull()
    java.lang.String stateName, @org.jetbrains.annotations.NotNull()
    java.lang.String cityName) {
    }
}