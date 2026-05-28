package com.pluralsight.ui;
import com.pluralsight.models.*;
import com.pluralsight.models.enums.BreadType;
import com.pluralsight.models.enums.SandwichSize;
import com.pluralsight.models.enums.ToppingCategory;

import java.util.ArrayList;
import java.util.Arrays;


public class SandwichScreen {
    private final Console console;
    public SandwichScreen(Console console){
        this.console = console;
    }

    public Sandwich buildSandwich(){
        Sandwich sandwich = new Sandwich("Sandwich", "Custom", getSandwichSize(), getBread());
        sandwich.setToasted(console.promptForYesNo("Toast bread? [Y] Yes [N] No\n> "));
        addTopping(sandwich, ToppingCategory.MEAT);
        addTopping(sandwich, ToppingCategory.CHEESE);
        addTopping(sandwich, ToppingCategory.REGULAR_TOPPING);
        addTopping(sandwich, ToppingCategory.SAUCE);
        addTopping(sandwich, ToppingCategory.SIDE);
        return sandwich;
    }

    private void addTopping(Sandwich sandwich, ToppingCategory type){
        String name;
        ArrayList<String> availableTopping = new ArrayList<>(Arrays.asList(type.getNames()));
        do{
            name = getSelection(availableTopping, type.getPrice(sandwich.getSize()));
            if (name == null) {
                break;
            }
            Topping topping = new Topping(type, name);
            sandwich.addTopping(topping);
            System.out.printf("Would you like to add extra %s? (Price: $%.2f)%n[Y] Yes [N] No%n", name, topping.getExtraPrice(sandwich.getSize()));
            if (console.promptForYesNo("> ")) {
                sandwich.addExtraTopping(new Topping(type, "Extra " + name));
            }
            availableTopping.remove(name);
        }while (!availableTopping.isEmpty());
    }


    private BreadType getBread(){
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
        System.out.printf("[%d] Skip%n", selection.size() + 1);
        int choice = console.promptForIntRange("> " , 1, selection.size() + 1);
        if (choice == selection.size() + 1){
            return null;
        }
        return selection.get(choice - 1);
    }


    private SandwichSize getSandwichSize(){
        SandwichSize[] sizes = SandwichSize.values();
        System.out.println("\tSize Selection");
        for (int i = 0; i < sizes.length; i++){
            System.out.printf("[%d] %s ---- $%,.2f%n", i + 1, sizes[i].getLabel(), sizes[i].getPrice());
        }
        int choice = console.promptForIntRange("> " , 1, sizes.length);
        return sizes[choice - 1];

    }


}
