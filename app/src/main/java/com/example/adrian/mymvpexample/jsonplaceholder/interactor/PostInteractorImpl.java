package com.example.adrian.mymvpexample.jsonplaceholder.interactor;

import android.util.Log;

import com.example.adrian.mymvpexample.jsonplaceholder.di.JsonPlaceholderApiComponent;
import com.example.adrian.mymvpexample.jsonplaceholder.model.Post;
import com.example.adrian.mymvpexample.jsonplaceholder.service.PostService;
import com.example.adrian.mymvpexample.jsonplaceholder.view.JsonPlaceholderApiActivity;
import com.example.adrian.mymvpexample.jsonplaceholder.view.JsonPlaceholderApiView;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Adrian_Czigany on 3/8/2017.
 */

public class PostInteractorImpl implements PostInteractor {

    private static final String TAG = PostInteractorImpl.class.getName();

    JsonPlaceholderApiView jsonPlaceholderApiView;

    @Inject
    PostService postService;

    public PostInteractorImpl(JsonPlaceholderApiView jsonPlaceholderApiView) {
        this.jsonPlaceholderApiView = jsonPlaceholderApiView;

        JsonPlaceholderApiComponent.Injector.buildComponent((JsonPlaceholderApiActivity) jsonPlaceholderApiView).inject(this);

    }

    @Override
    public void findAllPost() {
        Call<List<Post>> call = postService.findAllPost();

        Log.i(TAG, call.request().url().toString());

        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                Log.i(TAG, "onResponse");
                int statusCode = response.code();
                List<Post> posts = response.body();
                Log.i(TAG, posts.toString());
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                Log.i(TAG, "onFailure");
                System.out.println(t.getMessage());
            }
        });
    }

    @Override
    public void findPostById(final int id) {
        Call<Post> call = postService.findPostById(id);

        Log.i(TAG, call.request().url().toString());

        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                Log.i(TAG, "onResponse");
                int statusCode = response.code();
                Post post = response.body();
                Log.i(TAG, post.toString());
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                Log.i(TAG, "onFailure");
                System.out.println(t.getMessage());
            }
        });
    }

}
