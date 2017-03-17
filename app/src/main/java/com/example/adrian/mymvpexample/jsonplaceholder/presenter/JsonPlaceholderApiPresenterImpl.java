package com.example.adrian.mymvpexample.jsonplaceholder.presenter;

import com.example.adrian.mymvpexample.jsonplaceholder.interactor.PostInteractor;
import com.example.adrian.mymvpexample.jsonplaceholder.view.JsonPlaceholderApiView;

/**
 * Created by Adrian_Czigany on 3/8/2017.
 */

public class JsonPlaceholderApiPresenterImpl implements JsonPlaceholderApiPresenter {

    private JsonPlaceholderApiView jsonPlaceholderApiView;


    //TODO: Constructor injection.
    private PostInteractor postInteractor;


//    CommentInteractor commentInteractor;
//
//    @Injectfgh
//    AlbumInteractor albumInteractor;
//
//    @Inject
//    PhotoInteractor photoInteractor;
//
//    @Inject
//    TodoInteractor todoInteractor;
//
//    @Inject
////    @Named("withService")
//            UserInteractor userInteractor;

    public JsonPlaceholderApiPresenterImpl(JsonPlaceholderApiView jsonPlaceholderApiView, PostInteractor postInteractor) {
        this.jsonPlaceholderApiView = jsonPlaceholderApiView;
        this.postInteractor = postInteractor;
        postInteractor.toString();
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
//        commentInteractor.findAllComment();
    }

    @Override
    public void onClickBtnFindAllAlbum() {
//        albumInteractor.findAllAlbum();
    }

    @Override
    public void onClickBtnFindAllPhoto() {
//        photoInteractor.findAllPhoto();
    }

    @Override
    public void onClickBtnFindAllTodo() {
//        todoInteractor.findAllTodo();
    }

    @Override
    public void onClickBtnFindAllUser() {
//        userInteractor.findAllUser();
    }
}
