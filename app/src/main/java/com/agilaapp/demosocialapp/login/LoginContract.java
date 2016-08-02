package com.agilaapp.demosocialapp.login;

import android.content.Context;

import com.agilaapp.demosocialapp.BasePresenter;
import com.agilaapp.demosocialapp.BaseView;

public class LoginContract {
    public interface View extends BaseView {
        void showLoadingIndicator();
        void hideLoadingIndicator();
        void showLoginButton();
        void hideLoginButton();
        void showLoginFailedErrorMessage();
        void hideLoginFailedErrorMessage();
        void navigateToRegistration();
    }

    public interface Presenter extends BasePresenter {
        void validateInputAndLogin(String username,String password);
    }

    public interface Model {
        void login(String username,String password);
    }

}
