package com.example.mrzhang.interviewtext.activity;

import com.example.mrzhang.interviewtext.net.NetApi;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class RetrofitActivity {


    public void retrofitHttpRequest(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .build();

        NetApi netApi = retrofit.create(NetApi.class);

        Call<ResponseBody> call = netApi.contributorsBySimpleGetCall("userName", "path");
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }
}
