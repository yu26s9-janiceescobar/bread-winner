package com.pluralsight.models;

public class Soda extends OrderableItem {
    private SodaSize size;
    public Soda(String category, String name, SodaSize size){
        super(category, name);
        this.size = size;
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
