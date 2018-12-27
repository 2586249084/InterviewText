package com.example.mrzhang.interviewtext.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

import com.example.mrzhang.interviewtext.R;
import com.example.mrzhang.interviewtext.bean.User;
import com.example.mrzhang.interviewtext.view.IUserLoginView;

public class UserLoginActivity extends AppCompatActivity implements IUserLoginView{

    private EditText edit_userName, edit_userPassword;
    private Button btn_login, btn_clean;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);
        initView();
    }

    public void initView(){
        edit_userName = findViewById(R.id.edit_userName);
        edit_userPassword = findViewById(R.id.edit_userPassword);
        btn_login = findViewById(R.id.btn_login);
        btn_clean = findViewById(R.id.btn_clean);
    }

    @Override
    public String getUserName() {
        return edit_userName.getText().toString();
    }

    @Override
    public String getPassword() {
        return edit_userPassword.getText().toString();
    }

    @Override
    public void cleanUserName() {

    }

    @Override
    public void cleanPassword() {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void toMainActivity(User user) {

    }

    @Override
    public void showFailedError() {

    }
}
