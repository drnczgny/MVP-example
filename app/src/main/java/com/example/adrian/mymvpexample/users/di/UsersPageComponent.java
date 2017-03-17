package com.example.adrian.mymvpexample.users.di;

import com.example.adrian.mymvpexample.jsonplaceholder.di.JsonPlaceholderApiComponent;
import com.example.adrian.mymvpexample.users.view.UsersPageActivity;

import dagger.Component;

/**
 * Created by Adrian_Czigany on 3/17/2017.
 */

@UsersPageScope
@Component(dependencies = JsonPlaceholderApiComponent.class, modules = {UsersPageModule.class})
public interface UsersPageComponent {

    void inject(UsersPageActivity usersPageActivity);

    final class Injector {
        private Injector() {
        }

        public static UsersPageComponent buildComponent(UsersPageActivity activity) {
            return DaggerUsersPageComponent.builder()
                    .jsonPlaceholderApiComponent(JsonPlaceholderApiComponent.Injector.getJsonPlaceholderApiComponent())
                    .usersPageModule(new UsersPageModule(activity))
                    .build();
        }
    }

}
