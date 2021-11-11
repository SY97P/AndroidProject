package com.example.autobahnrestpoints.thread;

import java.lang.System;

/**
 * HttpThread
 *
 * @param route : 도로명
 *
 * 1. json 요청을 원하는 대로 수정
 * 2. json 응답을 받음
 * 3. json 응답으로부터 jsonArray를 추출
 * 4. jsonArray로부터 route와 대조하여 원하는 결과만 추출
 * 5. DEFINE에 RestPointModel 타입의 arrayList 하나를 만들어서 거기다가 추가.
 */
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u000b\u001a\u00020\fH\u0016R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b\u00a8\u0006\r"}, d2 = {"Lcom/example/autobahnrestpoints/thread/HttpThread;", "Ljava/lang/Thread;", "route", "", "date", "hour", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDate", "()Ljava/lang/String;", "getHour", "getRoute", "run", "", "app_debug"})
public final class HttpThread extends java.lang.Thread {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String route = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String date = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String hour = null;
    
    public HttpThread(@org.jetbrains.annotations.NotNull()
    java.lang.String route, @org.jetbrains.annotations.NotNull()
    java.lang.String date, @org.jetbrains.annotations.NotNull()
    java.lang.String hour) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getRoute() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDate() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getHour() {
        return null;
    }
    
    @java.lang.Override()
    public void run() {
    }
}