package com.example.adrian.mymvpexample.app.di;

import android.content.SharedPreferences;

import com.example.adrian.mymvpexample.app.MyApp;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

/**
 * Created by Adrian_Czigany on 3/1/2017.
 */

@Singleton
@Component(modules = {AppModule.class, NetworkModule.class})
public interface AppComponent {

    void inject(MyApp myApp);

    SharedPreferences sharedPreferences();

    @Named("omdbapi") Retrofit retrofitForOmbdApi();

    @Named("jsonplaceholderapi") Retrofit retrofitForJsonPlaceholderApi();

    final class Injector {
        private static AppComponent appComponent;

        private Injector() {
        }

        public static void inject(MyApp myApp) {
            appComponent = DaggerAppComponent.builder()
                    .appModule(new AppModule(myApp))
                    .build();
            appComponent.inject(myApp);
        }

        public static AppComponent getComponent() {
            return appComponent;
        }
    }
}
