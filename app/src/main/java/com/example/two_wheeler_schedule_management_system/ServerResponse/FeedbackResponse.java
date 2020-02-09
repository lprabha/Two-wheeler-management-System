package com.example.two_wheeler_schedule_management_system.ServerResponse;

import com.example.two_wheeler_schedule_management_system.Models.Feedback;

public class FeedbackResponse {

    private String status;
    private String token;
    private Feedback feedback;

    public FeedbackResponse(String status, String token, Feedback feedback) {
        this.status = status;
        this.token = token;
        this.feedback = feedback;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Feedback getFeedback() {
        return feedback;
    }

}

