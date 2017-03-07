package com.example.adrian.mymvpexample.main.di;

import com.example.adrian.mymvpexample.app.di.AppComponent;
import com.example.adrian.mymvpexample.main.view.MainActivity;

import dagger.Component;

/**
 * Created by cadri on 2017. 03. 06..
 */

@MainScope
@Component(dependencies = AppComponent.class, modules = {MainModule.class})
public interface MainComponent {

    void inject(MainActivity mainActivity);

}
