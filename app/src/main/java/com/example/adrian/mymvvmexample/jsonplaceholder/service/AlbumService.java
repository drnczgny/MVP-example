package com.example.adrian.mymvvmexample.jsonplaceholder.service;

import com.example.adrian.mymvvmexample.jsonplaceholder.model.Album;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Adrian_Czigany on 3/8/2017.
 */

public interface AlbumService {

    @GET("/albums")
    Call<List<Album>> findAllAlbum();

}
