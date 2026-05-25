package com.pluralsight.business;
import com.pluralsight.models.MenuOption;

import java.util.ArrayList;

public class MenuCatalog {
    private String name;
    private ArrayList<MenuOption> menuCatalog;

    public MenuCatalog(String name){
        this.name = name;
        menuCatalog = new ArrayList<>();
    }
    public void addMenuItem(MenuOption menuOption){
        menuCatalog.add(menuOption);
    }
    public void removeMenuItem(MenuOption menuOption){
        menuCatalog.remove(menuOption);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<MenuOption> getMenuCatalog() {
        return menuCatalog;
    }

    public void setMenuCatalog(ArrayList<MenuOption> menuCatalog) {
        this.menuCatalog = menuCatalog;
    }



}
