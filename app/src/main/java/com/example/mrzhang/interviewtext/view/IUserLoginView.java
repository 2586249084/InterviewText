package com.example.mrzhang.interviewtext.view;

import com.example.mrzhang.interviewtext.bean.User;

public interface IUserLoginView {
    String getUserName();
    String getPassword();
    void cleanUserName();
    void cleanPassword();
    void showLoading();
    void hideLoading();
    void toMainActivity(User user);
    void showFailedError();
}
