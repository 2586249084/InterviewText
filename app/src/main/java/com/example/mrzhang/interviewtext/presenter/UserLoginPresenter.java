package com.example.mrzhang.interviewtext.presenter;

import android.os.Handler;
import com.example.mrzhang.interviewtext.bean.User;
import com.example.mrzhang.interviewtext.biz.IUserBiz;
import com.example.mrzhang.interviewtext.biz.OnLoginListener;
import com.example.mrzhang.interviewtext.biz.UserBiz;
import com.example.mrzhang.interviewtext.view.IUserLoginView;

public class UserLoginPresenter {

    private IUserBiz userBiz;
    private IUserLoginView userLoginView;
    private Handler handler = new Handler();

    public UserLoginPresenter(IUserLoginView userLoginView){
        this.userLoginView = userLoginView;
        this.userBiz = new UserBiz();
    }

    public void login(){
        userLoginView.showLoading();
        userBiz.login(userLoginView.getUserName(), userLoginView.getPassword(), new OnLoginListener() {
            @Override
            public void loginSuccess(final User user) {
                // 需要在UI线程执行
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        userLoginView.toMainActivity(user);
                        userLoginView.hideLoading();
                    }
                });
            }

            @Override
            public void loginFailed() {
                // 需要在UI线程执行
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        userLoginView.showFailedError();
                        userLoginView.hideLoading();
                    }
                });
            }
        });
    }
}
