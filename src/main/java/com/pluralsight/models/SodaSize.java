package com.pluralsight.models;

public enum SodaSize {
    SMALL(2.0),
    MEDIUM(2.50),
    LARGE(3.0);

    private final double price;

    SodaSize(double price){
        this.price = price;
    }
    public double getPrice(){
        return price;
    }
    @Override
    public String toString(){
        return String.format("""
                     %s --- $%.2f""",
                name().toLowerCase(), price);
    }
}
