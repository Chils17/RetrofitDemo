package com.example.retrofitdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.retrofitdemo.R;
import com.example.retrofitdemo.api.model.MangalamParivar;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by komal on 04-04-2017.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private final Context context;
    private List<MangalamParivar> list;

    public MyAdapter(Context context, List<MangalamParivar> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.setValues(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setDataList(List<MangalamParivar> data) {
        list=new ArrayList<>();
        list = data;
        notifyDataSetChanged();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgPic;
        private TextView txtName, txtAddress, txtDesc;

        public MyViewHolder(View itemView) {
            super(itemView);
            imgPic = (ImageView) itemView.findViewById(R.id.imgPic);
            txtName = (TextView) itemView.findViewById(R.id.txtName);
            txtAddress = (TextView) itemView.findViewById(R.id.txtAddress);
            txtDesc = (TextView) itemView.findViewById(R.id.txtDesc);
        }

        public void setValues(MangalamParivar mangalamParivar) {
            Log.e("data",mangalamParivar.getName());
            txtName.setText(mangalamParivar.getName());
            txtAddress.setText(mangalamParivar.getAddress());
            txtDesc.setText(mangalamParivar.getDescription());
            Glide.with(context).load(mangalamParivar.getImage()).placeholder(R.mipmap.ic_launcher).into(imgPic);
        }
    }
}
