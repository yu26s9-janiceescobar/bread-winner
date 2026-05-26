package com.pluralsight.business;
import com.pluralsight.models.MenuItem;
import com.pluralsight.models.PriceEntry;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class MenuCatalog {
    private final ArrayList<MenuItem> menuItems;
    private final ArrayList<PriceEntry> priceEntries;

    public MenuCatalog(ArrayList<MenuItem> menuItems, ArrayList<PriceEntry> priceEntries){
        this.menuItems = menuItems;
        this.priceEntries = priceEntries;
    }
    public ArrayList<MenuItem> getMenuItemByCategory(String category){
        return menuItems.stream()
                .filter(menuItem -> menuItem.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toCollection(ArrayList::new));
    }
    public ArrayList<PriceEntry> getPriceEntryByCategory(String category){
        return priceEntries.stream()
                .filter(priceEntry ->
                        priceEntry.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toCollection(ArrayList::new));
    }
    public double getPrice(MenuItem menuItem){
        return priceEntries.stream()
                .filter(priceEntry ->
                        priceEntry.getCategory().equalsIgnoreCase(category) && priceEntry.getSize().equalsIgnoreCase(size))
                .collect(Collectors.toCollection(ArrayList::new));
    }
    public ArrayList<MenuItem> getMenuItems() {
        return menuItems;
    }

    public ArrayList<PriceEntry> getPriceEntries() {
        return priceEntries;
    }



}
