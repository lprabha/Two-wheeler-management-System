package com.example.two_wheeler_schedule_management_system;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class BookingFragment extends Fragment {

    TextView cName, vName, sType, vNumber, bookingName, sprice, dateTime;



        @Nullable
        @Override
        public View onCreateView (LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState){

            // Inflate the layout for this fragment
            View view = inflater.inflate( R.layout.activity_fragment_booking, container, false );
            return view;

    }
}