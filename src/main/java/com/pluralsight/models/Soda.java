package com.pluralsight.models;

public class Soda extends OrderItem {
    private String drinkType;
    private SodaSize size;

    public Soda(String name, String drinkType, SodaSize size){
        super(name);
        this.drinkType = drinkType;
        this.size = size;
    }
    @Override
    public double getPrice(){
        return size.getPrice();
    }
    public String getDrinkType() {
        return drinkType;
    }

    public void setDrinkType(String drinkType) {
        this.drinkType = drinkType;
    }

    public void setSize(SodaSize size){
        this.size = size;
    }
    public SodaSize getSize(){
        return size;
    }
}
