package com.example.autobahnrestpoints.model;

import java.lang.System;

/**
 * RestPointModel
 *
 * 휴게소 정보 모델
 *
 * @param unitCode      : 휴게소 코드 (entity랑 연동할 때 사용)
 * @param unitName      : 휴게소명
 * @param addr          : 주소
 * @param routeName     : 도로명
 * @param weatherContents   : 기상상태
 * @param tempValue     : 현재 온도
 * @param highestTemp   : 최고온도
 * @param lowestTemp    : 최저온도
 * @param rainfallValue : 강수량
 * @param snowValue     : 적설량
 * @param windValue     : 풍속량
 */
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001a\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u000eJ\u0006\u0010\u001b\u001a\u00020\u0003J\u0006\u0010\u001c\u001a\u00020\u0003R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\t\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\n\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\u000b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0011\u0010\f\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010R\u0011\u0010\r\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0010\u00a8\u0006\u001d"}, d2 = {"Lcom/example/autobahnrestpoints/model/RestPointModel;", "", "unitCode", "", "unitName", "addr", "routeName", "weatherContents", "tempValue", "highestTemp", "lowestTemp", "rainfallValue", "snowValue", "windValue", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAddr", "()Ljava/lang/String;", "getHighestTemp", "getLowestTemp", "getRainfallValue", "getRouteName", "getSnowValue", "getTempValue", "getUnitCode", "getUnitName", "getWeatherContents", "getWindValue", "getDetail", "getTemper", "app_debug"})
public final class RestPointModel {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String unitCode = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String unitName = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String addr = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String routeName = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String weatherContents = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String tempValue = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String highestTemp = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String lowestTemp = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String rainfallValue = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String snowValue = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String windValue = null;
    
    public RestPointModel(@org.jetbrains.annotations.NotNull()
    java.lang.String unitCode, @org.jetbrains.annotations.NotNull()
    java.lang.String unitName, @org.jetbrains.annotations.NotNull()
    java.lang.String addr, @org.jetbrains.annotations.NotNull()
    java.lang.String routeName, @org.jetbrains.annotations.NotNull()
    java.lang.String weatherContents, @org.jetbrains.annotations.NotNull()
    java.lang.String tempValue, @org.jetbrains.annotations.NotNull()
    java.lang.String highestTemp, @org.jetbrains.annotations.NotNull()
    java.lang.String lowestTemp, @org.jetbrains.annotations.NotNull()
    java.lang.String rainfallValue, @org.jetbrains.annotations.NotNull()
    java.lang.String snowValue, @org.jetbrains.annotations.NotNull()
    java.lang.String windValue) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUnitCode() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUnitName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAddr() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getRouteName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getWeatherContents() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTempValue() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getHighestTemp() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getLowestTemp() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getRainfallValue() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSnowValue() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getWindValue() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTemper() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDetail() {
        return null;
    }
}