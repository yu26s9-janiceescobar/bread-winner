package com.pluralsight.ui;
import com.pluralsight.business.Order;
import com.pluralsight.models.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ReceiptFormatter {
    /**
     * Collects order information and formats it into a receipt format.
     * @param order the order with the menu items user has selected.
     * @return String containing formatted order summary.
     */
    public static String format(Order order, LocalDateTime dateTime){
        StringBuilder stringBuilder = new StringBuilder();
        List<OrderableItem> formattedOrder = new ArrayList<>(order.getOrder());
        formattedOrder.sort(Comparator.comparingInt(item -> item instanceof Sandwich ? 0 : 1));
        stringBuilder.append(String.format("%28s %n %26s %n %s %n %26s %n","Order Summary", "Bread Winner", "85 Broad Street, New York, NY 10004", "123-456-7890"));
        String fmt = dateTime.format(DateTimeFormatter.ofPattern("MMMM d, yyyy h:mm a"));
        stringBuilder.append(String.format("%30s %n", fmt ));
        stringBuilder.repeat("=", 50);

        for (OrderableItem item: formattedOrder){
            if (item instanceof Sandwich){
                Sandwich sandwich = (Sandwich) item;
                stringBuilder.append(String.format("%n%s - %s (%s - $ %.2f)%n\tBread: %s%n\tToasted: %s%n%n",
                        item.getCategory(),
                        item.getName(),
                        sandwich.getSize().getLabel(),
                        sandwich.getSize().getPrice(),
                        sandwich.getBread().getLabel(),
                        sandwich.isToasted() ? "Yes" : "No"));

                List<Topping> toppings = new ArrayList<>(sandwich.getToppings());
                toppings.sort(Comparator.comparing(Topping::getCategory) // sort categories together
                        .thenComparing(t -> t.isExtra() ? 1 : 0) // normal toppings before "extra" toppings.
                        .thenComparing(Topping::getName)); // sort topping alphabetically



                    String currentCategory = "";
                    for (Topping t : toppings) {
                        if (!t.getCategory().equals(currentCategory)) {
                            currentCategory = t.getCategory();
                            stringBuilder.append(String.format("%10s: %n", currentCategory.toUpperCase()));
                        }


                        stringBuilder.append(String.format("%10s %-25s %10s%n",
                               t.isExtra() ? "+ " : " ",
                               t.getName(),
                               t.getPrice(sandwich.getSize()) == 0 ? "FREE" : String.format("$ %.2f", t.getPrice(sandwich.getSize()))));
                    }
                    stringBuilder.repeat("-", 50);

            }
            if (item instanceof Chips || item instanceof Soda){

                stringBuilder.append(String.format("%n%-10s %n %-37s $ %.2f%n", item.getCategory().toUpperCase(), item.getName(), item.getTotalPrice()));
            }
        }
        stringBuilder.append(" \n");
        stringBuilder.repeat("-",50);
        stringBuilder.append(String.format("%n%-38s $ %,.2f %n", "TOTAL PRICE:",order.getTotalPrice()));
        return stringBuilder.toString();
    }

}
