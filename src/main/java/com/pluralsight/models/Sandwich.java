package com.pluralsight.models;

import java.util.ArrayList;

public class Sandwich extends OrderItem{
    private boolean isToasted;
    private Size size;
    private double price;
    private ArrayList<Topping> toppings;

    public Sandwich(String name, double price, boolean isToasted, Size size, ArrayList<Topping> toppings){
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
    public void setSize(Size size){
        this.size = size;
    }
    public Size getSize(){
        return size;
    }
    @Override
    public String getDetail(){
        // returns toppings
    }
    @Override
    public double calculatePrice(){

    }
    public void setToasted(boolean isToasted){
        this.isToasted = isToasted;
    }
    public boolean isToasted(){
        return isToasted;
    }

}
