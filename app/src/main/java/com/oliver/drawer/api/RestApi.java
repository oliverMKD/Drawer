package com.oliver.drawer.api;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.oliver.drawer.BuildConfig;
import com.oliver.drawer.Interceptor.LoggingInterceptor;
import com.oliver.drawer.Models.PhotoModel;
import com.oliver.drawer.other.CheckConnection;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Oliver on 1/16/2018.
 */

public class RestApi {

    public static final int request_max_time_in_secconds = 20;
    private Context activity;

    public RestApi(Context context) {
        this.activity = activity;
    }

    public Retrofit getRetrofitInstance(){
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new LoggingInterceptor())
                .readTimeout(request_max_time_in_secconds, TimeUnit.SECONDS)
                .connectTimeout(request_max_time_in_secconds,TimeUnit.SECONDS)
                .build();
        return new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
    }

    public ApiService request(){
        return getRetrofitInstance().create(ApiService.class);
    }

    public void checkInternet(Runnable callback){
        if (CheckConnection.CheckInternetConnectivity(activity,true,callback))
            callback.run();
    }
    public void checkInternet(Runnable callback, boolean showConnectionDialog){
        if (CheckConnection.CheckInternetConnectivity(activity,showConnectionDialog,callback))
            callback.run();
        else {
            Toast.makeText(activity, "Connection failed, please check connection", Toast.LENGTH_SHORT).show();
        }
    }
    public void checkInternet(Runnable callback, boolean showConnectionDialog, String message){
        if (CheckConnection.CheckInternetConnectivity(activity,showConnectionDialog,callback))
            callback.run();
        else {
            if (showConnectionDialog)
            Toast.makeText(activity, message, Toast.LENGTH_SHORT).show();
            else
                Log.d("Connection failed","" + message);
        }
    }



    public Call<PhotoModel> getPhotos(String feature){
        return request().getPhotos(feature);
    }
}
