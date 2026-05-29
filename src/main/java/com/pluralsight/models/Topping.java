package com.pluralsight.models;

import com.pluralsight.models.enums.SandwichSize;
import com.pluralsight.models.enums.ToppingCategory;

public class Topping implements MenuItem {
    private final String name;
    private final ToppingCategory category;
    private final boolean isExtra;

    public Topping(ToppingCategory category, String name, boolean isExtra){
        this.category = category;
        this.name = name;
        this.isExtra = isExtra;
    }
    public Topping(Topping other){
        this.category = other.category;
        this.name = other.name;
        this.isExtra = other.isExtra;
    }

    public boolean isExtra() {
        return isExtra;
    }

    public double getPrice(SandwichSize size){
        return isExtra ? category.getExtraPrice(size) : category.getPrice(size);
    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getCategory() {
        return category.getCategory();
    }
    public ToppingCategory getCategoryEnum(){
        return category;
    }
}
