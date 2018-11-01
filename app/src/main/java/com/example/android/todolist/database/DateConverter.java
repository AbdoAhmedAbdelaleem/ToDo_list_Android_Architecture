package com.example.android.todolist.database;

import android.arch.persistence.room.TypeConverter;

import java.util.Date;

public class DateConverter
{
    @TypeConverter
    public Date toDate(long time)
    {
        return new Date(time);
    }
    @TypeConverter
    public static long toTimeStamp(Date date)
    {
        return date.getTime();
    }
}
