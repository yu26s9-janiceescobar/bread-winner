package com.pluralsight.models;

public class Meat extends Topping{
    private boolean isExtra;

    public Meat(String name, boolean isExtra){
        super(name);
        this.isExtra = isExtra;
    }

    @Override
    public double getPrice(SandwichSize size){
        return (isExtra) ? getExtraPrice(size) : getBasePrice(size);
    }
    public void setExtra(boolean isExtra){
        this.isExtra = isExtra;
    }
    public boolean isExtra(){
        return isExtra;
    }
    public static double getBasePrice(SandwichSize size){
        return switch(size){
            case SMALL -> 0.5;
            case MEDIUM -> 1.0;
            case LARGE -> 1.5;
        };
    }

    public static double getExtraPrice(SandwichSize size){
            return switch(size){
                case SMALL -> 1.0;
                case MEDIUM -> 2.0;
                case LARGE -> 3.0;
        };
    }





}
