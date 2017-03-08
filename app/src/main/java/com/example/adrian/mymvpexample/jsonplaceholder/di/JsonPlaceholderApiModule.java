package com.example.adrian.mymvpexample.jsonplaceholder.di;

import com.example.adrian.mymvpexample.jsonplaceholder.presenter.JsonPlaceholderApiInteractor;
import com.example.adrian.mymvpexample.jsonplaceholder.presenter.JsonPlaceholderApiInteractorImpl;
import com.example.adrian.mymvpexample.jsonplaceholder.presenter.JsonPlaceholderApiPresenter;
import com.example.adrian.mymvpexample.jsonplaceholder.presenter.JsonPlaceholderApiPresenterImpl;
import com.example.adrian.mymvpexample.jsonplaceholder.service.JsonPlaceholderApiService;
import com.example.adrian.mymvpexample.jsonplaceholder.view.JsonPlaceholderApiActivity;
import com.example.adrian.mymvpexample.jsonplaceholder.view.JsonPlaceholderApiView;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by Adrian_Czigany on 3/8/2017.
 */

@Module
public class JsonPlaceholderApiModule {

    JsonPlaceholderApiActivity jsonPlaceholderApiActivity;

    public JsonPlaceholderApiModule(JsonPlaceholderApiActivity jsonPlaceholderApiActivity) {
        this.jsonPlaceholderApiActivity = jsonPlaceholderApiActivity;
    }

    @JsonPlaceholderScope
    @Provides
    JsonPlaceholderApiView providesJsonPlaceholderApiView() {
        return jsonPlaceholderApiActivity;
    }

    @JsonPlaceholderScope
    @Provides
    JsonPlaceholderApiService provideJsonPlaceholderApiService(@Named("jsonplaceholderapi") Retrofit retrofit) {
        JsonPlaceholderApiService jsonPlaceholderApiService = retrofit.create(JsonPlaceholderApiService.class);
        return jsonPlaceholderApiService;
    }

    @JsonPlaceholderScope
    @Provides
    JsonPlaceholderApiInteractor provideJsonPlaceholderApiInteractor() {
        return new JsonPlaceholderApiInteractorImpl(providesJsonPlaceholderApiView());
    }

    @JsonPlaceholderScope
    @Provides
    JsonPlaceholderApiPresenter providesJsonPlaceholderApiPresenter() {
        return new JsonPlaceholderApiPresenterImpl(providesJsonPlaceholderApiView());
    }

}
