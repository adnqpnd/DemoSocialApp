package com.agilaapp.demosocialapp.login.view.activity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.agilaapp.demosocialapp.BaseActivity;
import com.agilaapp.demosocialapp.PresenterHolder;
import com.agilaapp.demosocialapp.R;
import com.agilaapp.demosocialapp.login.LoginContract;
import com.agilaapp.demosocialapp.login.model.LoginModel;
import com.agilaapp.demosocialapp.login.presenter.LoginPresenter;
import com.agilaapp.demosocialapp.login.view.fragment.LoginFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends BaseActivity implements LoginContract.View {

    private static final String TAG = LoginActivity.class.getSimpleName();

    @BindView(R.id.editTextUsername)
    EditText mEditTextUsername;

    @BindView(R.id.editTextPassword)
    EditText mEditTextPassword;

    @BindView(R.id.buttonLogin)
    Button mButtonLogin;

    @BindView(R.id.buttonRegister)
    Button mButtonRegister;

    @BindView(R.id.progressBarLogin)
    ProgressBar mProgressBarLogin;

    private LoginContract.Presenter mLoginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        setupMVP();
        mButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick:");
                mLoginPresenter.validateInputAndLogin(mEditTextUsername.getText().toString(),mEditTextPassword.getText().toString());
            }
        });
    }

    private void setupMVP(){
        mLoginPresenter = PresenterHolder.getInstance().getPresenter(LoginContract.Presenter.class);

        Log.d(TAG, "setupMVP: mLoginPresenter - " +mLoginPresenter);

        if(mLoginPresenter == null){
            LoginPresenter loginPresenter = new LoginPresenter(this);
            LoginModel loginModel = new LoginModel(loginPresenter);
            loginPresenter.setModel(loginModel);
            mLoginPresenter = loginPresenter;
        }else {
            LoginPresenter loginPresenter = (LoginPresenter) mLoginPresenter;
            LoginModel loginModel = new LoginModel(loginPresenter);
            loginPresenter.setModel(loginModel);
            loginPresenter.setView(this);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        PresenterHolder.getInstance().putPresenter(LoginContract.Presenter.class, mLoginPresenter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(isFinishing()){
            PresenterHolder.getInstance().remove(LoginContract.Presenter.class);
        }
    }

    @Override
    public void showLoadingIndicator() {
        mProgressBarLogin.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoadingIndicator() {
        mProgressBarLogin.setVisibility(View.GONE);
    }

    @Override
    public void showLoginButton() {
        mButtonLogin.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoginButton() {
        mButtonLogin.setVisibility(View.GONE);
    }

    @Override
    public void showLoginFailedErrorMessage() {
        Toast.makeText(this,"Login failed!!!",Toast.LENGTH_LONG).show();
    }

    @Override
    public void hideLoginFailedErrorMessage() {

    }

    @Override
    public void navigateToRegistration() {
        Toast.makeText(this,"GO to main!!!",Toast.LENGTH_LONG).show();
    }

    @Override
    public Context getActivityContext() {
        return this;
    }
}
