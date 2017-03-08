package com.example.adrian.mymvpexample.jsonplaceholder.interactor;

import android.util.Log;

import com.example.adrian.mymvpexample.app.MyApp;
import com.example.adrian.mymvpexample.jsonplaceholder.di.DaggerJsonPlaceholderApiComponent;
import com.example.adrian.mymvpexample.jsonplaceholder.di.JsonPlaceholderApiComponent;
import com.example.adrian.mymvpexample.jsonplaceholder.di.JsonPlaceholderApiModule;
import com.example.adrian.mymvpexample.jsonplaceholder.service.AlbumService;
import com.example.adrian.mymvpexample.jsonplaceholder.view.JsonPlaceholderApiActivity;
import com.example.adrian.mymvpexample.jsonplaceholder.view.JsonPlaceholderApiView;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Adrian_Czigany on 3/8/2017.
 */

public class AlbumInteractorImpl implements AlbumInteractor {

    private static final String TAG = AlbumInteractorImpl.class.getName();

    private JsonPlaceholderApiView jsonPlaceholderApiView;

    @Inject
    AlbumService albumService;

    public AlbumInteractorImpl(JsonPlaceholderApiView jsonPlaceholderApiView) {
        this.jsonPlaceholderApiView = jsonPlaceholderApiView;

        JsonPlaceholderApiComponent jsonPlaceholderApiComponent = DaggerJsonPlaceholderApiComponent.builder()
                .jsonPlaceholderApiModule(new JsonPlaceholderApiModule((JsonPlaceholderApiActivity) jsonPlaceholderApiView))
                .appComponent(MyApp.get((JsonPlaceholderApiActivity)jsonPlaceholderApiView).getAppComponent())
                .build();
        jsonPlaceholderApiComponent.inject(this);
    }

    @Override
    public void findAllAlbum() {
        Call<String> call = albumService.findAllAlbum();

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
