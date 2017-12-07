package com.example.retrofitdemo.ui;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.retrofitdemo.R;
import com.example.retrofitdemo.adapter.MyAdapter;
import com.example.retrofitdemo.api.call.GetData;
import com.example.retrofitdemo.api.model.MangalamParivar;
import com.example.retrofitdemo.helper.Function;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Context context;
    private MyAdapter adapter;
    private List<MangalamParivar> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

    }

    private void init() {
        context = this;

        list = new ArrayList<>();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        adapter = new MyAdapter(context, list);
        recyclerView.setAdapter(adapter);

        callApi();

    }

    private void callApi() {
        new GetData(context, new GetData.OnGetData() {
            @Override
            public void onSuccess(List<MangalamParivar> data) {
                if (data != null && data.size() > 0) {
                    adapter.setDataList(data);
                }
            }

            @Override
            public void onFail() {
                Function.showToast(context, getString(R.string.try_again));
            }

            @Override
            public void onServerError(String responseMessage) {
                Function.showToast(context, responseMessage);
            }
        });
    }
}
