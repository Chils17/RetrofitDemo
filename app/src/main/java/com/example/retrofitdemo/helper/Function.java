package com.example.retrofitdemo.helper;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by komal on 04-04-2017.
 */

public class Function {


    public static void showToast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT);
    }

}
