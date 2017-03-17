package com.example.adrian.mymvpexample.jsonplaceholder.di;

import com.example.adrian.mymvpexample.base.di.ActivityScope;
import com.example.adrian.mymvpexample.jsonplaceholder.service.AlbumService;
import com.example.adrian.mymvpexample.jsonplaceholder.service.CommentService;
import com.example.adrian.mymvpexample.jsonplaceholder.service.PhotoService;
import com.example.adrian.mymvpexample.jsonplaceholder.service.PostService;
import com.example.adrian.mymvpexample.jsonplaceholder.service.TodoService;
import com.example.adrian.mymvpexample.jsonplaceholder.service.UserService;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by Adrian_Czigany on 3/9/2017.
 */

@Module
public class JsonPlaceholderServiceModule {

    @ActivityScope
    @Provides
    PostService providePostService(@Named("jsonplaceholderapi") Retrofit retrofit) {
        PostService postService = retrofit.create(PostService.class);
        return postService;
    }

    @ActivityScope
    @Provides
    CommentService provideCommentService(@Named("jsonplaceholderapi") Retrofit retrofit) {
        CommentService commentService = retrofit.create(CommentService.class);
        return commentService;
    }

    @ActivityScope
    @Provides
    AlbumService provideAlbumService(@Named("jsonplaceholderapi") Retrofit retrofit) {
        AlbumService albumService = retrofit.create(AlbumService.class);
        return albumService;
    }

    @ActivityScope
    @Provides
    PhotoService providePhotoService(@Named("jsonplaceholderapi") Retrofit retrofit) {
        PhotoService photoService = retrofit.create(PhotoService.class);
        return photoService;
    }

    @ActivityScope
    @Provides
    TodoService provideTodoService(@Named("jsonplaceholderapi") Retrofit retrofit) {
        TodoService todoService = retrofit.create(TodoService.class);
        return todoService;
    }

    @ActivityScope
    @Provides
    UserService provideUserService(@Named("jsonplaceholderapi") Retrofit retrofit) {
        UserService userService = retrofit.create(UserService.class);
        return userService;
    }

}
