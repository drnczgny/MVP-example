package com.example.adrian.mymvpexample.app;

import android.app.Application;

/**
 * Created by Adrian_Czigany on 3/1/2017.
 */

public class MyApp extends Application {

    AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();

        appComponent.inject(this);
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
