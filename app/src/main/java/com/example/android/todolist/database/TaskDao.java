package com.example.android.todolist.database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import android.database.Cursor;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

@Dao
public interface TaskDao
{
    @Query("SELECT * FROM TASKS ORDER BY priority")
    public List<TaskEntry> GetAllTaksQuery();
    @Insert
    public long Insert(TaskEntry entry);
    @Update(onConflict = OnConflictStrategy.REPLACE)
    public void Update(TaskEntry taskEntry);
    @Delete
    public void Delete(TaskEntry taskEntry);
}