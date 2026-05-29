package com.pluralsight.models;

import com.pluralsight.models.enums.SodaSize;

public class Soda extends OrderableItem {
    private SodaSize size;
    public static final String[] FLAVORS = new String[]{"Sprite", "Ginger Ale", "Pepsi", "Diet Pepsi"};
    public Soda(String category, String name, SodaSize size){
        super(category, name);
        this.size = size;
    }
    public Soda(Soda other){
        super(other.getCategory(), other.getName());
        this.size = other.size;
    }
    @Override
    public double getTotalPrice(){
        return size.getPrice();
    }
    public void setSize(SodaSize size){
        this.size = size;
    }
    public SodaSize getSize(){
        return size;
    }
}
