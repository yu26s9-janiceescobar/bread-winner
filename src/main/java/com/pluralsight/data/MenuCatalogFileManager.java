package com.pluralsight.data;

import com.pluralsight.business.MenuCatalog;
import com.pluralsight.business.MenuItem;
import com.pluralsight.business.PriceEntry;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MenuCatalogFileManager {
    private final String menuItemsFile;
    private final String menuItemPricesFile;
    private final ArrayList<MenuItem> menuItems;
    private final ArrayList<PriceEntry> priceEntries;

    public MenuCatalogFileManager(String menuItemsFile, String menuItemPricesFile){
        this.menuItemsFile = menuItemsFile;
        this.menuItemPricesFile = menuItemPricesFile;
        menuItems = new ArrayList<>();
        priceEntries = new ArrayList<>();
    }
    public MenuCatalog getCatalog(){
        
    }

    private ArrayList<MenuItem> getMenuItemsFromEncodedString(){
        try{
            FileReader fileReader = new FileReader(menuItemsFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            bufferedReader.readLine(); // skips first line.

            String line;

            while((line = bufferedReader.readLine()) != null){
                if (!line.isBlank()) {
                    String[] fileLine = line.split("\\|");
                    String category = fileLine[0];
                    String name =  fileLine[1];
                    MenuItem menuItem = new MenuItem(category, name);
                    menuItems.add(menuItem);
                }
            }
            bufferedReader.close();
        }catch(IOException e){
            throw new RuntimeException("Trouble reading file.");
        }
        return menuItems;
    }
    private ArrayList<PriceEntry> getPriceEntriesFromEncodedString(){
        try{
            FileReader fileReader = new FileReader(menuItemPricesFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            bufferedReader.readLine(); // skips first line.

            String line;

            while((line = bufferedReader.readLine()) != null){
                if (!line.isBlank()) {
                    String[] fileLine = line.split("\\|");
                    String category = fileLine[0];
                    String name =  fileLine[1];
                    double price = Double.parseDouble(fileLine[2]);
                    PriceEntry priceEntry = new PriceEntry(category, name, price);
                    priceEntries.add(priceEntry);
                }
            }
            bufferedReader.close();
        }catch(IOException e){
            throw new RuntimeException("Trouble reading file.");
        }
        return priceEntries;
    }
}
