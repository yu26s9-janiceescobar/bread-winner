package com.pluralsight.ui;
import com.pluralsight.business.Catalog;
import com.pluralsight.business.Store;
import com.pluralsight.models.*;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;


public class UserInterface {
    private Store store;
    private Console console;

    private Catalog catalog;
    private void init(Store store, Console console) {
        this.store = store;
        this.console = console;
        catalog = store.getMenuCatalog();
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

    private void displayListOfMenuOptions(ArrayList<CatalogItem> catalogItems){
        AtomicInteger atomicInteger = new AtomicInteger(1);
        for (CatalogItem catalogItem : catalogItems){
            System.out.printf("[%s] %s%n", atomicInteger.getAndIncrement(), catalogItem.getName());
        }
    }
    private void displaySandwichSizeCost(ArrayList<PriceEntry> priceEntries){
        AtomicInteger atomicInteger = new AtomicInteger(1);
        for (PriceEntry priceEntry: priceEntries){
            System.out.printf("[%s] %s-inch - $%.2f%n", atomicInteger.getAndIncrement(),  priceEntry.getSize(), priceEntry.getPrice());
        }
    }
    private void processAddTopping(String category, Sandwich sandwich){
        double price = catalog.getPrice(category, sandwich.getSize());
        System.out.printf("""
                What %s would you like to add?
                Additional Cost: $%.2f
                """ ,category, price);

        ArrayList<CatalogItem> toppings = catalog.getMenuItemByCategory(category);
        displayListOfMenuOptions(toppings);
        int choice = console.promptForIntRange("> ",1, toppings.size());
        CatalogItem toppingSelected = toppings.get(choice);
        sandwich.addTopping(new Topping(toppingSelected.getName()));
        String extraToppingCategory = "extra " + category;
        double extraPrice = catalog.getPrice(extraToppingCategory, sandwich.getSize());
        System.out.printf("""
                Would you like to add extra %s?
                Additional Cost: $%.2f
                """ ,extraToppingCategory, extraPrice);
        boolean addExtraTopping = console.promptForYesNo("[Y] Yes [N] No");
        if (addExtraTopping){
            sandwich.addTopping(new Topping(extraToppingCategory));
        }
    }

    private void processAddSandwich(){
        System.out.println("What bread would you like? ");
        ArrayList<CatalogItem> breads = catalog.getMenuItemByCategory("bread");
        displayListOfMenuOptions(breads);

        int breadOption = console.promptForIntRange("> ", 1, breads.size());
        CatalogItem selectedBread = breads.get(breadOption - 1);

        System.out.println("What size would you like? ");
        ArrayList<PriceEntry> breadPrices = catalog.getPriceEntryByCategory("bread");
        displaySandwichSizeCost(breadPrices);
        int sizeOption = console.promptForIntRange("> ",1, breadPrices.size());
        PriceEntry sandwichPrice = breadPrices.get(sizeOption - 1);

        Sandwich sandwich = new Sandwich("Custom Sandwich", sandwichPrice.getSize());
        sandwich.setBread(selectedBread.getName());
        processAddTopping("meat", sandwich);
        processAddTopping("cheese", sandwich);
        processAddTopping("regular topping", sandwich);
        processAddTopping("sauce", sandwich);

    }



}
