package com.pluralsight.models;

public abstract class Topping {
    private String name;
    public Topping(String name){
        this.name = name;
    }

    public abstract double getPrice(Size size);
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

}
