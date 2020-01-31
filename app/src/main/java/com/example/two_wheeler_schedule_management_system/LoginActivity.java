package com.example.two_wheeler_schedule_management_system;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    Button loginbtn;
    EditText uname,upassword;
    TextView twsignup, twforgot;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();

        uname = findViewById( R.id.twUsername );
        upassword = findViewById( R.id.twPassword );
        twsignup = findViewById( R.id.tvSignUp );
        twforgot = findViewById(R.id.tvHelpSignIn);
        uname = findViewById( R.id.twUsername );
        loginbtn = findViewById( R.id.tw_btnLogin );


        twsignup.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openSignup = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(openSignup);
            }
        } );
        loginbtn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        } );


    }


    public void login(){

        UserModel userLogin = new UserModel(uname.getText().toString(), upassword.getText().toString());

        LoginApi loginApi = Url.getInstance().create(LoginApi.class );
        Call<Void> loginCall =loginApi.login(userLogin);

        loginCall.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(LoginActivity.this, "Login Error", Toast.LENGTH_SHORT).show();
                    return;
                }
                openDashBoard();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "Error " + t.getLocalizedMessage() , Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void openDashBoard(){
        Intent openDash = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(openDash);
    }


}
