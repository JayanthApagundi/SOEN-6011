/**
 * A GUI-based application to calculate the tangent of an angle.
 *
 * @version 1.0.0
 */

package com.example.sep;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * A simple JavaFX-based GUI application to compute the tangent of a given angle
 * using Taylor series approximation for sin(x) and cos(x).
 * Users can input an angle in either degrees or radians, and the result will be
 * displayed using custom implementations of trigonometric functions.
 *
 * <p>This GUI follows semantic versioning and includes accessibility support
 * using Java Accessibility API techniques such as tooltips and accessible text.
 */
public class TanCalcGuiD2 extends Application {

  /** Instance of TrigCalculator to perform trigonometric calculations. */
  private final TrigCalculator calculator = new TrigCalculator();

  /**
   * Launches the JavaFX application.
   *
   * @param args command-line arguments (not used)
   */
  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {
    primaryStage.setTitle("TAN(x) CALCULATOR v" + Version.getVersion());

    TextField angleInput = new TextField();
    angleInput.setPromptText("Enter angle (x)");
    angleInput.setAccessibleText("Input field for angle in degrees or radians");
    angleInput.setTooltip(new Tooltip("Enter the angle to calculate tan(x)"));

    ComboBox<String> unitBox = new ComboBox<>();
    unitBox.getItems().addAll("Degrees", "Radians");
    unitBox.setPromptText("Select Unit");
    unitBox.setAccessibleText("Dropdown to select Degrees or Radians");
    unitBox.setTooltip(new Tooltip("Choose angle unit: Degrees or Radians"));

    Button calculateBtn = new Button("Calculate tan(x)");
    calculateBtn.setAccessibleText("Button to calculate tangent");
    calculateBtn.setTooltip(new Tooltip("Click to calculate tan(x) using Taylor Series"));

    Label resultLabel = new Label();
    resultLabel.setAccessibleText("Displays the result of tangent calculation");

    Label versionLabel = new Label("Version: " + Version.getVersion());
    versionLabel.setAccessibleText("Version information");

    calculateBtn.setOnAction(e -> {
      try {
        double inputAngle = Double.parseDouble(angleInput.getText());
        String unit = unitBox.getValue();

        if (unit == null) {
          resultLabel.setText("Please select a unit (Degrees or Radians).");
          return;
        }

        double angleInRadians = unit.equals("Degrees")
            ? calculator.toRadians(inputAngle)
            : inputAngle;

        double tanVal = calculator.customTan(angleInRadians);
        resultLabel.setText(String.format("tan(%.4f) = %.6f", inputAngle, tanVal));

      } catch (NumberFormatException ex) {
        resultLabel.setText("Invalid input! Please enter a valid number.");
      } catch (ArithmeticException ex) {
        resultLabel.setText("Error: " + ex.getMessage());
      } catch (Exception ex) {
        resultLabel.setText("Unexpected error occurred.");
      }
    });

    Label heading = new Label("TAN(x) CALCULATOR");

    VBox layout = new VBox(10);
    layout.setPadding(new Insets(20));
    layout.getChildren().addAll(
        heading, angleInput, unitBox, calculateBtn, resultLabel);

    Scene scene = new Scene(layout, 300, 250);
    primaryStage.setScene(scene);
    primaryStage.show();
  }
}
