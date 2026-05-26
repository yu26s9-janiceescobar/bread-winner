package com.pluralsight.models;

public class Cheese extends Topping{
    private boolean isExtra;
    public Cheese(String name, boolean isExtra){
        super(name);
        this.isExtra = isExtra;
    }
    public void setExtra(boolean isExtra){
        this.isExtra = isExtra;
    }
    public boolean isExtra(){
        return isExtra;
    }

    @Override
    public double getPrice(SandwichSize size){
        return (isExtra) ? getExtraPrice(size) : getBasePrice(size);
    }
    public double getExtraPrice(SandwichSize size){
        return switch(size){
            case SMALL -> 0.30;
            case MEDIUM -> 0.60;
            case LARGE -> 0.90;
        };
    }
    public double getBasePrice(SandwichSize size){
        return switch(size){
            case SMALL -> .75;
            case MEDIUM -> 1.50;
            case LARGE -> 2.25;
        };
    }
}
