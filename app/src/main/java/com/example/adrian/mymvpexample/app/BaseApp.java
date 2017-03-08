package com.example.adrian.mymvpexample.app;

import android.app.Activity;
import android.app.Application;

import com.example.adrian.mymvpexample.app.di.AppComponent;
import com.example.adrian.mymvpexample.app.di.AppModule;
import com.example.adrian.mymvpexample.app.di.DaggerAppComponent;

/**
 * Created by Adrian_Czigany on 3/1/2017.
 */

public class BaseApp extends Application {

    AppComponent appComponent;

    public static BaseApp get(Activity activity) {
        return (BaseApp) activity.getApplication();
    }

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
