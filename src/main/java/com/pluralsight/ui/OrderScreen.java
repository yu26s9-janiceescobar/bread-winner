package com.pluralsight.ui;
import com.pluralsight.business.Order;
import com.pluralsight.models.*;

import java.awt.*;


public class OrderScreen {
    private final Console console;
    private final Order order;
    private final static String[] sandwichSize = {"4 inch", "8 inch", "12 inch"};
    private final static String[] soda = {"sprite", "ginger ale", "pepsi"};
    private final static String[] breads = {"white", "wheat", "rye", "wrap"};

    public OrderScreen(Console console){
        this.console = console;
        order = new Order();

    }
    public void startNewOrder(){
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
                        //addSoda();
                        break;
                    case 3:
                        //addChip();
                        break;
                    case 4:
                        // processCheckOut();
                        break;
                }
            } while (option != 0);
    }

    private void processNewSandwich(){

    }


}
