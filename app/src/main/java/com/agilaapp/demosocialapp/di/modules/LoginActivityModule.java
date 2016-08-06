package com.agilaapp.demosocialapp.di.modules;

import com.agilaapp.demosocialapp.di.scopes.ActivityScope;
import com.agilaapp.demosocialapp.login.LoginContract;
import com.agilaapp.demosocialapp.login.model.LoginModel;
import com.agilaapp.demosocialapp.login.presenter.LoginPresenter;
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

    @Provides
    @ActivityScope
    LoginContract.Presenter providedPresenterOps() {
        LoginPresenter loginPresenter = new LoginPresenter(loginActivity);
        LoginModel loginModel = new LoginModel(loginPresenter);
        loginPresenter.setModel(loginModel);
        return loginPresenter;
    }

}
