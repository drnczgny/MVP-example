package com.example.adrian.mymvvmexample.jsonplaceholder.view;

import android.os.Bundle;
import android.widget.Button;

import com.example.adrian.mymvvmexample.R;
import com.example.adrian.mymvvmexample.base.BaseActivity;
import com.example.adrian.mymvvmexample.jsonplaceholder.di.JsonPlaceholderApiComponent;
import com.example.adrian.mymvvmexample.jsonplaceholder.presenter.JsonPlaceholderApiPresenter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class JsonPlaceholderApiActivity extends BaseActivity implements JsonPlaceholderApiView {

    @BindView(R.id.btnFindAllPost)
    Button btnFindAllPost;

    @BindView(R.id.btnPostById)
    Button btnPostById;

    @BindView(R.id.btnFindAllComment)
    Button btnFindAllComment;

    @BindView(R.id.btnFindAllAlbum)
    Button btnFindAllAlbum;

    @BindView(R.id.btnFindAllPhoto)
    Button btnFindAllPhoto;

    @BindView(R.id.btnFindAllTodo)
    Button btnFindAllTodo;

    @BindView(R.id.btnFindAllUser)
    Button btnFindAll;

    @Inject
    JsonPlaceholderApiPresenter jsonPlaceholderApiPresenterImpl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_placeholder_api);

        ButterKnife.bind(this);
        JsonPlaceholderApiComponent.Injector.buildComponent(this).inject(this);

    }

    @OnClick(R.id.btnFindAllPost)
    public void onClickBtnFindAllPost() {
        jsonPlaceholderApiPresenterImpl.onClickBtnFindAllPost();
    }

    @OnClick(R.id.btnPostById)
    public void onClickBtnPostById() {
        jsonPlaceholderApiPresenterImpl.onClickBtnPostById(1);
    }

    @OnClick(R.id.btnFindAllComment)
    public void onClickBtnFindAllComment() {
        jsonPlaceholderApiPresenterImpl.onClickBtnFindAllComment();
    }

    @OnClick(R.id.btnFindAllAlbum)
    public void onClickBtnFindAllAlbum() {
        jsonPlaceholderApiPresenterImpl.onClickBtnFindAllAlbum();
    }

    @OnClick(R.id.btnFindAllPhoto)
    public void onClickBtnFindAllPhoto() {
        jsonPlaceholderApiPresenterImpl.onClickBtnFindAllAlbum();
    }

    @OnClick(R.id.btnFindAllTodo)
    public void onClickBtnFindAllTodo() {
        jsonPlaceholderApiPresenterImpl.onClickBtnFindAllTodo();
    }

    @OnClick(R.id.btnFindAllUser)
    public void onClickBtnFindAllUser() {
        jsonPlaceholderApiPresenterImpl.onClickBtnFindAllUser();
    }

}
