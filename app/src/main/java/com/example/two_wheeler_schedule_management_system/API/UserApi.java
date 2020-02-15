package com.example.two_wheeler_schedule_management_system.API;

import com.example.two_wheeler_schedule_management_system.Models.BookingModel;
import com.example.two_wheeler_schedule_management_system.ServerResponse.BookingResponse;
import com.example.two_wheeler_schedule_management_system.ServerResponse.FeedbackResponse;
import com.example.two_wheeler_schedule_management_system.ServerResponse.ImageResponse;
import com.example.two_wheeler_schedule_management_system.Models.Feedback;
import com.example.two_wheeler_schedule_management_system.Models.UserModel;
import com.example.two_wheeler_schedule_management_system.ServerResponse.UserResponse;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
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
    Call<UserModel> getUserDetails(@Header( "Authorization" ) String token);

    @POST("complain")
    Call<FeedbackResponse> feedbackDetail(@Body Feedback feedback);

    @POST("booking")
    Call<BookingResponse> bookingDetail(@Header( "Authorization" ) String token ,@Body BookingModel bookingModel);

    @FormUrlEncoded
    @PUT("users/me")
    Call<UserResponse> userUpate(@Header("Authorization") String token, @Field( "fullname" ) String fullname, @Field( "email" ) String email, @Field( "username" )String username, @Field( "address" ) String address, @Field( "phonenumber" ) String phonenumber);
}

