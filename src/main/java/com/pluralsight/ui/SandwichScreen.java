package com.pluralsight.ui;

import com.pluralsight.models.*;

import java.util.concurrent.atomic.AtomicInteger;

public class SandwichScreen {
    private final Console console;
    private static final String[] meats = {"steak", "ham", "salami", "roast beef", "chicken", "bacon"};
    private static final String[] cheeses = {"american", "provolone", "cheddar", "swiss"};
    private static final String[] breads = {"white", "wheat", "rye", "wrap"};
    private static final String[] regularToppings = {"lettuce", "peppers", "onions", "tomatoes", "jalapeños", "cucumbers", "pickles", "guacamole", "mushrooms"};;
    private static final String[] sauces = {"mayo", "mustard", "ketchup", "ranch", "thousand islands", "vinaigrette"};;
    public SandwichScreen(Console console){
        this.console = console;
    }
    private String getUserSelection(String[] selection, String category){
        int choice = console.promptForIntRange("Choose " + category, 1, selection.length);
        return selection[choice - 1];
    }

    public Sandwich buildSandwich(){
        Sandwich sandwich;
        SandwichSize size = getSandwichSize();
        sandwich = new Sandwich("Custom Sandwich", size);

        displayBreadOptions();
        String selectedBread = getUserSelection(breads, "Bread");
        sandwich.setBread(selectedBread);

        displayMeatOptions(sandwich.getSize(), false);
        String selectedMeat = getUserSelection(meats, "Meat");
        Topping meat = new Meat(selectedMeat, false);

        displayMeatOptions(sandwich.getSize(), true);
        boolean isExtraMeat = console.promptForYesNo("Extra Meat: [Y] Yes [N] No");
        if (isExtraMeat){
            Topping extraMeat = new Meat(selectedMeat, true);
        }

        displayCheeseOptions(sandwich.getSize(), false);
        String selectedCheese = getUserSelection(cheeses, "Cheese");

        displayCheeseOptions(sandwich.getSize(), true);
        boolean isExtraCheese = console.promptForYesNo("Extra Cheese: [Y] Yes [N] No");
        if (isExtraCheese){
            Topping extraCheese = new Cheese(selectedCheese, true);
        }


        return sandwich;
    }
    private void displayMeatOptions(String[] selection, SandwichSize size){
        for (int i = 0; i < selection.length; i++){
            System.out.printf("[%d] %s --- $%.2f (Extra: $%.2f)", i, selection[i], Meat.getBasePrice(size), Meat.getExtraPrice(size));
        }
    }
    private void displayCheeseOptions(String[] selection, SandwichSize size){
        for (int i = 0; i < selection.length; i++){
            System.out.printf("[%d] %s --- $%.2f (Extra: $%.2f)", i, selection[i], Meat.getBasePrice(size), Cheese.getExtraPrice(size));
        }
    }

    private void displayPremiumTopping(String[] selection, SandwichSize size){
        for (int i = 0; i < selection.length; i++){
            System.out.printf("[%d] %s --- $%.2f (Extra: $%.2f)", i, selection[i], Meat.getBasePrice(size), Meat.getExtraPrice(size));
        }

    }
    private void displayBreadOptions(){
        AtomicInteger atomicInteger = new AtomicInteger(1);
        for (String b: breads){
            System.out.printf("[%d] %s ", atomicInteger.getAndIncrement(), b);
        }
    }
    private SandwichSize getSandwichSize(){
        SandwichSize[] sizes = SandwichSize.values();
        for (int i = 0; i < sizes.length; i++){
            System.out.printf("[%d] %d --- %.2f%n", i, sizes[i].getInches(), sizes[i].getBasePrice());
        }
        int choice = console.promptForIntRange("Choose Size%n> " , 1, sizes.length);
        return sizes[choice - 1];
    }


}
