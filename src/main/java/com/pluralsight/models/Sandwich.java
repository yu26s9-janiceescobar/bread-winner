package com.pluralsight.models;

import java.util.ArrayList;
import java.util.List;

public class Sandwich extends OrderItem{
    private boolean isToasted;
    private String size;
    private double price;
    private ArrayList<Topping> toppings;

    public Sandwich(String name, String size, MenuOption bread){
        super(name);
        toppings = new ArrayList<>();
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
    public double calculatePrice(){
        double total = 0;
        for (Topping topping: toppings){
            total += topping.getPrice(size);
        }
        return total;
    }
    public void setToasted(boolean isToasted){
        this.isToasted = isToasted;
    }
    public boolean isToasted(){
        return isToasted;
    }

}
