package com.example.vaccinationcenter.database.dao;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\b\u0010\u0006\u001a\u00020\u0003H\'J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\'J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\tH\'\u00a8\u0006\f"}, d2 = {"Lcom/example/vaccinationcenter/database/dao/SelectedDao;", "", "delete", "", "id", "", "deleteAll", "getAll", "", "Lcom/example/vaccinationcenter/database/entity/Selected;", "insert", "selected", "app_debug"})
public abstract interface SelectedDao {
    
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    public abstract void insert(@org.jetbrains.annotations.NotNull()
    com.example.vaccinationcenter.database.entity.Selected selected);
    
    @androidx.room.Query(value = "DELETE FROM Selected WHERE id = :id")
    public abstract void delete(int id);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM Selected")
    public abstract java.util.List<com.example.vaccinationcenter.database.entity.Selected> getAll();
    
    @androidx.room.Query(value = "DELETE FROM Selected")
    public abstract void deleteAll();
}