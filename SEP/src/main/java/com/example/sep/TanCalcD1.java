/**
 * A console-based application to calculate the tangent of an angle.
 *
 * @version 1.0.0
 */

package com.example.sep;

import java.util.Scanner;

/**
 * A simple console-based Java application to calculate the tangent of an angle.
 *
 * <p>Supports user input in degrees or radians and handles undefined cases
 * (e.g., when tan(x) is not defined due to division by zero in cos(x)).
 */
public class TanCalcD1 {

  /**
   * Entry point for the TAN(x) calculator.
   *
   * <p>Prompts the user to input an angle and select whether it's in degrees or radians,
   * then computes tan(x) or reports if it's undefined.
   *
   * @param args command-line arguments (not used)
   */
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Calculator:TAN(x) v:" + Version.getVersion());
    System.out.print("Enter the angle (x): ");
    double x = scanner.nextDouble();

    System.out.print("Is the angle entered is in degrees or radians? (d/r): ");
    String mode = scanner.next();

    double angleInRadians;

    // Convert angle to radians based on mode
    if (mode.equalsIgnoreCase("d")) {
      angleInRadians = Math.toRadians(x);
    } else if (mode.equalsIgnoreCase("r")) {
      angleInRadians = x;
    } else {
      System.out.println("Invalid mode!!! Please enter 'd' for degrees or 'r' for radians.");
      scanner.close();
      return;
    }

    // Check if tan(x) is undefined due to cos(x) being 0
    double valueOfCos = Math.cos(angleInRadians);
    if (Math.abs(valueOfCos) < 1e-10) {
      System.out.println("Not Defined !!!");
    } else {
      double valueOfTan = Math.tan(angleInRadians);
      System.out.println("tan(" + x + ") = " + valueOfTan);
    }

    scanner.close();
  }
}
