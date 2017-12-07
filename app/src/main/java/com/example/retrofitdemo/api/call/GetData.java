package com.example.retrofitdemo.api.call;

import android.content.Context;

import com.example.retrofitdemo.api.ApiCalling;
import com.example.retrofitdemo.api.model.MainRes;
import com.example.retrofitdemo.api.model.MangalamParivar;
import com.example.retrofitdemo.helper.AppConstant;
import com.example.retrofitdemo.helper.MyApplication;
import com.example.retrofitdemo.helper.ProgressBarHelper;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by komal on 04-04-2017.
 */

public class GetData {
    private ProgressBarHelper progressBarHelper;
    private OnGetData onGetData;

    public GetData(Context context, OnGetData onGetData) {
        progressBarHelper = new ProgressBarHelper(context, false);
        this.onGetData = onGetData;
        call();
    }

    private void call() {

        progressBarHelper.showProgressDialog();
        ApiCalling api = MyApplication.getRetrofit().create(ApiCalling.class);
        api.getMangalamParivar().enqueue(new Callback<MainRes>() {
            @Override
            public void onResponse(Call<MainRes> call, Response<MainRes> response) {
                progressBarHelper.hideProgressDialog();
                if (response.body() != null) {
                    if (response.body().getResponseCode() == AppConstant.ONSUCCESS) {
                        onGetData.onSuccess(response.body().getData());
                    } else {
                        onGetData.onServerError(response.body().getResponseMessage());
                    }
                } else {
                    onGetData.onFail();
                }
            }

            @Override
            public void onFailure(Call<MainRes> call, Throwable t) {
                progressBarHelper.hideProgressDialog();
                onGetData.onFail();
            }
        });
    }

    public interface OnGetData {
        void onSuccess(List<MangalamParivar> data);

        void onFail();

        void onServerError(String responseMessage);
    }
}
