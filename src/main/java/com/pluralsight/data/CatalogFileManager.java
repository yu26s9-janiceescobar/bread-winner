package com.pluralsight.data;
import com.pluralsight.business.Catalog;
import com.pluralsight.models.CatalogItem;
import com.pluralsight.models.PriceEntry;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CatalogFileManager {
    private final String menuItemsFile;
    private final String menuPricesFile;

    public CatalogFileManager(String menuItemsFile, String menuPricesFile){
        this.menuItemsFile = menuItemsFile;
        this.menuPricesFile = menuPricesFile;
    }
    public Catalog getMenuCatalog(){
        ArrayList<CatalogItem> catalogItems = new ArrayList<>();
        ArrayList<PriceEntry> priceEntries = new ArrayList<>();
        try (
                BufferedReader bufferedReader = new BufferedReader(new FileReader(menuItemsFile));
                BufferedReader bufferedReader2 = new BufferedReader(new FileReader(menuPricesFile));

            ) {
            bufferedReader.readLine(); // skip first line
            bufferedReader2.readLine(); // skip first line


            String file1Line;
            String file2Line;

            while((file1Line = bufferedReader.readLine()) != null){
                if (!file1Line.isBlank()) {
                    catalogItems.add(makeMenuItemFromEncodedString(file1Line));
                }
            }
            while((file2Line = bufferedReader2.readLine()) != null){
                if (!file2Line.isBlank()) {
                    priceEntries.add(makePriceEntryFromEncodedString(file2Line));
                }
            }
            return new Catalog(catalogItems, priceEntries);
        }catch(IOException e){
            throw new RuntimeException("Trouble reading files.");
        }
    }

    private CatalogItem makeMenuItemFromEncodedString(String s){
        String[] line = s.split("\\|");
        String category = line[0];
        String name = line[1];

        return new CatalogItem(category, name);
    }
    private PriceEntry makePriceEntryFromEncodedString(String s){
        String[] line = s.split("\\|");
        String category = line[0];
        String size = line[1];
        double price = Double.parseDouble(line[2]);
        return new PriceEntry(category, size, price);
    }


}
