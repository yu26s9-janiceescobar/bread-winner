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
    public double getPrice(int size){
        return (isExtra) ? getExtraPrice(size) : getBasePrice(size);
    }
    public double getExtraPrice(int size){
        return switch(size){
            case 4 -> 0.30;
            case 8 -> 0.60;
            case 12 -> 0.90;
            default -> 0;
        };
    }
    public double getBasePrice(int size){
        return switch(size){
            case 4 -> .75;
            case 8 -> 1.50;
            case 12 -> 2.25;
            default -> 0;
        };
    }
}
