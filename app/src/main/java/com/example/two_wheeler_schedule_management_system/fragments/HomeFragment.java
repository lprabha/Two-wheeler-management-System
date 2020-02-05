package com.example.two_wheeler_schedule_management_system.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.two_wheeler_schedule_management_system.BookingFragment;
import com.example.two_wheeler_schedule_management_system.R;
import com.example.two_wheeler_schedule_management_system.ServicingFragment;

public class HomeFragment extends Fragment {


CardView servicing, booking, emergency, servicecenter,subscription, feedback ;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_fragment_home, container, false);
        servicing = view.findViewById( R.id.cardServicing );
        booking = view.findViewById( R.id.cardbooking );



        servicing.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,
                        new ServicingFragment()).commit();

            }
        } );
        booking.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,
                        new BookingFragment()).commit();

            }
        } );

        return view;
    }

}
