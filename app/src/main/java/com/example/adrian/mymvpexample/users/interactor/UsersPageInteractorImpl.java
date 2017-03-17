package com.example.adrian.mymvpexample.users.interactor;

import com.example.adrian.mymvpexample.jsonplaceholder.service.UserService;

/**
 * Created by Adrian_Czigany on 3/17/2017.
 */

public class UsersPageInteractorImpl implements UsersPageInteractor {

    private UserService userService;

    public UsersPageInteractorImpl(UserService userService) {
        this.userService = userService;
    }
}
