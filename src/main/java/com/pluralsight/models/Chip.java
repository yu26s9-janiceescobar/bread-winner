package com.pluralsight.models;

import com.pluralsight.business.Catalog;

public class Chip extends OrderItem {
    private String name;
    private String chipType;
    public Chip(String name, String chipType){
        super(name);
        this.chipType = chipType;
    }
    @Override
    public double getPrice(Catalog catalog){
        // return price
    }

    public String getChipType() {
        return chipType;
    }
    public void setChipType(String chipType){
        this.chipType = chipType;
    }

}
