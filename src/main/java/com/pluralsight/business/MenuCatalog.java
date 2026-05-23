package com.pluralsight.business;

import java.util.ArrayList;

public class MenuCatalog {
    private final MenuItem menuItem;
    private final PriceEntry priceEntry;
    private final ArrayList<MenuItem> menuCatalog;
    public MenuCatalog(MenuItem menuItem, PriceEntry priceEntry, ArrayList<MenuItem> menuCatalog){
        this.menuItem = menuItem;
        this.priceEntry = priceEntry;
        this.menuCatalog = menuCatalog;
    }

}
