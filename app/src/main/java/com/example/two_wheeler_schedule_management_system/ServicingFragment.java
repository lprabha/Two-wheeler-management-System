package com.example.two_wheeler_schedule_management_system;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.two_wheeler_schedule_management_system.MainActivity;
import com.example.two_wheeler_schedule_management_system.R;

public class ServicingFragment extends Fragment {

    CardView cleaning,fullservicing,repair,homeServicing;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate( R.layout.activity_fragment_servicing, container, false);
        cleaning = view.findViewById( R.id. cardcleaning);
//        fullservicing = view.findViewById( R.id.cardfullservicing );
//        repair = view.findViewById( R.id.cardrepair );
//        homeServicing = view.findViewById( R.id.cardhomeServicing );

        cleaning.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        } );

        return view;
    }

}
