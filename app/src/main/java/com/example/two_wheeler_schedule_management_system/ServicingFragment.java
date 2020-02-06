package com.example.two_wheeler_schedule_management_system;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;


public class ServicingFragment extends Fragment {

    CardView cleaning, fullservicing, repair, homeServicing;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate( R.layout.activity_fragment_servicing, container, false );
        cleaning = view.findViewById( R.id.cardcleaning );
        fullservicing = view.findViewById( R.id.cardfullservicing );
        repair = view.findViewById( R.id.cardrepair );
        homeServicing = view.findViewById( R.id.cardhomeServicing );

        cleaning.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( getActivity(), BookNowActivity.class );
                startActivity( intent );

            }
        } );
        fullservicing.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( getActivity(), BookNowActivity.class );
                startActivity( intent );

            }
        } );
        repair.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( getActivity(), BookNowActivity.class );
                startActivity( intent );

            }
        } );
        homeServicing.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( getActivity(), BookNowActivity.class );
                startActivity( intent );

            }
        } );

        return view;
    }
}