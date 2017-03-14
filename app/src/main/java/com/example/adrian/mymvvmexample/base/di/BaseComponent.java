package com.example.adrian.mymvvmexample.base.di;

import com.example.adrian.mymvvmexample.app.di.AppComponent;
import com.example.adrian.mymvvmexample.base.BaseActivity;

import dagger.Component;

/**
 * Created by Adrian_Czigany on 3/9/2017.
 */

@BaseScope
@Component(dependencies = AppComponent.class, modules = {BaseModule.class})
public interface BaseComponent {

    void inject(BaseActivity BaseActivity);

    final class Injector {
        private Injector() {
        }

        public static BaseComponent buildComponent(BaseActivity activity) {
            return DaggerBaseComponent.builder()
                    .appComponent(AppComponent.Injector.getComponent())
                    .baseModule(new BaseModule(activity))
                    .build();
        }
    }

}
