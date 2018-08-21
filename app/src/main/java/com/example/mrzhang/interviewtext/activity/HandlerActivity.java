package com.example.mrzhang.interviewtext.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.example.mrzhang.interviewtext.R;

public class HandlerActivity extends AppCompatActivity{

    private static final int MSG_FINISH = 0x001;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case MSG_FINISH:
                    Log.e("handler所在的线程ID是:", Thread.currentThread().getName());
            }
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        customTimeThread(findViewById(R.id.btn_bind));
    }

    private void customTimeThread(View view){
        new Thread(){
            @Override
            public void run() {
                try {
                    Log.e("耗时子线程的Name是:", Thread.currentThread().getName());
                    Thread.sleep(5000);
                    handler.sendEmptyMessage(MSG_FINISH);
                } catch (InterruptedException error) {
                    Log.e("ThreadError:", error.getLocalizedMessage());
                    error.printStackTrace();
                }
            }
        }.start();
    }
}
