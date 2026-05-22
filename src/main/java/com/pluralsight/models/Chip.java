package com.pluralsight.models;

public class Chip implements OrderItem {
    private String details;
    private String name;
    private double price;
    public Chip(String details, String name, double price){
        this.details = details;
        this.name = name;
        this.price = price;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getName() {
        return name;
    }
}
