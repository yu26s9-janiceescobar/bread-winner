package com.pluralsight.ui;


import com.pluralsight.models.Cheese;
import com.pluralsight.models.Meat;
import com.pluralsight.models.Sandwich;
import com.pluralsight.models.Topping;

import java.util.concurrent.atomic.AtomicInteger;

public class UserInterface {
    private Console console;

    String[] meats = {"steak", "ham", "salami", "roast beef", "chicken", "bacon"};
    int[] sandwichSize = {4, 8, 12};
    String[] cheeses = {"american", "provolone", "cheddar", "swiss"};
    String[] breads = {"white", "wheat", "rye", "wrap"};
    String[] regularToppings = { "lettuce", "peppers","onions","tomatoes","jalapeños","cucumbers","pickles","guacamole","mushrooms"};
    String[] sauces = {"mayo", "mustard", "ketchup", "ranch", "thousand islands", "vinaigrette"};
    String[] sides = {"au jus","sauce"};
    String[] soda = {"coke", "ginger ale", "sprite", "diet coke"};
    String[] chips = {"salt and vinegar", "potato", "bbq"};




    private void init(Console console) {
        this.console = console;
    }
    public void display(Console console) {
        init(console);
        MainMenuScreen mainMenuScreen = new MainMenuScreen(console);
        mainMenuScreen.start();

    }

    private void processNewOrder() {
        int option;
        do {
            System.out.println("""
                    Order Screen
                    [1] Add Sandwich
                    [2] Add Drink
                    [3] Add Chips
                    [4] Checkout
                    [0] Cancel Order""");
            option = console.promptForIntRange("> ", 0, 4);
            switch (option) {
                case 0:
                    System.out.println("Cancelling Order...");
                    break;
                case 1:
                    //processAddSandwich();
                    break;
                case 2:
                    // processAddDrink();
                    break;
                case 3:
                    // processaddChips();
                    break;
                case 4:
                    // processCheckOut();
                    break;
            }
        } while (option != 0);
    }
    public void displayMeatOptions(int size, boolean isExtra){
        AtomicInteger atomicInteger = new AtomicInteger(1);
        Topping meat = new Meat("meat", isExtra);
        for (String m: meats){
            System.out.printf("[%d] %s ---- %.2f", atomicInteger.getAndIncrement(), m, meat.getPrice(size));
        }
    }
    public void displayCheeseOptions(int size, boolean isExtra){
        AtomicInteger atomicInteger = new AtomicInteger(1);
        Topping cheese = new Cheese("cheese", isExtra);
        for (String c: cheeses){
            System.out.printf("[%d] %s ---- %.2f", atomicInteger.getAndIncrement(), c, cheese.getPrice(size));
        }
    }
    public void displayBreadOptions(){
        AtomicInteger atomicInteger = new AtomicInteger(1);
        for (String b: breads){
            System.out.printf("[%d] %s ", atomicInteger.getAndIncrement(), b);
        }
    }
    public void displaySandwichSize(){
        AtomicInteger atomicInteger = new AtomicInteger(1);
        for (int size: sandwichSize){
            Sandwich sandwich = new Sandwich("Custom", size);
            System.out.printf("[%d] %s ---- %.2f", atomicInteger.getAndIncrement(), size, sandwich.getPrice());
        }
    }
    public void processAddSandwich(){
        Sandwich sandwich = new Sandwich("Custom", 0);

        int sizeChoice = console.promptForIntRange("Choose size of sandwich: ",1, sandwichSize.length);
        int selectedSize = sandwichSize[sizeChoice - 1];
        sandwich.setSize(selectedSize);

        displayBreadOptions();
        int breadChoice = console.promptForIntRange("Choose a bread: ",1, breads.length);
        String selectedBread = breads[breadChoice - 1];
        sandwich.setBread(selectedBread);

        displayMeatOptions(sandwich.getSize(), false);
        int meatChoice = console.promptForIntRange("Choose Meat: ", 1, meats.length);
        String selectedMeat = meats[meatChoice - 1];
        Topping meat = new Meat(selectedMeat, false);
        displayMeatOptions(sandwich.getSize(), true);
        boolean isExtraMeat = console.promptForYesNo("Extra Meat: [Y] Yes [N] No");
        if (isExtraMeat){
            Topping extraMeat = new Meat(selectedMeat, true);
        }
        displayCheeseOptions(sandwich.getSize(), false);
        int cheeseChoice = console.promptForIntRange("Choose cheese: ", 1, cheeses.length);
        String selectedCheese = cheeses[cheeseChoice - 1];
        displayCheeseOptions(sandwich.getSize(), true);
        boolean isExtraCheese = console.promptForYesNo("Extra Cheese: [Y] Yes [N] No");
        if (isExtraCheese){
            Topping extraCheese = new Cheese(selectedCheese, true);
        }



    }

}








