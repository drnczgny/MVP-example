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
import com.example.adrian.mymvpexample.jsonplaceholder.view.JsonPlaceholderApiActivity;
import com.example.adrian.mymvpexample.jsonplaceholder.view.JsonPlaceholderApiView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Adrian_Czigany on 3/8/2017.
 */

@Module(includes = JsonPlaceholderServiceModule.class)
public class JsonPlaceholderApiBaseModule {

    JsonPlaceholderApiActivity jsonPlaceholderApiActivity;

    public JsonPlaceholderApiBaseModule(JsonPlaceholderApiActivity jsonPlaceholderApiActivity) {
        this.jsonPlaceholderApiActivity = jsonPlaceholderApiActivity;
    }

    @JsonPlaceholderScope
    @Provides
    JsonPlaceholderApiView providesJsonPlaceholderApiView() {
        return jsonPlaceholderApiActivity;
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

//    @JsonPlaceholderScope
//    @Provides
//    @Named("withService")
//    UserInteractor provideUserInteractorWithService(UserService userService) {
//        return new UserInteractorImpl(providesJsonPlaceholderApiView(), userService);
//    }

    @JsonPlaceholderScope
    @Provides
    JsonPlaceholderApiPresenter providesJsonPlaceholderApiPresenter(JsonPlaceholderApiView jsonPlaceholderApiView, PostInteractor postInteractor) {
        return new JsonPlaceholderApiPresenterImpl(jsonPlaceholderApiView, postInteractor);
    }

}
