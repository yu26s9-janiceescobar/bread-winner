package com.pluralsight.ui;

import com.pluralsight.business.Order;
import com.pluralsight.models.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ReceiptFormatter {
    public static String format(Order order){
        StringBuilder stringBuilder = new StringBuilder();
        List<OrderableItem> formattedOrder = new ArrayList<>(order.getOrder());
        formattedOrder.sort(Comparator.comparingInt(item -> item instanceof Sandwich ? 0 : 1));
        stringBuilder.append(String.format("%27s %n %25s %n %s %n %25s %n","Order Summary", "Bread Winner", "85 Broad Street, New York, NY 10004", "123-456-7890"));
        stringBuilder.repeat("=", 50);

        for (OrderableItem item: formattedOrder){
            if (item instanceof Sandwich){
                Sandwich sandwich = (Sandwich) item;
                stringBuilder.append(String.format("%n%s - %s (%s)%n\tBread: %s%nToasted: %s%n%n",
                        item.getCategory(),
                        item.getName(),
                        sandwich.getSize().getLabel(),
                        sandwich.getBread().getLabel(),
                        sandwich.isToasted() ? "Yes" : "No"));

                List<Topping> toppings = new ArrayList<>(sandwich.getAllToppings());
                toppings.sort(Comparator.comparing(Topping::getCategory) // sort categories together
                        .thenComparing(t -> t.getName().startsWith("Extra") ? 1 : 0) // normal toppings before "extra" toppings.
                        .thenComparing(Topping::getName)); // sort topping alphabetically



                    String currentCategory = "";
                    for (Topping t : toppings) {
                        if (!t.getCategory().equals(currentCategory)) {
                            currentCategory = t.getCategory();
                            stringBuilder.append(String.format("%10s: %n", currentCategory.toUpperCase()));
                        }
                        boolean isExtra = t.getName().startsWith("Extra");
                        double price = isExtra ? t.getExtraPrice(sandwich.getSize()) : t.getPrice(sandwich.getSize());
                        stringBuilder.append(String.format("%10s %-25s %10s%n",
                               isExtra ? "+ " : " ",
                               t.getName(),
                               price == 0 ? "FREE" : String.format("$ %.2f", price)));
                    }
                    stringBuilder.repeat("-", 50);

            }
            if (item instanceof Chips || item instanceof Soda){

                stringBuilder.append(String.format("%n%-10s %n %-37s $ %.2f%n", item.getCategory().toUpperCase(), item.getName(), item.getTotalPrice()));
            }
        }
        stringBuilder.repeat("-",50);
        stringBuilder.append(String.format("%n%-38s $ %,.2f %n", "TOTAL PRICE:",order.getTotalPrice()));
        return stringBuilder.toString();
    }
}
