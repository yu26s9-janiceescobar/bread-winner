package com.pluralsight.ui;
import com.pluralsight.business.Order;
import com.pluralsight.models.Chip;
import com.pluralsight.models.OrderItem;
import com.pluralsight.models.Soda;
import com.pluralsight.models.SodaSize;



public class OrderScreen {
    private final Console console;
    private final Order order;
    public OrderScreen(Console console){
        this.console = console;
        this.order = new Order();
    }
    public void startNewOrder(){
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
                        processAddSandwich();
                        break;
                    case 2:
                        addSoda();
                        break;
                    case 3:
                        addChip();
                        break;
                    case 4:
                        // processCheckOut();
                        break;
                }
            } while (option != 0);
    }
    private void processAddSandwich(){
        SandwichScreen sandwichScreen = new SandwichScreen(console);
        order.addToOrder(sandwichScreen.buildSandwich());
    }

    private void processAddSoda(){
        String[] sodas = {"coca cola", "ginger ale", "mountain dew", "club soda"};
        String selectedSoda = selectOption(sodas);
        SodaSize[] sizes = SodaSize.values();

        for (int i = 0; i < sizes.length; i++){
            System.out.printf("[%d] %s%n", i + 1, sizes[i]);
        }
        int choice = console.promptForIntRange("Choose Size%n> " , 1, sizes.length);
        SodaSize size = sizes[choice - 1];
        order.addToOrder(new Soda("Soda", selectedSoda, size));
    }
    private void prcoessAddChip(){
        String[] chips = {"bbq", "salt and vinegar", "doritos", "cheetos"};
        String selectedChip = selectOption(chips);
        order.addToOrder(new Chip("Chips", selectedChip));
    }
    private String selectOption(String[] options){
        for (int i = 0; i < options.length; i++){
            System.out.printf("[%d] %s%n", i + 1, options[i]);
        }
        int choice = console.promptForIntRange("Choose:%n> " , 1, options.length);
        return options[choice - 1];
    }
    private void processCheckOut(){
        int option;
        do {
            System.out.println("Order Summary");
            for (OrderItem orderItem : order.getOrder()) {
                System.out.printf("""
                        %s ----- %.2f""", orderItem.getName(), orderItem.getPrice());
            }
            System.out.println("""
                    Select an Option:
                    [1] Confirm Order
                    [2] Edit Order
                    [3] Cancel Order
                    """);
            option = console.promptForIntRange("> ", 1, 3);
            switch(option){
                case 1:

                    break;
                case 2:
                    break;
                case 3:
                    break;
            }
        } while(option != 3);
    }

}
