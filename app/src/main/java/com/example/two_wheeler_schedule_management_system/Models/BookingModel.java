package com.example.two_wheeler_schedule_management_system.Models;


public class BookingModel {

    private String client;
    private String servicingType;
    private String servicingPrice;
    private String time;
    private String bookingNote;
    private String _id;


    public BookingModel(String client, String servicingType, String servicingPrice, String time) {
        this.client = client;
        this.servicingType = servicingType;
        this.servicingPrice = servicingPrice;
        this.time = time;
    }

    public BookingModel(String client, String servicingType, String servicingPrice, String time, String _id) {
        this.client = client;
        this.servicingType = servicingType;
        this.servicingPrice = servicingPrice;
        this.time = time;
        this._id = _id;
    }

    public String getBookingNote() {
        return bookingNote;
    }

    public void setBookingNote(String bookingNote) {
        this.bookingNote = bookingNote;
    }

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

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }
}