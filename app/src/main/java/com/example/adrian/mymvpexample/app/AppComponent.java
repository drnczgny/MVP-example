package com.example.adrian.mymvpexample.app;

import com.example.adrian.mymvpexample.login.view.LoginActivity;
import com.example.adrian.mymvpexample.main.view.MainActivity;
import com.example.adrian.mymvpexample.omdb.di.OmdbModule;
import com.example.adrian.mymvpexample.omdb.view.OmdbApiFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Adrian_Czigany on 3/1/2017.
 */

@Singleton
@Component(modules = {AppModule.class, OmdbModule.class})
public interface AppComponent {

//    SharedPreferences prefs();

    void inject(MyApp myApp);

    void inject(LoginActivity loginActivity);

    void inject(MainActivity mainActivity);

    void inject(OmdbApiFragment omdbApiFragment);
}
