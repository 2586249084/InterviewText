package com.example.mrzhang.interviewtext.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

public class MyService extends Service{

    private String data = "服务器正在运行";
    private CallBack callBack = null;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        System.out.print("成功绑定服务!");
        return new MyBinder();
    }

    public class MyBinder extends Binder{
        public void setData(String data){
            MyService.this.data = data;
        }

        public String getData(){
            return MyService.this.data;
        }

        public MyService getMyService(){
            return MyService.this;
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        data = intent.getStringExtra("data");
        System.out.print(data);
        return super.onStartCommand(intent, flags, startId);
    }

    public interface CallBack{
        void onDataChange(String data);
    }

    public void setCallBack(CallBack callBack){
        this.callBack = callBack;
    }
}
