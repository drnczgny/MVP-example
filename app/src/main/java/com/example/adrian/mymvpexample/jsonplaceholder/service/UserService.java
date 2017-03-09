package com.example.adrian.mymvpexample.jsonplaceholder.service;

import com.example.adrian.mymvpexample.jsonplaceholder.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Adrian_Czigany on 3/8/2017.
 */

public interface UserService {

    @GET("/users")
    Call<List<User>> findAllUser();
}
