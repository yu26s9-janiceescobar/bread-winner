package com.pluralsight.models;

import java.util.ArrayList;
import java.util.List;

public class Sandwich extends OrderItem{
    private boolean isToasted;
    private String size;
    private double price;
    private ArrayList<Topping> toppings;

    public Sandwich(String name, MenuItem bread, List<MenuItem> meats, List<MenuItem> cheeses, List<MenuItem> toppings, List<MenuItem> sauces){
        super(name);
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
