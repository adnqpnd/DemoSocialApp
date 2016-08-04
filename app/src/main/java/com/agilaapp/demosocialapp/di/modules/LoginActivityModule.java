package com.agilaapp.demosocialapp.di.modules;

import com.agilaapp.demosocialapp.di.scopes.ActivityScope;
import com.agilaapp.demosocialapp.login.view.activity.LoginActivity;

import dagger.Module;
import dagger.Provides;

@Module
public class LoginActivityModule {

    private LoginActivity loginActivity;

    public LoginActivityModule(LoginActivity loginActivity) {
        this.loginActivity = loginActivity;
    }

    @Provides
    @ActivityScope
    LoginActivity providesLoginActivity(){
        return loginActivity;
    }


}
