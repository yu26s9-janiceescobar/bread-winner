package com.pluralsight.models;

public enum SodaSize {
    SMALL("Small Soda", 2.0),
    MEDIUM("Medium Soda", 2.5),
    LARGE("Large Soda", 3.0);

    private final String label;
    private final double price;
    SodaSize(String label, double price){
        this.label = label;
        this.price = price;
    }

    public String getLabel() {
        return label;
    }

    public double getPrice() {
        return price;
    }


}
