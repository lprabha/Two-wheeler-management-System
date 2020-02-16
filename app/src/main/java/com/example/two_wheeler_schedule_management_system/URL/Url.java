package com.example.two_wheeler_schedule_management_system.URL;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Url {
    //public static final String BASE_URL = "http://10.0.2.2:3001/";
    //public static final String BASE_URL = "http://localhost:3002/";
    public static final String BASE_URL = "http://192.168.1.87:3001/";


    public static String token = "Bearer ";

    public static String imagePath = BASE_URL + "upload/";
    public static String base_url;

    public static Retrofit getInstance() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl( BASE_URL )
                .addConverterFactory( GsonConverterFactory.create() )
                .build();
        return retrofit;
    }

}
