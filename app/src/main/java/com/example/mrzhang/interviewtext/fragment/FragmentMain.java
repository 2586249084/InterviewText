package com.example.mrzhang.interviewtext.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.example.mrzhang.interviewtext.activity.MainActivity;

public class FragmentMain extends Fragment{

    private FragmentListener listener;
    private String data = "";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //执行回调
        listener.progress("我是回调接口!");
    }

    //定义一个内部回调接口
    public interface FragmentListener{
        void progress(String str);
    }

    //当Fragment被加载到Activity中时会被回调
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof FragmentListener){
            //获取到宿主Activity并赋值
            listener = (FragmentListener) activity;
        } else{
            throw new IllegalArgumentException("activity must implements FragmentListener");
        }
        if (isAdded()) {
            //利用getArgument()接收来自Activity的数据
            data = getArguments().getString("name");
            //将activity强转为当前传递数据的Activity，调用Activity中的获取数值的方法
            data = ((MainActivity)activity).getString();
        }
    }

    //把传递过来的Activity对象释放掉
    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}
