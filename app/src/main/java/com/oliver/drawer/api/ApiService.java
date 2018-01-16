package com.oliver.drawer.api;

import android.content.ClipData;

import com.oliver.drawer.Models.PhotoModel;
import com.oliver.drawer.Photo;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Oliver on 1/16/2018.
 */

public interface ApiService {

    @GET("photos?"+ApiConstants.Conusumer_key)
    Call<PhotoModel> getPhotos(@Query("feature")String feature);

    @FormUrlEncoded
    @POST("photos")
    Call<Photo> uploadPhoto(@Field("name") String stringName, @Body Photo photo);
}
