package com.example.adrian.mymvpexample.users.di;

import com.example.adrian.mymvpexample.base.di.ActivityScope;
import com.example.adrian.mymvpexample.jsonplaceholder.di.JsonPlaceholderInteractorModule;
import com.example.adrian.mymvpexample.jsonplaceholder.interactor.UserInteractor;
import com.example.adrian.mymvpexample.users.presenter.UsersPagePresenter;
import com.example.adrian.mymvpexample.users.presenter.UsersPagePresenterImpl;
import com.example.adrian.mymvpexample.users.view.UsersPageActivity;
import com.example.adrian.mymvpexample.users.view.UsersPageView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Adrian_Czigany on 3/17/2017.
 */

@Module(includes = {JsonPlaceholderInteractorModule.class})
public class UsersPageModule {

    UsersPageActivity usersPageActivity;

    public UsersPageModule(UsersPageActivity usersPageActivity) {
        this.usersPageActivity = usersPageActivity;
    }

    @ActivityScope
    @Provides
    UsersPageView providesUsersPageView() {
        return this.usersPageActivity;
    }

    @ActivityScope
    @Provides
    UsersPagePresenter providesUsersPagePresenter(UsersPageView usersPageView, UserInteractor userInteractor) {
        return new UsersPagePresenterImpl(usersPageView, userInteractor);
    }


}
