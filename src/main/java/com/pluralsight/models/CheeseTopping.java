package com.pluralsight.models;

public class CheeseTopping extends Topping{
    public CheeseTopping(String name){
        super(name);
    }
    @Override
    public double getPrice(int size){
        return switch(size){
            case 4 -> .75;
            case 8 -> 1.50;
            case 12 -> 2.25;
            default -> 0;
        };
    }
}
