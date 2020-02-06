package com.example.two_wheeler_schedule_management_system;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.two_wheeler_schedule_management_system.API.BookNowApi;
import com.example.two_wheeler_schedule_management_system.Models.BookingModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BookingDetails extends AppCompatActivity {
    List<BookingModel> bookingModelList = new ArrayList<>();
    Retrofit retrofit;
    BookNowApi bookNowApi;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_fragment_booking );
        recyclerView = findViewById( R.id.recyclerView );
        getBook();

    }


    private void getBook() {
        retrofit = new Retrofit.Builder()
                .baseUrl( "http://10.0.2.2:3001/" )
                .addConverterFactory( GsonConverterFactory.create() )
                .build();

        bookNowApi = retrofit.create( BookNowApi.class );

        Call<List<BookingModel>> listCall = BookNowApi.getbooking();

        listCall.enqueue( new Callback<List<BookingModel>>() {
            @Override
            public void onResponse(Call<List<BookingModel>> call, Response<List<BookingModel>> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(getBaseContext(), "Code: " + response.body(), Toast.LENGTH_SHORT).show();
                    return;
                }

                bookingModelList = response.body();

                BookingAdapter bookingAdapter = new BookingAdapter( bookingModelList );
                recyclerView.setAdapter( bookingAdapter );
                recyclerView.setAdapter( new BookingAdapter(BookingDetails.this,bookingModelList ) );

                recyclerView.setLayoutManager( new LinearLayoutManager( BookingDetails.this ) );

            }

            @Override
            public void onFailure(Call<List<BookingModel>> call, Throwable t) {
                Toast.makeText( BookingDetails.this,"Error"+ t.getMessage(),Toast.LENGTH_SHORT).show();

            }
        } );
    }
}
