package com.example.adrian.mymvpexample.jsonplaceholder.di;

import com.example.adrian.mymvpexample.app.di.AppComponent;
import com.example.adrian.mymvpexample.jsonplaceholder.interactor.AlbumInteractorImpl;
import com.example.adrian.mymvpexample.jsonplaceholder.interactor.CommentInteractorImpl;
import com.example.adrian.mymvpexample.jsonplaceholder.interactor.PhotoInteractorImpl;
import com.example.adrian.mymvpexample.jsonplaceholder.interactor.PostInteractorImpl;
import com.example.adrian.mymvpexample.jsonplaceholder.interactor.TodoInteractorImpl;
import com.example.adrian.mymvpexample.jsonplaceholder.interactor.UserInteractorImpl;
import com.example.adrian.mymvpexample.jsonplaceholder.presenter.JsonPlaceholderApiPresenterImpl;
import com.example.adrian.mymvpexample.jsonplaceholder.view.JsonPlaceholderApiActivity;

import dagger.Component;

/**
 * Created by Adrian_Czigany on 3/8/2017.
 */

@JsonPlaceholderScope
@Component(dependencies = AppComponent.class, modules = {JsonPlaceholderApiModule.class})
public interface JsonPlaceholderApiComponent {

    void inject(JsonPlaceholderApiActivity jsonPlaceholderApiActivity);

    void inject(JsonPlaceholderApiPresenterImpl jsonPlaceholderApiPresenterImpl);

    void inject(PostInteractorImpl postInteractorImpl);

    void inject(CommentInteractorImpl commentInteractorImpl);

    void inject(AlbumInteractorImpl albumInteractorImpl);

    void inject(PhotoInteractorImpl photoInteractorImpl);

    void inject(TodoInteractorImpl todoInteractorImpl);

    void inject(UserInteractorImpl userInteractorImpl);

}
