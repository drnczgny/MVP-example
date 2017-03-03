package com.example.adrian.mymvpexample.omdb.presenter;

import android.util.Log;

import com.example.adrian.mymvpexample.omdb.service.OmdbApiService;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;

/**
 * Created by Adrian_Czigany on 3/3/2017.
 */

public class OmdbInteractorImpl implements OmdbInteractor {

    final OmdbApiService omdbApiService;

    public OmdbInteractorImpl(OmdbApiService omdbApiService) {
        this.omdbApiService = omdbApiService;
    }

    @Override
    public void findAllMovie() {
//        OmdbApiService omdbApiService = OmdbApiService.retrofit.create(OmdbApiService.class);
        Call<String> call = omdbApiService.findAllMovie();

        Log.i(TAG, call.request().url().toString());

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.i(TAG, "onResponse");
                int statusCode = response.code();
                String simpleString = response.body();
                Log.i(TAG, simpleString);
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.i(TAG, "onFailure");
                System.out.println(t.getMessage());
                // Log error here since request failed
            }
        });
    }

    @Override
    public void findMovieByYear(final int year) {
//        OmdbApiService omdbApiService = OmdbApiService.retrofit.create(OmdbApiService.class);

        Map<String, Integer> data = new HashMap<>();
        data.put("y", year);

        Call<String> call = omdbApiService.findMovieByYear(data);

        Log.i(TAG, call.request().url().toString());

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.i(TAG, "onResponse");
                int statusCode = response.code();
                String simpleString = response.body();
                Log.i(TAG, simpleString);
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.i(TAG, "onFailure");
                System.out.println(t.getMessage());
                // Log error here since request failed
            }
        });
    }

    @Override
    public void findMovieByTitle(final String title) {
//        OmdbApiService omdbApiService = OmdbApiService.retrofit.create(OmdbApiService.class);

        Map<String, String> data = new HashMap<>();
        data.put("t", title);

        Call<String> call = omdbApiService.findMovieByTitle(data);

        Log.i(TAG, call.request().url().toString());

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.i(TAG, "onResponse");
                int statusCode = response.code();
                String simpleString = response.body();
                Log.i(TAG, simpleString);
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.i(TAG, "onFailure");
                System.out.println(t.getMessage());
                // Log error here since request failed
            }
        });
    }

}
