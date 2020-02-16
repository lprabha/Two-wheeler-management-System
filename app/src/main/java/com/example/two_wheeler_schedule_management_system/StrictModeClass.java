package com.example.two_wheeler_schedule_management_system;

public class StrictModeClass {

    public static void StrictMode(){
        android.os.StrictMode.ThreadPolicy policy =
                new android.os.StrictMode.ThreadPolicy.Builder()
                        .permitAll().build();

        android.os.StrictMode.setThreadPolicy(policy);
    }
}
