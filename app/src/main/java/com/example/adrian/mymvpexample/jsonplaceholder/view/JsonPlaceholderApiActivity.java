package com.example.adrian.mymvpexample.jsonplaceholder.view;

import android.os.Bundle;

import com.example.adrian.mymvpexample.R;
import com.example.adrian.mymvpexample.app.BaseApp;
import com.example.adrian.mymvpexample.app.base.BaseActivity;
import com.example.adrian.mymvpexample.jsonplaceholder.di.DaggerJsonPlaceholderApiComponent;
import com.example.adrian.mymvpexample.jsonplaceholder.di.JsonPlaceholderApiComponent;
import com.example.adrian.mymvpexample.jsonplaceholder.di.JsonPlaceholderApiModule;
import com.example.adrian.mymvpexample.jsonplaceholder.presenter.JsonPlaceholderApiPresenter;

import javax.inject.Inject;

public class JsonPlaceholderApiActivity extends BaseActivity implements JsonPlaceholderApiView {

    @Inject
    JsonPlaceholderApiPresenter jsonPlaceholderApiPresenterImpl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_placeholder_api);

        JsonPlaceholderApiComponent jsonPlaceholderApiComponent = DaggerJsonPlaceholderApiComponent.builder()
                .jsonPlaceholderApiModule(new JsonPlaceholderApiModule(this))
                .appComponent(BaseApp.get(this).getAppComponent())
                .build();
        jsonPlaceholderApiComponent.inject(this);

    }
}
