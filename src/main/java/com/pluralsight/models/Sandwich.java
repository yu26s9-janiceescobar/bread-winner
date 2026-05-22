package com.pluralsight.models;

import java.util.ArrayList;

public class Sandwich implements OrderItem{
    private boolean isToasted;
    private Size size;
    private double smallPrice;
    private double mediumPrice;
    private double largePrice;
    private ArrayList<Topping> toppings;

    public Sandwich(boolean isToasted, double smallPrice, double mediumPrice, double largePrice, Size size, ArrayList<Topping> toppings){
        this.isToasted = isToasted;
        this.size = size;
        this.toppings = toppings;
    }
    @Override
    public double getPrice(){
        return calculatePrice();
    }
    @Override
    public String getName(){
        return "Sandwich";
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
    public double calculatePrice(){
        double runningTotal = switch(size){
            case SMALL -> smallPrice;
            case MEDIUM -> mediumPrice;
            case LARGE -> largePrice;
        };
        for (Topping t: toppings){
            runningTotal += t.getPrice(size);
        }
        return runningTotal;
    }
    public void setToasted(boolean isToasted){
        this.isToasted = isToasted;
    }
    public boolean isToasted(){
        return isToasted;
    }

}
