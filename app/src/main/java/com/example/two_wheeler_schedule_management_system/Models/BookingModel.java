package com.example.two_wheeler_schedule_management_system.Models;


public class BookingModel {


    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getServicingType() {
        return servicingType;
    }

    public void setServicingType(String servicingType) {
        this.servicingType = servicingType;
    }

    public String getServicingPrice() {
        return servicingPrice;
    }

    public void setServicingPrice(String servicingPrice) {
        this.servicingPrice = servicingPrice;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    private String client;
    private String servicingType;
    private String servicingPrice;
    private String time;


    public BookingModel(String client, String servicingType, String servicingPrice, String time) {
        this.client = client;
        this.servicingType = servicingType;
        this.servicingPrice = servicingPrice;
        this.time = time;
    }
}