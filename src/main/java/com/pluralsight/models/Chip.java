package com.pluralsight.models;

public class Chip implements OrderItem {
    private final double price;
    private String chipType;
    public Chip( double price, String chipType){
        this.price = price;
        this.chipType = chipType;
    }

    @Override
    public double getPrice(){
        return price;
    }

    @Override
    public String getName() {
        return "Chips";
    }
    public String getChipType(){
        return chipType;
    }
    public void setChipType(String chipType){
        this.chipType = chipType;
    }

}
