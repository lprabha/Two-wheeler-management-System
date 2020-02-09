package com.example.two_wheeler_schedule_management_system.ServerResponse;

import com.example.two_wheeler_schedule_management_system.Models.UserModel;

public class UserResponse {

    private String token;
    private String status;
    private UserModel userModel;

    public UserResponse(String token, String status) {
        this.token = token;
        this.status = status;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public UserModel getUserModel() {
        return userModel;
    }
}
