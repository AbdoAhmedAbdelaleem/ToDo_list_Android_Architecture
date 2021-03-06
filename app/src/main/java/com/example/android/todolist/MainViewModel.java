package com.example.android.todolist;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.android.todolist.database.AppDatabase;
import com.example.android.todolist.database.TaskEntry;

import java.util.List;

public class MainViewModel extends AndroidViewModel {
    private LiveData<List<TaskEntry>>tasks;
    public static final String TAG=MainViewModel.class.getSimpleName();
    public MainViewModel(@NonNull Application application) {
        super(application);
        tasks= AppDatabase.getsInstance(this.getApplication()).getTaskDao().GetAllTaksQuery();
        Log.i(TAG, "MainViewModel: Updating Data")  ;
    }

    public LiveData<List<TaskEntry>> getTasks() {
        return tasks;
    }
}
