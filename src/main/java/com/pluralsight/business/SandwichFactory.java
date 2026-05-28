package com.pluralsight.business;
import com.pluralsight.models.Sandwich;
import com.pluralsight.models.Topping;
import com.pluralsight.models.enums.SandwichSize;
import com.pluralsight.models.enums.SpecialitySandwich;
import com.pluralsight.models.enums.ToppingCategory;


public class SandwichFactory {

    public static Sandwich create(SpecialitySandwich type, SandwichSize size){
        return switch(type){
            case SpecialitySandwich.BLT -> createBLT(type, size);
            case SpecialitySandwich.PHILLY_CHEESE -> createPhilly(type, size);
        };
    }

    private static Sandwich createBLT(SpecialitySandwich type, SandwichSize size){
        Sandwich sandwich = new Sandwich(type.getLabel(), size);
        sandwich.addTopping(new Topping(ToppingCategory.MEAT, "Bacon"));
        sandwich.addTopping(new Topping(ToppingCategory.CHEESE, "Cheddar"));
        sandwich.addTopping(new Topping(ToppingCategory.REGULAR_TOPPING, "Lettuce"));
        sandwich.addTopping(new Topping(ToppingCategory.REGULAR_TOPPING, "Tomato"));
        sandwich.addTopping(new Topping(ToppingCategory.SAUCE, "Ranch"));
        sandwich.setToasted(true);
        return sandwich;
    }
    private static Sandwich createPhilly(SpecialitySandwich type, SandwichSize size){
        Sandwich sandwich = new Sandwich(type.getLabel(), size);
        sandwich.addTopping(new Topping(ToppingCategory.MEAT, "Steak"));
        sandwich.addTopping(new Topping(ToppingCategory.CHEESE, "American Cheese"));
        sandwich.addTopping(new Topping(ToppingCategory.REGULAR_TOPPING, "Peppers"));
        sandwich.addTopping(new Topping(ToppingCategory.SAUCE, "Mayo"));
        sandwich.setToasted(true);
        return sandwich;
    }
}
