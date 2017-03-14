package com.example.adrian.mymvvmexample.jsonplaceholder.interactor;

import android.util.Log;

import com.example.adrian.mymvvmexample.jsonplaceholder.di.JsonPlaceholderApiComponent;
import com.example.adrian.mymvvmexample.jsonplaceholder.model.User;
import com.example.adrian.mymvvmexample.jsonplaceholder.service.UserService;
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

public class UserInteractorImpl implements UserInteractor {

    private static final String TAG = UserInteractorImpl.class.getName();

    private JsonPlaceholderApiView jsonPlaceholderApiView;

    @Inject
    UserService userService;

    public UserInteractorImpl(JsonPlaceholderApiView jsonPlaceholderApiView) {
        this.jsonPlaceholderApiView = jsonPlaceholderApiView;

        JsonPlaceholderApiComponent.Injector.buildComponent((JsonPlaceholderApiActivity) jsonPlaceholderApiView).inject(this);

    }

    @Override
    public void findAllUser() {
        Call<List<User>> call = userService.findAllUser();

        Log.i(TAG, call.request().url().toString());

        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                Log.i(TAG, "onResponse");
                int statusCode = response.code();
                List<User> users = response.body();
                Log.i(TAG, users.toString());
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Log.i(TAG, "onFailure");
                System.out.println(t.getMessage());
            }
        });
    }
}
