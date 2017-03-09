package com.example.adrian.mymvpexample.jsonplaceholder.service;

import com.example.adrian.mymvpexample.jsonplaceholder.model.Todo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Adrian_Czigany on 3/8/2017.
 */

public interface TodoService {

    @GET("/todos")
    Call<List<Todo>> findAllTodo();

}
