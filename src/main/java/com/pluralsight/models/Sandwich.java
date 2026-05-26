package com.pluralsight.models;

import java.util.ArrayList;

public class Sandwich extends OrderItem{
    private boolean isToasted;
    private String size;
    private String bread;
    private final ArrayList<Topping> toppings;

    public Sandwich(String name, String size){
        super(name);
        this.size = size;
        toppings = new ArrayList<>();
    }
    @Override
    public double getPrice(){
        return 0;
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
    public void setSize(String size){
        this.size = size;
    }
    public String getSize(){
        return size;
    }

    public void setToasted(boolean isToasted){
        this.isToasted = isToasted;
    }
    public boolean isToasted(){
        return isToasted;
    }

}
