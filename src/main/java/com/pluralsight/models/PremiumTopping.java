package com.pluralsight.models;

public class PremiumTopping extends Topping {
    private double price;
    private final double smallPrice;
    private final double mediumPrice;
    private final double largePrice;
    public PremiumTopping(String name, double smallPrice, double mediumPrice, double largePrice){
        super(name);
        this.smallPrice = smallPrice;
        this.mediumPrice = mediumPrice;
        this.largePrice = largePrice;
    }

    @Override
    public double getPrice(Size size){
        return switch(size){
            case SMALL -> smallPrice;
            case MEDIUM -> mediumPrice;
            case LARGE -> largePrice;
        };
    }

}
