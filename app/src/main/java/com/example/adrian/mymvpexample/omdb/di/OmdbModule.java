package com.example.adrian.mymvpexample.omdb.di;

import com.example.adrian.mymvpexample.omdb.presenter.OmdbInteractor;
import com.example.adrian.mymvpexample.omdb.presenter.OmdbInteractorImpl;
import com.example.adrian.mymvpexample.omdb.presenter.OmdbPresenter;
import com.example.adrian.mymvpexample.omdb.presenter.OmdbPresenterImpl;
import com.example.adrian.mymvpexample.omdb.service.OmdbApiService;
import com.example.adrian.mymvpexample.omdb.view.OmdbApiActivity;
import com.example.adrian.mymvpexample.omdb.view.OmdbApiView;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by Adrian_Czigany on 3/3/2017.
 */

@Module
public class OmdbModule {

    private OmdbApiActivity omdbApiActivity;

    private OmdbInteractor omdbInteractor;

    public OmdbModule(OmdbApiActivity omdbApiActivity) {
        this.omdbApiActivity = omdbApiActivity;
    }

    public OmdbModule(OmdbInteractor omdbInteractor) {
        this.omdbInteractor = omdbInteractor;
    }

    @Provides
    @OmdbScope
    public OmdbApiService provideOmdbService(@Named("omdbapi") Retrofit retrofit) {
        OmdbApiService omdbApiService = retrofit.create(OmdbApiService.class);
        return omdbApiService;
    }

    @Provides
    @OmdbScope
    OmdbInteractor provideOmdbInteractor(OmdbApiView omdbApiView) {
        return new OmdbInteractorImpl(omdbApiView);
    }

    @Provides
    @OmdbScope
    public OmdbPresenter provideOmdbPresenter(OmdbApiView omdbApiView, OmdbInteractor omdbInteractor) {
        return new OmdbPresenterImpl(omdbApiView, omdbInteractor);
    }

    @Provides
    @OmdbScope
    OmdbApiView provideOmdApiView() {
        return omdbApiActivity;
    }

}
