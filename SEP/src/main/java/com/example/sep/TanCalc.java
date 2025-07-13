package com.example.sep;
import java.util.Scanner;

public class TanCalc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== CALCULATOR: TAN(x)  ===");
        System.out.print("Enter the angle (x): ");
        double x = scanner.nextDouble();

        System.out.print("Is the angle entered is in degrees or radians? (d/r): ");
        String mode = scanner.next();

        double angleInRadians;

        if (mode.equalsIgnoreCase("d")) {
            angleInRadians = Math.toRadians(x);
        } else if (mode.equalsIgnoreCase("r")) {
            angleInRadians = x;
        } else {
            System.out.println("Invalid mode!!! Please enter 'd' for degrees or 'r' for radians.");
            scanner.close();
            return;
        }

        // Check if tan(x) is undefined (e.g., 90°, 270°, etc.)
        double cosValue = Math.cos(angleInRadians);
        if (Math.abs(cosValue) < 1e-10) {
            System.out.println("Not Defined !!!");
        } else {
            double ValueOfTan = Math.tan(angleInRadians);
            System.out.println("tan(" + x + ") = " + ValueOfTan);
        }

        scanner.close();
    }
}
