package com.example.adrian.mymvpexample.jsonplaceholder.di;

import com.example.adrian.mymvpexample.jsonplaceholder.interactor.AlbumInteractor;
import com.example.adrian.mymvpexample.jsonplaceholder.interactor.AlbumInteractorImpl;
import com.example.adrian.mymvpexample.jsonplaceholder.interactor.CommentInteractor;
import com.example.adrian.mymvpexample.jsonplaceholder.interactor.CommentInteractorImpl;
import com.example.adrian.mymvpexample.jsonplaceholder.interactor.PhotoInteractor;
import com.example.adrian.mymvpexample.jsonplaceholder.interactor.PhotoInteractorImpl;
import com.example.adrian.mymvpexample.jsonplaceholder.interactor.PostInteractor;
import com.example.adrian.mymvpexample.jsonplaceholder.interactor.PostInteractorImpl;
import com.example.adrian.mymvpexample.jsonplaceholder.interactor.TodoInteractor;
import com.example.adrian.mymvpexample.jsonplaceholder.interactor.TodoInteractorImpl;
import com.example.adrian.mymvpexample.jsonplaceholder.interactor.UserInteractor;
import com.example.adrian.mymvpexample.jsonplaceholder.interactor.UserInteractorImpl;
import com.example.adrian.mymvpexample.jsonplaceholder.presenter.JsonPlaceholderApiPresenter;
import com.example.adrian.mymvpexample.jsonplaceholder.presenter.JsonPlaceholderApiPresenterImpl;
import com.example.adrian.mymvpexample.jsonplaceholder.service.AlbumService;
import com.example.adrian.mymvpexample.jsonplaceholder.service.CommentService;
import com.example.adrian.mymvpexample.jsonplaceholder.service.JsonPlaceholderApiService;
import com.example.adrian.mymvpexample.jsonplaceholder.service.PhotoService;
import com.example.adrian.mymvpexample.jsonplaceholder.service.PostService;
import com.example.adrian.mymvpexample.jsonplaceholder.service.TodoService;
import com.example.adrian.mymvpexample.jsonplaceholder.service.UserService;
import com.example.adrian.mymvpexample.jsonplaceholder.view.JsonPlaceholderApiActivity;
import com.example.adrian.mymvpexample.jsonplaceholder.view.JsonPlaceholderApiView;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by Adrian_Czigany on 3/8/2017.
 */

@Module
public class JsonPlaceholderApiModule {

    JsonPlaceholderApiActivity jsonPlaceholderApiActivity;

    public JsonPlaceholderApiModule(JsonPlaceholderApiActivity jsonPlaceholderApiActivity) {
        this.jsonPlaceholderApiActivity = jsonPlaceholderApiActivity;
    }

    @JsonPlaceholderScope
    @Provides
    JsonPlaceholderApiView providesJsonPlaceholderApiView() {
        return jsonPlaceholderApiActivity;
    }

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

    @JsonPlaceholderScope
    @Provides
    JsonPlaceholderApiService provideJsonPlaceholderApiService(@Named("jsonplaceholderapi") Retrofit retrofit) {
        JsonPlaceholderApiService jsonPlaceholderApiService = retrofit.create(JsonPlaceholderApiService.class);
        return jsonPlaceholderApiService;
    }

    @JsonPlaceholderScope
    @Provides
    PostInteractor providePostInteractor() {
        return new PostInteractorImpl(providesJsonPlaceholderApiView());
    }

    @JsonPlaceholderScope
    @Provides
    CommentInteractor provideCommentInteractor() {
        return new CommentInteractorImpl(providesJsonPlaceholderApiView());
    }

    @JsonPlaceholderScope
    @Provides
    AlbumInteractor provideAlbumInteractor() {
        return new AlbumInteractorImpl(providesJsonPlaceholderApiView());
    }

    @JsonPlaceholderScope
    @Provides
    PhotoInteractor providePhotoInteractor() {
        return new PhotoInteractorImpl(providesJsonPlaceholderApiView());
    }

    @JsonPlaceholderScope
    @Provides
    TodoInteractor provideTodoInteractor() {
        return new TodoInteractorImpl(providesJsonPlaceholderApiView());
    }

    @JsonPlaceholderScope
    @Provides
    UserInteractor provideUserInteractor() {
        return new UserInteractorImpl(providesJsonPlaceholderApiView());
    }

    @JsonPlaceholderScope
    @Provides
    JsonPlaceholderApiPresenter providesJsonPlaceholderApiPresenter() {
        return new JsonPlaceholderApiPresenterImpl(providesJsonPlaceholderApiView());
    }

}
