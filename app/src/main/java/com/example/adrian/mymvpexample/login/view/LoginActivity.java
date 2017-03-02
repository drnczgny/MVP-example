package com.example.adrian.mymvpexample.login.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.example.adrian.mymvpexample.R;
import com.example.adrian.mymvpexample.app.MyApp;
import com.example.adrian.mymvpexample.login.presenter.LoginPresenter;
import com.example.adrian.mymvpexample.login.presenter.LoginPresenterImpl;
import com.example.adrian.mymvpexample.main.view.MainActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity implements LoginView {

    private static final String TAG = LoginActivity.class.getName().toString();

    @BindView(R.id.etUsername)
    EditText etUsername;
    @BindView(R.id.etPassword)
    EditText etPassword;
    @BindView(R.id.btnLogIn)
    Button btnLogIn;
    @BindView(R.id.progress)
    ProgressBar progressBar;

    @Inject
    SharedPreferences sharedPreferences;

    private LoginPresenter loginPresenterImpl = new LoginPresenterImpl(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        ((MyApp) getApplication()).getAppComponent().inject(this);
    }

    @OnClick(R.id.btnLogIn)
    public void onClickLogIn() {
        loginPresenterImpl.validateCredentials(etUsername.getText().toString(), etPassword.getText().toString());
    }

    @Override
    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void errorOnUsername() {
        etUsername.setError("Cannot be empty");
    }

    @Override
    public void errorOnPassword() {
        etPassword.setError("Cannot be empty");
    }

    @Override
    public void credentialsVerified() {
        loginPresenterImpl.saveCredentialsToSharedPreferences(sharedPreferences, etUsername.getText().toString());
    }

    @Override
    public void navigateToMain() {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
