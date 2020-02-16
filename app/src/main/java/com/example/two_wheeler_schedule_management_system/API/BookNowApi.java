package com.example.two_wheeler_schedule_management_system.API;

import com.example.two_wheeler_schedule_management_system.Models.BookingModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface BookNowApi {


    @GET("booking")
    Call<List<BookingModel>> getbooking(@Header( "Authorization" ) String token);

    @POST("booking")
    Call<BookingModel> booknow(@Body BookingModel booking);
}
