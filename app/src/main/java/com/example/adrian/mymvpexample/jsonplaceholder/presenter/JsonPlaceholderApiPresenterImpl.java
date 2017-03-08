package com.example.adrian.mymvpexample.jsonplaceholder.presenter;

import com.example.adrian.mymvpexample.app.MyApp;
import com.example.adrian.mymvpexample.jsonplaceholder.di.DaggerJsonPlaceholderApiComponent;
import com.example.adrian.mymvpexample.jsonplaceholder.di.JsonPlaceholderApiComponent;
import com.example.adrian.mymvpexample.jsonplaceholder.di.JsonPlaceholderApiModule;
import com.example.adrian.mymvpexample.jsonplaceholder.interactor.AlbumInteractor;
import com.example.adrian.mymvpexample.jsonplaceholder.interactor.CommentInteractor;
import com.example.adrian.mymvpexample.jsonplaceholder.interactor.PhotoInteractor;
import com.example.adrian.mymvpexample.jsonplaceholder.interactor.PostInteractor;
import com.example.adrian.mymvpexample.jsonplaceholder.interactor.TodoInteractor;
import com.example.adrian.mymvpexample.jsonplaceholder.interactor.UserInteractor;
import com.example.adrian.mymvpexample.jsonplaceholder.view.JsonPlaceholderApiActivity;
import com.example.adrian.mymvpexample.jsonplaceholder.view.JsonPlaceholderApiView;

import javax.inject.Inject;

/**
 * Created by Adrian_Czigany on 3/8/2017.
 */

public class JsonPlaceholderApiPresenterImpl implements JsonPlaceholderApiPresenter {

    private JsonPlaceholderApiView jsonPlaceholderApiView;

    @Inject
    PostInteractor postInteractor;

    @Inject
    CommentInteractor commentInteractor;

    @Inject
    AlbumInteractor albumInteractor;

    @Inject
    PhotoInteractor photoInteractor;

    @Inject
    TodoInteractor todoInteractor;

    @Inject
    UserInteractor userInteractor;

    public JsonPlaceholderApiPresenterImpl(JsonPlaceholderApiView jsonPlaceholderApiView) {
        this.jsonPlaceholderApiView = jsonPlaceholderApiView;

        JsonPlaceholderApiComponent jsonPlaceholderApiComponent = DaggerJsonPlaceholderApiComponent.builder()
                .jsonPlaceholderApiModule(new JsonPlaceholderApiModule((JsonPlaceholderApiActivity) jsonPlaceholderApiView))
                .appComponent(MyApp.get((JsonPlaceholderApiActivity)jsonPlaceholderApiView).getAppComponent())
                .build();
        jsonPlaceholderApiComponent.inject(this);

//        postInteractor.findAllPost();
//        postInteractor.findPostById(1);

//        commentInteractor.findAllComment();

//        albumInteractor.findAllAlbum();

//        photoInteractor.findAllPhoto();

//        todoInteractor.findAllTodo();

        userInteractor.findAllUser();


    }
}
