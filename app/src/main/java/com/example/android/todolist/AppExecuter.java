package com.example.android.todolist;

import android.os.Looper;
import android.support.annotation.NonNull;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Handler;

public class AppExecuter
{
    private static final Object lock=new Object();

    public AppExecuter(Executor diskIO, Executor mainThread, Executor networkIO) {
        this.diskIO = diskIO;
        this.mainThread = mainThread;
        this.networkIO = networkIO;
    }
    public   Executor diskIO;
    public  Executor mainThread;
    public  Executor networkIO;
    private static AppExecuter sInstance;



    public static AppExecuter getsInstance()
    {
        if(sInstance==null)
        {
            synchronized (lock)
            {
                sInstance=new AppExecuter(Executors.newSingleThreadExecutor(),new MainThreadExecutor(),Executors.newFixedThreadPool(3));
            }
        }
        return sInstance;
    }
    private static class MainThreadExecutor implements Executor
    {
    private android.os.Handler mainThreadHandler = new android.os.Handler(Looper.getMainLooper());

        @Override
        public void execute(@NonNull Runnable command) {
            mainThreadHandler.post(command);
        }
    }
}
