package com.agilaapp.demosocialapp;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.agilaapp.demosocialapp.di.components.ApplicationComponent;
import com.agilaapp.demosocialapp.di.components.DaggerApplicationComponent;
import com.agilaapp.demosocialapp.di.modules.ApplicationModule;
import com.squareup.leakcanary.LeakCanary;

public class DemoSocialApplication extends Application {
    private final static String TAG = DemoSocialApplication.class.getSimpleName();
    private ApplicationComponent mApplicationComponent;

    public static DemoSocialApplication get(Context context) {
        return (DemoSocialApplication) context.getApplicationContext();
    }

    @Override public void onCreate() {
        Log.d(TAG, "onCreate: ");
        super.onCreate();
        LeakCanary.install(this);
        initApplicationComponent();
    }

    private void initApplicationComponent(){
        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }

}
