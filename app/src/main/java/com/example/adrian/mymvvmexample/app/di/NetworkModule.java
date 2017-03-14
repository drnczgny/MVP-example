package com.example.adrian.mymvvmexample.app.di;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by Adrian_Czigany on 3/6/2017.
 */

@Module
public class NetworkModule {

    @AppScope
    @Provides
    public Gson provideGson() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        return gson;
    }

    @AppScope
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

    @AppScope
    @Provides
    @Named("omdbapi")
    public Retrofit provideRetrofitForOmdbApi(OkHttpClient client) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.omdbapi.com/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .client(client)
                .build();
        return retrofit;
    }

    @AppScope
    @Provides
    @Named("jsonplaceholderapi")
    public Retrofit provideRetrofitForJsonPlaceholderApi(Gson gson, OkHttpClient client) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://jsonplaceholder.typicode.com")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(client)
                .build();
        return retrofit;
    }

}
