package com.example.android.todolist;

import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.example.android.todolist.database.AppDatabase;
import com.example.android.todolist.database.TaskEntry;

public class AddTaskViewModel extends ViewModel
{
    AppDatabase mdb;
    int taskID;
    LiveData<TaskEntry>taskEntryLiveData;

    public AddTaskViewModel(AppDatabase mdb, int taskID) {
        this.mdb = mdb;
        this.taskID = taskID;
        mdb.getTaskDao().GetTaskByID(taskID);
    }

    public LiveData<TaskEntry> getTaskEntryLiveData() {
        return taskEntryLiveData;
    }
}
