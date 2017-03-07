package com.example.adrian.mymvpexample.login.di;

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
    LoginPresenter provideLoginPresenter() {
        return new LoginPresenterImpl(provideLoginView());
    }

    @Provides
    @LoginScope
    LoginView provideLoginView() {
        return loginActivity;
    }
}
