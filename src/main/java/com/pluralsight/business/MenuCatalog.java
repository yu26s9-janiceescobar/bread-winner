package com.pluralsight.business;

import com.pluralsight.models.ItemName;
import com.pluralsight.models.OrderItem;
import com.pluralsight.models.PriceEntry;

import java.util.ArrayList;


public class MenuCatalog {
    private String name;
    private ArrayList<OrderItem> menuCatalog;

    public MenuCatalog(String name){
        this.name = name;

    }

    public void addEntry(String category, String name, String size, double price){

    }
//    public List<MenuItem> getItemsByCategory(String category){
//        return menuItems.stream()
//                .filter(menuItem -> menuItem.getCategory().equalsIgnoreCase(category))
//                .collect(Collectors.toCollection(ArrayList::new));
//    }
//
//    public List<PriceEntry> getPricesByCategory(String category){
//        return priceEntries.stream()
//                .filter(priceEntry -> priceEntry.getCategory().equalsIgnoreCase(category))
//                .collect(Collectors.toCollection(ArrayList::new));
//    }
//    public List<PriceEntry> getPricesByCategory(String category, String size){
//        return priceEntries.stream()
//                .filter(priceEntry ->
//                        priceEntry.getCategory().equalsIgnoreCase(category) && priceEntry.getSize().equalsIgnoreCase(size))
//                .collect(Collectors.toCollection(ArrayList::new));
//    }


    public double getPriceBySize(ItemName menuItem, String size){
        for (PriceEntry p: priceEntries){
            if (p.getCategory().equalsIgnoreCase(menuItem.getCategory()) && p.getSize().equalsIgnoreCase(size)){
               return p.getPrice();
            }
        }
        return 0;
    }



}
