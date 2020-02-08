package com.example.two_wheeler_schedule_management_system.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.two_wheeler_schedule_management_system.R;
import com.example.two_wheeler_schedule_management_system.Show_Parts;
import com.example.two_wheeler_schedule_management_system.activity.BookNowActivity;

public class HomeFragment extends Fragment {


CardView servicing, booking, emergency, vparts,subscription, feedback ;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View sview = inflater.inflate(R.layout.activity_fragment_home, container, false);
        servicing = sview.findViewById( R.id.cardServicing );
        booking = sview.findViewById( R.id.cardBooking );
        emergency = sview.findViewById( R.id.cardemergency );
        vparts = sview.findViewById( R.id.cardParts );
        subscription = sview.findViewById( R.id.cardSubscription );
        feedback = sview.findViewById( R.id.cardFeedback );



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
        emergency.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,
                        new BookingFragment()).commit();

            }
        } );
        vparts.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( getActivity(), Show_Parts.class );
                startActivity( intent );

            }
        } );
        subscription.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,
                        new BookingFragment()).commit();

            }
        } );
        feedback.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,
                        new BookingFragment()).commit();

            }
        } );

        return sview;
    }

}
