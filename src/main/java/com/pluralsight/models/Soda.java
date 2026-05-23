package com.pluralsight.models;

public class Soda extends OrderItem{
    private final double price;
    private String drinkType;
    private Size size;

    public Soda(String name, double price, String drinkType, Size size){
        super(name);
        this.price = price;
        this.drinkType = drinkType;
        this.size = size;
    }

    @Override
    public double calculatePrice(){
        return price;
    }
    @Override
    public String getDetail(){
        return drinkType;
    }
    public void setSelectedDrink(String selectedDrink){
        this.drinkType = selectedDrink;
    }

    public void setSize(Size size){
        this.size = size;
    }
    public Size getSize(){
        return size;
    }
}
