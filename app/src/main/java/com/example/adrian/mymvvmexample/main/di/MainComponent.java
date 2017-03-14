package com.example.adrian.mymvvmexample.main.di;

import com.example.adrian.mymvvmexample.app.di.AppComponent;
import com.example.adrian.mymvvmexample.main.view.MainActivity;

import dagger.Component;

/**
 * Created by cadri on 2017. 03. 06..
 */

@MainScope
@Component(dependencies = AppComponent.class, modules = {MainModule.class})
public interface MainComponent {

    void inject(MainActivity mainActivity);

    final class Injector {
        private Injector() {
        }

        public static MainComponent buildComponent(MainActivity activity) {
            return DaggerMainComponent.builder()
                    .appComponent(AppComponent.Injector.getComponent())
                    .mainModule(new MainModule(activity))
                    .build();
        }
    }

}
