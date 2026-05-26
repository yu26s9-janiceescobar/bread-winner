package com.pluralsight.models;

public class MeatTopping extends Topping{
    public MeatTopping(String name){
        super(name);
    }
    @Override
    public double getPrice(int size){
        return switch(size){
            case 4 -> 1.0;
            case 8 -> 2.0;
            case 12 -> 3.0;
            default -> 0;
        };
    }
}
