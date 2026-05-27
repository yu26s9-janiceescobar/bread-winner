package com.pluralsight;
import com.pluralsight.ui.Console;
import com.pluralsight.ui.UserInterface;

public class Main {
    public static void main(String[] args){
        Console console = new Console();
        UserInterface userInterface = new UserInterface();
        userInterface.display(console);
    }
}
