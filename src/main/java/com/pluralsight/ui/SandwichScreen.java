package com.pluralsight.ui;

import com.pluralsight.models.*;


public class SandwichScreen {
    private final Console console;
    private final static String[] sandwichSize = {"4 inch", "8 inch", "12 inch"}
    private static final String[] meats = {"steak", "ham", "salami", "roast beef", "chicken", "bacon"};
    private static final String[] cheeses = {"american", "provolone", "cheddar", "swiss"};
    private static final String[] breads = {"white", "wheat", "rye", "wrap"};
    private static final String[] regularToppings = {"lettuce", "peppers", "onions", "tomatoes", "jalapeños", "cucumbers", "pickles", "guacamole", "mushrooms"};
    private static final String[] sauces = {"mayo", "mustard", "ketchup", "ranch", "thousand islands", "vinaigrette"};
    private static final String[] sides = {"au jus", "sauce"};
    public SandwichScreen(Console console){
        this.console = console;
    }

    public Sandwich buildSandwich(){
        Sandwich sandwich;
        String size = selectOption(sandwichSize, "Select Sandwich Size: ");
        String bread = selectOption(breads, "Select bread: ");
        sandwich = new Sandwich("Sandwich", "Custom", size, bread);
        sandwich.setToasted(console.promptForYesNo("Toast bread? [Y] Yes [N] No"));
        addMeat(sandwich);
        addCheese(sandwich);
        addRegTopping(sandwich, regularToppings, "regular topping");
        addRegTopping(sandwich, sauces, "sauce");
        addRegTopping(sandwich, sides, "sides");
        return sandwich;
    }

    private void addRegTopping(Sandwich sandwich, String[] selection, String category){
        boolean addToSandwich;
        int maxToppings = 0;
        do {
            String selectedTopping = selectOption(selection, category);
            sandwich.addTopping(new RegularTopping(selectedTopping));
            addToSandwich = console.promptForYesNo("Add another " + category + " [Y] yes [N] no\n");
            maxToppings++;
        }while(addToSandwich && maxToppings < selection.length);
    }

    private void addMeat(Sandwich sandwich){
        String selectedMeat = selectOption(meats,"Select Meat: ");
        MenuItemFactory.createMenuItem("Meat", "topping", selectedMeat, );
        double basePrice = Menu.meat().getBasePrice();
        double extraPrice = meat.getExtraPrice(sandwich.getSize());
        System.out.printf("Price: $%.2f Additional Cost: $%.2f %n", basePrice, extraPrice);
        sandwich.addTopping(meat);
        if (console.promptForYesNo("Extra Meat: [Y] Yes [N] No")){
            sandwich.addTopping(new Meat(selectedMeat, true));
        }
    }


    private void addCheese(Sandwich sandwich){
        String selectedCheese = selectOption(cheeses, "Select Cheese: ");
        PremiumTopping cheese = new Cheese(selectedCheese, false);
        double basePrice = cheese.getBasePrice(sandwich.getSize());
        double extraPrice = cheese.getExtraPrice(sandwich.getSize());
        System.out.printf("Price: $%.2f Additional Cost: $%.2f %n", basePrice, extraPrice);
        sandwich.addTopping(cheese);
        if (console.promptForYesNo("Extra Cheese: [Y] Yes [N] No")){
            sandwich.addTopping(new Cheese(selectedCheese, true));
        }
    }



    private String selectOption(String[] selection, String prompt){
        for (int i = 0; i < selection.length; i++){
            System.out.printf("[%d] %s%n", i + 1, selection[i]);
        }
        int choice = console.promptForIntRange(prompt, 1, selection.length);
        return selection[choice - 1];
    }

    private String getSandwichSize(){
        SandwichSize[] sizes = SandwichSize.values();
        for (int i = 0; i < sizes.length; i++){
            System.out.printf("[%d] %s%n", i + 1, sizes[i].getInches());
        }
        int choice = console.promptForIntRange("Choose Size%n> " , 1, sizes.length);
        return sizes[choice - 1];

    }


}
