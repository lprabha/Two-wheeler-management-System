package com.example.two_wheeler_schedule_management_system.API;

import com.example.two_wheeler_schedule_management_system.Models.PartsModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ShowPartsAPI {
    @GET("showparts")
    Call<List<PartsModel>> getParts();
}
