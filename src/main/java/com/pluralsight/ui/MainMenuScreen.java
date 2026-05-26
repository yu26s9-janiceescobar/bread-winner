package com.pluralsight.ui;

public class MainMenuScreen {
    private Console console;
    public MainMenuScreen(Console console){
        this.console = console;
    }
    public void start(){
        int option;
        do {
            System.out.println("""
                    Bread Winner Shop
                    [1] New Order
                    [0] Exit""");
            option = console.promptForIntRange("> ", 0, 1);
            switch (option) {
                case 1 -> openOrderScreen();
            }
        } while (option != 0);
    }
    private void openOrderScreen(){
        OrderScreen orderScreen = new OrderScreen(console);
    }
}
