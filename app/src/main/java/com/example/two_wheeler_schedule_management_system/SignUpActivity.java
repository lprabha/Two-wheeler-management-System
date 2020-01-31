package com.example.two_wheeler_schedule_management_system;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpActivity extends AppCompatActivity {
    private EditText signup_username, signup_phone, signup_password, signup_email;
    private Button signup_btn;
    public static int phoneOrEmail = 0;

    @Override
    public void onCreate(Bundle saveInstanceState) {
        super.onCreate( saveInstanceState );
        setContentView( R.layout.activity_signup );
        signup_username = findViewById( R.id.signup_username );
        signup_email = findViewById( R.id.signup_email );
        signup_password = findViewById( R.id.signup_password );
        signup_phone = findViewById( R.id.signup_phone );
        signup_btn = findViewById( R.id.signup_btn );

    }
}
