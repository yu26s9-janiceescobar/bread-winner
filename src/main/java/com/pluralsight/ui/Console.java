package com.pluralsight.ui;

import java.util.Scanner;

public class Console {
    private final Scanner scanner;
    public Console(){
        scanner = new Scanner(System.in);
    }
    public int promptForIntOptions(String prompt, int ... options){
        while(true) {
            int userInput = promptForInt(prompt);
            for (int option : options) {
                if (userInput == option) {
                    return userInput;
                }
            }
            System.out.println("Must enter a valid option.");
        }
    }
    public String promptForString(String prompt){
        System.out.print(prompt);
        return scanner.nextLine().strip();
    }
    public int promptForInt(String prompt){
        while(true) {
            try {
                String userInput = promptForString(prompt);
                return Integer.parseInt(userInput);
            }catch(NumberFormatException e){
                System.out.println("Must enter a number.");
            }
        }
    }

    public String promptForStringOptions(String prompt, String ...options){
        while(true) {
            String userInput = promptForString(prompt);
            for (String option : options) {
                if (userInput.equalsIgnoreCase(option)) {
                    return option;
                }
            }
            System.out.println("Must Enter a Valid Option.");
        }
    }
    public boolean promptForYesNo(String prompt){
        String userInput = promptForStringOptions(prompt, "y", "n");
        return userInput.equalsIgnoreCase("y");

    }
    public int promptForIntRange(String prompt, int min, int max){
        while(true){
            int parseIntInput = promptForInt(prompt);
            if (parseIntInput >= min && parseIntInput <= max){
                return parseIntInput;
            }
            System.out.println("Must Enter an option above.");
        }
    }


}
