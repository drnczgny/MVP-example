package com.example.adrian.mymvpexample.jsonplaceholder.service;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Adrian_Czigany on 3/8/2017.
 */

public interface TodoService {

    @GET("/todos")
    Call<String> findAllTodo();

}
