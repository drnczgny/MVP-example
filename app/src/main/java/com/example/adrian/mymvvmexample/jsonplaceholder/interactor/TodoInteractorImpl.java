package com.example.adrian.mymvvmexample.jsonplaceholder.interactor;

import android.util.Log;

import com.example.adrian.mymvvmexample.jsonplaceholder.di.JsonPlaceholderApiComponent;
import com.example.adrian.mymvvmexample.jsonplaceholder.model.Todo;
import com.example.adrian.mymvvmexample.jsonplaceholder.service.TodoService;
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

public class TodoInteractorImpl implements TodoInteractor {

    private static final String TAG = TodoInteractorImpl.class.getName();

    private JsonPlaceholderApiView jsonPlaceholderApiView;

    @Inject
    TodoService todoService;

    public TodoInteractorImpl(JsonPlaceholderApiView jsonPlaceholderApiView) {
        this.jsonPlaceholderApiView = jsonPlaceholderApiView;

        JsonPlaceholderApiComponent.Injector.buildComponent((JsonPlaceholderApiActivity) jsonPlaceholderApiView).inject(this);

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
