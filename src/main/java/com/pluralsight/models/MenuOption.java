package com.pluralsight.models;

public class MenuOption {
    private String category;
    private String name;
    private String size;
    private double price;
    public MenuOption(String category, String name, String size, double price){
        this.category = category;
        this.name = name;
        this.size = size;
        this.price = price;
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

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
