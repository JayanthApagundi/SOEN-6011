package com.example.sep;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for the console-based TAN(x) calculator {@link TanCalcD1}.
 *
 * <p>These tests simulate stdin/stdout to verify expected console behavior without
 * requiring manual input.
 */
public class TanCalcD1Test {

  private PrintStream originalOut;
  private ByteArrayOutputStream testOut;
  private java.io.InputStream originalIn;

  @BeforeEach
  void setUp() {
    originalOut = System.out;
    originalIn = System.in;
    testOut = new ByteArrayOutputStream();
    System.setOut(new PrintStream(testOut));
  }

  @AfterEach
  void tearDown() {
    System.setOut(originalOut);
    System.setIn(originalIn);
  }

  /**
   * Helper to run the main method with a given "user input" and return all console output.
   *
   * @param simulatedInput lines to feed to stdin (use \n between responses)
   * @return captured stdout as a String
   */
  private String runWithInput(String simulatedInput) {
    System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
    TanCalcD1.main(new String[0]);
    return testOut.toString();
  }

  @Test
  void computesTanInDegrees_45deg_isApproximatelyOne() {
    // 45 degrees, choose degrees mode ('d')
    String out = runWithInput("45\n" + "d\n");

    // Should contain a tan(45.0) line and be close to 1.0
    assertTrue(out.contains("tan(45.0)"), "Output should mention tan(45.0)");

    // Extract numeric value printed after '=' and assert it's ~ 1.0
    double printed = extractLastNumber(out);
    assertEquals(1.0, printed, 1e-2, "tan(45°) should be ~1.0");
  }

  @Test
  void computesTanInRadians_piOver4_isApproximatelyOne() {
    // pi/4 in radians, choose radians mode ('r')
    String out = runWithInput(Math.PI / 4 + "\n" + "r\n");

    assertTrue(out.contains("tan("), "Output should contain a tan(x) line");
    double printed = extractLastNumber(out);
    assertEquals(1.0, printed, 1e-2, "tan(pi/4) should be ~1.0");
  }

  @Test
  void reportsUndefined_whenCosineIsZero_like90deg() {
    // 90 degrees, choose degrees mode ('d') -> tan undefined
    String out = runWithInput("90\n" + "d\n");

    assertTrue(out.contains("Not Defined"),
        "Should inform the user that tan(x) is undefined for this angle");
  }

  @Test
  void rejectsInvalidMode() {
    // Invalid mode 'x' should trigger the invalid mode message
    String out = runWithInput("10\n" + "x\n");

    assertTrue(out.contains("Invalid mode"),
        "Should warn user to enter 'd' for degrees or 'r' for radians");
  }

  /**
   * Extracts the last floating-point number from the captured output.
   * This lets us assert approximate values without depending on exact formatting.
   */
  private static double extractLastNumber(String output) {
    Pattern p = Pattern.compile("([-+]?[0-9]*\\.?[0-9]+([eE][-+]?[0-9]+)?)");
    Matcher m = p.matcher(output);
    double last = Double.NaN;
    while (m.find()) {
      try {
        last = Double.parseDouble(m.group(1));
      } catch (NumberFormatException ignore) {
        // keep scanning
      }
    }
    return last;
  }
}
