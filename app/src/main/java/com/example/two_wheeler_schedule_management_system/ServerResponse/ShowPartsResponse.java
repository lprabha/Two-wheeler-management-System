package com.example.two_wheeler_schedule_management_system.ServerResponse;

import com.example.two_wheeler_schedule_management_system.Models.PartsModel;

public class ShowPartsResponse {
    public ShowPartsResponse(String status, String token, PartsModel partsModel) {
        this.status = status;
        this.token = token;
        this.partsModel = partsModel;
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

    public PartsModel getPartsModel() {
        return partsModel;
    }

    private String status;
    private String token;
    private PartsModel partsModel;
}
