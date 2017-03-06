package com.example.adrian.mymvpexample.omdb.di;

import com.example.adrian.mymvpexample.omdb.service.OmdbApiService;
import com.example.adrian.mymvpexample.omdb.view.OmdbApiActivity;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by Adrian_Czigany on 3/3/2017.
 */

@Module
public class OmdbModule {

    private OmdbApiActivity omdbApiActivity;

    public OmdbModule(OmdbApiActivity omdbApiActivity) {
        this.omdbApiActivity = omdbApiActivity;
    }

    @Provides
    @OmdbScope
    public OmdbApiService provideOmdbService(Retrofit retrofit) {
        OmdbApiService omdbApiService = retrofit.create(OmdbApiService.class);
        return omdbApiService;
    }

//    @Singleton
//    @Provides
//    @Named("OmdbPresenterImpl")
//    public OmdbPresenterImpl providesOmdbPresenterImpl(OmdbApiService omdbApiService) {
//        return new OmdbPresenterImpl((OmdbApiView) omdbApiFragment, omdbApiService);
//    }
}
