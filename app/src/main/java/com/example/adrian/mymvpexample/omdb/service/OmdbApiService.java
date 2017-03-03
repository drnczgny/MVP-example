package com.example.adrian.mymvpexample.omdb.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.Map;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by Adrian_Czigany on 3/3/2017.
 */

public interface OmdbApiService {

    public static final String BASE_URL = "http://www.omdbapi.com/";

    @GET("/?y=2010")
    Call<String> findAllMovie();

    @GET("/")
    Call<String> findMovieByTitle(@QueryMap Map<String, String> options);

    Gson gson = new GsonBuilder().setLenient().create();

    OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request newRequest  = chain.request().newBuilder()
                    .build();
            return chain.proceed(newRequest);
        }
    }).build();

    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create(gson))
            .addConverterFactory(ScalarsConverterFactory.create())
            .client(client)
            .build();

}

