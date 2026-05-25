package com.pluralsight;

import com.pluralsight.business.MenuCatalog;
import com.pluralsight.data.MenuCatalogFileManager;
import com.pluralsight.ui.Console;
import com.pluralsight.ui.UserInterface;

public class Main {
    public static void main(String[] args){
        MenuCatalogFileManager menuFileManager = new MenuCatalogFileManager("menuCatalog.csv", "priceModifier.csv");
        MenuCatalog menuCatalog = menuFileManager.getCatalog();
        Console console = new Console();
        // UserInterface userInterface = new UserInterface(console, menuCatalog);
    }
}
