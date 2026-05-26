package com.pluralsight.models;

public class Soda extends OrderItem {
    private String drinkType;
    private String size;

    public Soda(String name, String drinkType, String size){
        super(name);
        this.drinkType = drinkType;
        this.size = size;
    }
    @Override
    public double getPrice(){
        return switch(size){
            case "small" -> 2.0;
            case "medium" -> 2.5;
            case "large" -> 3.0;
            default -> 0;
        };
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
