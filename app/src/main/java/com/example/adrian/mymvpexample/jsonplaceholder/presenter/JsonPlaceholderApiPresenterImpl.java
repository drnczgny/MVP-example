package com.example.adrian.mymvpexample.jsonplaceholder.presenter;

import com.example.adrian.mymvpexample.jsonplaceholder.di.JsonPlaceholderApiComponent;
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

        JsonPlaceholderApiComponent.Injector.buildComponent((JsonPlaceholderApiActivity) jsonPlaceholderApiView).inject(this);

    }

    @Override
    public void onClickBtnFindAllPost() {
        postInteractor.findAllPost();
    }

    @Override
    public void onClickBtnPostById(final int id) {
        postInteractor.findPostById(id);
    }

    @Override
    public void onClickBtnFindAllComment() {
        commentInteractor.findAllComment();
    }

    @Override
    public void onClickBtnFindAllAlbum() {
        albumInteractor.findAllAlbum();
    }

    @Override
    public void onClickBtnFindAllPhoto() {
        photoInteractor.findAllPhoto();
    }

    @Override
    public void onClickBtnFindAllTodo() {
        todoInteractor.findAllTodo();
    }

    @Override
    public void onClickBtnFindAllUser() {
        userInteractor.findAllUser();
    }
}
