package com.example.mrzhang.interviewtext.service.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.mrzhang.interviewtext.IMyAidlInterface;
import com.example.mrzhang.interviewtext.bean.Person;

import java.util.ArrayList;
import java.util.List;

public class MyAidlService extends Service{

    private final String TAG = this.getClass().getSimpleName();
    private ArrayList<Person> personList;

    /**
     * 创建生成的本地Binder对象，实现AIDL制定的方法
     */
    private IBinder mIBinder = new IMyAidlInterface.Stub() {
        @Override
        public void addPerson(Person person) throws RemoteException {
            personList.add(person);
        }

        @Override
        public List<Person> getPersonList() throws RemoteException {
            return personList;
        }
    };

    /**
     * 客户端与服务器绑定时的回调，返回mIBinder后客户端可以通过它远程调用服务端的方法
     */
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        personList = new ArrayList<>();
        Log.d(TAG, "MyAidlService onBind");
        return mIBinder;
    }
}
