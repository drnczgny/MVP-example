package com.example.adrian.mymvpexample.jsonplaceholder.interactor;

import android.util.Log;

import com.example.adrian.mymvpexample.jsonplaceholder.model.User;
import com.example.adrian.mymvpexample.jsonplaceholder.service.UserService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Adrian_Czigany on 3/8/2017.
 */

public class UserInteractorImpl implements UserInteractor {

    private static final String TAG = UserInteractorImpl.class.getName();

    private UserService userService;

    public UserInteractorImpl(final UserService userService) {
        this.userService = userService;
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
