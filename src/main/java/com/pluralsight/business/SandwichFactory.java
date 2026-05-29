package com.pluralsight.business;
import com.pluralsight.models.Sandwich;
import com.pluralsight.models.Topping;
import com.pluralsight.models.enums.BreadType;
import com.pluralsight.models.enums.SandwichSize;
import com.pluralsight.models.enums.SpecialitySandwich;
import com.pluralsight.models.enums.ToppingCategory;


public class SandwichFactory {

    public static Sandwich create(SpecialitySandwich type, SandwichSize size, boolean isToasted){
        return switch(type){
            case SpecialitySandwich.BLT -> createBLT(type, size, isToasted);
            case SpecialitySandwich.PHILLY_CHEESE -> createPhilly(type, size, isToasted);
            case SpecialitySandwich.TURKEY_CLUB -> createTurkeyClub(type, size, isToasted);
        };
    }
    private static Sandwich createTurkeyClub(SpecialitySandwich type, SandwichSize size, boolean isToasted){
        Sandwich sandwich = new Sandwich(type.getLabel(), size, isToasted);
        sandwich.addTopping(new Topping(ToppingCategory.MEAT, "Turkey", false));
        sandwich.addTopping(new Topping(ToppingCategory.MEAT, "Bacon", false));
        sandwich.addTopping(new Topping(ToppingCategory.CHEESE, "American Cheese", false));
        sandwich.addTopping(new Topping(ToppingCategory.REGULAR_TOPPING, "Lettuce", false));
        sandwich.addTopping(new Topping(ToppingCategory.REGULAR_TOPPING, "Tomato", false));
        sandwich.addTopping(new Topping(ToppingCategory.SAUCE, "Mayo", false));
        sandwich.setBread(BreadType.WHITE);
        return sandwich;
    }

    private static Sandwich createBLT(SpecialitySandwich type, SandwichSize size, boolean isToasted){
        Sandwich sandwich = new Sandwich(type.getLabel(), size, isToasted);
        sandwich.addTopping(new Topping(ToppingCategory.MEAT, "Bacon", false));
        sandwich.addTopping(new Topping(ToppingCategory.CHEESE, "Cheddar", false));
        sandwich.addTopping(new Topping(ToppingCategory.REGULAR_TOPPING, "Lettuce", false));
        sandwich.addTopping(new Topping(ToppingCategory.REGULAR_TOPPING, "Tomato", false));
        sandwich.addTopping(new Topping(ToppingCategory.SAUCE, "Ranch", false));
        sandwich.setBread(BreadType.WHITE);
        return sandwich;
    }
    private static Sandwich createPhilly(SpecialitySandwich type, SandwichSize size, boolean isToasted){
        Sandwich sandwich = new Sandwich(type.getLabel(), size, isToasted);
        sandwich.addTopping(new Topping(ToppingCategory.MEAT, "Steak", false));
        sandwich.addTopping(new Topping(ToppingCategory.CHEESE, "American Cheese", false));
        sandwich.addTopping(new Topping(ToppingCategory.REGULAR_TOPPING, "Peppers", false));
        sandwich.addTopping(new Topping(ToppingCategory.SAUCE, "Mayo", false));
        sandwich.setBread(BreadType.WHEAT);
        return sandwich;
    }
}
