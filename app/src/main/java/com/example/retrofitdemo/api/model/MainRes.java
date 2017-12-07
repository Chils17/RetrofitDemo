package com.example.retrofitdemo.api.model;

import java.util.List;

/**
 * Created by komal on 04-04-2017.
 */

public class MainRes extends BaseResponce {
    List<MangalamParivar> Data;

    public List<MangalamParivar> getData() {
        return Data;
    }

    public void setData(List<MangalamParivar> data) {
        Data = data;
    }
}
