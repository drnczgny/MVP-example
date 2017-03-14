package com.example.adrian.mymvvmexample.jsonplaceholder.di;

import com.example.adrian.mymvvmexample.jsonplaceholder.service.AlbumService;
import com.example.adrian.mymvvmexample.jsonplaceholder.service.CommentService;
import com.example.adrian.mymvvmexample.jsonplaceholder.service.PhotoService;
import com.example.adrian.mymvvmexample.jsonplaceholder.service.PostService;
import com.example.adrian.mymvvmexample.jsonplaceholder.service.TodoService;
import com.example.adrian.mymvvmexample.jsonplaceholder.service.UserService;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by Adrian_Czigany on 3/9/2017.
 */

@Module
public class JsonPlaceholderServiceModule {

    @JsonPlaceholderScope
    @Provides
    PostService providePostService(@Named("jsonplaceholderapi") Retrofit retrofit) {
        PostService postService = retrofit.create(PostService.class);
        return postService;
    }

    @JsonPlaceholderScope
    @Provides
    CommentService provideCommentService(@Named("jsonplaceholderapi") Retrofit retrofit) {
        CommentService commentService = retrofit.create(CommentService.class);
        return commentService;
    }

    @JsonPlaceholderScope
    @Provides
    AlbumService provideAlbumService(@Named("jsonplaceholderapi") Retrofit retrofit) {
        AlbumService albumService = retrofit.create(AlbumService.class);
        return albumService;
    }

    @JsonPlaceholderScope
    @Provides
    PhotoService providePhotoService(@Named("jsonplaceholderapi") Retrofit retrofit) {
        PhotoService photoService = retrofit.create(PhotoService.class);
        return photoService;
    }

    @JsonPlaceholderScope
    @Provides
    TodoService provideTodoService(@Named("jsonplaceholderapi") Retrofit retrofit) {
        TodoService todoService = retrofit.create(TodoService.class);
        return todoService;
    }

    @JsonPlaceholderScope
    @Provides
    UserService provideUserService(@Named("jsonplaceholderapi") Retrofit retrofit) {
        UserService userService = retrofit.create(UserService.class);
        return userService;
    }

}
