package com.example.mrzhang.interviewtext.utils;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

public class UpdateTextTask extends AsyncTask<Void, Integer, Integer>{

    private Context context;

    UpdateTextTask(Context context){
        this.context = context;
    }

    /**
     * 后台运行的方法，可以运行非UI线程，可以执行耗时的方法
     */
    @Override
    protected Integer doInBackground(Void... voids) {
        int i= 0;
        while (i < 10) {
            i ++;
            publishProgress(i);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException error) {
                Log.e("ThreadError:", error.getLocalizedMessage());
                error.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 运行在UI线程中，在调用doInBackground()之前执行
     */
    @Override
    protected void onPreExecute() {
        Toast.makeText(context, "开始执行!", Toast.LENGTH_SHORT).show();
    }

    /**
     * 运行在UI线程中，在doInBackground()执行完毕后执行
     */
    @Override
    protected void onPostExecute(Integer integer) {
        Toast.makeText(context, "执行完毕!", Toast.LENGTH_SHORT).show();
    }

    /**
     * 在publishProgress()被调用后执行，publishProgress()用于更新进度
     */
    @Override
    protected void onProgressUpdate(Integer... values) {

    }
}
