package com.example.two_wheeler_schedule_management_system.API;

import com.example.two_wheeler_schedule_management_system.ServerResponse.FeedbackResponse;
import com.example.two_wheeler_schedule_management_system.ServerResponse.ImageResponse;
import com.example.two_wheeler_schedule_management_system.Models.Feedback;
import com.example.two_wheeler_schedule_management_system.Models.UserModel;
import com.example.two_wheeler_schedule_management_system.ServerResponse.UserResponse;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;


public interface UserApi {

    @POST("users/signup")
    Call<UserResponse> signup(@Body UserModel user);

    @POST("users/login")
    Call<UserResponse> login(@Body UserModel user);

    @Multipart
    @POST("/upload")
    Call<ImageResponse> uploadImage(@Part MultipartBody.Part Profileimage);

    @GET("users")
    Call<UserModel> getUserDetails(String token);

    @POST("complain")
    Call<FeedbackResponse> feedbackDetail(Feedback feedback);
}

