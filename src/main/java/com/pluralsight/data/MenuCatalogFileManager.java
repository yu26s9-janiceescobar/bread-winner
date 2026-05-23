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
    private final String menuPricesFile;

    public MenuCatalogFileManager(String menuItemsFile, String menuPricesFile){
        this.menuItemsFile = menuItemsFile;
        this.menuPricesFile = menuPricesFile;
    }
    public MenuCatalog getCatalog(){
        ArrayList<MenuItem> menuItems = new ArrayList<>();
        ArrayList<PriceEntry> priceEntries = new ArrayList<>();
        try (
                BufferedReader bufferedReader = new BufferedReader(new FileReader(menuItemsFile));
                BufferedReader bufferedReader2 = new BufferedReader(new FileReader(menuPricesFile));
            ) {

            bufferedReader.readLine(); // skips first line.
            bufferedReader2.readLine();

            String file1Line;
            String file2Line;

            while((file1Line = bufferedReader.readLine()) != null){
                if (!file1Line.isBlank()) {
                    menuItems.add(getMenuItemFromEncodedString(file1Line));
                }
            }
            while((file2Line = bufferedReader2.readLine()) != null){
                if (!file2Line.isBlank()) {
                    priceEntries.add(getPriceEntryFromEncodedString(file2Line));
                }
            }
        }catch(IOException e){
            throw new RuntimeException("Trouble reading files.");
        }
        return new MenuCatalog(menuItems, priceEntries);
    }


    private MenuItem getMenuItemFromEncodedString(String s){
            String[] fileLine = s.split("\\|");
            String category = fileLine[0];
            String name =  fileLine[1];
            return new MenuItem(category, name);
    }
    private PriceEntry getPriceEntryFromEncodedString(String s){
            String[] fileLine = s.split("\\|");
            String category = fileLine[0];
            String name =  fileLine[1];
            double price = Double.parseDouble(fileLine[2]);
            return  new PriceEntry(category, name, price);
    }
}
