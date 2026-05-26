package com.pluralsight;
import com.pluralsight.business.Catalog;
import com.pluralsight.business.Store;
import com.pluralsight.data.CatalogFileManager;
import com.pluralsight.data.StoreFileManager;
import com.pluralsight.ui.Console;
import com.pluralsight.ui.UserInterface;

public class Main {
    public static void main(String[] args){
        CatalogFileManager menuFileManager = new CatalogFileManager("data/menuCatalog.csv", "data/priceModifier.csv");
        Catalog catalog = menuFileManager.getMenuCatalog();

        StoreFileManager storeFileManager = new StoreFileManager("data/storeInfo.csv");
        Store store = storeFileManager.createStore();
        store.addMenuCatalog(catalog);

        Console console = new Console();

        UserInterface userInterface = new UserInterface();
        userInterface.display(store, console);

    }
}
