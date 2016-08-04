package com.agilaapp.demosocialapp;

import android.content.Context;

public interface BasePresenter {
    void create();
    void start();
    void resume();
    void pause();
    void stop();
    void destroy();
    Context getActivityContext();
    Context getApplicationContext();
    void setView(BaseView view);
}
