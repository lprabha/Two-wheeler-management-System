package com.example.two_wheeler_schedule_management_system;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.two_wheeler_schedule_management_system.API.BookNowApi;
import com.example.two_wheeler_schedule_management_system.Models.BookingModel;
import com.example.two_wheeler_schedule_management_system.URL.Url;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BookNowActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
     EditText etclient,etbookingName,etvehicleNumber,etprice,ettime;
     Spinner VehicleName_spinner, ServicingType_spinner;
     Button BtnBookNow;

     @SuppressLint("WrongViewCast")
     @Override
     protected  void  onCreate( Bundle savedInstanceState) {
         super.onCreate( savedInstanceState );
         setContentView( R.layout.activitybooking );

         etclient = findViewById( R.id.clientName );
         etbookingName = findViewById( R.id.bookingName );
         etvehicleNumber = findViewById( R.id.vehicleNumber );
         etprice = findViewById( R.id.price );
         ettime = findViewById( R.id.dateTime );
         BtnBookNow= findViewById( R.id.btnBookNow );

         ServicingType_spinner = findViewById(R.id.ServicingType_spinner);
         VehicleName_spinner = findViewById(R.id.VehicleName_spinner);

         ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource( this,R.array.ServicingType_spinner,android.R.layout.simple_spinner_item );
         adapter.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item );
         ServicingType_spinner.setAdapter(adapter);
         ServicingType_spinner.setOnItemSelectedListener(this);

         ArrayAdapter<CharSequence> Vadapter = ArrayAdapter.createFromResource( this,R.array.VehicleName_spinner,android.R.layout.simple_spinner_item );
         Vadapter.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item );
         VehicleName_spinner.setAdapter(Vadapter);
         VehicleName_spinner.setOnItemSelectedListener(this);




         BtnBookNow.setOnClickListener( new View.OnClickListener() {
             @Override
             //Validation
             public void onClick(View v) {
                 if(etclient.getText().toString().matches("")){
                     etclient.setError("Enter Client Name please");
                     return;
                 }
                 if(etbookingName.getText().toString().matches("")){
                     etbookingName.setError("Enter Phone Number please");
                     return;
                 }
                 if(etvehicleNumber.getText().toString().matches("")){
                     etvehicleNumber.setError("Enter Name please");
                     return;
                 }
                 if(etprice.getText().toString().matches("")){
                     etprice.setError("Enter Client Name please");
                     return;
                 }
                 if(ettime.getText().toString().matches("")){
                     ettime.setError("Enter Phone Number please");
                     return;
                 }
                     Book();

                 Intent IntentForm = new Intent( BookNowActivity.this, BookingDetails.class );
                 startActivity( IntentForm );

             }
         } );
     }

    private void Book() {

         String client = etclient.getText().toString();
         String bookingName = etbookingName.getText().toString();
         String vehicleNumber = etvehicleNumber.getText().toString();
         String price = etprice.getText().toString();
         String date = ettime.getText().toString();
         String ServicingType = ServicingType_spinner.getSelectedItem().toString();
         String VehicleName = VehicleName_spinner.getSelectedItem().toString();



         BookingModel book = new BookingModel(VehicleName,ServicingType,client,bookingName,vehicleNumber,price,date,"120","retet");

         BookNowApi bookNowApi = Url.getInstance().create( BookNowApi.class );

        Call<BookingModel> bookingModelCall = bookNowApi.booknow(book);


        bookingModelCall.enqueue( new Callback<BookingModel>() {
            @Override
            public void onResponse(Call<BookingModel> call, Response<BookingModel> response) {
                if(!response.isSuccessful()){
                    Toast.makeText( BookNowActivity.this,"Error",Toast.LENGTH_SHORT ).show();
                    return;
                }
                Toast.makeText( BookNowActivity.this, "Book Successful.", Toast.LENGTH_SHORT ).show();
            }

            @Override
            public void onFailure(Call<BookingModel> call, Throwable t) {
                Toast.makeText( BookNowActivity.this, "Error:"+ t.getLocalizedMessage() , Toast.LENGTH_SHORT ).show();
            }
        } );
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String text = adapterView.getItemAtPosition(i).toString();
        Toast.makeText(adapterView.getContext(),text,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        etclient =findViewById( R.id.clientName );
        etbookingName =findViewById( R.id.BookingName );
        ServicingType_spinner =findViewById( R.id. ServicingType_spinner);
        VehicleName_spinner =findViewById( R.id.VehicleName_spinner );
        etvehicleNumber  =findViewById( R.id.VehicleNumber );
        etprice =findViewById( R.id.price );
        ettime =findViewById( R.id.DateTime );
        BtnBookNow =findViewById( R.id.btnBookNow );
    }
}
