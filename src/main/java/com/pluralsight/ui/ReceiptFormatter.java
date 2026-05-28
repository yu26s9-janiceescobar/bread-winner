package com.pluralsight.ui;

import com.pluralsight.business.Order;
import com.pluralsight.models.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ReceiptFormatter {
    public static void receiptFormatter(Order order){
        ArrayList<OrderableItem> format = order.getOrder();
        format.sort(Comparator.comparingInt(item -> item instanceof Sandwich ? 0 : 1));
        System.out.printf("%25s%n","Order Summary");
        System.out.println("=".repeat(50));

        for (OrderableItem item: format){

            if (item instanceof Sandwich){
                System.out.printf("""
                        %s - %s (%s)
                        \tBread: %s
                        \tToasted: %s
                        \n""",
                        item.getCategory(),
                        item.getName(),
                        ((Sandwich) item).getSize().getLabel(),
                        ((Sandwich) item).getBread().getLabel(),
                        ((Sandwich) item).isToasted() ? "Yes" : "No");

                List<Topping> toppings = ((Sandwich) item).getAllToppings();

                toppings.sort(Comparator.comparing(Topping::getCategory)
                        .thenComparing(t -> t.getName().startsWith("Extra") ? 1 : 0));


                    String currentCategory = "";
                    for (Topping t : toppings) {
                        if (!t.getCategory().equals(currentCategory) && !t.getName().startsWith("Extra")) {
                            currentCategory = t.getCategory();
                            System.out.printf("%10s: %n", currentCategory.toUpperCase());
                        }
                        if (t.getName().startsWith("Extra")) {
                            System.out.printf("%10s %-25s", "+ ", t.getName());
                        }
                        else{
                            System.out.printf("%10s %-25s", " ",t.getName());
                        }

                        double price = t.getPrice(((Sandwich) item).getSize());
                        System.out.printf("%10s%n",
                                price == 0 ? "FREE" : String.format("$%.2f", price) );
                    }
            }else{
                System.out.println("-".repeat(50));
                System.out.printf("%s - %s \t$%5.2f%n", item.getCategory().toUpperCase(), item.getName(), item.getTotalPrice());
            }
        }
        System.out.println("-".repeat(50));
    }
}
