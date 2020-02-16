package com.example.two_wheeler_schedule_management_system;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.two_wheeler_schedule_management_system.API.ShowPartsAPI;
import com.example.two_wheeler_schedule_management_system.API.UserApi;
import com.example.two_wheeler_schedule_management_system.Adapter.PartsAdapter;
import com.example.two_wheeler_schedule_management_system.Models.PartsModel;
import com.example.two_wheeler_schedule_management_system.URL.Url;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class Show_Parts extends AppCompatActivity {
    private RecyclerView recyclerView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_parts_activity);

        recyclerView=findViewById(R.id.rv_show_parts);
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Url.base_url).addConverterFactory( GsonConverterFactory.create()).build();
        UserApi usersAPI = retrofit.create(UserApi.class);

        Call<List<PartsModel>> allParts = usersAPI.getAllParts();
        allParts.enqueue( new Callback<List<PartsModel>>() {
            @Override
            public void onResponse(Call<List<PartsModel>> call, Response<List<PartsModel>> response) {
                if (!response.isSuccessful()){
                    Toast.makeText(Show_Parts.this,"Error code"+response.code(),Toast.LENGTH_SHORT).show();
                    return;
                }
                List<PartsModel> partsModelList = response.body();
                PartsAdapter partsAdapter = new PartsAdapter( Show_Parts.this,partsModelList );
                recyclerView.setAdapter( partsAdapter );
                recyclerView.setLayoutManager( new LinearLayoutManager( Show_Parts.this ) );
            }

            @Override
            public void onFailure(Call<List<PartsModel>> call, Throwable t) {
Log.d("Msg", "onFailure"+t.getLocalizedMessage());
Toast.makeText( Show_Parts.this,"Error"+t.getLocalizedMessage(),Toast.LENGTH_SHORT ).show();

            }
        } );
    }
}

