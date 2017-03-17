package com.example.adrian.mymvpexample.main.di;

import com.example.adrian.mymvpexample.main.presenter.MainPresenter;
import com.example.adrian.mymvpexample.main.presenter.MainPresenterImpl;
import com.example.adrian.mymvpexample.main.view.MainActivity;
import com.example.adrian.mymvpexample.main.view.MainView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by cadri on 2017. 03. 06..
 */

@Module
public class MainModule {

    private MainActivity mainActivity;

    public MainModule(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Provides
    @MainScope
    MainPresenter provideMainPresenter(MainView mainView) {
        return new MainPresenterImpl(mainView);
    }

    @Provides
    @MainScope
    MainView provideMainView() {
        return mainActivity;
    }
}
