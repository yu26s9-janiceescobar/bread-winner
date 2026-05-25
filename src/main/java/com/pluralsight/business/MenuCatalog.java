package com.pluralsight.business;

import com.pluralsight.models.MenuItem;
import com.pluralsight.models.PriceEntry;

import java.util.ArrayList;
import java.util.List;
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
    public List<MenuItem> getItemsByCategory(String category){
        return menuItems.stream()
                .filter(menuItem -> menuItem.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toCollection(ArrayList::new));
    }
    public List<PriceEntry> getPricesByCategory(String category){
        return priceEntries.stream()
                .filter(priceEntry -> priceEntry.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toCollection(ArrayList::new));
    }
    public double getPriceBySize(MenuItem menuItem, String size){
        for (PriceEntry p: priceEntries){
            if (p.getCategory().equalsIgnoreCase(menuItem.getCategory()) && p.getSize().equalsIgnoreCase(size)){
               return p.getPrice();
            }
        }
        return 0;
    }


}
