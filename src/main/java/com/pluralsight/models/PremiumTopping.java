package com.pluralsight.models;

public abstract class PremiumTopping extends Topping{
    private boolean isExtra;
    public PremiumTopping(String name, boolean isExtra) {
        super(name);
        this.isExtra = isExtra;
    }
    public void setExtra(boolean isExtra){
        this.isExtra = isExtra;
    }
    public boolean isExtra(){
        return isExtra;
    }

    public double getPrice(SandwichSize size){
        return (isExtra) ? getExtraPrice(size) : getBasePrice(size);
    }
    public abstract double getExtraPrice(SandwichSize size);

    public abstract double getBasePrice(SandwichSize size);

}
