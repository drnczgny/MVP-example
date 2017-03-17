package com.example.adrian.mymvpexample.jsonplaceholder.presenter;

import com.example.adrian.mymvpexample.jsonplaceholder.interactor.AlbumInteractor;
import com.example.adrian.mymvpexample.jsonplaceholder.interactor.CommentInteractor;
import com.example.adrian.mymvpexample.jsonplaceholder.interactor.PhotoInteractor;
import com.example.adrian.mymvpexample.jsonplaceholder.interactor.PostInteractor;
import com.example.adrian.mymvpexample.jsonplaceholder.interactor.TodoInteractor;
import com.example.adrian.mymvpexample.jsonplaceholder.interactor.UserInteractor;
import com.example.adrian.mymvpexample.jsonplaceholder.view.JsonPlaceholderApiView;

/**
 * Created by Adrian_Czigany on 3/8/2017.
 */

public class JsonPlaceholderApiPresenterImpl implements JsonPlaceholderApiPresenter {

    private JsonPlaceholderApiView jsonPlaceholderApiView;

    private PostInteractor postInteractor;

    private CommentInteractor commentInteractor;

    private AlbumInteractor albumInteractor;

    private PhotoInteractor photoInteractor;

    private TodoInteractor todoInteractor;

    private UserInteractor userInteractor;

    public JsonPlaceholderApiPresenterImpl(JsonPlaceholderApiView jsonPlaceholderApiView,
                                           PostInteractor postInteractor,
                                           CommentInteractor commentInteractor,
                                           AlbumInteractor albumInteractor,
                                           PhotoInteractor photoInteractor,
                                           TodoInteractor todoInteractor,
                                           UserInteractor userInteractor) {

        this.jsonPlaceholderApiView = jsonPlaceholderApiView;
        this.postInteractor = postInteractor;
        this.commentInteractor = commentInteractor;
        this.albumInteractor = albumInteractor;
        this.photoInteractor = photoInteractor;
        this.todoInteractor = todoInteractor;
        this.userInteractor = userInteractor;

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
