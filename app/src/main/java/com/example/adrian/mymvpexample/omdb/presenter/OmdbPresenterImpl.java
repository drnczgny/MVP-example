package com.example.adrian.mymvpexample.omdb.presenter;

import com.example.adrian.mymvpexample.omdb.view.OmdbApiView;

/**
 * Created by Adrian_Czigany on 3/2/2017.
 */

public class OmdbPresenterImpl implements OmdbPresenter {

    private OmdbApiView omdbApiView;
    private OmdbInteractor omdbInteractor;

    public OmdbPresenterImpl(OmdbApiView omdbApiView) {
        this.omdbApiView = omdbApiView;
        omdbInteractor = new OmdbInteractorImpl();
    }

    @Override
    public void findAllMovie() {
        omdbInteractor.findAllMovie();
    }

    @Override
    public void findMovieByTitle(String title) {
        omdbInteractor.findMovieByTitle(title);
    }
}
