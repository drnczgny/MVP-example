package com.example.adrian.mymvpexample.omdb.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.adrian.mymvpexample.R;

public class OmdbApiActivity extends AppCompatActivity implements OmdbApiView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_omdb_api);




    }
}
