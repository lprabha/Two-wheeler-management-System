package com.example.two_wheeler_schedule_management_system.Models;

public class ItemList {
    private  String itemTitle;
    private int itemIcon;

    public ItemList(String itemTitle, int itemIcon) {
        this.itemTitle = itemTitle;
        this.itemIcon = itemIcon;
    }

    public String getItemTitle() {
        return itemTitle;
    }

    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
    }

    public int getItemIcon() {
        return itemIcon;
    }

    public void setItemIcon(int itemIcon) {
        this.itemIcon = itemIcon;
    }

    public String getDailyPhoto() {
        return null;
    }

    public String getPostByName() {
        return null;
    }
}
