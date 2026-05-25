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
    private void displayListOfMenuItems(List<ItemName> menuItems){
        AtomicInteger index = new AtomicInteger(1);
        menuItems.forEach(menuItem ->
                System.out.printf("[%d] %s%n",index.getAndIncrement(), menuItem.getName()));
    }
    private void displayPricesBySize(List<PriceEntry> priceEntries){
        AtomicInteger index = new AtomicInteger(1);
        priceEntries.forEach(priceEntry ->
                System.out.printf("[%d] %s === $%.2f %n",index.getAndIncrement(), priceEntry.getSize(), priceEntry.getPrice()));
    }

    private void processAddSandwich(){
        List<ItemName> selectedMeats = new ArrayList<>();
        List<ItemName> selectedCheeses = new ArrayList<>();
        List<ItemName> selectedRegToppings = new ArrayList<>();
        List<ItemName> selectedSauces = new ArrayList<>();

        List<PriceEntry> sandwichPrices = menuCatalog.getPricesByCategory("SANDWICH");
        displayPricesBySize(sandwichPrices);
        int sandwichChoice = console.promptForIntRange("> ", 1, sandwichPrices.size());
        PriceEntry selectedSandwich = sandwichPrices.get(sandwichChoice - 1);

        List<ItemName> breads = menuCatalog.getItemsByCategory("BREAD");
        displayListOfMenuItems( breads);
        int breadChoice = console.promptForIntRange("> ", 1, breads.size());
        ItemName selectedBread = breads.get(breadChoice - 1);


        OrderItem sandwich = new Sandwich("Sandwich", selectedBread,selectedMeats , selectedCheeses, selectedRegToppings, selectedSauces);
    }

    private List<ItemName> processAddCheese(String size){
        do {
            System.out.println("Select one of the following Cheeses: ");
            List<ItemName> availableCheeseOptions = menuCatalog.getItemsByCategory("CHEESE");
            displayListOfMenuItems(availableCheeseOptions);
            int cheeseChoice = console.promptForIntRange("> ", 1, availableCheeseOptions.size());
            ItemName selectedCheese = availableCheeseOptions.get(cheeseChoice - 1);
            availableCheeseOptions.remove(selectedCheese);
//            double cheesePrices = menuCatalog.getPriceBySize(selectedCheese, size);

            System.out.println("Would you like extra " + selectedCheese.getName() + "?");
            List<ItemName> extraCheeseOptions = menuCatalog.getItemsByCategory("EXTRA_CHEESE");
            boolean addExtraCheese = console.promptForYesNo("[Y] Yes [N] No");
            if (addExtraCheese){
                ItemName extraCheeseSelected = menuCatalog.getItemsByCategory("EXTRA_CHEESE");
            }
                menuCatalog.getPricesByCategory("EXTRA_CHEESE", size);
            }
        }while()

    }
    private List<ItemName> processAddMeat(String size){

        List<ItemName> availableMeats = menuCatalog.getItemsByCategory("MEATS");
        displayListOfMenuItems(availableMeats);

        int meatChoice = console.promptForIntRange("> ", 1, availableMeats.size());
        ItemName selectedMeat = availableMeats.get(meatChoice - 1);

        double meatPrice = menuCatalog.getPriceBySize(selectedMeat, size);


}
