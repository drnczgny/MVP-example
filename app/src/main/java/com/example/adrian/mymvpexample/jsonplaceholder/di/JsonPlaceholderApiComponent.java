package com.example.adrian.mymvpexample.jsonplaceholder.di;

import com.example.adrian.mymvpexample.app.di.AppComponent;
import com.example.adrian.mymvpexample.jsonplaceholder.interactor.UserInteractor;
import com.example.adrian.mymvpexample.jsonplaceholder.view.JsonPlaceholderApiActivity;

import dagger.Component;

/**
 * Created by Adrian_Czigany on 3/8/2017.
 */

@JsonPlaceholderScope
@Component(dependencies = AppComponent.class, modules = {JsonPlaceholderApiBaseModule.class})
public interface JsonPlaceholderApiComponent {

    void inject(JsonPlaceholderApiActivity jsonPlaceholderApiActivity);

    UserInteractor userInteractor();

//    @Named("withService")
//    UserInteractor userInteractorWithService();

    final class Injector {

        private static JsonPlaceholderApiComponent jsonPlaceholderApiComponent;

        private Injector() {
        }

        public static JsonPlaceholderApiComponent buildComponent(JsonPlaceholderApiActivity activity) {
            jsonPlaceholderApiComponent = DaggerJsonPlaceholderApiComponent.builder()
                    .appComponent(AppComponent.Injector.getComponent())
                    .jsonPlaceholderApiBaseModule(new JsonPlaceholderApiBaseModule(activity))
                    .build();

            return jsonPlaceholderApiComponent;
        }

        public static JsonPlaceholderApiComponent getJsonPlaceholderApiComponent() {
            return jsonPlaceholderApiComponent;
        }
    }

}
