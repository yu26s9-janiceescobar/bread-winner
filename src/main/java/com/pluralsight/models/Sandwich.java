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
    @Override
    public String getDetail(){
        StringBuilder toppingDetail = new StringBuilder();
        for (Topping t: toppings){
            toppingDetail.append(" ").append(t.getName());
        }
        return toppingDetail.toString();
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
