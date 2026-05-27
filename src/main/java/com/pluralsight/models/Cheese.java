package com.pluralsight.models;

public class Cheese extends PremiumTopping{
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
    public double getExtraPrice(SandwichSize size){
        return switch(size){
            case SMALL -> 0.30;
            case MEDIUM -> 0.60;
            case LARGE -> 0.90;
        };
    }
    @Override
    public  double getBasePrice(SandwichSize size){
        return switch(size){
            case SMALL -> .75;
            case MEDIUM -> 1.50;
            case LARGE -> 2.25;
        };
    }
}
