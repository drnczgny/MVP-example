package com.example.adrian.mymvvmexample.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.adrian.mymvvmexample.R;
import com.example.adrian.mymvvmexample.base.di.BaseComponent;

public class BaseActivity extends AppCompatActivity {

    private static final String TAG = BaseActivity.class.getSimpleName();

    private boolean injected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        if(!injected) {
            inject();
        }

//        BaseComponent baseComponent = DaggerBaseComponent.builder()
//                .baseModule(new BaseModule(this))
//                .appComponent(MyApp.get(this).getAppComponent())
//                .build();
//        baseComponent.inject(this);
    }

    protected void inject() {
        BaseComponent.Injector.buildComponent(this).inject(this);
        injected = true;
    }
}
