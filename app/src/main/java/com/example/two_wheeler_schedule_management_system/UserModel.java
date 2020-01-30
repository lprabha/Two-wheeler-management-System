package com.example.two_wheeler_schedule_management_system;

public class UserModel {
    private  String uId, uname, upassword, uemail;
    private int profilePicture;



    public UserModel(String uname, String uemail, int profilePicture) {
        this.uname = uname;
        this.uemail = uemail;
        this.profilePicture = profilePicture;
    }
    public UserModel( String uname, String upassword) {
        this.uname = uname;
        this.upassword = upassword;
    }
    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpassword() {
        return upassword;
    }

    public void setUpassword(String upassword) {
        this.upassword = upassword;
    }

    public String getUemail() {
        return uemail;
    }

    public void setUemail(String uemail) {
        this.uemail = uemail;
    }

    public int getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(int profilePicture) {
        this.profilePicture = profilePicture;
    }
}
