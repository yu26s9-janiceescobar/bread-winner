package com.pluralsight.ui;
import com.pluralsight.business.MenuCatalog;
import com.pluralsight.models.MenuItem;

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
    private void processAddSandwich(){
        List<MenuItem> breads = menuCatalog.getItemsByCategory("BREAD");
        displayListOfMenuItems( breads, "Type of Breads");
        int choice = console.promptForIntRange("> ", 1, breads.size());
        

    }

}
