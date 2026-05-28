package com.pluralsight.models;

public enum SandwichSize {
    FOUR_INCH("4 Inch", 5.5),
    EIGHT_INCH("8 Inch", 7.0),
    TWELVE_INCH("12 Inch", 8.5);


    private final String label;
    private final double price;
    SandwichSize(String label, double price){
        this.label = label;
        this.price = price;
    }
    public String getLabel(){
        return label;
    }
    public double getPrice(){
        return price;
    }
}
