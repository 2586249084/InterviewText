package com.example.mrzhang.interviewtext.activity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.mrzhang.interviewtext.service.MyService;
import com.example.mrzhang.interviewtext.R;

public class ServiceActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btn_bind;
    private MyService.MyBinder binder = null;
    private Intent intent;
    private MyServiceConnection connection;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        connection = new MyServiceConnection();
        intent = new Intent(this, ServiceActivity.class);
        intent.putExtra("data", "Activity传给Service的值");
        btn_bind = findViewById(R.id.btn_bind);
        btn_bind.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        bindService(intent, connection, Context.BIND_AUTO_CREATE);
    }

    class MyServiceConnection implements ServiceConnection{

        //服务被绑定成功后执行
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            //service为OnBind()方法返回的Service实例
            binder = (MyService.MyBinder) service;
        }

        //服务崩溃或者服务被杀死
        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    }
}
