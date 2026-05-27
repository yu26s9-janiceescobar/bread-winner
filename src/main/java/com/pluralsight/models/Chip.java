package com.pluralsight.models;

public class Chip extends OrderItem {
    private String name;
    private String chipType;
    public Chip(String name, String chipType){

        super(name);
        this.chipType = chipType;
    }
    @Override
    public double getPrice(){
        return 1.5;
    }

    public String getChipType() {
        return chipType;
    }
    public void setChipType(String chipType){
        this.chipType = chipType;
    }

}
