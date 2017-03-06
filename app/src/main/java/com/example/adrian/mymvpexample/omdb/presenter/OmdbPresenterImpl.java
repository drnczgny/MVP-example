package com.example.adrian.mymvpexample.omdb.presenter;

import com.example.adrian.mymvpexample.omdb.service.OmdbApiService;
import com.example.adrian.mymvpexample.omdb.view.OmdbApiView;

/**
 * Created by Adrian_Czigany on 3/2/2017.
 */

public class OmdbPresenterImpl implements OmdbPresenter {

    private OmdbApiView omdbApiView;
    private OmdbApiService omdbApiService;
    private OmdbInteractor omdbInteractor;

    public OmdbPresenterImpl(OmdbApiView omdbApiView, OmdbApiService omdbApiService) {
        this.omdbApiView = omdbApiView;
        this.omdbApiService = omdbApiService;
        this.omdbInteractor = new OmdbInteractorImpl(this.omdbApiService);
    }

    @Override
    public void findAllMovie() {
        omdbInteractor.findAllMovie();
    }

    @Override
    public void findMovieByTitle(String title) {
        omdbInteractor.findMovieByTitle(title);
    }

    @Override
    public void findMovieByYear(int year) {
        omdbInteractor.findMovieByYear(year);
        omdbApiView.test();
    }

}
