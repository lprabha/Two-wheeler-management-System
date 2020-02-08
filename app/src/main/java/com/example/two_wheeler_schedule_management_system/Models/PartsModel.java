package com.example.two_wheeler_schedule_management_system.Models;

public class PartsModel {
    public String  partName;
    public String partPrice;
    public  String partsModel;
    public String partImage;

    public PartsModel(String partImage) {
        this.partImage = partImage;
    }

    public String getPartImage() {
        return partImage;
    }

    public void setPartImage(String partImage) {
        this.partImage = partImage;
    }



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

    public String getPartsModel() {
        return partsModel;
    }

    public void setPartsModel(String partsModel) {
        this.partsModel = partsModel;
    }

    public PartsModel(String partName, String partPrice, String partsModel) {
        this.partName = partName;
        this.partPrice = partPrice;
        this.partsModel = partsModel;
    }

}
