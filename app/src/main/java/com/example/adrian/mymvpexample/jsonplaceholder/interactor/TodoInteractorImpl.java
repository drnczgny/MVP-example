package com.example.adrian.mymvpexample.jsonplaceholder.interactor;

import android.util.Log;

import com.example.adrian.mymvpexample.jsonplaceholder.model.Todo;
import com.example.adrian.mymvpexample.jsonplaceholder.service.TodoService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Adrian_Czigany on 3/8/2017.
 */

public class TodoInteractorImpl implements TodoInteractor {

    private static final String TAG = TodoInteractorImpl.class.getName();

    private TodoService todoService;

    public TodoInteractorImpl(final TodoService todoService) {
        this.todoService = todoService;
    }

    @Override
    public void findAllTodo() {
        Call<List<Todo>> call = todoService.findAllTodo();

        Log.i(TAG, call.request().url().toString());

        call.enqueue(new Callback<List<Todo>>() {
            @Override
            public void onResponse(Call<List<Todo>> call, Response<List<Todo>> response) {
                Log.i(TAG, "onResponse");
                int statusCode = response.code();
                List<Todo> todos = response.body();
                Log.i(TAG, todos.toString());
            }

            @Override
            public void onFailure(Call<List<Todo>> call, Throwable t) {
                Log.i(TAG, "onFailure");
                System.out.println(t.getMessage());
            }
        });
    }
}
