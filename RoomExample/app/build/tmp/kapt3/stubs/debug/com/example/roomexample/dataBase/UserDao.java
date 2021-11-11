package com.example.roomexample.dataBase;

import java.lang.System;

/**
 * 2. DAO (Data Access Objects) 생성
 *
 * 데이터에 접근할 수 있는 메소드를 정의한 인터페이스
 *
 * insert, update, delete로 데이터베이스가 기본적으로 수행해야하는 메소드를 annotation한다.
 *
 * INSERT INTO [entity] ([col1], [col2], ...) VALUE ([item1], [item2], ...)
 * UPDATE [entity] SET [col] = [item] WHERE [condition]
 * DELETE FROM [entity] WHERE [condition]
 *
 * 추가로 필요한 기능은 @Query annotation으로 선언하고 SQLite를 사용하면 된다.
 */
@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\b\u0010\u0006\u001a\u00020\u0003H\'J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\'J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\nH\'J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005H\'\u00a8\u0006\u0010"}, d2 = {"Lcom/example/roomexample/dataBase/UserDao;", "", "delete", "", "name", "", "deleteAll", "deleteUserByName", "getAll", "", "Lcom/example/roomexample/entity/User;", "insert", "user", "update", "after", "before", "app_debug"})
public abstract interface UserDao {
    
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    public abstract void insert(@org.jetbrains.annotations.NotNull()
    com.example.roomexample.entity.User user);
    
    @androidx.room.Query(value = "UPDATE User SET name = :before WHERE name = :after")
    public abstract void update(@org.jetbrains.annotations.NotNull()
    java.lang.String after, @org.jetbrains.annotations.NotNull()
    java.lang.String before);
    
    @androidx.room.Query(value = "DELETE FROM User WHERE name = :name")
    public abstract void delete(@org.jetbrains.annotations.NotNull()
    java.lang.String name);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM User")
    public abstract java.util.List<com.example.roomexample.entity.User> getAll();
    
    @androidx.room.Query(value = "DELETE FROM User WHERE name = :name")
    public abstract void deleteUserByName(@org.jetbrains.annotations.NotNull()
    java.lang.String name);
    
    @androidx.room.Query(value = "DELETE FROM User")
    public abstract void deleteAll();
}