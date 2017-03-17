package com.example.adrian.mymvpexample.login.di;

import com.example.adrian.mymvpexample.login.presenter.LoginInteractor;
import com.example.adrian.mymvpexample.login.presenter.LoginInteractorImpl;
import com.example.adrian.mymvpexample.login.presenter.LoginPresenter;
import com.example.adrian.mymvpexample.login.presenter.LoginPresenterImpl;
import com.example.adrian.mymvpexample.login.view.LoginActivity;
import com.example.adrian.mymvpexample.login.view.LoginView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by cadri on 2017. 03. 06..
 */

@Module
public class LoginModule {

    private LoginActivity loginActivity;

    public LoginModule(LoginActivity loginActivity) {
        this.loginActivity = loginActivity;
    }

    @Provides
    @LoginScope
    LoginInteractor provideLoginInteractor() {
        return new LoginInteractorImpl();
    }

    @Provides
    @LoginScope
    LoginPresenter provideLoginPresenter(LoginView loginView, LoginInteractor provideLoginInteractor) {
        return new LoginPresenterImpl(loginView, provideLoginInteractor);
    }

    @Provides
    @LoginScope
    LoginView provideLoginView() {
        return loginActivity;
    }
}
