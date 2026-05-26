package com.pluralsight.ui;

import com.pluralsight.models.*;


public class SandwichScreen {
    private final Console console;
    private static final String[] meats = {"steak", "ham", "salami", "roast beef", "chicken", "bacon"};
    private static final String[] cheeses = {"american", "provolone", "cheddar", "swiss"};
    private static final String[] breads = {"white", "wheat", "rye", "wrap"};
    private static final String[] regularToppings = {"lettuce", "peppers", "onions", "tomatoes", "jalapeños", "cucumbers", "pickles", "guacamole", "mushrooms"};
    private static final String[] sauces = {"mayo", "mustard", "ketchup", "ranch", "thousand islands", "vinaigrette"};
    private static final String[] sides = {"au jus", "sauce"};
    public SandwichScreen(Console console){
        this.console = console;
    }
    private String getUserSelection(String[] selection, String category){
        int choice = console.promptForIntRange("Choose " + category, 1, selection.length);
        return selection[choice - 1];
    }

    public Sandwich buildSandwich(){
        Sandwich sandwich;
        SandwichSize size = getSandwichSize();
        sandwich = new Sandwich("Custom Sandwich", size);
        sandwich.setBread(selectOption(breads, "Breads"));
        addMeat(sandwich);
        addCheese(sandwich);
        addRegularTopping(sandwich);
        addSauce(sandwich);
        addSide(sandwich);
        return sandwich;
    }
    private void addSide(Sandwich sandwich){
        boolean addSide;
        int maxSides = 0;
        do {
            String selectedTopping = selectOption(sides, "Sides");
            sandwich.addTopping(new RegularTopping(selectedTopping));
            addSide = console.promptForYesNo("Add another topping? [Y] yes [N] no\n");
            maxSides++;
        }while(addSide && maxSides < sides.length);
    }
    private void addRegularTopping(Sandwich sandwich){
        boolean addTopping;
        int maxToppings = 0;
        do {
            String selectedTopping = selectOption(regularToppings, "Regular Topping");
            sandwich.addTopping(new RegularTopping(selectedTopping));
            addTopping = console.promptForYesNo("Add another topping? [Y] yes [N] no\n");
            maxToppings++;
        }while(addTopping && maxToppings < regularToppings.length);
    }
    private void addSauce(Sandwich sandwich){
        boolean addSauce;
        int maxSauce = 0;
        do {
            String selectedTopping = selectOption(sauces, "Sauces");
            sandwich.addTopping(new RegularTopping(selectedTopping));
            addSauce = console.promptForYesNo("Add another topping? [Y] yes [N] no\n");
            maxSauce++;
        }while(addSauce && maxSauce < sauces.length);
    }

    private void addMeat(Sandwich sandwich){
        for (int i = 0; i < meats.length; i++){
            System.out.printf("[%d] %s --- $%.2f (Extra: $%.2f)%n",
                    i + 1, meats[i], Meat.getBasePrice(sandwich.getSize()), Meat.getExtraPrice(sandwich.getSize()));
        }
        String selectedMeat = getUserSelection(meats, "Meat");
        sandwich.addTopping(new Meat(selectedMeat, false));
        boolean addExtraMeat = console.promptForYesNo("Extra Meat: [Y] Yes [N] No");
        if (addExtraMeat){
            sandwich.addTopping(new Meat(selectedMeat, true));
        }
    }


    private void addCheese(Sandwich sandwich){
        for (int i = 0; i < cheeses.length; i++){
            System.out.printf("[%d] %s --- $%.2f (Extra: $%.2f)%n",
                    i + 1, cheeses[i], Cheese.getBasePrice(sandwich.getSize()), Cheese.getExtraPrice(sandwich.getSize()));
        }
        String selectedCheese = getUserSelection(cheeses, "Cheese");
        sandwich.addTopping(new Cheese(selectedCheese, false));
        boolean addExtraCheese = console.promptForYesNo("Extra Cheese: [Y] Yes [N] No");
        if (addExtraCheese){
            sandwich.addTopping(new Cheese(selectedCheese, true));
        }
    }



    private String selectOption(String[] selection, String category){
        for (int i = 0; i < selection.length; i++){
            System.out.printf("[%d] %s%n", i + 1, selection[i]);
        }
        return getUserSelection(selection, category);
    }

    private SandwichSize getSandwichSize(){
        SandwichSize[] sizes = SandwichSize.values();
        for (int i = 0; i < sizes.length; i++){
            System.out.printf("[%d] %d --- %.2f%n", i + 1, sizes[i].getInches(), sizes[i].getBasePrice());
        }
        int choice = console.promptForIntRange("Choose Size%n> " , 1, sizes.length);
        return sizes[choice - 1];
    }


}
