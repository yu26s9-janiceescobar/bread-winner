package com.pluralsight.business;
public class Store {
    private String name;
    private String address;
    private String phoneNumber;
    private Catalog catalog;

    public Store(String name, String address, String phoneNumber){
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;

    }

    public void addMenuCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public Catalog getMenuCatalog() {
        return catalog;
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
