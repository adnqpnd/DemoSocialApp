package com.agilaapp.demosocialapp;

import android.app.Application;
import android.util.Log;

import com.squareup.leakcanary.LeakCanary;

public class DemoSocialApplication extends Application {
    private final static String TAG = DemoSocialApplication.class.getSimpleName();

    @Override public void onCreate() {
        Log.d(TAG, "onCreate: ");
        super.onCreate();
        LeakCanary.install(this);
    }

}
