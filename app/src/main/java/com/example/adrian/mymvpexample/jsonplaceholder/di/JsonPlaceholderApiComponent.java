package com.example.adrian.mymvpexample.jsonplaceholder.di;

import com.example.adrian.mymvpexample.app.di.AppComponent;
import com.example.adrian.mymvpexample.jsonplaceholder.presenter.JsonPlaceholderApiInteractorImpl;
import com.example.adrian.mymvpexample.jsonplaceholder.presenter.JsonPlaceholderApiPresenterImpl;
import com.example.adrian.mymvpexample.jsonplaceholder.view.JsonPlaceholderApiActivity;

import dagger.Component;

/**
 * Created by Adrian_Czigany on 3/8/2017.
 */

@JsonPlaceholderScope
@Component(dependencies = AppComponent.class, modules = {JsonPlaceholderApiModule.class})
public interface JsonPlaceholderApiComponent {

    void inject(JsonPlaceholderApiActivity jsonPlaceholderApiActivity);

    void inject(JsonPlaceholderApiInteractorImpl jsonPlaceholderApiInteractorImpl);

    void inject(JsonPlaceholderApiPresenterImpl jsonPlaceholderApiPresenterImpl);

}
