package com.pluralsight;
import java.util.Scanner;

public class RentalCarCalculator {
    static Scanner scanner = new Scanner(System.in);
    static String pickupDate;
    static byte numDaysToRent;
    static boolean tollTag;
    static boolean gps;
    static boolean roadsideAssistance;
    static byte age;

    static double basicCarRental;
    static double totalOptionsCost;
    static double underageCost;
    static double totalPrice;

    public static void main(String[] args) {
        askUser();
        calcTotal();
        printReceipt();
    }
    static void askUser() {
        System.out.print("Welcome to Rent-a-Wreck!\nEnter pickup date:\n>>> "); pickupDate = scanner.nextLine();
        System.out.print("How many days will you be renting with us?\n>>> "); numDaysToRent = scanner.nextByte();
        System.out.print("Would you like an electronic toll tag at $3.95/day? (y/n)\n>>> ");
        String scanToll = scanner.nextLine(); scanner.nextLine();
        tollTag = (scanToll.equalsIgnoreCase("y") || scanToll.equalsIgnoreCase("yes")) ?
                true : false;
        System.out.print("Would you like a GPS at $2.95/day? (y/n)\n>>> ");
        String scanGps = scanner.nextLine();
        gps = (scanGps.equalsIgnoreCase("y") || scanGps.equalsIgnoreCase("yes")) ?
                true : false;
        System.out.print("Would you like roadside assistance at $3.95/day? (y/n\n>>> ");
        String scanRoadside = scanner.nextLine();
        roadsideAssistance = (scanRoadside.equalsIgnoreCase("y") || scanRoadside.equalsIgnoreCase("yes")) ?
                true : false;
        System.out.print("Enter your age:\n>>> "); age = scanner.nextByte();

    }
    static void calcTotal() {
        basicCarRental = 29.99 * numDaysToRent;
        totalOptionsCost += tollTag            ? 3.95 * numDaysToRent : 0;
        totalOptionsCost += gps                ? 2.95 * numDaysToRent : 0;
        totalOptionsCost += roadsideAssistance ? 3.95 * numDaysToRent : 0;
        underageCost     += age < 25           ? basicCarRental * .3  : 0;
        totalPrice = basicCarRental + totalOptionsCost + underageCost;
    }
    static void printReceipt() {
        System.out.printf("""
                ------Receipt------
                 Rent      $%.2f
                 Options   $%.2f%s
                 Total:    $%.2f
                ------------------""",
                basicCarRental,
                totalOptionsCost,
                age < 25 ? "\n Underage  $" + underageCost : "",
                totalPrice);
    }
}