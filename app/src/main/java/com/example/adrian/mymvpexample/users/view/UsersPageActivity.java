package com.example.adrian.mymvpexample.users.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.adrian.mymvpexample.R;
import com.example.adrian.mymvpexample.users.di.UsersPageComponent;

public class UsersPageActivity extends AppCompatActivity {

//    @Inject
//    UserService userService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users_page);

        UsersPageComponent.Injector.buildComponent(this).inject(this);

    }
}
