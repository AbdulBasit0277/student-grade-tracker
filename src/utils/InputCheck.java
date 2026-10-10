package utils;

import java.util.Scanner;

public class InputCheck {

    public static int readInt(Scanner sc, String message) {
        while (true) {
            System.out.print(message);
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a whole number between 0 and 4.");
            }
        }
    }

    public static String readText(Scanner sc, String message) {
        while (true){
            System.out.print(message);
            String input = sc.nextLine().trim();
            if (input.isEmpty()){
                System.out.println("This field can not be empty.");
                continue;
            }
            return input;
        }
    }

    public static double readScore(Scanner sc, String message) {
        while (true) {
            System.out.print(message);
            try {
                double value = Double.parseDouble(sc.nextLine().trim());
                if (value >= 0 && value <= 100) {
                    return value;
                }
                System.out.println("Score must be between 0 and 100.");
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }
}
