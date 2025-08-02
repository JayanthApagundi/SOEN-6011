package com.example.sep;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class TanCalcGUI extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    // Convert degrees to radians
    private double toRadians(double degrees) {
        return degrees * Math.PI / 180;
    }

    // Custom factorial function
    private double factorial(int n) {
        double result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    // Custom sin(x) using Taylor Series
    private double sin(double x) {
        double sum = 0;
        for (int i = 0; i < 10; i++) {
            int sign = (i % 2 == 0) ? 1 : -1;
            sum += sign * Math.pow(x, 2 * i + 1) / factorial(2 * i + 1);
        }
        return sum;
    }

    // Custom cos(x) using Taylor Series
    private double cos(double x) {
        double sum = 0;
        for (int i = 0; i < 10; i++) {
            int sign = (i % 2 == 0) ? 1 : -1;
            sum += sign * Math.pow(x, 2 * i) / factorial(2 * i);
        }
        return sum;
    }

    // Custom tan(x) using sin(x)/cos(x)
    private double customTan(double x) throws ArithmeticException {
        double cosVal = cos(x);
        if (Math.abs(cosVal) < 1e-10) {
            throw new ArithmeticException("tan(x) is undefined at this angle (cos(x) = 0)");
        }
        return sin(x) / cosVal;
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("TAN(x) CALCULATOR");

        // Input field
        TextField angleInput = new TextField();
        angleInput.setPromptText("Enter angle (x)");

        // Dropdown for unit selection
        ComboBox<String> unitBox = new ComboBox<>();
        unitBox.getItems().addAll("Degrees", "Radians");
        unitBox.setPromptText("Select Unit");

        // Button to calculate
        Button calculateBtn = new Button("Calculate tan(x)");

        // Label to show result
        Label resultLabel = new Label();

        // Handle calculation
        calculateBtn.setOnAction(e -> {
            try {
                double inputAngle = Double.parseDouble(angleInput.getText());
                String unit = unitBox.getValue();

                if (unit == null) {
                    resultLabel.setText("Please select a unit (Degrees or Radians).");
                    return;
                }

                double angleInRadians = unit.equals("Degrees") ? toRadians(inputAngle) : inputAngle;
                double tanVal = customTan(angleInRadians);
                resultLabel.setText(String.format("tan(%.4f) = %.6f", inputAngle, tanVal));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Invalid input! Please enter a valid number.");
            } catch (ArithmeticException ex) {
                resultLabel.setText("Error: " + ex.getMessage());
            } catch (Exception ex) {
                resultLabel.setText("Unexpected error occurred.");
            }
        });

        // Layout
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(
                new Label("TAN(x) CALCULATOR"),
                angleInput,
                unitBox,
                calculateBtn,
                resultLabel
        );

        Scene scene = new Scene(layout, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
