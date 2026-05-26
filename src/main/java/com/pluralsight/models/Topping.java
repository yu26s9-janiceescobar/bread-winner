package com.pluralsight.models;

public abstract class Topping {
    private final String name;
    public Topping(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract double getPrice(SandwichSize size);
}
