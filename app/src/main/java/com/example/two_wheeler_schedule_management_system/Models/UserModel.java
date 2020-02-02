package com.example.two_wheeler_schedule_management_system.Models;

public class UserModel {


    private  String uId;
    private String uname;
    private String upassword;
    private String uphone;
    private String uemail;
    private String profilePic;

    public UserModel(String uname, String upassword, String uphone, String uemail, String profilePicture) {
        this.uname = uname;
        this.upassword = upassword;
        this.uphone = uphone;
        this.uemail = uemail;
        this.profilePic = profilePic;
    }

    public UserModel(String uname, String upassword, String uphone, String uemail) {
        this.uname = uname;
        this.upassword = upassword;
        this.uphone = uphone;
        this.uemail = uemail;
    }
    public UserModel(String uname, String upassword) {
        this.uname = uname;
        this.upassword = upassword;
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

    public String getUphone() {
        return uphone;
    }

    public void setUphone(String uphone) {
        this.uphone = uphone;
    }

    public String getUemail() {
        return uemail;
    }

    public void setUemail(String uemail) {
        this.uemail = uemail;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }



}
