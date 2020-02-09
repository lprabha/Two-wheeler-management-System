package com.example.two_wheeler_schedule_management_system.ServerResponse;

public class ImageResponse {
    private String profileimage;
    public String getProfileimage() {
        return profileimage;
    }
    public void setProfileimage(String profileimage) {
        this.profileimage = profileimage;
    }
    public ImageResponse(String profileimage) {
        this.profileimage = profileimage;
    }

}
