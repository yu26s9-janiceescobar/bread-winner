package com.pluralsight.business;

import java.util.ArrayList;

// Category|Name
public class MenuItem {
    private String category;
    private String name;

    public MenuItem(String category, String name){
        this.category = category;
        this.name = name;
        
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
