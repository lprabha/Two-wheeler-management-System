package com.example.two_wheeler_schedule_management_system;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.content.CursorLoader;

import com.example.two_wheeler_schedule_management_system.API.UserApi;
import com.example.two_wheeler_schedule_management_system.Models.UserModel;
import com.example.two_wheeler_schedule_management_system.ServerResponse.ImageResponse;
import com.example.two_wheeler_schedule_management_system.ServerResponse.UserResponse;
import com.example.two_wheeler_schedule_management_system.URL.Url;
import com.example.two_wheeler_schedule_management_system.activity.LoginActivity;

import java.io.File;
import java.io.IOException;

import de.hdodenhof.circleimageview.CircleImageView;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SignUpActivity extends AppCompatActivity {
    private EditText signup_username, signup_phone, signup_password, signup_cpassword, signup_email, signup_fullname,signup_address;
    private Button signup_btn;
    private CircleImageView imgProfile;

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
        signup_fullname = findViewById( R.id.signup_fullname );
        signup_address = findViewById( R.id.signup_address );
        imgProfile = findViewById( R.id.imgProfile );
        signup_btn = findViewById( R.id.signup_btn );

        imgProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BrowseImage();
            }
        });



        signup_btn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(signup_password.getText().toString().equals(signup_cpassword.getText().toString())){
                    signup();
                    saveImageOnly();
                }
                else{
                    Toast.makeText(SignUpActivity.this, "Password does not match", Toast.LENGTH_SHORT).show();
                    signup_password.requestFocus();
                    return;
                }
            }
        } );

    }
    private boolean validate() {
        boolean status = true;

        if (imgProfile.getDrawable() == null) {
            Toast.makeText(this, "Please select image", Toast.LENGTH_SHORT).show();
            imgProfile.requestFocus();
            status = false;
        }

        if (TextUtils.isEmpty(signup_username.getText())) {
            signup_username.setError("Enter username");
            signup_username.requestFocus();
            status = false;
        }
        if (TextUtils.isEmpty(signup_fullname.getText())) {
            signup_fullname.setError("Enter fullname");
            signup_fullname.requestFocus();
            status = false;
        }
        if (TextUtils.isEmpty(signup_password.getText())) {
            signup_password.setError("Enter password");
            signup_password.requestFocus();
            status = false;
        }
        if (TextUtils.isEmpty(signup_cpassword.getText())) {
            signup_cpassword.setError("Enter password");
            signup_cpassword.requestFocus();
            status = false;
        }
        if (TextUtils.isEmpty(signup_email.getText())) {
            signup_email.setError("Enter Email address");
            signup_email.requestFocus();
            status = false;
        }

        if (TextUtils.isEmpty(signup_address.getText())) {
            signup_address.setError("Enter street name");
            signup_address.requestFocus();
            status = false;
        }
        if (signup_phone.toString().length() < 10) {
            signup_phone.setError("Minimum 10 character");
            signup_phone.requestFocus();
            status = false;
        }
        if (TextUtils.isEmpty(signup_phone.getText())) {
            signup_phone.setError("Enter mobile phone number");
            signup_phone.requestFocus();
            status = false;
        }

        return status;
    }

    private void BrowseImage(){
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/");
        startActivityForResult(intent,0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            if (data == null) {
                Toast.makeText(this, "Please Select Image", Toast.LENGTH_SHORT).show();
            }
        }
        Uri uri = data.getData();
        //profilePic.setImageURI(uri);
        imageUrl = getRealPathFromUri(uri);
    }

    private String getRealPathFromUri(Uri uri) {
        String[] projection = {MediaStore.Images.Media.DATA};
        CursorLoader loader = new CursorLoader(getApplicationContext(),
                uri, projection, null, null, null);
        Cursor cursor = loader.loadInBackground();
        int colIndex = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        String result = cursor.getString(colIndex);
        cursor.close();
        return result;
    }

    private void saveImageOnly() {
        File file = new File(imageUrl);
        RequestBody requestBody = RequestBody.create( MediaType.parse("multipart/form-data"), file);
        MultipartBody.Part body = MultipartBody.Part.createFormData("imageFile",
                file.getName(), requestBody);

        UserApi usersAPI = Url.getInstance().create(UserApi.class);
        Call<ImageResponse> responseBodyCall = usersAPI.uploadImage(body);

        StrictModeClass.StrictMode();
        //Synchronous methid
        try {
            Response<ImageResponse> imageResponseResponse = responseBodyCall.execute();
            profilePic = imageResponseResponse.body().getProfileimage();
            Toast.makeText(this, "Image inserted" + profilePic, Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            Toast.makeText(this, "Error" + e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }

    private void signup() {
        String uname, upassword, uphone, uemail, ucpassword;

        uname = signup_username.getText().toString();
        uemail = signup_email.getText().toString();
        uphone = signup_phone.getText().toString();
        upassword = signup_password.getText().toString();
        ucpassword = signup_cpassword.getText().toString();

        UserModel userModel = new UserModel( uname,uemail,uphone,upassword,ucpassword );
        UserApi userApi = Url.getInstance().create( UserApi.class );
        Call<UserResponse> signup = userApi.signup(userModel);
        signup.enqueue( new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                if (!response.isSuccessful()){
                    Toast.makeText( SignUpActivity.this,"Code: " +response.body(), Toast.LENGTH_SHORT ).show();
                    return;
                }
                Toast.makeText( SignUpActivity.this,"Signup completed.", Toast.LENGTH_SHORT ).show();
                Intent intent=new Intent( SignUpActivity.this, LoginActivity.class );
                startActivity( intent );
                finish();
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                Toast.makeText(SignUpActivity.this, "Error: " + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        } );
    }
}
