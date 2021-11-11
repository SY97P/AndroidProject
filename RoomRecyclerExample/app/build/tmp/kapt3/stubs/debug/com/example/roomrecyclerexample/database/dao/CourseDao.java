package com.example.roomrecyclerexample.database.dao;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\'J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\'J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0006H\'J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\'J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000bH\'J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000bH\'\u00a8\u0006\u000f"}, d2 = {"Lcom/example/roomrecyclerexample/database/dao/CourseDao;", "", "deleteAll", "", "deleteById", "courseId", "", "deleteByName", "courseName", "getAll", "", "Lcom/example/roomrecyclerexample/Entity/Course;", "insert", "course", "update", "app_debug"})
public abstract interface CourseDao {
    
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    public abstract void insert(@org.jetbrains.annotations.NotNull()
    com.example.roomrecyclerexample.Entity.Course course);
    
    @androidx.room.Update()
    public abstract void update(@org.jetbrains.annotations.NotNull()
    com.example.roomrecyclerexample.Entity.Course course);
    
    @androidx.room.Query(value = "DELETE FROM Course WHERE courseId = :courseId")
    public abstract void deleteById(@org.jetbrains.annotations.NotNull()
    java.lang.String courseId);
    
    @androidx.room.Query(value = "DELETE FROM Course WHERE courseName = :courseName")
    public abstract void deleteByName(@org.jetbrains.annotations.NotNull()
    java.lang.String courseName);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM Course")
    public abstract java.util.List<com.example.roomrecyclerexample.Entity.Course> getAll();
    
    @androidx.room.Query(value = "DELETE FROM Course")
    public abstract void deleteAll();
}