package com.pluralsight.business;
import com.pluralsight.models.Sandwich;
import com.pluralsight.models.Topping;
import com.pluralsight.models.enums.BreadType;
import com.pluralsight.models.enums.SandwichSize;
import com.pluralsight.models.enums.SpecialitySandwich;
import com.pluralsight.models.enums.ToppingCategory;


public class SandwichFactory {
    private Sandwich sandwich;
    public SandwichFactory(SpecialitySandwich type, SandwichSize size){
        sandwich = new Sandwich(type.getLabel(), size);
        switch(type){
            case SpecialitySandwich.BLT -> createBLT();
            case SpecialitySandwich.PHILLY_CHEESE -> createPhilly();
        };
    }

    private Sandwich createBLT(){
        sandwich.addTopping(new Topping(ToppingCategory.MEAT, "Bacon"));
        sandwich.addTopping(new Topping(ToppingCategory.CHEESE, "Cheddar"));
        sandwich.addTopping(new Topping(ToppingCategory.REGULAR_TOPPING, "Lettuce"));
        sandwich.addTopping(new Topping(ToppingCategory.REGULAR_TOPPING, "Tomato"));
        sandwich.addTopping(new Topping(ToppingCategory.SAUCE, "Ranch"));
        sandwich.setToasted(true);
        return sandwich;
    }
    private Sandwich createPhilly(){
        sandwich.addTopping(new Topping(ToppingCategory.MEAT, "Steak"));
        sandwich.addTopping(new Topping(ToppingCategory.CHEESE, "American Cheese"));
        sandwich.addTopping(new Topping(ToppingCategory.REGULAR_TOPPING, "Peppers"));
        sandwich.addTopping(new Topping(ToppingCategory.SAUCE, "Mayo"));
        sandwich.setToasted(true);
        return sandwich;
    }
}
