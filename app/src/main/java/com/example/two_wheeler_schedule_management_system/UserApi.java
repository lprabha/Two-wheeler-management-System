package com.example.two_wheeler_schedule_management_system;

import com.example.two_wheeler_schedule_management_system.Models.UserModel;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;


public interface UserApi {

    @POST("users/signup")
    Call<Void> signup(@Body UserModel user);

    @POST("users/login")
    Call<UserResponse> login(@Body UserModel user);

    @Multipart
    @POST("/upload")
    Call<ImageResponse> uploadImage(@Part MultipartBody.Part Profileimage);

}

