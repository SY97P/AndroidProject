package com.example.roomrecyclerexample.rest;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rJ\u0010\u0010\u000e\u001a\u00020\r2\b\u0010\n\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0010\u001a\u00020\u0004J\u001e\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u0012j\b\u0012\u0004\u0012\u00020\u0013`\u00142\u0006\u0010\f\u001a\u00020\rJ\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0016\u001a\u00020\u0004H\u0002J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u0018"}, d2 = {"Lcom/example/roomrecyclerexample/rest/HttpTask;", "", "()V", "DEVELOP_KEY", "", "REQ_MESSAGE", "getREQ_MESSAGE", "()Ljava/lang/String;", "checkNoData", "", "response", "getCourseName", "dataArray", "Lcom/google/gson/JsonArray;", "getDataArray", "getJsonResponse", "courseNum", "getModelList", "Ljava/util/ArrayList;", "Lcom/example/roomrecyclerexample/model/CourseModel;", "Lkotlin/collections/ArrayList;", "getUrlorNull", "src", "replaceUrl", "app_debug"})
public final class HttpTask {
    @org.jetbrains.annotations.NotNull()
    public static final com.example.roomrecyclerexample.rest.HttpTask INSTANCE = null;
    private static final java.lang.String DEVELOP_KEY = "zua1imi%2F74fkzPmdzhWhKPCRxrtbYbDwrvZO4H11utjZs7AgGAqQBvLQeChxhoPptfpFILnup3yobdLtC1Nmzg%3D%3D";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String REQ_MESSAGE = "http://apis.data.go.kr/1360000/TourStnInfoService/getTourStnVilageFcst?serviceKey=zua1imi%2F74fkzPmdzhWhKPCRxrtbYbDwrvZO4H11utjZs7AgGAqQBvLQeChxhoPptfpFILnup3yobdLtC1Nmzg%3D%3D&pageNo=1&numOfRows=10&dataType=JSON&CURRENT_DATE=2019122010&HOUR=24&COURSE_ID=1";
    
    private HttpTask() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getREQ_MESSAGE() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCourseName(@org.jetbrains.annotations.NotNull()
    com.google.gson.JsonArray dataArray) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.example.roomrecyclerexample.model.CourseModel> getModelList(@org.jetbrains.annotations.NotNull()
    com.google.gson.JsonArray dataArray) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.gson.JsonArray getDataArray(@org.jetbrains.annotations.Nullable()
    java.lang.String response) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getJsonResponse(@org.jetbrains.annotations.NotNull()
    java.lang.String courseNum) {
        return null;
    }
    
    public final boolean checkNoData(@org.jetbrains.annotations.Nullable()
    java.lang.String response) {
        return false;
    }
    
    private final java.lang.String getUrlorNull(java.lang.String src) {
        return null;
    }
    
    private final java.lang.String replaceUrl(java.lang.String courseNum) {
        return null;
    }
}