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
        addMeat(sandwich);
        addCheese(sandwich);
        addRegularTopping(sandwich);
        addSauce(sandwich);
        addSide(sandwich);
        return sandwich;
    }
    private void addMeat(Sandwich sandwich){
        String name;
        ArrayList<String> availableMeats = new ArrayList<>(Arrays.asList(ToppingCategory.MEAT.getNames()));
        do {
            name = getSelection(availableMeats);
            if (name == null) {
                break;
            }
            sandwich.addTopping(new Topping(ToppingCategory.MEAT, name));
            if (console.promptForYesNo("Would you like to add extra " + name + "\n> ")) {
                sandwich.addExtraTopping(new Topping(ToppingCategory.MEAT, "Extra " + name));
            }
            availableMeats.remove(name);
        }while(!availableMeats.isEmpty());
    }
    private void addCheese(Sandwich sandwich){
        String name;
        ArrayList<String> availableCheese = new ArrayList<>(Arrays.asList(ToppingCategory.CHEESE.getNames()));
        do {
            name = getSelection(availableCheese);
            if (name == null) {
                break;
            }
            sandwich.addTopping(new Topping(ToppingCategory.CHEESE, name));
            if (console.promptForYesNo("Would you like to add extra " + name + "\n> ")) {
                sandwich.addExtraTopping(new Topping(ToppingCategory.CHEESE, "Extra " + name));
            }
            availableCheese.remove(name);
        }while(!availableCheese.isEmpty());
    }
    private void addRegularTopping(Sandwich sandwich){
        while(true) {
            String name = getSelection(ToppingCategory.REGULAR_TOPPING.getNames());
            if (name == null){
                break;
            }
            sandwich.addTopping(new Topping(ToppingCategory.REGULAR_TOPPING, name));
        }
    }
    private void addSauce(Sandwich sandwich){
        while(true) {
            String name = getSelection(ToppingCategory.SAUCE.getNames());
            if (name == null){
                break;
            }
            sandwich.addTopping(new Topping(ToppingCategory.SAUCE, name));
        }
    }
    private void addSide(Sandwich sandwich){
        while(true) {
            String name = getSelection(ToppingCategory.SIDE.getNames());
            if (name == null) {
                break;
            }
            sandwich.addTopping(new Topping(ToppingCategory.SIDE, name));
        }
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
    private String getSelection(String[] selection){
        for (int i = 0; i < selection.length; i++){
            System.out.printf("[%d] %s%n", i + 1, selection[i]);
        }
        System.out.printf("[%d] Skip", selection.length);
        System.out.println("Which one would you like to add?");
        int choice = console.promptForIntRange("> " , 1, selection.length + 1);
        if (choice == selection.length){
            return null;
        }
        return selection[choice - 1];
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
