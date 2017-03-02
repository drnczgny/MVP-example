package com.example.adrian.mymvpexample.omdb.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.adrian.mymvpexample.R;
import com.example.adrian.mymvpexample.utils.ActivityUtils;

import butterknife.ButterKnife;

public class OmdbApiActivity extends AppCompatActivity {

    private static final String TAG = OmdbApiActivity.class.getName();

//    @BindView(R.id.content_frame)
//    FrameLayout content_frame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_omdb_api);

        ButterKnife.bind(this);

        OmdbApiFragment omdbApiFragment = (OmdbApiFragment) getSupportFragmentManager().findFragmentById(R.id.content_frame);
        if(omdbApiFragment == null) {
            omdbApiFragment = OmdbApiFragment.newInstance();
        }
        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), omdbApiFragment, R.id.content_frame);





    }
}
