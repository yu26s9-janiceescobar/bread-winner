package com.pluralsight.models;

public class Soda extends OrderItem{
    private final double price;
    private String drinkType;
    private String size;

    public Soda(String name, double price, String drinkType, String size){
        super(name);
        this.price = price;
        this.drinkType = drinkType;
        this.size = size;
    }

    @Override
    public double calculatePrice(){
        return price;
    }
    

    public String getDrinkType() {
        return drinkType;
    }

    public void setDrinkType(String drinkType) {
        this.drinkType = drinkType;
    }

    public void setSize(String size){
        this.size = size;
    }
    public String getSize(){
        return size;
    }
}
