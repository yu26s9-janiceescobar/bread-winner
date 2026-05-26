package com.pluralsight.models;

import com.pluralsight.business.Catalog;

public class Soda extends OrderItem{
    private String drinkType;
    private String size;

    public Soda(String name, String drinkType, String size){
        super(name);
        this.drinkType = drinkType;
        this.size = size;
    }
    @Override
    public double getPrice(Catalog catalog){
        // return price;
    }
    public String getDrinkType() {
        return drinkType;
    }

    public void setDrinkType(String drinkType) {
        this.drinkType = drinkType;
    }

    public void setSize(String size){
        this.size = size;
    }
    public String getSize(){
        return size;
    }
}
