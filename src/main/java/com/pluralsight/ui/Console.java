package com.pluralsight.ui;

import java.util.Scanner;

public class Console {
    private final Scanner scanner;
    public Console(){
        scanner = new Scanner(System.in);
    }

    public String promptForString(String prompt){
        System.out.println(prompt);
        return scanner.nextLine().strip();
    }

}
