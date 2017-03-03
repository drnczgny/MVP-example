package com.example.adrian.mymvpexample.omdb.di;

import com.example.adrian.mymvpexample.omdb.service.OmdbApiService;

import java.io.IOException;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by Adrian_Czigany on 3/3/2017.
 */

@Module
public class OmdbModule {

    @Singleton
    @Provides
    public OkHttpClient providesOkHttpClient() {
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request newRequest = chain.request().newBuilder()
                        .build();
                return chain.proceed(newRequest);
            }
        }).build();
        return client;
    }

    @Singleton
    @Provides
    public Retrofit provideRetrofit(OkHttpClient client) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.omdbapi.com/")
//            .addConverterFactory(GsonConverterFactory.create(gson))
                .addConverterFactory(ScalarsConverterFactory.create())
                .client(client)
                .build();
        return retrofit;
    }

    @Singleton
    @Provides
    public OmdbApiService provideOmdbService(Retrofit retrofit) {
        OmdbApiService omdbApiService = retrofit.create(OmdbApiService.class);
        return omdbApiService;
    }
}
