package com.example.two_wheeler_schedule_management_system.activity;


import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.two_wheeler_schedule_management_system.API.UserApi;
import com.example.two_wheeler_schedule_management_system.MainActivity;
import com.example.two_wheeler_schedule_management_system.Models.BookingModel;
import com.example.two_wheeler_schedule_management_system.Models.UserModel;
import com.example.two_wheeler_schedule_management_system.R;
import com.example.two_wheeler_schedule_management_system.ServerResponse.BookingResponse;
import com.example.two_wheeler_schedule_management_system.URL.Url;

import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BookNowActivity extends AppCompatActivity {
    TextView  ettime;
    EditText etclient;
    String id;
    int year3;
    int month3;
    int day3;
    Spinner ServicingType_spinner, price_spinner;
    Button BtnBookNow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activitybooking );

        etclient = findViewById( R.id.clientName );
        ettime = findViewById( R.id.DateTime );
        BtnBookNow = findViewById( R.id.btnBookNow );

        ServicingType_spinner = findViewById( R.id.ServicingType_spinner );
        price_spinner = findViewById( R.id.price_spinner );


        BtnBookNow.setOnClickListener( new View.OnClickListener() {
            @Override
            //Validation
            public void onClick(View v) {
                Booking();

            }
        } );

        String servicingType[] = {"Servicing Type", "Cleaning", "Full Servicing", "Maintinance", "On Call Home Service"};
        ArrayAdapter adapter = new ArrayAdapter<>( this,android.R.layout.simple_expandable_list_item_1, servicingType);
        ServicingType_spinner.setAdapter( adapter );

        String price[] = {"Price of servicing","500", "200", "300", "100"};
        ArrayAdapter padapter = new ArrayAdapter<>( this,android.R.layout.simple_expandable_list_item_1, price);
        price_spinner.setAdapter( padapter );

        ettime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadDatePickerDate();
            }
        });


        etclient = findViewById(R.id.clientName);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String clientName = bundle.getString("id");
            etclient.setText(clientName);
            Toast.makeText(this, clientName, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "no message received", Toast.LENGTH_SHORT).show();
        }

        UserApi usersAPI = Url.getInstance().create(UserApi.class);
        Call<UserModel> userModelCall = usersAPI.getUserDetails(Url.token);

        userModelCall.enqueue(new Callback<UserModel>() {
            @Override
            public void onResponse(Call<UserModel> call, Response<UserModel> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(BookNowActivity.this, "Error" + response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }
                etclient.setText(response.body().getFullname());


                id = response.body().get_id();


            }

            @Override
            public void onFailure(Call<UserModel> call, Throwable t) {

                Log.d("Msg", "onFailure: " + t.getLocalizedMessage());
                Toast.makeText(BookNowActivity.this, "Error" + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }

    private void Booking() {
        String client = etclient.getText().toString();
        String date = ettime.getText().toString();
        String ServicingType = ServicingType_spinner.getSelectedItem().toString();
        String price = price_spinner.getSelectedItem().toString();

        BookingModel bookingModel = new BookingModel(client,date,ServicingType,price);
        UserApi usersAPI = Url.getInstance().create(UserApi.class);
        Call<BookingResponse> bookingCall = usersAPI.bookingDetail(Url.token, bookingModel);

        bookingCall.enqueue(new Callback<BookingResponse>() {
            @Override
            public void onResponse(Call<BookingResponse> call, Response<BookingResponse> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(BookNowActivity.this, "Code" + response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }
                Toast.makeText(BookNowActivity.this, "Booked sucessfully", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(BookNowActivity.this, BookingDetail.class);
                startActivity(intent);
                finish();

            }


            @Override
            public void onFailure(Call<BookingResponse> call, Throwable t) {

                Toast.makeText(BookNowActivity.this, "Error " + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void loadDatePickerDate() {
        final Calendar c1=Calendar.getInstance();
        int year= c1.get(Calendar.YEAR);
        final int month = c1.get(Calendar.MONTH);
        int day= c1.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog=new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year1, int month, int dayOfMonth1) {
                String date =  + (month + 1) + "/" + dayOfMonth1 + "/" + year1;
                month3=month;
                day3=dayOfMonth1;
                year3=year1;
                ettime.setText(date);
            }
        },year,month,day);
        datePickerDialog.show();
    }
}
