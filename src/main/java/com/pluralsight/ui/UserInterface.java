package com.pluralsight.ui;
import com.pluralsight.business.MenuCatalog;
import com.pluralsight.business.Store;
import com.pluralsight.models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


public class UserInterface {
    private Store store;
    private Console console;

    private MenuCatalog menuCatalog;
    private void init(Store store, Console console) {
        this.store = store;
        this.console = console;
        menuCatalog = store.getMenuCatalog();
    }

    public void display(Store store, Console console) {
        init(store, console);

        int option;
        do {
            System.out.println("""
                    Bread Winner Shop
                    [1] New Order
                    [0] Exit""");
            option = console.promptForIntRange("> ", 0, 1);
            switch (option) {
                case 0:
                    System.out.println("Exiting Application...");
                    break;
                case 1:
                    processNewOrder();
            }
        } while (option != 0);
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
                    processAddSandwich();
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

    private void displayListOfMenuOptions(ArrayList<MenuItem> menuItems){
        AtomicInteger atomicInteger = new AtomicInteger(1);
        for (MenuItem menuItem: menuItems){
            System.out.printf("[%s] %s%n", atomicInteger.getAndIncrement(), menuItem.getName());
        }
    }
    private void displaySandwichSizeCost(ArrayList<PriceEntry> priceEntries){
        AtomicInteger atomicInteger = new AtomicInteger(1);
        for (PriceEntry priceEntry: priceEntries){
            System.out.printf("[%s] %s-inch - $%.2f%n", atomicInteger.getAndIncrement(),  priceEntry.getSize(), priceEntry.getPrice());
        }
    }
  
    private void processAddSandwich(){
        System.out.println("What bread would you like? ");
        ArrayList<MenuItem> breads = menuCatalog.getMenuItemByCategory("BREAD");
        displayListOfMenuOptions(breads);

        int breadOption = console.promptForIntRange("> ", 1, breads.size());
        MenuItem selectedBread = breads.get(breadOption - 1);

        System.out.println("What size would you like? ");
        ArrayList<PriceEntry> priceEntries = menuCatalog.getPriceEntryByCategory("BREAD");
        displaySandwichSizeCost(priceEntries);
        int sizeOption = console.promptForIntRange("> ",1, priceEntries.size());
        PriceEntry price = priceEntries.get(sizeOption - 1);

        System.out.println("What Meat would you like to add? ");
        ArrayList<MenuItem> meats = menuCatalog.getMenuItemByCategory("MEAT");
        displayListOfMenuOptions(meats);



    }



}
