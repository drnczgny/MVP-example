package com.example.adrian.mymvpexample.app;

import android.app.Activity;
import android.app.Application;

import com.example.adrian.mymvpexample.app.di.AppComponent;

/**
 * Created by Adrian_Czigany on 3/1/2017.
 */

public class MyApp extends Application {

    AppComponent appComponent;

    private static volatile MyApp application;


    public static MyApp get(Activity activity) {
        return (MyApp) activity.getApplication();
    }

    @Override
    public void onCreate() {
        super.onCreate();

        AppComponent.Injector.inject(this);

        //        appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
        //        appComponent.inject(this);

    }

//    public AppComponent getAppComponent() {
//        return appComponent;
//    }

    public static MyApp getApplication() {
        return application;
    }
}
