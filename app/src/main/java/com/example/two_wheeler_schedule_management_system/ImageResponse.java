package com.example.two_wheeler_schedule_management_system;

public class ImageResponse {
    public String getProfileimage() {
        return profileimage;
    }

    public void setProfileimage(String profileimage) {
        this.profileimage = profileimage;
    }

    private String profileimage;

    public ImageResponse(String profileimage) {
        this.profileimage = profileimage;
    }

}
