package com.agilaapp.demosocialapp.login.model;

import android.nfc.Tag;
import android.util.Log;

import com.agilaapp.demosocialapp.login.LoginContract;

public class LoginModel implements LoginContract.Model {
    private static final String TAG = LoginModel.class.getSimpleName();
    private LoginContract.Presenter mLoginPresenter;

    public LoginModel(LoginContract.Presenter loginPresenter) {
        mLoginPresenter = loginPresenter;
    }

    public void login(String username, String password) {
        Log.d(TAG, "login: " + username + " " + password);
    }
}
