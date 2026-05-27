package com.pluralsight.models;

public class Soda extends OrderableItem {
    private String size;
    public Soda(String name, double price, String size){
        super(name, price);
        this.size = size;
    }

    public void setSize(String size){
        this.size = size;
    }
    public String getSize(){
        return size;
    }
}
