package com.example.adrian.mymvpexample.users.view;

import android.os.Bundle;
import android.widget.Button;

import com.example.adrian.mymvpexample.R;
import com.example.adrian.mymvpexample.base.BaseActivity;
import com.example.adrian.mymvpexample.users.di.UsersPageComponent;
import com.example.adrian.mymvpexample.users.presenter.UsersPagePresenter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class UsersPageActivity extends BaseActivity implements UsersPageView {

    @BindView(R.id.btnFindAllUser)
    Button btnFindAllUser;

    @Inject
    UsersPagePresenter usersPagePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users_page);

        ButterKnife.bind(this);

        UsersPageComponent.Injector.buildComponent(this).inject(this);


    }

    @OnClick(R.id.btnFindAllUser)
    public void onClickBtnFindAllUser() {
        usersPagePresenter.onClickBtnFindAllUser();
    }
}
