package com.example.two_wheeler_schedule_management_system;

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

public class BookNowActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
     EditText etclient,etbookingName,etvehicleNumber,etprice,ettime;
     Spinner VehicleName_spinner, ServicingType_spinner;
     Button BtnBookNow;

     @Override
     protected  void  onCreate(Bundle savedInstanceState) {
         super.onCreate( savedInstanceState );
         setContentView( R.layout.activitybooking );

         final Spinner spinner = findViewById(R.id.ServicingType_spinner);

         ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource( this,R.array.ServicingType_spinner,android.R.layout.simple_spinner_item );
         adapter.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item );
         spinner.setAdapter(adapter);
         spinner.setOnItemSelectedListener(this);

         final Spinner vspinner = findViewById(R.id.VehicleName_spinner);
         ArrayAdapter<CharSequence> Vadapter = ArrayAdapter.createFromResource( this,R.array.VehicleName_spinner,android.R.layout.simple_spinner_item );
         Vadapter.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item );
         vspinner.setAdapter(Vadapter);
         vspinner.setOnItemSelectedListener(this);

         viewValue();

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



                 String client,bookingName,vehicleNumber,price,time,servicingType, vehicleName;
                 client = etclient.getText().toString();
                 bookingName = etbookingName.getText().toString();
                 vehicleNumber = etvehicleNumber.getText().toString();
                 price = etprice.getText().toString();
                 time = ettime.getText().toString();
                 vehicleName = vspinner.getSelectedItem().toString();
                 servicingType =spinner.getSelectedItem().toString();
                 Intent IntentForm = new Intent( BookNowActivity.this, BookingFragment.class );
                 IntentForm.putExtra( "Client",client );
                 IntentForm.putExtra( "BookingName",bookingName );
                 IntentForm.putExtra( "vehicleNumber",vehicleNumber );
                 IntentForm.putExtra( "price",price );
                 IntentForm.putExtra( "time",time );
                 IntentForm.putExtra( "vehicleName",vehicleName );
                 IntentForm.putExtra( "servicingType",servicingType );
                 startActivity( IntentForm );

             }
         } );
     }

    private void viewValue() {

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
