package com.example.two_wheeler_schedule_management_system.activity;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.two_wheeler_schedule_management_system.R;
import com.example.two_wheeler_schedule_management_system.fragments.BookingFragment;
import com.example.two_wheeler_schedule_management_system.fragments.HomeFragment;
import com.example.two_wheeler_schedule_management_system.fragments.ServicingFragment;
import com.example.two_wheeler_schedule_management_system.fragments.SettingFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ActivityDashboard extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_dashboard);


        BottomNavigationView bottomNav = findViewById(R.id.bottomNavigat);
        bottomNav.setOnNavigationItemSelectedListener(navigationListner);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,
                new HomeFragment()).commit();

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navigationListner =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectFragment = null;
                    switch (item.getItemId()){

                        case R.id.navigation_home:
                            selectFragment = new HomeFragment();
                            break;
                        case R.id.navigation_servicing:
                            selectFragment = new ServicingFragment();
                            break;

                        case R.id.navigation_booking:
                            selectFragment = new BookingFragment();
                            break;

                        case R.id.navigation_setting:
                            selectFragment = new SettingFragment();
                            break;

                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,
                            selectFragment).commit();
                    return true;
                }
            };


}
