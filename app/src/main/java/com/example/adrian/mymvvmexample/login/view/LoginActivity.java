package com.example.adrian.mymvvmexample.login.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.example.adrian.mymvvmexample.R;
import com.example.adrian.mymvvmexample.base.BaseActivity;
import com.example.adrian.mymvvmexample.login.di.LoginComponent;
import com.example.adrian.mymvvmexample.login.presenter.LoginPresenter;
import com.example.adrian.mymvvmexample.main.view.MainActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity implements LoginView {

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

    @Inject
    LoginPresenter loginPresenterImpl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);
        LoginComponent.Injector.buildComponent(this).inject(this);

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
