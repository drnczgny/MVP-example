package com.example.adrian.mymvvmexample.login.di;

import com.example.adrian.mymvvmexample.app.di.AppComponent;
import com.example.adrian.mymvvmexample.login.view.LoginActivity;

import dagger.Component;

/**
 * Created by cadri on 2017. 03. 06..
 */

@LoginScope
@Component(dependencies = AppComponent.class, modules = {LoginModule.class})
public interface LoginComponent {

    void inject(LoginActivity loginActivity);

    final class Injector {
        private Injector() {
        }

        public static LoginComponent buildComponent(LoginActivity activity) {
            return DaggerLoginComponent.builder()
                    .appComponent(AppComponent.Injector.getComponent())
                    .loginModule(new LoginModule(activity))
                    .build();
        }
    }


}
