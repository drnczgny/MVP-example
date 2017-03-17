package com.example.adrian.mymvpexample.jsonplaceholder.interactor;

import android.util.Log;

import com.example.adrian.mymvpexample.jsonplaceholder.model.Comment;
import com.example.adrian.mymvpexample.jsonplaceholder.service.CommentService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Adrian_Czigany on 3/8/2017.
 */

public class CommentInteractorImpl implements CommentInteractor {

    private static final String TAG = CommentInteractorImpl.class.getName();

    private CommentService commentService;

    public CommentInteractorImpl(final CommentService commentService) {
        this.commentService = commentService;
    }

    @Override
    public void findAllComment() {
        Call<List<Comment>> call = commentService.findAllComment();

        Log.i(TAG, call.request().url().toString());

        call.enqueue(new Callback<List<Comment>>() {
            @Override
            public void onResponse(Call<List<Comment>> call, Response<List<Comment>> response) {
                Log.i(TAG, "onResponse");
                int statusCode = response.code();
                List<Comment> comments = response.body();
                Log.i(TAG, comments.toString());
            }

            @Override
            public void onFailure(Call<List<Comment>> call, Throwable t) {
                Log.i(TAG, "onFailure");
                System.out.println(t.getMessage());
            }
        });
    }
}
