package com.pluralsight.models;

import java.util.ArrayList;

public class Sandwich extends OrderItem{
    private boolean isToasted;
    private String size;
    private double price;
    private ArrayList<Topping> toppings;

    public Sandwich(String name, double price, boolean isToasted, String size, ArrayList<Topping> toppings){
        super(name);
        this.isToasted = isToasted;
        this.size = size;
        this.toppings = toppings;
    }

    public ArrayList<Topping> getSandwichTopping(){
        return toppings;
    }
    public void addTopping(Topping topping){
        toppings.add(topping);
    }
    public void setSize(String size){
        this.size = size;
    }
    public String getSize(){
        return size;
    }
    @Override
    public String getDetail(){
        // returns toppings
        return "";
    }
    @Override
    public double calculatePrice(){
        return 0;
    }
    public void setToasted(boolean isToasted){
        this.isToasted = isToasted;
    }
    public boolean isToasted(){
        return isToasted;
    }

}
