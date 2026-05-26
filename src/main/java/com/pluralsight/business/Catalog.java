package com.pluralsight.business;
import com.pluralsight.models.CatalogItem;
import com.pluralsight.models.PriceEntry;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Catalog {
    private final ArrayList<CatalogItem> catalogItems;
    private final ArrayList<PriceEntry> priceEntries;

    public Catalog(ArrayList<CatalogItem> catalogItems, ArrayList<PriceEntry> priceEntries){
        this.catalogItems = catalogItems;
        this.priceEntries = priceEntries;
    }
    public ArrayList<CatalogItem> getMenuItemByCategory(String category){
        return catalogItems.stream()
                .filter(catalogItem -> catalogItem.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toCollection(ArrayList::new));
    }
    public ArrayList<PriceEntry> getPriceEntryByCategory(String category){
        return priceEntries.stream()
                .filter(priceEntry ->
                        priceEntry.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toCollection(ArrayList::new));
    }
    public double getPrice(String category, String size){
        for (PriceEntry p: priceEntries){
            if (p.getCategory().equalsIgnoreCase(category) && p.getSize().equalsIgnoreCase(size)){
                return p.getPrice();
            }
        }
        return 0;
    }
    public ArrayList<CatalogItem> getMenuItems() {
        return catalogItems;
    }

    public ArrayList<PriceEntry> getPriceEntries() {
        return priceEntries;
    }



}
