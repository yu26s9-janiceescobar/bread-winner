package com.pluralsight.ui;

//Meats
//- steak
//- ham
//- salami
//- roast beef
//- chicken
//- bacon

public class UserInterface {
    private Console console;

    String[] meat = {"steak", "ham", "salami", "roast beef", "chicken", "bacon"};
    String[] cheese = {"american", "provolone", "cheddar", "swiss"};
    int[] sandwichSize = {4, 8, 12};
    String[] breads = {"white", "wheat", "rye", "wrap"};
    String[] regularToppings = { "lettuce", "peppers","onions","tomatoes","jalapeños","cucumbers","pickles","guacamole","mushrooms"};
    String[] sauces = {"mayo", "mustard", "ketchup", "ranch", "thousand islands", "vinaigrette"};
    String[] sides = {"au jus","sauce"};
    String[] soda = {"coke", "ginger ale", "sprite", "diet coke"};
    String[] sodaSize = {"small", "medium", "large"};
    String[] chips = {"salt and vinegar", "potato", "bbq"};
    double[] sandwichPrices = {5.5, 7.0, 8.5};
    double[] meatPrices = {1.0, 2.0, 3.0};
    double[] cheesePrices = {.75, 1.50, 2.25};
    double[] sodaPrices = {2.0, 2.5, 3.0};
    double[] chipPrices ={1.5};


    private void init(Console console) {
        this.console = console;
    }
    public void display(Console console) {
        init(console);

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
                    //processAddSandwich();
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

    public void processAddSandwich(){

    }
}








