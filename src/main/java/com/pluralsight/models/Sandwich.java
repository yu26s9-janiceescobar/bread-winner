package com.pluralsight.models;
import com.pluralsight.models.enums.BreadType;
import com.pluralsight.models.enums.SandwichSize;
import java.util.ArrayList;

public class Sandwich extends OrderableItem {
    private boolean isToasted;
    private SandwichSize size;
    private BreadType bread;
    private final ArrayList<Topping> toppings;


    public Sandwich(String name, SandwichSize size, boolean isToasted){
        super("Sandwich", name);
        this.size = size;
        this.isToasted = isToasted;
        toppings = new ArrayList<>();
    }
    public Sandwich(String name, SandwichSize size, BreadType bread, boolean isToasted, ArrayList<Topping> toppings){
        super("Sandwich", name);
        this.size = size;
        this.bread = bread;
        this.isToasted = isToasted;
        this.toppings = toppings;
    }
    // java allows private access between instances of the same class.
    // constructor used to make copies
    public Sandwich(Sandwich other){
        super("Sandwich", other.getName());
        this.size = other.size;
        this.bread = other.bread;
        this.isToasted = other.isToasted;
        this.toppings = new ArrayList<>();
        for (Topping t : other.toppings){
            this.toppings.add(new Topping(t));
        }
    }

    @Override
    public double getTotalPrice(){
        double runningTotal = size.getPrice();
        for (Topping topping: toppings) {
            runningTotal += topping.getPrice(size);
        }
        return runningTotal;
    }

    public ArrayList<Topping> getToppings() {
        return toppings;
    }
    public void addMultipleToppings(ArrayList<Topping> toppings){
        this.toppings.addAll(toppings);
    }
    public void addTopping(Topping topping){
        toppings.add(topping);
    }

    public void removeTopping(Topping topping){
        toppings.remove(topping);
    }
    public void setBread(BreadType bread){
        this.bread = bread;
    }
    public BreadType getBread(){
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
