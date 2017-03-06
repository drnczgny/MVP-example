package com.example.adrian.mymvpexample.omdb.di;

import com.example.adrian.mymvpexample.app.AppComponent;
import com.example.adrian.mymvpexample.omdb.service.OmdbApiService;
import com.example.adrian.mymvpexample.omdb.view.OmdbApiActivity;

import dagger.Component;

/**
 * Created by Adrian_Czigany on 3/3/2017.
 */

@Component(dependencies = {AppComponent.class}, modules = {OmdbModule.class})
@OmdbScope
public interface OmdbComponent {

    OmdbApiService omdbApiService();

    void inject(OmdbApiActivity omdbApiActivity);

}
