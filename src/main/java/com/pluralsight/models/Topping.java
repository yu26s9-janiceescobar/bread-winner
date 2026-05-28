package com.pluralsight.models;

import com.pluralsight.models.enums.SandwichSize;
import com.pluralsight.models.enums.ToppingCategory;

public class Topping implements MenuItem {
    private final String name;
    private final ToppingCategory category;

    public Topping(ToppingCategory category, String name){
        this.category = category;
        this.name = name;
    }
    public double getPrice(SandwichSize size){
        return category.getPrice(size);
    }

    public double getExtraPrice(SandwichSize size){
        if (category == ToppingCategory.MEAT)
            return category.getPrice(size) * 0.5;
        if (category == ToppingCategory.CHEESE){
            return category.getPrice(size) * 0.4;
        }
        return 0;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getCategory() {
        return category.getCategory();
    }
}
