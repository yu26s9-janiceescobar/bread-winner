package com.pluralsight.models;

public class PriceEntry {
    private String category;
    private String size;
    private double price;
    public PriceEntry(String category, String size, double price){
        this.category = category;
        this.size = size;
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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
