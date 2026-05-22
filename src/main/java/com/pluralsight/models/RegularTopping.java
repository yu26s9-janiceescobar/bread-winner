package com.pluralsight.models;

public class RegularTopping extends Topping{
    public RegularTopping(String name){
        super(name);
    }

    @Override
    public double getPrice(Size size){
        return 0;
    }
}
