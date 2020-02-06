package com.example.two_wheeler_schedule_management_system.Models;

public class UserModel {


    private Boolean userAdmin;
    private String fullname;
    private String username;
    private String address;
    private String phonenumber;
    private String gender;
    private String email;
    private String password;


    public UserModel(String username, String address, String phonenumber, String email, String password) {
        this.username = username;
        this.address = address;
        this.phonenumber = phonenumber;
        this.email = email;
        this.password = password;
    }

    public UserModel(Boolean userAdmin, String fullname, String username, String address, String phonenumber, String gender, String email, String password) {
        this.userAdmin = userAdmin;
        this.fullname = fullname;
        this.username = username;
        this.address = address;
        this.phonenumber = phonenumber;
        this.gender = gender;
        this.email = email;
        this.password = password;
    }

    public UserModel(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Boolean getUserAdmin() {
        return userAdmin;
    }

    public void setUserAdmin(Boolean userAdmin) {
        this.userAdmin = userAdmin;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
