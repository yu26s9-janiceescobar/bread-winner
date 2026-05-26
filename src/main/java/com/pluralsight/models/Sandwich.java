package com.pluralsight.models;

import java.util.ArrayList;

public class Sandwich extends OrderItem {
    private boolean isToasted;
    private int size;
    private String bread;
    private final ArrayList<Topping> toppings;

    public Sandwich(String name, int size){
        super(name);
        this.size = size;
        toppings = new ArrayList<>();
    }
    @Override
    public double getPrice(){
        double runningTotal = 0;
        switch (size){
            case 4:
                runningTotal += 5.5;
                break;
            case 8:
                runningTotal += 7.0;
                break;
            case 12:
                runningTotal += 8.5;
                break;
        }
        for (Topping topping: toppings){
            runningTotal += topping.getPrice(size);
        }
        return runningTotal;
    }

    public ArrayList<Topping> getSandwichTopping(){
        return toppings;
    }
    public void addTopping(Topping topping){
        toppings.add(topping);
    }
    public void setBread(String bread){
        this.bread = bread;
    }
    public String getBread(){
        return bread;
    }
    public void setSize(int size){
        this.size = size;
    }
    public int getSize(){
        return size;
    }

    public void setToasted(boolean isToasted){
        this.isToasted = isToasted;
    }
    public boolean isToasted(){
        return isToasted;
    }

}
