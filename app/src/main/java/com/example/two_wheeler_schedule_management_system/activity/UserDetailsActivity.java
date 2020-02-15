package com.example.two_wheeler_schedule_management_system.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationManagerCompat;

import com.example.two_wheeler_schedule_management_system.API.UserApi;
import com.example.two_wheeler_schedule_management_system.CreateChannels;
import com.example.two_wheeler_schedule_management_system.Models.UserModel;
import com.example.two_wheeler_schedule_management_system.R;
import com.example.two_wheeler_schedule_management_system.ServerResponse.UserResponse;
import com.example.two_wheeler_schedule_management_system.URL.Url;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserDetailsActivity extends Activity {
    private EditText etFName,etUName,etUEmail,etUAddress,etUPnumber,etUPassword;
    private CircleImageView imgUimage;
    private Button btnUpdate;
    String id;
    NotificationManagerCompat notificationManagerCompat;

    @Nullable
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_user_profile);
        notificationManagerCompat = NotificationManagerCompat.from(this);
        CreateChannels channel = new CreateChannels(this);
        channel.createChannel();

        etFName = findViewById(R.id.userFullName);
        etUEmail = findViewById(R.id.UserEmail);
        etUAddress = findViewById(R.id.userAddress);
        etUPnumber = findViewById(R.id.userPhoneNumber);
        etUName = findViewById(R.id.UserName);
        imgUimage = findViewById(R.id.imgProfile);
        btnUpdate = findViewById(R.id.btnUpdate);

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UpdateUser();
            }
        });

        UserApi usersAPI = Url.getInstance().create(UserApi.class);
        Call<UserModel> userModelCall = usersAPI.getUserDetails(Url.token);


        userModelCall.enqueue(new Callback<UserModel>() {
            @Override
            public void onResponse(Call<UserModel> call, Response<UserModel> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(UserDetailsActivity.this, "Error" + response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }
                etFName.setText(response.body().getFullname());
                etUName.setText(response.body().getUsername());
                etUEmail.setText(response.body().getEmail());
                etUAddress.setText(response.body().getAddress());
                etUPnumber.setText(response.body().getPhonenumber());

                //image path
                String imgPath = Url.imagePath + response.body().getImage();

                Picasso.get().load(imgPath).into(imgUimage);

                id = response.body().get_id();


            }

            @Override
            public void onFailure(Call<UserModel> call, Throwable t) {

                Log.d("Msg", "onFailure: " + t.getLocalizedMessage());
                Toast.makeText(UserDetailsActivity.this, "Error" + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void UpdateUser() {
        UserApi userAPI = Url.getInstance().create(UserApi.class);
        String fullName = etFName.getText().toString();
        String email = etUEmail.getText().toString();
        String userName = etUName.getText().toString();
        String address = etUAddress.getText().toString();
        String phone = etUPnumber.getText().toString();
        Call<UserResponse> updatecall = userAPI.userUpate(Url.token, fullName,email,userName, address, phone);

        updatecall.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                Toast.makeText(UserDetailsActivity.this, "Updated Successfully!!!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(UserDetailsActivity.this, UserDetailsActivity.class));
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                Toast.makeText(UserDetailsActivity.this, "Error", Toast.LENGTH_SHORT).show();

            }
        });
    }

}
