package com.example.adrian.mymvpexample.jsonplaceholder.service;


import com.example.adrian.mymvpexample.jsonplaceholder.model.Post;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by Adrian_Czigany on 3/8/2017.
 */

public interface PostService {

    @GET("/posts")
    Observable<List<Post>> findAllPost();

    @GET("/posts/{id}")
    Observable<Post> findPostById(@Path("id") int id);

}
