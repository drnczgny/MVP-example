package com.example.adrian.mymvpexample.jsonplaceholder.service;

import com.example.adrian.mymvpexample.jsonplaceholder.model.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Adrian_Czigany on 3/8/2017.
 */

public interface PostService {

    @GET("/posts")
    Call<List<Post>> findAllPost();

    @GET("/posts/{id}")
    Call<Post> findPostById(@Path("id") int id);

}
