package com.example.two_wheeler_schedule_management_system.Models;

public class PartsModel {
    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public String getPartPrice() {
        return partPrice;
    }

    public void setPartPrice(String partPrice) {
        this.partPrice = partPrice;
    }

    public String getPartModel() {
        return partModel;
    }

    public void setPartModel(String partModel) {
        this.partModel = partModel;
    }

    public String getPartImage() {
        return partImage;
    }

    public void setPartImage(String partImage) {
        this.partImage = partImage;
    }

    public String partName;
    public String partPrice;
    public String partModel;
    public String partImage;


    public PartsModel(String partName, String partPrice, String partModel, String partImage) {
        this.partName = partName;
        this.partPrice = partPrice;
        this.partModel = partModel;
        this.partImage = partImage;
    }





}
