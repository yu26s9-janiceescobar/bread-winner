package com.pluralsight.ui;
import com.pluralsight.business.MenuCatalog;
import com.pluralsight.models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


public class UserInterface {
    private MenuCatalog menuCatalog;
    private Console console;
    private void init(MenuCatalog menuCatalog, Console console){
        this.menuCatalog = menuCatalog;
        this.console = console;
    }

    public void display(MenuCatalog menuCatalog, Console console){
        init(menuCatalog, console);
        int option;
        do {
            System.out.println("""
                    Bread Winner Shop
                    [1] New Order
                    [0] Exit""");
            option = console.promptForIntRange("> ", 0, 1);
            switch(option){
                case 0:
                    System.out.println("Exiting Application...");
                    break;
                case 1:
                    processNewOrder();
            }
        }while(option != 0);
    }

    private void processNewOrder(){
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
            switch(option){
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
        }while(option != 0);
    }
    private void displayListOfMenuItems(List<MenuItem> menuItems, String header){
        System.out.println(header);
        AtomicInteger index = new AtomicInteger(1);
        menuItems.forEach(menuItem ->
                System.out.printf("[%d] %s%n",index.getAndIncrement(), menuItem.getName()));
    }
    private void displayPricesBySize(List<PriceEntry> priceEntries, String header){
        System.out.println(header);
        AtomicInteger index = new AtomicInteger(1);
        priceEntries.forEach(priceEntry ->
                System.out.printf("[%d] %s === $%.2f %n",index.getAndIncrement(), priceEntry.getSize(), priceEntry.getPrice()));
    }

    private void processAddSandwich(){
        List<MenuItem> selectedMeats = new ArrayList<>();
        List<MenuItem> selectedCheeses = new ArrayList<>();
        List<MenuItem> selectedRegToppings = new ArrayList<>();
        List<MenuItem> selectedSauces = new ArrayList<>();

        List<PriceEntry> sandwichPrices = menuCatalog.getPricesByCategory("SANDWICH");
        displayPricesBySize(sandwichPrices, "Sandwich Size Options");
        int sandwichChoice = console.promptForIntRange("> ", 1, sandwichPrices.size());
        PriceEntry selectedSandwich = sandwichPrices.get(sandwichChoice - 1);

        List<MenuItem> breads = menuCatalog.getItemsByCategory("BREAD");
        displayListOfMenuItems( breads, "Types of Bread");
        int breadChoice = console.promptForIntRange("> ", 1, breads.size());
        MenuItem selectedBread = breads.get(breadChoice - 1);




        List<MenuItem> cheese = menuCatalog.getItemsByCategory("CHEESE");
        displayListOfMenuItems(cheese, "Types of Cheese");
        int cheeseChoice = console.promptForIntRange("> ", 1, cheese.size());
        MenuItem selectedCheese = cheese.get(cheeseChoice - 1);
        double cheesePrices = menuCatalog.getPriceBySize(selectedCheese, selectedSandwich.getSize());


        OrderItem sandwich = new Sandwich("Sandwich", selectedBread,selectedMeats , selectedCheeses, selectedRegToppings, selectedSauces);
    }

    private List<MenuItem> processAddMeats(String size){

        boolean extraMeat;
        do {
            List<MenuItem> availableMeats = menuCatalog.getItemsByCategory("MEATS");
            displayListOfMenuItems(availableMeats, "Types of Meat");

            int meatChoice = console.promptForIntRange("> ", 1, availableMeats.size());
            MenuItem selectedMeat = availableMeats.get(meatChoice - 1);

            double meatPrice = menuCatalog.getPriceBySize(selectedMeat, size);
            extraMeat = console.promptForYesNo("Would you like to Extra Meat? [Y] Yes [N] No");
            if (extraMeat){
                menuCatalog.getPriceBySize()
            }

        }while()
    }

}
