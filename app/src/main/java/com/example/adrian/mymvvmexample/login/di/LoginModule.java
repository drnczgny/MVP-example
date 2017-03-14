package com.example.adrian.mymvvmexample.login.di;

import com.example.adrian.mymvvmexample.login.presenter.LoginInteractor;
import com.example.adrian.mymvvmexample.login.presenter.LoginInteractorImpl;
import com.example.adrian.mymvvmexample.login.presenter.LoginPresenter;
import com.example.adrian.mymvvmexample.login.presenter.LoginPresenterImpl;
import com.example.adrian.mymvvmexample.login.view.LoginActivity;
import com.example.adrian.mymvvmexample.login.view.LoginView;

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
    LoginPresenter provideLoginPresenter() {
        return new LoginPresenterImpl(provideLoginView(), provideLoginInteractor());
    }

    @Provides
    @LoginScope
    LoginView provideLoginView() {
        return loginActivity;
    }
}
