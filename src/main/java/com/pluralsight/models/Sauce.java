package com.pluralsight.models;

public class Sauce extends Topping{
    public Sauce(String name){
        super(name);
    }
    @Override
    public double getPrice(SandwichSize size){
        return 0;
    }
}
