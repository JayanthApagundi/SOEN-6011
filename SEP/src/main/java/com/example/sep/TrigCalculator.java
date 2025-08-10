/**
 * A Helper code for determining the tangent of an angle.
 *
 * @version 1.0.0
 */

package com.example.sep;

/**
 * Utility class for trigonometric calculations using Taylor series.
 */
public class TrigCalculator {

  /**
   * Converts an angle from degrees to radians.
   *
   * @param degrees the angle in degrees
   * @return the angle in radians
   */
  double toRadians(double degrees) {
    return degrees * Math.PI / 180;
  }

  /**
   * Calculates the factorial of a given non-negative integer.
   *
   * @param n the integer to calculate factorial of
   * @return the factorial as a double
   */
  private double factorial(int n) {
    double result = 1;
    for (int i = 2; i <= n; i++) {
      result *= i;
    }
    return result;
  }

  /**
   * Computes the sine of x (in radians) using the first 10 terms of the Taylor series.
   *
   * @param x the angle in radians
   * @return the sine of x
   */
  double sin(double x) {
    double sum = 0;
    for (int i = 0; i < 10; i++) {
      int sign = (i % 2 == 0) ? 1 : -1;
      sum += sign * Math.pow(x, 2 * i + 1) / factorial(2 * i + 1);
    }
    return sum;
  }

  /**
   * Computes the cosine of x (in radians) using the first 10 terms of the Taylor series.
   *
   * @param x the angle in radians
   * @return the cosine of x
   */
  double cos(double x) {
    double sum = 0;
    for (int i = 0; i < 10; i++) {
      int sign = (i % 2 == 0) ? 1 : -1;
      sum += sign * Math.pow(x, 2 * i) / factorial(2 * i);
    }
    return sum;
  }

  /**
   * Computes the tangent of x using sin(x)/cos(x).
   *
   * @param x the angle in radians
   * @return the tangent of x
   * @throws ArithmeticException if cos(x) is too close to zero
   */
  double customTan(double x) throws ArithmeticException {
    double cosVal = cos(x);
    if (Math.abs(cosVal) < 1e-10) {
      throw new ArithmeticException("tan(x) is undefined at this angle (cos(x) = 0)");
    }
    return sin(x) / cosVal;
  }
}
