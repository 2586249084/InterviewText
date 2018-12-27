package com.example.mrzhang.interviewtext.activity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.example.mrzhang.interviewtext.fragment.FragmentMain;
import com.example.mrzhang.interviewtext.service.MyService;
import com.example.mrzhang.interviewtext.R;

public class MainActivity extends AppCompatActivity implements FragmentMain.FragmentListener, ServiceConnection{

    private MyService.MyBinder binder = null;
    private Handler handler= new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            msg.getData().getString("data");
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Activity传递数据给Fragment
        Fragment fragment = null;
        Bundle bundle = new Bundle();
        bundle.putString("name", "张鹏");

        //利用setArgument()传值给Fragment
        fragment.setArguments(bundle);
        //利用serviceConnection类来传递数值给Service
        binder.getData();
        binder.setData("启动服务了!");
        //利用intent来传值给service
        Intent intent = new Intent(this, MyService.class);
        intent.putExtra("data", "data");
        startService(intent);
    }

    public String getString(){
        return "利用方法向Fragment传值";
    }

    @Override
    public void progress(String str) {
        //todo
    }

    @Override
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        binder = (MyService.MyBinder) iBinder;
        binder.getMyService().setCallBack(new MyService.CallBack() {
            @Override
            public void onDataChange(String data) {
                Message msg = new Message();
                Bundle bundle = new Bundle();
                bundle.putString("data", data);
                msg.setData(bundle);
                handler.sendMessage(msg);
            }
        });
    }

    @Override
    public void onServiceDisconnected(ComponentName componentName) {

    }
}
