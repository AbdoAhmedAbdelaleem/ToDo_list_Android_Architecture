package com.example.android.todolist.database;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

@Database(entities = {TaskEntry.class},version = 1,exportSchema = false)
@TypeConverters(DateConverter.class)
public abstract class AppDatabase extends RoomDatabase
{
    public static final Object lock=new Object();
    public static AppDatabase sInstance;
    public  static final String DATABASE_NAME="todolist";
    public static AppDatabase getsInstance(Context context)
    {
        if(sInstance!=null)
            return sInstance;
        synchronized (lock)
        {
            sInstance=Room.databaseBuilder(context,AppDatabase.class,DATABASE_NAME).build();
            return sInstance;
        }
    }
    public abstract TaskDao getTaskDao();
}

