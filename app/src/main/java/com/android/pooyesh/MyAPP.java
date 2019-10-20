package com.android.pooyesh;

import android.app.Application;

import com.android.pooyesh.di.Component;
import com.android.pooyesh.di.DaggerComponent;

public class MyAPP extends Application {
    static Component component;

    public static Component getComponent() {
        return component;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerComponent.create();
    }
}
