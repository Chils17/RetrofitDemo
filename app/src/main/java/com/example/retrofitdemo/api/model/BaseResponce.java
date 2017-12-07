package com.example.retrofitdemo.api.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by komal on 04-04-2017.
 */

public class BaseResponce {
//    @SerializedName("ResponseCod")
    private int ResponseCode;
    private String ResponseMessage;

    public int getResponseCode() {
        return ResponseCode;
    }

    public void setResponseCode(int responseCode) {
        ResponseCode = responseCode;
    }

    public String getResponseMessage() {
        return ResponseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        ResponseMessage = responseMessage;
    }
}
