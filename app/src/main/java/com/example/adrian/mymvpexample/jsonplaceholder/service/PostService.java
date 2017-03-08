package com.example.adrian.mymvpexample.jsonplaceholder.service;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Adrian_Czigany on 3/8/2017.
 */

public interface PostService {

    @GET("/posts")
    Call<String> findAllPost();

    @GET("/posts/{id}")
    Call<String> findPostById(@Path("id") int id);

}
