package com.pluralsight.models;

public class PremiumTopping extends Topping {
    public PremiumTopping(String name){
        super(name);
    }
    
    @Override
    public double getPrice() {
        return price;
    }

}
