package com.example.adrian.mymvvmexample.jsonplaceholder.presenter;

/**
 * Created by Adrian_Czigany on 3/8/2017.
 */

public interface JsonPlaceholderApiPresenter {

    public void onClickBtnFindAllPost();

    public void onClickBtnPostById(final int id);

    public void onClickBtnFindAllComment();

    public void onClickBtnFindAllAlbum();

    public void onClickBtnFindAllPhoto();

    public void onClickBtnFindAllTodo();

    public void onClickBtnFindAllUser();
}
