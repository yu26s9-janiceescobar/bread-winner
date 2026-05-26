package com.pluralsight.models;

public class Meat extends Topping{
    private boolean isExtra;
    public Meat(String name, boolean isExtra){
        super(name);
        this.isExtra = isExtra;
    }
    public void setExtra(boolean isExtra){
        this.isExtra = isExtra;
    }
    @Override
    public double getPrice(int size){
        return  isExtra ? getExtraMeatPrice(size) : getBaseMeatPrice(size);
    }
    public double getExtraMeatPrice(int size){
        return switch(size){
            case 4 -> 0.5;
            case 8 -> 1.0;
            case 12 -> 1.5;
            default -> 0;
        };
    }
    public double getBaseMeatPrice(int size){
        return switch(size){
            case 4 -> 1.0;
            case 8 -> 2.0;
            case 12 -> 3.0;
            default -> 0;
        };
    }

}
