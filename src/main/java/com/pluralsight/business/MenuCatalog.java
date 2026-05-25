package com.pluralsight.business;
import com.pluralsight.models.MenuItem;
import com.pluralsight.models.PriceEntry;

import java.util.ArrayList;

public class MenuCatalog {
    private final ArrayList<MenuItem> menuItems;
    private final ArrayList<PriceEntry> priceEntries;

    public MenuCatalog(ArrayList<MenuItem> menuItems, ArrayList<PriceEntry> priceEntries){
        this.menuItems = menuItems;
        this.priceEntries = priceEntries;
    }

    public ArrayList<MenuItem> getMenuItems() {
        return menuItems;
    }

    public ArrayList<PriceEntry> getPriceEntries() {
        return priceEntries;
    }



}
