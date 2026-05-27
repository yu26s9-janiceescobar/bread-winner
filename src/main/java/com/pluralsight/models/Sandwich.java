package com.pluralsight.models;

import java.util.ArrayList;

public class Sandwich extends OrderableItem {
    private boolean isToasted;
    private String size;
    private String bread;
    private final ArrayList<Topping> toppings;

    public Sandwich(String name, double basePrice, String size, String bread){
        super(name, basePrice);
        this.size = size;
        this.bread = bread;
        toppings = new ArrayList<>();
    }

    public ArrayList<Topping> getToppings() {
        return toppings;
    }
    public void addTopping(Topping topping){
        toppings.add(topping);
    }
    public void removeTopping(Topping topping){
        toppings.remove(topping);
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
