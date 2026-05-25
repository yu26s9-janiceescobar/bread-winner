package com.pluralsight.models;

public abstract class OrderItem {
    private String name;

    public OrderItem(String name){
        this.name = name;
    }
    public abstract String getDetail();
    public abstract double calculatePrice();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
