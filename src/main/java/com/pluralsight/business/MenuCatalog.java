package com.pluralsight.business;

import com.pluralsight.models.MenuItem;
import com.pluralsight.models.PriceEntry;

import java.util.ArrayList;
//category + name) = MenuItem
//(category + size) = price
public class MenuCatalog {
    private final ArrayList<MenuItem> menuItems;
    private final ArrayList<PriceEntry> priceEntries;

    public MenuCatalog(ArrayList<MenuItem> menuItems, ArrayList<PriceEntry> priceEntries){
        this.menuItems = menuItems;
        this.priceEntries = priceEntries;
    }
    public double findPrice(String name, String size){
        String category = findCategory(name);
        for (PriceEntry p: priceEntries ){
            if (p.getSize().equalsIgnoreCase(size) && p.getCategory().equalsIgnoreCase(category)){
                return p.getPrice();
            }
        }
       throw new RuntimeException("Price not found.");
    }
    private String findCategory(String itemName){
        for (MenuItem m: menuItems){
            if (m.getName().equalsIgnoreCase(itemName)){
                return m.getCategory();
            }
        }
       throw new RuntimeException("Menu item not found.");
    }
}
