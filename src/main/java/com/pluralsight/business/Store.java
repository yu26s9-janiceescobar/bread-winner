package com.pluralsight.business;

import java.awt.*;
import java.util.ArrayList;

public class Store {
    private String name;
    private String address;
    private String phoneNumber;
    private ArrayList<MenuItem> menuCatalog;

    public Store(String name, String address, String phoneNumber){
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        menuCatalog = new ArrayList<>();
    }
    public void addMenuEntry(MenuItem menuItem){
        menuCatalog.add(menuItem);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
