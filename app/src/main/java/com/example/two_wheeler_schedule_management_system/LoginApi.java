package com.example.two_wheeler_schedule_management_system;

import com.example.two_wheeler_schedule_management_system.Models.UserModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface LoginApi {

    //for Register
    @POST("Two-wheeler-schedule-management-System/users/signup")
    Call<Void> register(@Body UserModel user);


    //for Login
    @POST("Two-wheeler-schedule-management-System/users/login")
    Call<Void> login(@Body UserModel user);

}

