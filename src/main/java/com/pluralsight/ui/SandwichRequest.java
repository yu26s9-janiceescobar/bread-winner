package com.pluralsight.ui;
import com.pluralsight.models.*;
import com.pluralsight.models.enums.BreadType;
import com.pluralsight.models.enums.SandwichSize;
import com.pluralsight.models.enums.ToppingCategory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;


public class SandwichRequest {
    private final Console console;
    public SandwichRequest(Console console){
        this.console = console;
    }

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

    private Topping chooseTopping(SandwichSize size, ArrayList<Topping> toppings){
        System.out.println("\t\t" + toppings.get(1).getCategory() + " Selection");
        System.out.printf("Price: $ %.2f %n", toppings.get(1).getPrice(size));
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

    public boolean requestIsToasted(){
        return console.promptForYesNo("Would you like to have your bread toasted? \n[Y] Yes [N] No \n> ");
    }
    public BreadType requestBread(){
        BreadType[] breadTypes = BreadType.values();
        System.out.println("\t\tBread Selection");
        for (int i = 0; i < breadTypes.length; i++){
            System.out.printf("\t[%d] %s\n", i + 1, breadTypes[i].getLabel());
        }
        int choice = console.promptForIntRange("> " , 1, breadTypes.length);
        return breadTypes[choice - 1];
    }


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
