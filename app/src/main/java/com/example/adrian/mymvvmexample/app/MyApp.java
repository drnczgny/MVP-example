package com.example.adrian.mymvvmexample.app;

import android.app.Activity;
import android.app.Application;

import com.example.adrian.mymvvmexample.app.di.AppComponent;

/**
 * Created by Adrian_Czigany on 3/1/2017.
 */

public class MyApp extends Application {

    private static volatile MyApp application;

    public static MyApp get(Activity activity) {
        return (MyApp) activity.getApplication();
    }

    @Override
    public void onCreate() {
        super.onCreate();

        AppComponent.Injector.inject(this);

    }

    public static MyApp getApplication() {
        return application;
    }
}
