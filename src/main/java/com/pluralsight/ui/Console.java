package com.pluralsight.ui;

import java.util.Scanner;

public class Console {
    private final Scanner scanner;

    /**
     * Creates Scanner
     */
    public Console(){
        scanner = new Scanner(System.in);
    }
//    public int promptForIntOptions(String prompt, int ... options){
//        while(true) {
//            int userInput = promptForInt(prompt);
//            for (int option : options) {
//                if (userInput == option) {
//                    return userInput;
//                }
//            }
//            System.out.println("Must enter a valid option.");
//        }
//    }

    /**
     * Prompts user for a string.
     * @param prompt the message displayed to the user.
     * @return the String user entered.
     */
    public String promptForString(String prompt){
        System.out.print(prompt);
        return scanner.nextLine().strip();
    }

    /**
     * Prompts user for an integer.
     * @param prompt the message displayed to the user.
     * @return the integer the user entered.
     */
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

    /**
     * Prompts the user to enter one of the options displayed.
     * @param prompt the message displayed to the user.
     * @param options the options available for user to select from.
     * @return String the option user entered.
     */
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

    /**
     * Prompts the user to enter y or n.
     * @param prompt the message displayed to the user.
     * @return boolean returns true if user entered y, false if n is entered.
     */
    public boolean promptForYesNo(String prompt){
        String userInput = promptForStringOptions(prompt, "y", "n");
        return userInput.equalsIgnoreCase("y");

    }

    /**
     * Propmts the user to enter an integer within a range of numbers.
     * @param prompt the message displayed to the user.
     * @param min the minimum integer input accepted.
     * @param max the maximum integer input accepted.
     * @return the integer user selected.
     */
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
