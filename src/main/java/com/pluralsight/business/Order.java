package com.pluralsight.business;
import com.pluralsight.models.OrderableItem;

import java.util.ArrayList;

public class Order {
    private final ArrayList<OrderableItem> order;
    public Order(){
        order = new ArrayList<>();
    }
    public void addToOrder(OrderableItem item){
        order.add(item);
    }
    public void removeFromOrder(OrderableItem item){
        order.remove(item);
    }
    public ArrayList<OrderableItem> getOrder(){
        return order;
    }
    public double getTotalPrice(){
        double total = 0;
        for (OrderableItem item: order){
             total += item.getPrice();
        }
        return total;
    }

}
