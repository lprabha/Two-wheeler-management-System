package com.example.two_wheeler_schedule_management_system.fragments;

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

import com.example.two_wheeler_schedule_management_system.activity.ActivityAbout;
import com.example.two_wheeler_schedule_management_system.activity.ActivityContact;
import com.example.two_wheeler_schedule_management_system.FAQ;
import com.example.two_wheeler_schedule_management_system.MainActivity;
import com.example.two_wheeler_schedule_management_system.R;


public class SettingFragment extends Fragment {

    CardView about, contact, faq, logout;

    @RequiresApi(api = Build.VERSION_CODES.M)


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate( R.layout.activity_fragment_setting, container, false);
        about = view.findViewById( R.id.cardaboutus );
        contact = view.findViewById( R.id.cardcontactus );
        faq = view.findViewById( R.id.cardfaq );
        logout = view.findViewById( R.id.cardlogout );


        about.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( getActivity(), ActivityAbout.class );
                startActivity( intent );

            }
        } );
        contact.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( getActivity(), ActivityContact.class );
                startActivity( intent );

            }
        } );
        faq.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( getActivity(), FAQ.class );
                startActivity( intent );

            }
        } );
        logout.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( getActivity(), MainActivity.class );
                startActivity( intent );

            }
        } );

        return view;
    }

}