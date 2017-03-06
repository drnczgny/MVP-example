package com.example.adrian.mymvpexample.app;

import com.example.adrian.mymvpexample.login.view.LoginActivity;
import com.example.adrian.mymvpexample.main.view.MainActivity;

import dagger.Component;
import retrofit2.Retrofit;

/**
 * Created by Adrian_Czigany on 3/1/2017.
 */

@AppScope
@Component(modules = {AppModule.class, NetworkModule.class})
public interface AppComponent {

//    SharedPreferences prefs();

    Retrofit retrofit();

    void inject(MyApp myApp);

    void inject(LoginActivity loginActivity);

    void inject(MainActivity mainActivity);

}
