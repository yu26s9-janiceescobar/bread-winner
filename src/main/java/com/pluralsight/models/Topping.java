package com.pluralsight.models;

public abstract class Topping {
    private String name;
    public Topping(String name){
        this.name = name;
    }
    public abstract double getPrice();
    public abstract void setSize(Size size);
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
