package com.pluralsight.models;
import java.util.ArrayList;



public class Sandwich extends OrderableItem {
    private boolean isToasted;
    private SandwichSize size;
    private String bread;
    private final ArrayList<Topping> toppings;
    private final ArrayList<Topping> extraToppings;


    public Sandwich(String category, String name, SandwichSize size, String bread){
        super(category, name);
        this.size = size;
        this.bread = bread;
        toppings = new ArrayList<>();
        extraToppings = new ArrayList<>();
    }

    @Override
    public double getTotalPrice(){
        double runningTotal = size.getPrice();
        for (Topping topping: toppings){
            runningTotal += topping.getPrice(size);
        }
        for (Topping topping: extraToppings){
            runningTotal += topping.getExtraPrice(size);
        }
        return runningTotal;
    }

    public ArrayList<Topping> getToppings() {
        return toppings;
    }
    public void addTopping(Topping topping){
        toppings.add(topping);
    }
    public void addExtraTopping(Topping topping){
        extraToppings.add(topping);
    }
    public void removeExtraTopping(Topping topping){
        extraToppings.remove(topping);
    }
    public void removeTopping(Topping topping){
        toppings.remove(topping);
    }
    public void setBread(String bread){
        this.bread = bread;
    }
    public String getBread(){
        return bread;
    }
    public void setSize(SandwichSize size){
        this.size = size;
    }
    public SandwichSize getSize(){
        return size;
    }

    public void setToasted(boolean isToasted){
        this.isToasted = isToasted;
    }
    public boolean isToasted(){
        return isToasted;
    }

}
