package com.example.adrian.mymvvmexample.jsonplaceholder.interactor;

import android.util.Log;

import com.example.adrian.mymvvmexample.jsonplaceholder.di.JsonPlaceholderApiComponent;
import com.example.adrian.mymvvmexample.jsonplaceholder.model.Photo;
import com.example.adrian.mymvvmexample.jsonplaceholder.service.PhotoService;
import com.example.adrian.mymvvmexample.jsonplaceholder.view.JsonPlaceholderApiActivity;
import com.example.adrian.mymvvmexample.jsonplaceholder.view.JsonPlaceholderApiView;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Adrian_Czigany on 3/8/2017.
 */

public class PhotoInteractorImpl implements PhotoInteractor {

    private static final String TAG = PhotoInteractorImpl.class.getName();

    private JsonPlaceholderApiView jsonPlaceholderApiView;

    @Inject
    PhotoService photoService;

    public PhotoInteractorImpl(JsonPlaceholderApiView jsonPlaceholderApiView) {
        this.jsonPlaceholderApiView = jsonPlaceholderApiView;

        JsonPlaceholderApiComponent.Injector.buildComponent((JsonPlaceholderApiActivity) jsonPlaceholderApiView).inject(this);

    }

    @Override
    public void findAllPhoto() {
        Call<List<Photo>> call = photoService.findAllPhoto();

        Log.i(TAG, call.request().url().toString());

        call.enqueue(new Callback<List<Photo>>() {
            @Override
            public void onResponse(Call<List<Photo>> call, Response<List<Photo>> response) {
                Log.i(TAG, "onResponse");
                int statusCode = response.code();
                List<Photo> photos = response.body();
                Log.i(TAG, photos.toString());
            }

            @Override
            public void onFailure(Call<List<Photo>> call, Throwable t) {
                Log.i(TAG, "onFailure");
                System.out.println(t.getMessage());
            }
        });
    }

}
