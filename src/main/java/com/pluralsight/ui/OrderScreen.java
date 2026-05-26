package com.pluralsight.ui;
import com.pluralsight.business.Order;
import com.pluralsight.models.SodaSize;


public class OrderScreen {
    private final Console console;
    private final Order order;
    public OrderScreen(Console console){
        this.console = console;
        this.order = new Order();
    }
    private void addSandwich(){
        SandwichScreen sandwichScreen = new SandwichScreen(console);
        order.addToOrder(sandwichScreen.buildSandwich());
    }
    private void addSoda(){
        SodaSize.get()
    }
}
