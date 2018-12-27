package com.example.mrzhang.interviewtext.activity;


import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.mrzhang.interviewtext.receiver.MyBroadcastReceiver;

public class BroadcastReceiverActivity extends AppCompatActivity{

    private MyBroadcastReceiver mBroadcastReceiver;

    @Override
    protected void onResume() {
        super.onResume();
        mBroadcastReceiver = new MyBroadcastReceiver();
        IntentFilter intentFilter = new IntentFilter();

        intentFilter.addAction(CONNECTIVITY_SERVICE);

        registerReceiver(mBroadcastReceiver, intentFilter);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(mBroadcastReceiver);
    }
}
