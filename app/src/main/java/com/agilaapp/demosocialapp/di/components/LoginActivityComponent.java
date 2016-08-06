package com.agilaapp.demosocialapp.di.components;

import com.agilaapp.demosocialapp.di.modules.LoginActivityModule;
import com.agilaapp.demosocialapp.di.scopes.ActivityScope;
import com.agilaapp.demosocialapp.login.view.activity.LoginActivity;

import dagger.Subcomponent;

@ActivityScope
@Subcomponent(modules = LoginActivityModule.class)
public interface LoginActivityComponent {
    LoginActivity inject(LoginActivity loginActivity);
}
