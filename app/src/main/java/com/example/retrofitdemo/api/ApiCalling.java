package com.example.retrofitdemo.api;

import com.example.retrofitdemo.api.model.MainRes;
import com.example.retrofitdemo.api.model.Req;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by komal on 04-04-2017.
 */

public interface ApiCalling {

    @GET(ApiConstant.GetMangalamParivar1)
    Call<MainRes> getMangalamParivar();
    @GET(ApiConstant.GetMangalamParivar2)
    Call<MainRes> getMangalamParivar2(@Query("id")int id);
    @GET(ApiConstant.GetMangalamParivar3)
    Call<MainRes> getMangalamParivar3(@Path("id")int id);
    @POST(ApiConstant.GetMangalamParivar4)
    Call<MainRes> getMangalamParivar4(@Body Req req);


}
