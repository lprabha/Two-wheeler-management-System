package com.example.two_wheeler_schedule_management_system.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.two_wheeler_schedule_management_system.API.BookNowApi;
import com.example.two_wheeler_schedule_management_system.Models.BookingModel;
import com.example.two_wheeler_schedule_management_system.R;
import com.example.two_wheeler_schedule_management_system.URL.Url;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class BookingDetail extends AppCompatActivity {
    TextView  client, datetime, servicingType, servicingPrice;
    Button BtnCancle;
    Spinner bookings;
    List<BookingModel> bookingList;
    Map<String, String> bookingMap = new HashMap<>(  );


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_showbookingdetails );

        client = findViewById( R.id.client );
        servicingType = findViewById( R.id.servicingType );
        servicingPrice = findViewById( R.id.servicingPrice );
        datetime = findViewById( R.id.time );
        BtnCancle = findViewById( R.id.btnCancle );
        bookings = findViewById( R.id.spBooking );

        getBook();
        showBookings();

        bookings.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        } );

        BtnCancle.setOnClickListener( new View.OnClickListener() {
            @Override
            //Validation
            public void onClick(View v) {
                //Toast.makeText( this, "Deleted Successfully", Toast.LENGTH_SHORT ).show();
            }
        } );

    }

    private void getBook() {
    }

    public void showBookings(){
        BookNowApi bookApi = Url.getInstance().create(BookNowApi.class);
        Call<List<BookingModel>> bookcall = bookApi.getbooking(Url.token);

        bookcall.enqueue( new Callback<List<BookingModel>>() {
            @Override
            public void onResponse(Call<List<BookingModel>> call, Response<List<BookingModel>> response) {
                if(!response.isSuccessful())
                {
                    Toast.makeText(BookingDetail.this, "Error", Toast.LENGTH_SHORT).show();
                    return;
                }

                for(BookingModel bookings : response.body()){
                    bookingMap.put(bookings.getClient(), bookings.get_id());
                }

                loadSpinner();
            }



            @Override
            public void onFailure(Call<List<BookingModel>> call, Throwable t) {
                Toast.makeText(BookingDetail.this, "Error"+t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        } );
    }

    private void CancleBooking() {
        BookingModel bookingModel = new BookingModel( client.getText().toString(),servicingType.getText().toString(),servicingPrice.getText().toString(),datetime.getText().toString() );
//        Call<BookingResponse> bookingResponseCall =UserApi.CancleBooking(Url.token);
    }

    public void loadSpinner(){
        ArrayAdapter bookingAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,
                                        new ArrayList( bookingMap.keySet()));

        bookings.setAdapter( bookingAdapter );
    }
}
