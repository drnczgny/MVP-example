package com.example.adrian.mymvpexample.users.di;

import com.example.adrian.mymvpexample.app.di.AppComponent;
import com.example.adrian.mymvpexample.base.di.ActivityScope;
import com.example.adrian.mymvpexample.users.view.UsersPageActivity;

import dagger.Component;

/**
 * Created by Adrian_Czigany on 3/17/2017.
 */

@ActivityScope
@Component(dependencies = AppComponent.class, modules = {UsersPageModule.class})
public interface UsersPageComponent {

    void inject(UsersPageActivity usersPageActivity);

    final class Injector {
        private Injector() {
        }

        public static UsersPageComponent buildComponent(UsersPageActivity activity) {
            return DaggerUsersPageComponent.builder()
                    .appComponent(AppComponent.Injector.getComponent())
                    .usersPageModule(new UsersPageModule(activity))
                    .build();
        }
    }

}
