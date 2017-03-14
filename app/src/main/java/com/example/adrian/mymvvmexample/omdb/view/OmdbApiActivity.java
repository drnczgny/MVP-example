package com.example.adrian.mymvvmexample.omdb.view;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Button;

import com.example.adrian.mymvvmexample.R;
import com.example.adrian.mymvvmexample.base.BaseActivity;
import com.example.adrian.mymvvmexample.omdb.di.OmdbComponent;
import com.example.adrian.mymvvmexample.omdb.presenter.OmdbPresenter;
import com.example.adrian.mymvvmexample.omdb.service.OmdbApiService;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OmdbApiActivity extends BaseActivity implements OmdbApiView {

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
    OmdbPresenter omdbPresenter;

    @Inject
    OmdbApiService omdbApiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_omdb_api);

        ButterKnife.bind(this);
        OmdbComponent.Injector.buildComponent(this).inject(this);

        omdbApiService.toString();
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
