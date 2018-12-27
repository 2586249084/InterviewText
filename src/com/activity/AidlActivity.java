package com.example.mrzhang.interviewtext.activity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.mrzhang.interviewtext.IMyAidlInterface;
import com.example.mrzhang.interviewtext.R;
import com.example.mrzhang.interviewtext.bean.Person;
import com.example.mrzhang.interviewtext.service.service.MyAidlService;

import java.util.ArrayList;
import java.util.List;

public class AidlActivity extends AppCompatActivity{

    private IMyAidlInterface mAidl;
    private Button btn_bind;
    private List<Person> personList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_bind = findViewById(R.id.btn_bind);
        btn_bind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AidlActivity.this, MyAidlService.class);
                bindService(intent, mConnection, BIND_AUTO_CREATE);
                //addPerson();
            }
        });
    }

    private ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            //连接后拿到Binder，转换成Aidl，在不同进程中会返回一个代理
            Log.e("BindMsg:", "onServiceConnected");
            mAidl = IMyAidlInterface.Stub.asInterface(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.e("BindMsg:", "onServiceDisconnected");
            mAidl = null;
        }
    };

    private void addPerson(){
        try {
            mAidl.addPerson(new Person("123456"));
            personList = mAidl.getPersonList();
        } catch (RemoteException error) {
            Log.e("RemoteException:", error.getLocalizedMessage());
            error.printStackTrace();
        }
    }
}
