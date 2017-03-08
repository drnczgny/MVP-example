package com.example.adrian.mymvpexample.jsonplaceholder.presenter;

import com.example.adrian.mymvpexample.app.MyApp;
import com.example.adrian.mymvpexample.jsonplaceholder.di.DaggerJsonPlaceholderApiComponent;
import com.example.adrian.mymvpexample.jsonplaceholder.di.JsonPlaceholderApiComponent;
import com.example.adrian.mymvpexample.jsonplaceholder.di.JsonPlaceholderApiModule;
import com.example.adrian.mymvpexample.jsonplaceholder.view.JsonPlaceholderApiActivity;
import com.example.adrian.mymvpexample.jsonplaceholder.view.JsonPlaceholderApiView;

import javax.inject.Inject;

/**
 * Created by Adrian_Czigany on 3/8/2017.
 */

public class JsonPlaceholderApiPresenterImpl implements JsonPlaceholderApiPresenter {

    private JsonPlaceholderApiView jsonPlaceholderApiView;

//    private JsonPlaceholderApiInteractor jsonPlaceholderApiInteractorImpl;

    @Inject
    JsonPlaceholderApiInteractor jsonPlaceholderApiInteractorImpl;

    public JsonPlaceholderApiPresenterImpl(JsonPlaceholderApiView jsonPlaceholderApiView) {
        this.jsonPlaceholderApiView = jsonPlaceholderApiView;

        JsonPlaceholderApiComponent jsonPlaceholderApiComponent = DaggerJsonPlaceholderApiComponent.builder()
                .jsonPlaceholderApiModule(new JsonPlaceholderApiModule((JsonPlaceholderApiActivity) jsonPlaceholderApiView))
                .appComponent(MyApp.get((JsonPlaceholderApiActivity)jsonPlaceholderApiView).getAppComponent())
                .build();
        jsonPlaceholderApiComponent.inject(this);

        jsonPlaceholderApiInteractorImpl.toString();


    }
}
