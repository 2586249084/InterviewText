package com.example.mrzhang.interviewtext.biz;

import com.example.mrzhang.interviewtext.bean.User;

public class UserBiz implements IUserBiz {
    @Override
    public void login(final String userName, final String password, final OnLoginListener loginListener) {
        // 模拟子线程耗时操作
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 模拟登陆成功
                if ("zp".equals(userName) && "123456".equals(password)) {
                    User user = new User();
                    user.setUserName(userName);
                    user.setPassword(password);
                    loginListener.loginSuccess(user);
                } else {
                    loginListener.loginFailed();
                }
            }
        }).start();
    }
}
