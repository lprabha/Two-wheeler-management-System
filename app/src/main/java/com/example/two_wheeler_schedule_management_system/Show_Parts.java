package com.example.two_wheeler_schedule_management_system;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.two_wheeler_schedule_management_system.API.ShowPartsAPI;
import com.example.two_wheeler_schedule_management_system.Models.PartsModel;
import com.example.two_wheeler_schedule_management_system.URL.Url;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class Show_Parts extends AppCompatActivity {
    private RecyclerView recyclerView;
    List<PartsModel> partsList = new ArrayList<>();
    Retrofit retrofit;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_parts_activity);

        recyclerView=findViewById(R.id.recyclerView);
        getParts();
//        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(),1));

    }

    public void getParts() {

        ShowPartsAPI partsApi = Url.getInstance().create( ShowPartsAPI.class );

        Call<List<PartsModel>> listCall = partsApi.getParts();
        listCall.enqueue(new Callback<List<PartsModel>>() {
            @Override
            public void onResponse(Call<List<PartsModel>> call, Response<List<PartsModel>> response) {
                partsList = response.body();
                recyclerView.setAdapter(new PartsAdapter(Show_Parts.this,partsList));
                PartsAdapter partsAdapter = new PartsAdapter( Show_Parts.this, partsList);
                recyclerView.setAdapter(partsAdapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(Show_Parts.this));
            }
            @Override
            public void onFailure(Call<List<PartsModel>> call, Throwable t) {
                Toast.makeText(Show_Parts.this, "ERROR"+t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }
}

