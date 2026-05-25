package com.pluralsight.models;

public class Chip extends OrderItem {
    private String name;
    private final double price;
    private String chipType;
    public Chip(String name, double price, String chipType){
        super(name);
        this.price = price;
        this.chipType = chipType;
    }
    @Override
    public double calculatePrice(){
        return price;
    }

    public String getChipType() {
        return chipType;
    }
    public void setChipType(String chipType){
        this.chipType = chipType;
    }

}
