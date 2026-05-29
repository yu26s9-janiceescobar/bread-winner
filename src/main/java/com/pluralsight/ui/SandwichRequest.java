package com.pluralsight.ui;
import com.pluralsight.models.*;
import com.pluralsight.models.enums.BreadType;
import com.pluralsight.models.enums.SandwichSize;
import com.pluralsight.models.enums.ToppingCategory;
import java.util.ArrayList;
import java.util.stream.Collectors;


public class SandwichRequest {
    private final Console console;
    public SandwichRequest(Console console){
        this.console = console;
    }

    /**
     * Checks to see available toppings based on current sandwich item. User is allowed
     * one topping plus an extra serving of the same topping.
     * If sandwich contains both then it is not available.
     * If sandwich contains the topping but not an extra serving then only the extra serving is available.
     * If sandwich contains neither then both servings are available.
     * @param sandwich the sandwich item with a list of toppings.
     * @return ArrayList of available toppingss.
     */
    private ArrayList<Topping> getAvailableToppings(Sandwich sandwich) {
        ToppingCategory[] allCategories = ToppingCategory.values();
        ArrayList<Topping> existingToppings = sandwich.getToppings();
        ArrayList<Topping> availableToppings = new ArrayList<>();
        boolean alreadyHasTopping;
        boolean alreadyHasExtraTopping;
        for (ToppingCategory category: allCategories){
            for (String toppingName: category.getNames()){
                alreadyHasTopping = existingToppings.stream()
                        .anyMatch(topping -> topping.getName().equalsIgnoreCase(toppingName) && !topping.isExtra());
                alreadyHasExtraTopping = existingToppings.stream()
                        .anyMatch(topping -> topping.getName().equalsIgnoreCase(toppingName) && topping.isExtra());
                if (!alreadyHasTopping && !alreadyHasExtraTopping){
                    availableToppings.add(new Topping(category, toppingName, false));
                }
                if (alreadyHasTopping && !alreadyHasExtraTopping){
                    availableToppings.add(new Topping(category, toppingName, true));
                }
            }

        }

        return availableToppings;
    }

    /**
     * Prompts user to select a topping.
     * @param size the size of the sandwich.
     * @param toppings the list of toppings user is allowed to select from.
     * @return the Topping user selects.
     */
    private Topping chooseTopping(SandwichSize size, ArrayList<Topping> toppings){
        System.out.println("\t\t" + toppings.getFirst().getCategory() + " Selection");
        System.out.printf("Price: $ %.2f %n", toppings.getFirst().getPrice(size));
        for (int i = 0; i < toppings.size(); i++ ){
            System.out.printf("\t[%d] %s ", i + 1, toppings.get(i).getName());
        }
        System.out.println("\t[0] Skip");
        int choice = console.promptForIntRange("> " , 0, toppings.size());
        if (choice == 0){
            return null;
        }
        return toppings.get(choice - 1);
    }
//    private ArrayList<Topping> getEntireToppingSelection(){
//        ToppingCategory[] allCategories = ToppingCategory.values();
//        ArrayList<Topping> allToppings = new ArrayList<>();
//        for (ToppingCategory category: allCategories){
//            for (String toppingName: category.getNames()){
//                allToppings.add(new Topping(category, toppingName, false));
//            }
//    }
//        return allToppings;
//    }
//    private ArrayList<Topping> getUnavailableToppings(Sandwich sandwich){
//        ArrayList<Topping> availableToppings = getAvailableToppings(sandwich);
//        ArrayList<Topping> unavailableToppings = getEntireToppingSelection().stream()
//                .filter(topping -> availableToppings.stream()
//                        .noneMatch(available ->
//                                available.getName().equalsIgnoreCase(topping.getName())))
//                .collect(Collectors.toCollection(ArrayList::new));
//        return unavailableToppings;
//    }

    /**
     * Prompts user to select topping per category and prompts user with a decision to add an extra
     * portion of the topping.
     * @param sandwich the sandwich toppings are being added to.
     * @return the list of topppings user has selected to add to sandwich.
     */
    public ArrayList<Topping> requestToppings(Sandwich sandwich){
            ArrayList<Topping> allToppings = getAvailableToppings(sandwich);
            ArrayList<Topping> addedToppings = new ArrayList<>();
            for(ToppingCategory category: ToppingCategory.values()){

                ArrayList<Topping> categoryToppings = allToppings.stream()
                        .filter(t -> t.getCategoryEnum() == category)
                        .collect(Collectors.toCollection(ArrayList::new));
                if (categoryToppings.isEmpty()){
                    continue;
                }
                Topping topping = chooseTopping(sandwich.getSize(), categoryToppings);
                if (topping == null){
                    continue;
                }
                addedToppings.add(topping);
                allToppings.remove(topping);
                ToppingCategory type = topping.getCategoryEnum();
                System.out.printf("Would you like to add extra %s? %nPrice: $ %.2f %n[Y] Yes [N] No%n", topping.getName(), type.getExtraPrice((sandwich.getSize())));
                if (console.promptForYesNo("> ")) {
                    addedToppings.add(new Topping(type, topping.getName(), true));
                }

            }
            return addedToppings;

    }

    /**
     * Prompts user with a choice to toast their sandwich.
     * @return boolean returns true if user chooses to toast their sandwich, false if user selects to not toast their sandwich.
     */
    public boolean requestIsToasted(){
        return console.promptForYesNo("Would you like to have your bread toasted? \n[Y] Yes [N] No \n> ");
    }

    /**
     * Prompts user to select the type of bread for their sandwich.
     * @return BreadType the type of bread user has selected.
     */
    public BreadType requestBread(){
        BreadType[] breadTypes = BreadType.values();
        System.out.println("\t\tBread Selection");
        for (int i = 0; i < breadTypes.length; i++){
            System.out.printf("\t[%d] %s\n", i + 1, breadTypes[i].getLabel());
        }
        int choice = console.promptForIntRange("> " , 1, breadTypes.length);
        return breadTypes[choice - 1];
    }

    /**
     * Prompts the user to select the size of their sandwich.
     * @return the size user has selected.
     */
    public SandwichSize requestSandwichSize(){
        SandwichSize[] sizes = SandwichSize.values();
        System.out.println("\t\tSize Selection");
        for (int i = 0; i < sizes.length; i++){
            System.out.printf("\t[%d] %s ---- $ %,.2f%n", i + 1, sizes[i].getLabel(), sizes[i].getPrice());
        }
        int choice = console.promptForIntRange("> " , 1, sizes.length);
        return sizes[choice - 1];

    }


}
