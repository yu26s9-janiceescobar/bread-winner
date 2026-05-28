package com.pluralsight.ui;
import com.pluralsight.business.Order;
import com.pluralsight.business.SandwichFactory;
import com.pluralsight.data.ReceiptFileManager;
import com.pluralsight.models.*;
import com.pluralsight.models.enums.*;

import java.util.ArrayList;

public class OrderScreen {
    private final Console console;
    private final Order order;
    private final ReceiptFileManager receiptFileManager;
    private final SandwichRequest request;
    public OrderScreen(Console console){
        this.console = console;
        order = new Order();
        receiptFileManager = new ReceiptFileManager();
        request = new SandwichRequest(console);

    }
    public void startNewOrder(){
            int option;
            do {
                System.out.println("""
                    \t\tOrder Screen
                    \t[1] Add Sandwich
                    \t[2] Add Drink
                    \t[3] Add Chips
                    \t[4] Checkout
                    \t[0] Cancel Order""");
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
        System.out.println("""
                \t\tSandwich Screen
                \t[1] Custom Sandwich
                \t[2] Speciality Sandwich
                \t[0] Cancel
                """);
        int option = console.promptForIntRange("> ",0, 2);
        switch(option){
            case 1:
                buildCustomSandwich();
                break;
            case 2:
                buildSpecialitySandwich();
                break;
            case 0:
                System.out.println("Cancelling Sandwich Order...");
                break;
        }
    }
    private void buildSpecialitySandwich(){
        SpecialitySandwich selection = getSpecialitySandwich();
        SandwichSize size = request.requestSandwichSize();
        order.addToOrder(SandwichFactory.create(selection, size));
    }
    private void buildCustomSandwich(){
        SandwichRequest request = new SandwichRequest(console);
        SandwichSize size = request.requestSandwichSize();
        BreadType bread = request.requestBread();
        boolean isToasted = request.requestIsToasted();
        ArrayList<Topping> allToppings = request.requestAllToppings(size);
        Sandwich sandwich = new Sandwich("Custom", size, bread, isToasted, allToppings);
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
        boolean hasSandwich = finalOrder.stream().anyMatch(item -> item instanceof Sandwich);
        boolean hasOtherProduct = finalOrder.stream().anyMatch(item -> item instanceof Soda || item instanceof Chips);
        if (finalOrder.isEmpty()){
            System.out.println("You must order a soda or chips to check out.");
            return;
        }
        String orderSummary = ReceiptFormatter.format(order);
        System.out.println(orderSummary);
        String option;
        do {
            option = console.promptForStringOptions("[C] Confirm [E] Edit [X] Cancel Order", "c", "e","x");
            switch (option.toLowerCase()) {
                case "c":
                    receiptFileManager.saveReceipt(orderSummary);
                    break;
                case "e":
                        //
                    break;
                case "x":
                    System.out.println("Cancelling Order...");
                    break;
            }
        }while(option.equalsIgnoreCase("e"));
    }
    private void editSandwich(){
        System.out.println("""
                        
               """)
    }
    private void editOrder(){
        OrderableItem item = getEditOrderSelection();
        if (item instanceof Sandwich){

        }
        else if(item instanceof Soda){

        }
        else if(item instanceof Chips){

        }
    }
    private OrderableItem getEditOrderSelection(){
        ArrayList<OrderableItem> items = order.getOrder();
        System.out.println("""
                What would you like to edit?""");
        for (int i = 0; i < items.size(); i++){
            System.out.printf("[%d] %s%n", i + 1, items.get(i).getName());
        }
        int choice = console.promptForIntRange("> " , 1, items.size());
        return items.get(choice - 1);
    }
    private SpecialitySandwich getSpecialitySandwich(){
        SpecialitySandwich[] type = SpecialitySandwich.values();
        for (int i = 0; i < type.length; i++){
            System.out.printf("[%d] %s%n", i + 1, type[i].getLabel());
        }
        int choice = console.promptForIntRange("Choose Size\n> " , 1, type.length);
        return type[choice - 1];
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
