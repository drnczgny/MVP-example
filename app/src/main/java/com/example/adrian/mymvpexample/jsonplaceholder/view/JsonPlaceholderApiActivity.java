package com.example.adrian.mymvpexample.jsonplaceholder.view;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.example.adrian.mymvpexample.R;
import com.example.adrian.mymvpexample.base.BaseActivity;
import com.example.adrian.mymvpexample.jsonplaceholder.di.JsonPlaceholderApiComponent;
import com.example.adrian.mymvpexample.jsonplaceholder.presenter.JsonPlaceholderApiPresenter;
import com.example.adrian.mymvpexample.users.view.UsersPageActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class JsonPlaceholderApiActivity extends BaseActivity implements JsonPlaceholderApiView {

    private static final String TAG = JsonPlaceholderApiActivity.class.getName();

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

    @BindView(R.id.btnUsersPage)
    Button btnUsersPage;

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

    @OnClick(R.id.btnUsersPage)
    public void onClickBtnUsersPage() {
        Log.i(TAG, "onClickBtnUsersPage method ....");
        Intent intent = new Intent(JsonPlaceholderApiActivity.this, UsersPageActivity.class);
        startActivity(intent);
    }

}
