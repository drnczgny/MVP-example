package com.example.adrian.mymvpexample.omdb.view;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.adrian.mymvpexample.R;
import com.example.adrian.mymvpexample.omdb.presenter.OmdbPresenter;
import com.example.adrian.mymvpexample.omdb.presenter.OmdbPresenterImpl;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OmdbApiFragment extends Fragment implements OmdbApiView {

    @BindView(R.id.rvMovies)
    RecyclerView rvMovies;

    private OmdbPresenter omdbPresenter = new OmdbPresenterImpl(this);


    public OmdbApiFragment() {
    }

    public static OmdbApiFragment newInstance() {
        OmdbApiFragment fragment = new OmdbApiFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_omdb_api, container, false);

        ButterKnife.bind(this, view);

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {

    }

}
