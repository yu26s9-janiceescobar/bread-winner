package com.pluralsight.models;

public class Sandwich implements OrderItem{
    public Sandwich(){

    }

    @Override
    public double getPrice() {
        return 0;
    }

    @Override
    public String getName() {
        return "";
    }
}
