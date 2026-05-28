package com.pluralsight.models;

public enum ToppingCategory {

    MEAT("Meat", 1.0, 2.0, 3.0, new String[]{"steak", "ham", "salami", "roast beef", "chicken", "bacon"}),
    CHEESE("Cheese", .75, 1.5, 2.25, new String[]{"american", "provolone", "cheddar", "swiss"}),
    REGULAR_TOPPING("Regular Topping", 0, 0, 0, new String[] {"lettuce", "peppers", "onions", "tomatoes", "jalapeños", "cucumbers", "pickles", "guacamole", "mushrooms"}),
    SIDE("Side", 0,0,0, new String[] {"au jus", "sauce"}),
    SAUCE("Sauce",0,0,0, new String[] {"mayo", "mustard", "ketchup", "ranch", "thousand islands", "vinaigrette"});

    private final String category;
    private final double smallPrice;
    private final double mediumPrice;
    private final double largePrice;
    private final String[] names;

    ToppingCategory(String category, double smallPrice, double mediumPrice, double largePrice, String[] names){
        this.category = category;
        this.smallPrice = smallPrice;
        this.mediumPrice = mediumPrice;
        this.largePrice = largePrice;
        this.names = names;
    }

    public String[] getNames() {
        return names;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice(SandwichSize size){
        return switch(size){
            case FOUR_INCH -> getSmallPrice();
            case EIGHT_INCH -> getMediumPrice();
            case TWELVE_INCH -> getLargePrice();
        };
    }
    public double getSmallPrice() {
        return smallPrice;
    }

    public double getMediumPrice() {
        return mediumPrice;
    }

    public double getLargePrice() {
        return largePrice;
    }
}
