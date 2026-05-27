package com.pluralsight.models;

public class Meat extends PremiumTopping{

    public Meat(String name, boolean isExtra){
        super(name, isExtra);
    }

    @Override
    public double getBasePrice(SandwichSize size){
        return switch(size){
            case SMALL -> 0.5;
            case MEDIUM -> 1.0;
            case LARGE -> 1.5;
        };
    }
    @Override
    public double getExtraPrice(SandwichSize size){
            return switch(size){
                case SMALL -> 1.0;
                case MEDIUM -> 2.0;
                case LARGE -> 3.0;
        };
    }



}
