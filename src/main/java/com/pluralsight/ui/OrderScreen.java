package com.pluralsight.ui;
import com.pluralsight.business.Order;
import com.pluralsight.models.*;

import java.util.ArrayList;

public class OrderScreen {
    private final Console console;
    private final Order order;

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
                        processAddSandwich();
                        break;
                    case 2:
                        processAddSoda();
                        break;
                    case 3:
                        processAddChips();
                        break;
                    case 4:
                        processCheckOut();
                        break;
                }
            } while (option != 0);
    }

    private void processAddSandwich(){
        SandwichScreen sandwichScreen = new SandwichScreen(console);
        Sandwich sandwich = sandwichScreen.buildSandwich();
        order.addToOrder(sandwich);
    }
    private void processAddSoda(){
        SodaSize sodaSize = getSodaSize();
        String name = getSelection(Soda.FLAVORS, sodaSize.getPrice());
        if (name != null) {
            Soda soda = new Soda(sodaSize.getLabel(), name, sodaSize);
            order.addToOrder(soda);
        }
    }
    private void processAddChips(){
        String name = getSelection(Chips.FLAVORS, Chips.PRICE);
        if (name != null) {
            Chips chips = new Chips("Chips", name);
            order.addToOrder(chips);
        }
    }
    private void processCheckOut(){
        ArrayList<OrderableItem> finalOrder = order.getOrder();
        boolean hasSandwich = order.getOrder().stream().anyMatch(item -> item instanceof Sandwich);
        boolean hasOtherProduct = order.getOrder().stream().anyMatch(item -> item instanceof Soda || item instanceof Chips);
        if (finalOrder.isEmpty()){
            System.out.println("Your order is empty.");
            return;
        }
        if (!hasSandwich && !hasOtherProduct){
            System.out.println("You must order a soda or chips to check out.");
            return;
        }
        System.out.println(ReceiptFormatter.format(order));
        console.promptForYesNo("[C] Confirm [E] Edit [ ")


    }
    private SodaSize getSodaSize(){
        SodaSize[] sizes = SodaSize.values();
        for (int i = 0; i < sizes.length; i++){
            System.out.printf("[%d] %s%n", i + 1, sizes[i].getLabel());
        }
        int choice = console.promptForIntRange("Choose Size\n> " , 1, sizes.length);
        return sizes[choice - 1];

    }
    private String getSelection(String[] selection, double price){
        System.out.println("Which one would you like to add?");
        for (int i = 0; i < selection.length; i++){
            System.out.printf("[%d] %s ---- $%.2f%n", i + 1, selection[i], price);
        }
        System.out.printf("[%d] Skip%n", selection.length + 1);

        int choice = console.promptForIntRange("> " , 1, selection.length + 1);
        if (choice == selection.length + 1){
            return null;
        }
        return selection[choice - 1];
    }


}
