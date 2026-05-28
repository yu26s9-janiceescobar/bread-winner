package com.pluralsight.ui;
import com.pluralsight.models.*;
import com.pluralsight.models.enums.BreadType;
import com.pluralsight.models.enums.SandwichSize;
import com.pluralsight.models.enums.ToppingCategory;
import java.util.ArrayList;
import java.util.Arrays;


public class SandwichRequest {
    private final Console console;
    public SandwichRequest(Console console){
        this.console = console;
    }
    public ArrayList<Topping> requestAllToppings(SandwichSize size){
        ArrayList<Topping> allToppings = new ArrayList<>();
        allToppings.addAll(requestToppings(size, ToppingCategory.MEAT));
        allToppings.addAll(requestToppings(size, ToppingCategory.CHEESE));
        allToppings.addAll(requestToppings(size, ToppingCategory.REGULAR_TOPPING));
        allToppings.addAll(requestToppings(size, ToppingCategory.SAUCE));
        allToppings.addAll(requestToppings(size, ToppingCategory.SIDE));
        return allToppings;
    }
    private ArrayList<Topping> requestToppings(SandwichSize size, ToppingCategory type){
        ArrayList<String> availableTopping = new ArrayList<>(Arrays.asList(type.getNames()));
        ArrayList<Topping> addedToppings = new ArrayList<>();
        while(!availableTopping.isEmpty()){
            String name = getSelection(availableTopping, type.getPrice(size));
            if (name == null) {
                break;
            }

            addedToppings.add(new Topping(type, name) );
            System.out.printf("Would you like to add extra %s? (Price: $%.2f)%n[Y] Yes [N] No%n", name, type.getExtraPrice(size));
            if (console.promptForYesNo("> ")) {
                addedToppings.add(new Topping(type, "Extra " + name));
            }
            availableTopping.remove(name);
        }
        return addedToppings;
    }

    public boolean requestIsToasted(){
        return console.promptForYesNo("Toast Bread? [Y] Yes [N] No ");
    }
    public BreadType requestBread(){
        BreadType[] sizes = BreadType.values();
        System.out.println("\tBread Selection");
        for (int i = 0; i < sizes.length; i++){
            System.out.printf("[%d] %s\n", i + 1, sizes[i].getLabel());
        }
        int choice = console.promptForIntRange("> " , 1, sizes.length);
        return sizes[choice - 1];
    }

    private String getSelection(ArrayList<String> selection, double price){
        System.out.println("Which one would you like to add?");
        for (int i = 0; i < selection.size(); i++){
            System.out.printf("[%d] %s ---- $%.2f%n", i + 1, selection.get(i), price);
        }
        System.out.println("[0] Skip");
        int choice = console.promptForIntRange("> " , 0, selection.size());
        if (choice == 0){
            return null;
        }
        return selection.get(choice - 1);
    }


    public SandwichSize requestSandwichSize(){
        SandwichSize[] sizes = SandwichSize.values();
        System.out.println("\tSize Selection");
        for (int i = 0; i < sizes.length; i++){
            System.out.printf("[%d] %s ---- $%,.2f%n", i + 1, sizes[i].getLabel(), sizes[i].getPrice());
        }
        int choice = console.promptForIntRange("> " , 1, sizes.length);
        return sizes[choice - 1];

    }


}
