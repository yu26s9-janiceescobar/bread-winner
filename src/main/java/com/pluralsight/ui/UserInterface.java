package com.pluralsight.ui;

public class UserInterface {
    private final Console console;
    public UserInterface(Console console){
        this.console = console;
    }
    public void display(){
        int option;
        do {
            System.out.println("""
                \t\tBread Winner
                \t[1] New Order
                \t[0] Exit""");
            option = console.promptForIntRange("> ", 0, 1);
            switch (option) {
                case 1 -> openOrderScreen();
                case 0 -> System.out.println("Exiting Application...");
            }
        } while (option != 0);
    }
    private void openOrderScreen() {
        OrderScreen orderScreen = new OrderScreen(console);
        orderScreen.startNewOrder();
    }

}








