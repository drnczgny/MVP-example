package com.example.adrian.mymvvmexample.base.di;

import com.example.adrian.mymvvmexample.base.BaseActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Adrian_Czigany on 3/9/2017.
 */

@Module
public class BaseModule {

    private BaseActivity baseActivity;

    public BaseModule(BaseActivity baseActivity) {
        this.baseActivity = baseActivity;
    }

    @BaseScope
    @Provides
    BaseActivity provideBaseActivity() {
        return baseActivity;
    }

}
