package com.agilaapp.demosocialapp;

import android.content.Context;

import java.util.HashMap;
import java.util.Map;

public class PresenterHolder {
    private static PresenterHolder sPresenterHolder = null;
    private Context mContext;
    private Map<Class, BasePresenter> presenterMap;

    public static PresenterHolder getInstance(Context context){
        if(sPresenterHolder == null){
            sPresenterHolder = new PresenterHolder(context);
        }

        return sPresenterHolder;
    }

    private PresenterHolder(Context context){
        mContext = context;
        presenterMap = new HashMap<>();
    }

    public void putPresenter(Class c, BasePresenter p) {
        presenterMap.put(c, p);
    }

    public <T extends BasePresenter> T getPresenter(Class<T> c) {
        return (T) presenterMap.get(c);
    }

    public void remove(Class c) {
        presenterMap.remove(c);
    }
}
