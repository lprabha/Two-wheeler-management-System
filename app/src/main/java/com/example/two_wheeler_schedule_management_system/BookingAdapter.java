package com.example.two_wheeler_schedule_management_system;

import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.two_wheeler_schedule_management_system.Models.BookingModel;
import com.example.two_wheeler_schedule_management_system.activity.BookingDetails;

import java.util.List;

public class BookingAdapter extends RecyclerView.Adapter<BookingAdapter.BookingViewHolder> {

    public static final String BASE_URL = "http://10.0.2.2:3001/";

    private List<BookingModel> bookingList;

    public BookingAdapter(BookingDetails bookingDetails, List<BookingModel> bookingList) {
        this.bookingList = bookingList;
    }

    @NonNull
    @Override
    public BookingViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from( viewGroup.getContext() )
                .inflate( R.layout.bookingdetails, viewGroup, false );
        return new BookingViewHolder( view );
    }

    private void strictMode(){
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }

    @Override
    public void onBindViewHolder(@NonNull BookingViewHolder bookingViewHolder, int i) {
        final BookingModel bookingModel = bookingList.get( i );
        bookingViewHolder.etclient.setText(bookingModel.getClient() );
        bookingViewHolder.etbookingName.setText(bookingModel.getBookingName() );
        bookingViewHolder.etvehicleNumber.setText(bookingModel.getVehicleNumber() );
        bookingViewHolder.etprice.setText( bookingModel.getPrice() );
        bookingViewHolder.ettime.setText(bookingModel.getTime() );
        bookingViewHolder.vehiclename.setText(bookingModel.getVehicleName() );
        bookingViewHolder.servicingtype.setText(bookingModel.getServicingType() );
    }

    @Override
    public int getItemCount() {
        return bookingList.size();
    }
    public class BookingViewHolder extends RecyclerView.ViewHolder{

        public TextView etclient,etbookingName,etvehicleNumber,etprice,ettime,vehiclename,servicingtype;
        public Button BtnBookNow;

        public BookingViewHolder(@NonNull View itemView) {
            super( itemView );
            etclient = itemView.findViewById( R.id.clientName );
            etbookingName = itemView.findViewById( R.id.bookingName );
            etvehicleNumber = itemView.findViewById( R.id.vehicleNumber );
            etprice = itemView.findViewById( R.id.price );
            ettime = itemView.findViewById( R.id.dateTime );
            BtnBookNow= itemView.findViewById( R.id.btnBookNow );
            servicingtype = itemView.findViewById(R.id.ServicingType_spinner);
            vehiclename = itemView.findViewById(R.id.VehicleName_spinner);
        }
    }

    public BookingAdapter(List<BookingModel> bookingModelList) {

    }



}

