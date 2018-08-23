package com.example.mrzhang.interviewtext.biz;

public interface IUserBiz {
    void login(String userName, String password, OnLoginListener loginListener);
}
