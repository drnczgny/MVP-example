package com.example.adrian.mymvpexample.users.di;

import com.example.adrian.mymvpexample.users.view.UsersPageActivity;

import dagger.Module;

/**
 * Created by Adrian_Czigany on 3/17/2017.
 */

@Module
public class UsersPageModule {

    UsersPageActivity usersPageActivity;

    public UsersPageModule(UsersPageActivity usersPageActivity) {
        this.usersPageActivity = usersPageActivity;
    }


}
