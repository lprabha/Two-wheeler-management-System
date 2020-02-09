package com.example.two_wheeler_schedule_management_system;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.two_wheeler_schedule_management_system.API.UserApi;
import com.example.two_wheeler_schedule_management_system.Models.Feedback;
import com.example.two_wheeler_schedule_management_system.Models.UserModel;
import com.example.two_wheeler_schedule_management_system.ServerResponse.FeedbackResponse;
import com.example.two_wheeler_schedule_management_system.URL.Url;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainFeedback extends AppCompatActivity {
    private TextView tvTname;
    private EditText etTopic,etfeedback;
    private Button btnPost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        tvTname = findViewById(R.id.tvname);
        etTopic = findViewById(R.id.clientTopic);
        etfeedback = findViewById(R.id.clientFeedback);
        btnPost = findViewById(R.id.btnpost);

        btnPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                feedback();
            }
        });


        UserApi usersAPI = Url.getInstance().create(UserApi.class);
        Call<UserModel> userModelCall = usersAPI.getUserDetails(Url.token);

        userModelCall.enqueue(new Callback<UserModel>() {


            @Override
            public void onResponse(Call<UserModel> call, Response<UserModel> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(MainFeedback.this, "Error" + response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }
                tvTname.setText(response.body().getFullname());

            }

            @Override
            public void onFailure(Call<UserModel> call, Throwable t) {

                Log.d("Msg", "onFailure: " + t.getLocalizedMessage());
                Toast.makeText(MainFeedback.this, "Error" + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }
    private void feedback(){
        String client = tvTname.getText().toString();
        String topic = etTopic.getText().toString();
        String desc = etfeedback.getText().toString();

        Feedback feedback = new Feedback(client,topic,desc);

        UserApi usersAPI = Url.getInstance().create(UserApi.class);
        Call<FeedbackResponse> feedbackCall = usersAPI.feedbackDetail( feedback );

        feedbackCall.enqueue(new Callback<FeedbackResponse>() {
            @Override
            public void onResponse(Call<FeedbackResponse> call, Response<FeedbackResponse> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(MainFeedback.this, "Code" + response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }
                Toast.makeText(MainFeedback.this, "Feedback Posted", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainFeedback.this,MainFeedback.class);
                startActivity(intent);
                finish();

            }


            @Override
            public void onFailure(Call<FeedbackResponse> call, Throwable t) {

                Toast.makeText(MainFeedback.this, "Error " + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
