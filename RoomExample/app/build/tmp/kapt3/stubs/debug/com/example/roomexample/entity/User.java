package com.example.roomexample.entity;

import java.lang.System;

/**
 * 1. Entity 생성
 *
 * 논리적 데이터베이스의 개체.
 * 물리적 데이터베이스의 테이블.
 *
 * 모든 entity는 하나의 Primarykey가 있어야 한다.
 */
@androidx.room.Entity(tableName = "User")
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0007J\t\u0010\u0012\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0013\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0003H\u00c6\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001a\u001a\u00020\u001bH\u00d6\u0001J\t\u0010\u001c\u001a\u00020\u0003H\u00d6\u0001R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000b\u00a8\u0006\u001d"}, d2 = {"Lcom/example/roomexample/entity/User;", "", "id", "", "name", "age", "phone", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAge", "()Ljava/lang/String;", "setAge", "(Ljava/lang/String;)V", "getId", "setId", "getName", "setName", "getPhone", "setPhone", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
public final class User {
    @org.jetbrains.annotations.NotNull()
    @androidx.room.PrimaryKey()
    private java.lang.String id;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String name;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String age;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String phone;
    
    /**
     * 1. Entity 생성
     *
     * 논리적 데이터베이스의 개체.
     * 물리적 데이터베이스의 테이블.
     *
     * 모든 entity는 하나의 Primarykey가 있어야 한다.
     */
    @org.jetbrains.annotations.NotNull()
    public final com.example.roomexample.entity.User copy(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String age, @org.jetbrains.annotations.NotNull()
    java.lang.String phone) {
        return null;
    }
    
    /**
     * 1. Entity 생성
     *
     * 논리적 데이터베이스의 개체.
     * 물리적 데이터베이스의 테이블.
     *
     * 모든 entity는 하나의 Primarykey가 있어야 한다.
     */
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object p0) {
        return false;
    }
    
    /**
     * 1. Entity 생성
     *
     * 논리적 데이터베이스의 개체.
     * 물리적 데이터베이스의 테이블.
     *
     * 모든 entity는 하나의 Primarykey가 있어야 한다.
     */
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    /**
     * 1. Entity 생성
     *
     * 논리적 데이터베이스의 개체.
     * 물리적 데이터베이스의 테이블.
     *
     * 모든 entity는 하나의 Primarykey가 있어야 한다.
     */
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    public User(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String age, @org.jetbrains.annotations.NotNull()
    java.lang.String phone) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getId() {
        return null;
    }
    
    public final void setId(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getName() {
        return null;
    }
    
    public final void setName(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAge() {
        return null;
    }
    
    public final void setAge(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPhone() {
        return null;
    }
    
    public final void setPhone(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
}