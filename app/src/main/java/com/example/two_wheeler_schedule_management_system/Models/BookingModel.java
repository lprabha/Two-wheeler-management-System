package com.example.two_wheeler_schedule_management_system.Models;

import android.widget.Adapter;
import android.widget.Spinner;

public class BookingModel {

    public BookingModel(String name, String type, String client, String vehicleName, String servicingType, String bookingName, String vehicleNumber, String price, String time) {
        this.client = client;
        this.vehicleName = vehicleName;
        this.servicingType = servicingType;
        this.bookingName = bookingName;
        this.vehicleNumber = vehicleNumber;
        this.price = price;
        this.time = time;
    }

    private String client;

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

    public String getBookingName() {
        return bookingName;
    }

    public void setBookingName(String bookingName) {
        this.bookingName = bookingName;
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

    private String vehicleName;
    private String servicingType;
    private String bookingName;
    private String vehicleNumber;
    private String price;
    private String time;

}