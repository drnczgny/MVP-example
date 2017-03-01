package com.example.adrian.mymvpexample.app;

import android.content.SharedPreferences;

import com.example.adrian.mymvpexample.login.presenter.LoginPresenterImpl;
import com.example.adrian.mymvpexample.login.view.LoginActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Adrian_Czigany on 3/1/2017.
 */

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    SharedPreferences prefs();

    void inject(LoginActivity loginActivity);

    void inject(LoginPresenterImpl loginPresenterImpl);

}
