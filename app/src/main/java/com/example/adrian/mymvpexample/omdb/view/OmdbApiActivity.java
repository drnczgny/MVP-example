package com.example.adrian.mymvpexample.omdb.view;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Button;

import com.example.adrian.mymvpexample.R;
import com.example.adrian.mymvpexample.app.MyApp;
import com.example.adrian.mymvpexample.omdb.di.DaggerOmdbComponent;
import com.example.adrian.mymvpexample.omdb.di.OmdbComponent;
import com.example.adrian.mymvpexample.omdb.di.OmdbModule;
import com.example.adrian.mymvpexample.omdb.presenter.OmdbPresenter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OmdbApiActivity extends AppCompatActivity implements OmdbApiView {

    private static final String TAG = OmdbApiActivity.class.getName();

    @BindView(R.id.rvMovies)
    RecyclerView rvMovies;

    @BindView(R.id.btnFindByYear)
    Button btnFindByYear;

    @BindView(R.id.btnFindByTitle)
    Button btnFindByTitle;

    @BindView(R.id.btnFindByBoth)
    Button btnFindByBoth;

    @Inject
    SharedPreferences sharedPreferences;

//    @Inject
//    OmdbApiService omdbApiService;

//    private OmdbPresenter omdbPresenter;

    @Inject
    OmdbPresenter omdbPresenter;

//    @Inject
//    @Named("OmdbPresenterImpl")
//    OmdbPresenterImpl omdbPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_omdb_api);

        ButterKnife.bind(this);

        OmdbComponent omdbComponent = DaggerOmdbComponent.builder()
                .omdbModule(new OmdbModule(this))
                .appComponent(MyApp.get(this).getAppComponent())
                .build();
        omdbComponent.inject(this);





        /* *****************************************************************************
        *****************************************************************************
        * *****************************************************************************
        * *****************************************************************************
        */
//        OmdbApiFragment omdbApiFragment = (OmdbApiFragment) getSupportFragmentManager().findFragmentById(R.id.content_frame);
//        if(omdbApiFragment == null) {
//            omdbApiFragment = OmdbApiFragment.newInstance();
//        }
//        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), omdbApiFragment, R.id.content_frame);
    }

    @OnClick(R.id.btnFindByYear)
    public void onClickBtnFindByYear() {
        omdbPresenter.findMovieByYear(2010);
    }

    @OnClick(R.id.btnFindByTitle)
    public void onClickBtnFindByTitle() {
        omdbPresenter.findMovieByTitle("Superman");
    }

    @OnClick(R.id.btnFindByBoth)
    public void onClickBtnFindByBoth() {
        omdbPresenter.findMovieByYear(2010);
        omdbPresenter.findMovieByTitle("Superman");
    }

    @Override
    public void test() {
        Log.i(TAG, " OK test !!! ");
    }
}
