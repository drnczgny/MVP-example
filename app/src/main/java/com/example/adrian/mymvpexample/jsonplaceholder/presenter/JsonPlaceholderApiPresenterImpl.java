package com.example.adrian.mymvpexample.jsonplaceholder.presenter;

import com.example.adrian.mymvpexample.jsonplaceholder.view.JsonPlaceholderApiView;

/**
 * Created by Adrian_Czigany on 3/8/2017.
 */

public class JsonPlaceholderApiPresenterImpl implements JsonPlaceholderApiPresenter {

    private JsonPlaceholderApiView jsonPlaceholderApiView;

    private JsonPlaceholderApiInteractor jsonPlaceholderApiInteractorImpl;

    public JsonPlaceholderApiPresenterImpl(JsonPlaceholderApiView jsonPlaceholderApiView, JsonPlaceholderApiInteractor jsonPlaceholderApiInteractor) {
        this.jsonPlaceholderApiView = jsonPlaceholderApiView;
        this.jsonPlaceholderApiInteractorImpl = jsonPlaceholderApiInteractor;


    }
}
