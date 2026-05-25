package com.pluralsight.business;

import com.pluralsight.models.MenuItem;
import com.pluralsight.models.PriceEntry;

import java.util.ArrayList;
import java.util.stream.Collectors;

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
            if (size.equalsIgnoreCase(p.getSize()) && category.equalsIgnoreCase(p.getCategory())){
                return p.getPrice();
            }
        }
       throw new RuntimeException("Price not found.");
    }
    private String findCategory(String itemName){
        for (MenuItem m: menuItems){
            if (itemName.equalsIgnoreCase(m.getName())){
                return m.getCategory();
            }
        }
       throw new RuntimeException("Menu item not found.");
    }
    public ArrayList<MenuItem> getItemsByCategory(String category){
        return menuItems.stream()
                .filter(menuItem -> menuItem.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
