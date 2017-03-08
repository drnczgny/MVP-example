package com.example.adrian.mymvpexample.jsonplaceholder.presenter;

import android.util.Log;

import com.example.adrian.mymvpexample.app.MyApp;
import com.example.adrian.mymvpexample.jsonplaceholder.di.DaggerJsonPlaceholderApiComponent;
import com.example.adrian.mymvpexample.jsonplaceholder.di.JsonPlaceholderApiComponent;
import com.example.adrian.mymvpexample.jsonplaceholder.di.JsonPlaceholderApiModule;
import com.example.adrian.mymvpexample.jsonplaceholder.service.JsonPlaceholderApiService;
import com.example.adrian.mymvpexample.jsonplaceholder.view.JsonPlaceholderApiActivity;
import com.example.adrian.mymvpexample.jsonplaceholder.view.JsonPlaceholderApiView;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Adrian_Czigany on 3/8/2017.
 */

public class JsonPlaceholderApiInteractorImpl implements JsonPlaceholderApiInteractor {

    private static final String TAG = JsonPlaceholderApiInteractorImpl.class.getName();

    private JsonPlaceholderApiView jsonPlaceholderApiView;

    @Inject
    JsonPlaceholderApiService jsonPlaceholderApiService;

    public JsonPlaceholderApiInteractorImpl(JsonPlaceholderApiView jsonPlaceholderApiView) {
        this.jsonPlaceholderApiView = jsonPlaceholderApiView;

        JsonPlaceholderApiComponent jsonPlaceholderApiComponent = DaggerJsonPlaceholderApiComponent.builder()
                .jsonPlaceholderApiModule(new JsonPlaceholderApiModule(this))
                .appComponent(MyApp.get((JsonPlaceholderApiActivity)jsonPlaceholderApiView).getAppComponent())
                .build();
        jsonPlaceholderApiComponent.inject(this);

        findAllPost();
        findAllComment();
        findAllAlbum();
        findAllPhoto();
        findAllTodo();
        findAllUser();
    }

    public void findAllPost() {
        Call<String> call = jsonPlaceholderApiService.findAllPost();

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
            }
        });
    }

    public void findAllComment() {
        Call<String> call = jsonPlaceholderApiService.findAllComment();

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
            }
        });
    }

    public void findAllAlbum() {
        Call<String> call = jsonPlaceholderApiService.findAllAlbum();

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
            }
        });
    }

    public void findAllPhoto() {
        Call<String> call = jsonPlaceholderApiService.findAllPhoto();

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
            }
        });
    }

    public void findAllTodo() {
        Call<String> call = jsonPlaceholderApiService.findAllTodo();

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
            }
        });
    }

    public void findAllUser() {
        Call<String> call = jsonPlaceholderApiService.findAllUser();

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
            }
        });
    }
}
