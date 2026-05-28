package com.pluralsight.models;

public abstract class OrderableItem implements MenuItem{
    private String category;
    private String name;
    public OrderableItem(String category, String name){
        this.category = category;
        this.name = name;
    }

    @Override
    public String getCategory() {
        return category;
    }

    @Override
    public String getName() {
        return name;
    }


    public abstract double getTotalPrice();
}
