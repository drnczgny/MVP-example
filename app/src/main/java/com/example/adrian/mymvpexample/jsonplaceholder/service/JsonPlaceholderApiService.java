package com.example.adrian.mymvpexample.jsonplaceholder.service;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Adrian_Czigany on 3/8/2017.
 */

public interface JsonPlaceholderApiService {

    public static final String BASE_URL = "http://jsonplaceholder.typicode.com";

    @GET("/posts")
    Call<String> findAllPost();

    @GET("/comments")
    Call<String> findAllComment();

    @GET("/albums")
    Call<String> findAllAlbum();

    @GET("/photos")
    Call<String> findAllPhoto();

    @GET("/todos")
    Call<String> findAllTodo();

    @GET("/users")
    Call<String> findAllUser();
}
