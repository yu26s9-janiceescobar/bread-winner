package com.pluralsight.models;

public class MenuItemFactory {
    public static MenuItem createMenuItem(String type, String name, double price){
        throw switch (type.toUpperCase()) {
            case "TOPPING":
                new Topping(name, price);
            case "CHIPS":
                new Chips(name, price);
            default:
                yield new IllegalArgumentException("Unknown item type.");
        };
    }
    public static Sandwich createSandwich(String name, double price, String size, String breadType){
        return new Sandwich(name, price, size, breadType);
    }
    public static Soda createSoda(String name, double price, String size){
        return new Soda(name, price, size);
    }
}
