package com.pluralsight.ui;
import com.pluralsight.business.Order;
import com.pluralsight.business.SandwichFactory;
import com.pluralsight.data.ReceiptFileManager;
import com.pluralsight.models.*;
import com.pluralsight.models.enums.*;

import java.time.LocalDateTime;

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

    /**
     * Display Menu and prompts the user to select menu option,
     * including add sandwich to order, add drink to order, add chips to order,
     * check out order, or cancel order.
     */
    public void startNewOrder(){
            int option;
            do {
                System.out.println("""
                    \t\tOrder Screen
                    \t[1] Add Sandwich
                    \t[2] Add Drink
                    \t[3] Add Chips
                    \t[4] Checkout
                    \t[0] Cancel Order
                    """);
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

    /**
     * Displays Sandwich Menu and prompts the user to select a menu option including,
     * creating a custom sandwich or ordering a speciality sandwich.
     */

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

    /**
     * Prompts user to select what Sandwich ingredient they want to edit,
     * including size, bread, topping.
     * @param sandwich the current sandwich item being modified.
     */
    private void editSandwich(Sandwich sandwich){
        int option;
        Sandwich copy = new Sandwich(sandwich);
        boolean isDone = false;
        while(!isDone){
            System.out.println("""
                     \t\tEdit Sandwich
                     \t[1] Size
                     \t[2] Bread
                     \t[3] Topping
                     \t[4] Confirm
                     \t[0] Cancel""");
            option = console.promptForIntRange("> ", 0, 4);
            switch(option){
                case 1:
                    copy.setSize(request.requestSandwichSize());
                    break;
                case 2:
                    copy.setBread(request.requestBread());
                    break;
                case 3:
                    copy.getToppings().clear();
                    copy.addMultipleToppings(request.requestToppings(copy));
                    break;
                case 4:
                    order.removeFromOrder(sandwich);
                    order.addToOrder(copy);
                    System.out.println("You have successfully updated your sandwich.");
                    isDone = true;
                    break;
                case 0:
                    System.out.println("Changes discared.");
                    isDone = true;
                    break;
            }
        }
    }
    /**
     * Allows user to edit soda from current order.
     * @param soda the current soda being modified.
     */
    private void editSoda(Soda soda){
        int option;
        boolean isDone = false;
        Soda copy = new Soda(soda);
        while(!isDone){
            System.out.println("""
                     \t\tEdit Soda
                     \t[1] Size
                     \t[2] Flavor
                     \t[3] Confirm
                     \t[0] Cancel
                    """);
            option = console.promptForIntRange("> ", 0, 3);
            switch(option){
                case 1:
                    copy.setSize(getSodaSize());
                    break;
                case 2:
                    copy.setName(promptForSelection(Soda.FLAVORS, copy.getTotalPrice()));
                    break;
                case 3:
                    order.removeFromOrder(soda);
                    order.addToOrder(copy);
                    System.out.println("You have successfully updated your soda.");
                    isDone = true;
                    break;
                case 0:
                    System.out.println("Changes discared.");
                    isDone = true;
                    break;
            }
        }
    }
    /**
     * Allows user to edit chips from current order.
     * @param chips the current chips being modified.
     */
    private void editChips(Chips chips){
        int option;
        boolean isDone = false;
        Chips copy = new Chips(chips.getCategory(), chips.getName());
        while(!isDone){
            System.out.println("""
                     \t\tEdit Chips
                     \t[1] Flavor
                     \t[2] Confirm
                     \t[0] Cancel
                    """);
            option = console.promptForIntRange("> ", 0, 2);
            switch(option){
                case 1:
                    copy.setName(promptForSelection(Chips.FLAVORS, copy.getTotalPrice()));
                    break;
                case 2:
                    order.removeFromOrder(chips);
                    order.addToOrder(copy);
                    System.out.println("You have successfully updated chips.");
                    isDone = true;
                    break;
                case 0:
                    System.out.println("Changes discared.");
                    isDone = true;
                    break;
            }
        };
    }
    /**
     * Allows user to see order summary and either confirm, edit, or cancel current order.
     */
    private void processCheckOut(){
        ArrayList<OrderableItem> finalOrder = order.getOrder();
        if (finalOrder.isEmpty()){
            System.out.println("You must order a soda or chips to check out.");
            return;
        }
        String option;
        boolean isDone = false;
        while(!isDone){
            String orderSummary = ReceiptFormatter.format(order, LocalDateTime.now());
            System.out.println(orderSummary);
            option = console.promptForStringOptions("[C] Confirm [E] Edit [X] Cancel Order\n> ", "c", "e","x");
            switch (option.toLowerCase()) {
                case "c":
                    LocalDateTime dateTime = LocalDateTime.now();
                    receiptFileManager.saveReceipt(ReceiptFormatter.format(order, dateTime), dateTime);
                    System.out.println("You have successfully checked out.");
                    order.getOrder().clear();
                    isDone = true;
                    break;
                case "e":
                    processEditOrder();
                    break;
                case "x":
                    System.out.println("Cancelling Order...");
                    order.getOrder().clear();
                    isDone = true;
                    break;
            }
        }
    }


    /**
     * Builds a preloaded speciality sandwich and adds it to order.
     */
    private void buildSpecialitySandwich(){
        SpecialitySandwich selection = getSpecialitySandwich();
        SandwichSize size = request.requestSandwichSize();
        boolean isToasted = request.requestIsToasted();
        order.addToOrder(SandwichFactory.create(selection, size, isToasted));
        System.out.println("You have successfully added to your order.");
    }

    /**
     * Allows user to create a custom sandwich and adds it to order.
     * User selects toppings, bread, sauces, sides,
     * and if they want their bread toasted
     */
    private void buildCustomSandwich(){
        SandwichSize size = request.requestSandwichSize();
        boolean isToasted = request.requestIsToasted();
        Sandwich sandwich = new Sandwich("Custom", size, isToasted);
        sandwich.setBread(request.requestBread());
        sandwich.addMultipleToppings(request.requestToppings(sandwich));
        order.addToOrder(sandwich);
        System.out.println("You have successfully added to your order.");
    }

    /**
     * Allows user to select Soda flavor and size and adds it to order.
     */
    private void processAddSoda(){
        SodaSize sodaSize = getSodaSize();
        String name = promptForSelection(Soda.FLAVORS, sodaSize.getPrice());
        if (name != null) {
            Soda soda = new Soda(sodaSize.getLabel(), name, sodaSize);
            order.addToOrder(soda);
            System.out.println("You have successfully added to your order.");
        }
    }

    /**
     * Allows user to select chips flavor and adds it to order.
     */
    private void processAddChips(){
        String name = promptForSelection(Chips.FLAVORS, Chips.PRICE);
        if (name != null) {
            Chips chips = new Chips("Chips", name);
            order.addToOrder(chips);
            System.out.println("You have successfully added to your order.");
        }
    }

    /**
     * Checks to see the type of item user has selected to order.
     */
    private void processEditOrder(){
        OrderableItem item = getEditOrderSelection();
        if (item instanceof Sandwich){
            editSandwich((Sandwich) item);
        }
        else if(item instanceof Soda){
            editSoda((Soda) item);
        }
        else if(item instanceof Chips){
            editChips((Chips) item);
        }
    }

    /**
     * Prompts user to select order item they wish to edit.
     * @return the order item user has selected to edit.
     */
    private OrderableItem getEditOrderSelection(){
        ArrayList<OrderableItem> items = order.getOrder();
        System.out.println("""
                What would you like to edit?""");
        for (int i = 0; i < items.size(); i++){
            System.out.printf("[%d] %s - %s %n", i + 1, items.get(i).getCategory(), items.get(i).getName());
        }
        int choice = console.promptForIntRange("> " , 1, items.size());
        return items.get(choice - 1);
    }

    /**
     * Displays and prompts user to select a speciality sandwich.
     * @return the speciality sandwich user has selected.
     */
    private SpecialitySandwich getSpecialitySandwich(){
        System.out.println("\t\tSpeciality Sandwich");
        SpecialitySandwich[] type = SpecialitySandwich.values();
        for (int i = 0; i < type.length; i++){
            System.out.printf("\t[%d] %s%n", i + 1, type[i].getLabel());
        }
        int choice = console.promptForIntRange("> " , 1, type.length);
        return type[choice - 1];
    }

    /**
     * Prompts user to select soda size.
     * @return the size of the soda user has selected.
     */
    private SodaSize getSodaSize(){
        SodaSize[] sizes = SodaSize.values();
        System.out.println("\t\tSize Selection");
        for (int i = 0; i < sizes.length; i++){
            System.out.printf("\t[%d] %s ---- $ %.2f %n", i + 1, sizes[i].getLabel(),sizes[i].getPrice());
        }
        int choice = console.promptForIntRange("> " , 1, sizes.length);
        return sizes[choice - 1];

    }

    /**
     * displays a list of options and prices and prompts user to select an option.
     * @param selection the list of options for user to select from.
     * @param price the price of options.
     * @return String the option user has selected.
     */
    private String promptForSelection(String[] selection, double price){
        System.out.printf("Which one would you like to add? %nPrice: $ %.2f %n", price);
        for (int i = 0; i < selection.length; i++){
            System.out.printf("[%d] %s ", i + 1, selection[i]);
        }
        System.out.printf("[%d] Skip%n", selection.length + 1);

        int choice = console.promptForIntRange("> " , 1, selection.length + 1);
        if (choice == selection.length + 1){
            return null;
        }
        return selection[choice - 1];
    }


}
