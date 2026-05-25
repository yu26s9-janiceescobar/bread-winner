package com.pluralsight.data;

import com.pluralsight.business.MenuCatalog;
import com.pluralsight.models.MenuOption;

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
    public MenuCatalog getMenuCatalog(){
        MenuCatalog menuCatalog;
        ArrayList<String[]> menuRow = new ArrayList<>();
        ArrayList<String[]> priceRow = new ArrayList<>();
        try (
                BufferedReader bufferedReader = new BufferedReader(new FileReader(menuItemsFile));
                BufferedReader bufferedReader2 = new BufferedReader(new FileReader(menuPricesFile));

            ) {
            String[] menuCatalogInfo = bufferedReader.readLine().split("\\|");
            menuCatalog = new MenuCatalog(menuCatalogInfo[0]);
            bufferedReader2.readLine();


            String file1Line;
            String file2Line;

            while((file1Line = bufferedReader.readLine()) != null){
                if (!file1Line.isBlank()) {
                    menuRow.add(file1Line.split("\\|"));
                }
            }
            while((file2Line = bufferedReader2.readLine()) != null){
                if (!file2Line.isBlank()) {
                    priceRow.add(file2Line.split("\\|"));
                }
            }

            for (String[] item: menuRow){
                for(String[] price: priceRow){
                    String category = item[0];
                    String name = item[1];
                    if (item[0].equalsIgnoreCase(price[0])){
                        menuCatalog.addMenuItem(new MenuOption(
                                category,
                                name,
                                price[1],
                                Double.parseDouble(price[2])));
                    }
                }
            }
        }catch(IOException e){
            throw new RuntimeException("Trouble reading files.");
        }
        return menuCatalog;
    }



}
