package com.pluralsight.ui;


import com.pluralsight.models.Cheese;
import com.pluralsight.models.Meat;
import com.pluralsight.models.Sandwich;
import com.pluralsight.models.Topping;

import java.util.concurrent.atomic.AtomicInteger;

public class UserInterface {
    private Console console;


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



}








