package com.pluralsight;

import com.pluralsight.data.MenuCatalogFileManager;
import com.pluralsight.ui.UserInterface;

public class Main {
    public static void main(String[] args){
        MenuCatalogFileManager menuFileManager = new MenuCatalogFileManager("data/menuCatalog.csv", "data/priceModifier.csv", "data/storeInfo.csv");

    }
}
