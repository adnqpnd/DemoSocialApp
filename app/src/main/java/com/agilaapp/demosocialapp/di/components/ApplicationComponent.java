package com.agilaapp.demosocialapp.di.components;

import android.app.Application;

import com.agilaapp.demosocialapp.di.modules.ApplicationModule;
import com.agilaapp.demosocialapp.di.modules.LoginActivityModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component( modules = ApplicationModule.class)
public interface ApplicationComponent {
    Application application();
    LoginActivityComponent getLoginComponent(LoginActivityModule module);
}