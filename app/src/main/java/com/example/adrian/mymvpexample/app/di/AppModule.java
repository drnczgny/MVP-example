package com.example.adrian.mymvpexample.app.di;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.adrian.mymvpexample.app.BaseApp;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Adrian_Czigany on 3/1/2017.
 */

@Module
public class AppModule {

    private final BaseApp baseApp;

    public AppModule(BaseApp myApp) {
        this.baseApp = myApp;
    }

    @AppScope
    @Provides
    public Context providesApplicationContext() {
        return baseApp;
    }

    @AppScope
    @Provides
    public SharedPreferences provideSharedPreferences(Context app) {
        return app.getSharedPreferences("PREFS", Context.MODE_PRIVATE);
    }


}
