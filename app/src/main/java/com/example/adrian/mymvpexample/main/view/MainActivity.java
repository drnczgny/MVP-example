package com.example.adrian.mymvpexample.main.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.adrian.mymvpexample.R;
import com.example.adrian.mymvpexample.apteligent.view.ApteligentActivity;
import com.example.adrian.mymvpexample.main.presenter.MainPresenter;
import com.example.adrian.mymvpexample.main.presenter.MainPresenterImpl;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainView {

    private static final String TAG = MainActivity.class.getName().toString();

    private int navItemIndex = 0;

    private MainPresenter mainPresenter;

    @BindView(R.id.navigationView) NavigationView navigationView;
    @BindView(R.id.drawerLayout) DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        mainPresenter = new MainPresenterImpl(this);

        mainPresenter.setUpNavDrawer();

    }

    @Override
    public void setUpNavDrawer() {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            public boolean onNavigationItemSelected(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.nav_home:
                        navItemIndex = 0;
                        break;
                    case R.id.nav_apteligent:
                        navItemIndex = 1;
                        startActivity(new Intent(MainActivity.this, ApteligentActivity.class));
                        drawerLayout.closeDrawers();
                        return true;
                    default:
                        navItemIndex = 0;
                }

                if (menuItem.isChecked()) {
                    menuItem.setChecked(false);
                } else {
                    menuItem.setChecked(true);
                }
                menuItem.setChecked(true);

                return true;
            }
        });
    }


}
