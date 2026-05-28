package com.pluralsight.models;

public class Chips extends OrderableItem {
    public static final double PRICE = 1.5;
    public static final String[] FLAVORS = new String[] {"BBQ", "Original", "Sour Cream & Onion", "Salt & Vinegar"};
    public Chips(String category, String name){
        super(category, name);

    }
    @Override
    public double getTotalPrice(){
        return PRICE;
    }

}


