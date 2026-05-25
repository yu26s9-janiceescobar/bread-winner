package com.pluralsight.models;

public class PremiumTopping extends Topping {
    private final double price;

    public PremiumTopping(String name, double price){
        super(name);
        this.price = price;
    }

    @Override
    public double getPrice(String size){
       return price;
    }

}
