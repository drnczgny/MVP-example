package com.example.adrian.mymvpexample.main.presenter;

import com.example.adrian.mymvpexample.main.view.MainView;

/**
 * Created by Adrian_Czigany on 3/1/2017.
 */

public class MainPresenterImpl implements MainPresenter {

    private MainView mainView;

    public MainPresenterImpl(MainView mainView) {
        this.mainView = mainView;
    }

    @Override
    public void setUpNavDrawer() {
        mainView.setUpNavDrawer();
    }
}
