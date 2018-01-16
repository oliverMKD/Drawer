package com.oliver.drawer.api;

import com.oliver.drawer.BuildConfig;
import com.oliver.drawer.Models.PhotoModel;

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

    public Retrofit getRetrofitInstance(){
        OkHttpClient client = new OkHttpClient.Builder()
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

    public Call<PhotoModel> getPhotos(String feature){
        return request().getPhotos(feature);
    }
}
