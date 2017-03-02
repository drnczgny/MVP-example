package com.example.adrian.mymvpexample.omdb.presenter;

import com.example.adrian.mymvpexample.omdb.view.OmdbApiView;

/**
 * Created by Adrian_Czigany on 3/2/2017.
 */

public class OmdbPresenterImpl implements OmdbPresenter {

    private OmdbApiView omdbApiView;

    public OmdbPresenterImpl(OmdbApiView omdbApiView) {
        this.omdbApiView = omdbApiView;
    }
}
