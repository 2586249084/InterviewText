package com.example.mrzhang.interviewtext.biz;

import com.example.mrzhang.interviewtext.bean.User;

public interface OnLoginListener {
    void loginSuccess(User user);

    void loginFailed();
}
