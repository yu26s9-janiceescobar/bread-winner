package com.pluralsight.models;

public class RegularTopping extends Topping{
    private final double price;
    public RegularTopping(String name){
        super(name);
        price = 0;
    }

    @Override
    public double getPrice() {
        return price;
    }

}
