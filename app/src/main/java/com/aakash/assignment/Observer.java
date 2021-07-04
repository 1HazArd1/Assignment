package com.aakash.assignment;

import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

public class Observer implements LifecycleObserver {
    //observer class for the lifecycle

    public static final String Tag="ActivityLifecycle";

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public  void onCreateEvent(){
        Log.i(Tag,"OBSERVER: Activity Created");
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStartEvent(){
        Log.i(Tag,"OBSERVER: Activity started");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResumeEvent(){
        Log.i(Tag,"OBSERVER: Activity Resumed");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onStartPause(){
        Log.i(Tag,"OBSERVER: Activity paused");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStopEvent(){
        Log.i(Tag,"OBSERVER: Activity stoped");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroyedEvent(){
        Log.i(Tag,"OBSERVER: Activity destroyed");
    }
}
