package com.example.sep;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for the {@link TrigCalculator} class.
 *
 * <p>This test suite verifies the correctness of trigonometric functions:
 * sine, cosine, and tangent, including edge cases where the tangent function
 * is undefined (division by zero in cosine).</p>
 */
public class TrigCalculatorTest {

  /** Instance of {@link TrigCalculator} to run tests against. */
  private TrigCalculator calculator;

  /**
   * Initializes a new {@link TrigCalculator} before each test.
   */
  @BeforeEach
  public void setUp() {
    calculator = new TrigCalculator();
  }

  /**
   * Tests that {@link TrigCalculator#sin(double)} returns approximately 1.0
   * for an input of π/2 radians.
   */
  @Test
  public void testSin() {
    assertEquals(1.0, calculator.sin(Math.PI / 2), 0.01);
  }

  /**
   * Tests that {@link TrigCalculator#cos(double)} returns approximately 1.0
   * for an input of 0 radians.
   */
  @Test
  public void testCos() {
    assertEquals(1.0, calculator.cos(0), 0.01);
  }

  /**
   * Tests that {@link TrigCalculator#customTan(double)} returns approximately 1.0
   * for an input of π/4 radians.
   */
  @Test
  public void testTanValid() {
    assertEquals(1.0, calculator.customTan(Math.PI / 4), 0.01);
  }

  /**
   * Tests that {@link TrigCalculator#customTan(double)} throws an
   * {@link ArithmeticException} when given π/2 radians, where tangent
   * is mathematically undefined.
   */
  @Test
  public void testTanUndefined() {
    assertThrows(ArithmeticException.class, () -> calculator.customTan(Math.PI / 2));
  }
}
