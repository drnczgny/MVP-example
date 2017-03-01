package com.example.adrian.mymvpexample.login.presenter;

import android.util.Log;

import com.example.adrian.mymvpexample.login.view.LoginView;

/**
 * Created by Adrian_Czigany on 2/28/2017.
 */

public class LoginPresenterImpl implements LoginPresenter, LoginInteractor.OnLoginFinishedListener {

    private static final String TAG = LoginPresenterImpl.class.getName().toString();

    private LoginView loginView;

    private LoginInteractor loginInteractor;

    public LoginPresenterImpl(LoginView loginView) {
        this.loginView = loginView;
        loginInteractor = new LoginInteractorImpl();

    }

    @Override
    public void validateCredentials(String username, String password) {
        Log.i(TAG, "validateCredentials");
        loginView.showProgressBar();
        loginInteractor.validateLoginCredentials(username, password, this);
    }

    @Override
    public void onUsernameError() {
        loginView.errorOnUsername();
        loginView.hideProgressBar();
    }

    @Override
    public void onPasswordError() {
        loginView.errorOnPassword();
        loginView.hideProgressBar();
    }

    @Override
    public void onSuccess() {
        loginView.navigateToMain();
        loginView.hideProgressBar();
    }
}
