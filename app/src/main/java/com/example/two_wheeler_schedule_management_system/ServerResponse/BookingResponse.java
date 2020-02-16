package com.example.two_wheeler_schedule_management_system.ServerResponse;

import com.example.two_wheeler_schedule_management_system.Models.BookingModel;

public class BookingResponse {
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

    public BookingModel getBookingModel() {
        return bookingModel;
    }

    private String status;
    private String token;
    private BookingModel bookingModel;

    public BookingResponse(String status, String token, BookingModel bookingModel) {
        this.status = status;
        this.token = token;
        this.bookingModel = bookingModel;
    }
}
