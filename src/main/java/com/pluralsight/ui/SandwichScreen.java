package com.pluralsight.ui;

import com.pluralsight.models.*;

import java.util.ArrayList;
import java.util.Arrays;


public class SandwichScreen {
    private final Console console;
    public SandwichScreen(Console console){
        this.console = console;
    }

    public Sandwich buildSandwich(){
        Sandwich sandwich;
        sandwich = new Sandwich("Sandwich", "Custom", getSandwichSize(), getBread());
        sandwich.setToasted(console.promptForYesNo("Toast bread? [Y] Yes [N] No"));
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
            name = getSelection(availableTopping);
            if (name == null) {
                break;
            }
            sandwich.addTopping(new Topping(type, name));
            if (console.promptForYesNo("Would you like to add extra " + name + "\n> ")) {
                sandwich.addExtraTopping(new Topping(type, "Extra " + name));
            }
            availableTopping.remove(name);
        }while (!availableTopping.isEmpty());
    }
    

    private BreadType getBread(){
        BreadType[] sizes = BreadType.values();
        for (int i = 0; i < sizes.length; i++){
            System.out.printf("[%d] %s%n", i + 1, sizes[i].getLabel());
        }
        int choice = console.promptForIntRange("Choose Bread%n> " , 1, sizes.length);
        return sizes[choice - 1];
    }

    private String getSelection(ArrayList<String> selection){
        for (int i = 0; i < selection.size(); i++){
            System.out.printf("[%d] %s%n", i + 1, selection.get(i));
        }
        System.out.printf("[%d] Skip", selection.size());
        System.out.println("Which one would you like to add?");
        int choice = console.promptForIntRange("> " , 1, selection.size() + 1);
        if (choice == selection.size()){
            return null;
        }
        return selection.get(choice - 1);
    }


    private SandwichSize getSandwichSize(){
        SandwichSize[] sizes = SandwichSize.values();
        for (int i = 0; i < sizes.length; i++){
            System.out.printf("[%d] %s%n", i + 1, sizes[i].getLabel());
        }
        int choice = console.promptForIntRange("Choose Size%n> " , 1, sizes.length);
        return sizes[choice - 1];

    }


}
