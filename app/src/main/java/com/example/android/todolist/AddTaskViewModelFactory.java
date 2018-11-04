package com.example.android.todolist;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.example.android.todolist.database.AppDatabase;

public class AddTaskViewModelFactory implements ViewModelProvider.Factory {
  AppDatabase mdb;
  int taskID;

    public AddTaskViewModelFactory(AppDatabase mdb, int taskID) {
        this.mdb = mdb;
        this.taskID = taskID;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new AddTaskViewModel(mdb,taskID);
    }
}
