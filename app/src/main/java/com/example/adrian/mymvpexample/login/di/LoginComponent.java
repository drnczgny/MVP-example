package com.example.adrian.mymvpexample.login.di;

import com.example.adrian.mymvpexample.app.di.AppComponent;
import com.example.adrian.mymvpexample.login.view.LoginActivity;

import dagger.Component;

/**
 * Created by cadri on 2017. 03. 06..
 */

@LoginScope
@Component(dependencies = AppComponent.class, modules = {LoginModule.class})
public interface LoginComponent {

    void inject(LoginActivity loginActivity);

}
