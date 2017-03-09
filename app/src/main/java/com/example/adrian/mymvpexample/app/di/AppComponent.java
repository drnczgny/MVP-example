package com.example.adrian.mymvpexample.app.di;

import android.content.SharedPreferences;

import com.example.adrian.mymvpexample.app.BaseApp;

import javax.inject.Named;

import dagger.Component;
import retrofit2.Retrofit;

/**
 * Created by Adrian_Czigany on 3/1/2017.
 */

@AppScope
@Component(modules = {AppModule.class, NetworkModule.class})
public interface AppComponent {

    SharedPreferences sharedPreferences();

    @Named("omdbapi") Retrofit retrofitForOmbdApi();

    @Named("jsonplaceholderapi") Retrofit retrofitForJsonPlaceholderApi();

    void inject(BaseApp myApp);

}
