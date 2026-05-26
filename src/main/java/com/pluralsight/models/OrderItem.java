package com.pluralsight.models;

import com.pluralsight.business.Catalog;

public abstract class OrderItem {
    private String name;

    public OrderItem(String name){
        this.name = name;
    }
    public abstract double getPrice(Catalog catalog);
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
