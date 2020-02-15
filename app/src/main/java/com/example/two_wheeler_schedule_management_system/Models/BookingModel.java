package com.example.two_wheeler_schedule_management_system.Models;


public class BookingModel {

    public BookingModel(String client, String vehicleNumber, String time,  String servicingType, String vehicleName, String price  ) {
        this.client = client;
        this.vehicleName = vehicleName;
        this.servicingType = servicingType;
        this.vehicleNumber = vehicleNumber;
        this.price = price;
        this.time = time;
    }



    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public String getServicingType() {
        return servicingType;
    }

    public void setServicingType(String servicingType) {
        this.servicingType = servicingType;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    private String client;
    private String vehicleName;
    private String vehicleNumber;
    private String servicingType;

    private String price;
    private String time;

}