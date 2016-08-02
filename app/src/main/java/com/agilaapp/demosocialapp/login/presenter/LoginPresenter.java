package com.agilaapp.demosocialapp.login.presenter;

import android.content.Context;

import com.agilaapp.demosocialapp.login.LoginContract;
import com.agilaapp.demosocialapp.UserSessionManager;

import java.lang.ref.WeakReference;


public class LoginPresenter implements LoginContract.Presenter {

    private WeakReference<LoginContract.View> mLoginView;
    private LoginContract.Model mLoginModel;

    public LoginPresenter(LoginContract.View loginView) {
        mLoginView = new WeakReference<>(loginView);
    }

    public void validateInputAndLogin(String username, String password) {
        mLoginModel.login(username,password);
    }

    @Override
    public void create() {

    }

    @Override
    public void start() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void destroy() {

    }

    private LoginContract.View getView() throws NullPointerException{
        if ( mLoginView != null )
            return mLoginView.get();
        else
            throw new NullPointerException("View is unavailable");
    }


    @Override
    public Context getActivityContext() {
        return getView().getActivityContext();
    }

    @Override
    public Context getApplicationContext() {
        return getView().getApplicationContext();
    }


    public void setView(LoginContract.View loginView) {

    }

    public void setModel(LoginContract.Model loginModel){
        mLoginModel = loginModel;
    }
}
