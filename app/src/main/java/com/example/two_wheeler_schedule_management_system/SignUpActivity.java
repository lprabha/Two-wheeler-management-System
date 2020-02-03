package com.example.two_wheeler_schedule_management_system;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.two_wheeler_schedule_management_system.Models.UserModel;
import com.example.two_wheeler_schedule_management_system.URL.Url;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SignUpActivity extends AppCompatActivity {
    private EditText signup_username, signup_phone, signup_password, signup_cpassword, signup_email;
    private Button signup_btn;

    String imageUrl;
    private String profilePic = "";


    @Override
    public void onCreate(Bundle saveInstanceState) {
        super.onCreate( saveInstanceState );
        setContentView( R.layout.activity_signup );

        getSupportActionBar().hide();

        signup_username = findViewById( R.id.signup_username );
        signup_email = findViewById( R.id.signup_email );
        signup_password = findViewById( R.id.signup_password );
        signup_cpassword = findViewById( R.id.signup_cpassword );
        signup_phone = findViewById( R.id.signup_phone );


        signup_btn = findViewById( R.id.signup_btn );

        signup_btn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(signup_password.getText().toString().equals(signup_cpassword.getText().toString())){
                    signup();
                }
                else{
                    Toast.makeText(SignUpActivity.this, "Password does not match", Toast.LENGTH_SHORT).show();
                    signup_password.requestFocus();
                    return;
                }
            }
        } );

    }

    private void signup() {
        String uname, upassword, uphone, uemail, ucpassword;

        uname = signup_username.getText().toString();
        uemail = signup_email.getText().toString();
        uphone = signup_phone.getText().toString();
        upassword = signup_password.getText().toString();
        ucpassword = signup_cpassword.getText().toString();

        UserModel userModel = new UserModel( uname,uemail,uphone,upassword,ucpassword );
        UserApi  userApi = Url.getInstance().create( UserApi.class );
        Call<Void> signup = userApi.signup(userModel);
        signup.enqueue( new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (!response.isSuccessful()){
                    Toast.makeText( SignUpActivity.this,"Code: " +response.body(), Toast.LENGTH_SHORT ).show();
                }
                Toast.makeText( SignUpActivity.this,"Signup completed.", Toast.LENGTH_SHORT ).show();
                Intent intent=new Intent( SignUpActivity.this,LoginActivity.class );
                startActivity( intent );
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(SignUpActivity.this, "Error: " + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        } );


    }
}
