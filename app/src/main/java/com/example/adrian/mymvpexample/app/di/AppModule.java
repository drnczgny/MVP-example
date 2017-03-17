package com.example.adrian.mymvpexample.app.di;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.adrian.mymvpexample.app.MyApp;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Adrian_Czigany on 3/1/2017.
 */

@Module
public class AppModule {

    private final MyApp myApp;

    public AppModule(MyApp myApp) {
        this.myApp = myApp;
    }

    @Singleton
    @Provides
    public Context providesApplicationContext() {
        return myApp;
    }

    @Singleton
    @Provides
    public SharedPreferences provideSharedPreferences(Context app) {
        return app.getSharedPreferences("PREFS", Context.MODE_PRIVATE);
    }

}
