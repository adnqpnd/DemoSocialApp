package com.agilaapp.demosocialapp.login.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.agilaapp.demosocialapp.PresenterHolder;
import com.agilaapp.demosocialapp.login.LoginContract;
import com.agilaapp.demosocialapp.R;
import com.agilaapp.demosocialapp.login.model.LoginModel;
import com.agilaapp.demosocialapp.login.presenter.LoginPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;


public class LoginFragment extends Fragment implements LoginContract.View {

    private static final String TAG = LoginFragment.class.getSimpleName();

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
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setupMVP();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_login, container, false);
        ButterKnife.bind(this, view);

        mButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick:");
                mLoginPresenter.validateInputAndLogin(mEditTextUsername.getText().toString(),mEditTextPassword.getText().toString());
            }
        });

        return view;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        PresenterHolder.getInstance(getActivityContext()).putPresenter(LoginFragment.class, mLoginPresenter);
    }

    private void setupMVP(){
        mLoginPresenter = PresenterHolder.getInstance(getActivityContext()).getPresenter(LoginContract.Presenter.class);
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
        Toast.makeText(getActivity(),"Login failed!!!",Toast.LENGTH_LONG).show();
    }

    @Override
    public void hideLoginFailedErrorMessage() {

    }

    @Override
    public void navigateToRegistration() {
        Toast.makeText(getActivity(),"GO to main!!!",Toast.LENGTH_LONG).show();
    }

    @Override
    public Context getActivityContext() {
        return getActivity();
    }

    @Override
    public Context getApplicationContext() {
        return getActivity().getApplicationContext();
    }

}
