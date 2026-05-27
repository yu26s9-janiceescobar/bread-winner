package com.pluralsight.business;
import com.pluralsight.models.OrderItem;

import java.util.ArrayList;

public class Order {
    private final ArrayList<OrderItem> order;
    public Order(){
        order = new ArrayList<>();
    }
    public void addToOrder(OrderItem item){
        order.add(item);
    }
    public void removeFromOrder(OrderItem item){
        order.remove(item);
    }
    public ArrayList<OrderItem> getOrder(){
        return order;
    }
    public double getTotalPrice(){
        double total = 0;
        for (OrderItem item: order){
             total += item.getPrice();
        }
        return total;
    }

}
