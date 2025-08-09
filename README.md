# SOEN-6011  
**SEP – Project/Deliverables**  
**Author:** Jayanth Apagundi  
*Concordia University*   

---

## 📌 Project Overview  
This repository contains all deliverables for the **SOEN-6011 – Software Engineering Process** course project.  
The project implements **Tangent Function Calculation** (`tan(x)`) in multiple phases, covering both **console** and **GUI** versions, following software engineering principles such as coding standards, version control, semantic versioning, accessibility, and UI design principles.

---

## 📂 Repository Structure  
```
SOEN-6011/
│
├── Deliverable-1/     # Console-based TAN(x) Calculator (D1)
│   └── TanCalc.java
│
├── Deliverable-2/     # JavaFX GUI-based TAN(x) Calculator (D2)
│   └── TanCalcGUI.java
│
├── SEP/               # D3- Modifications from D1/D2
│
└── README.md          # Project documentation
```

---

## 📦 Deliverable-1: Console TAN(x) Calculator  

**Description:**  
A simple console-based application to compute `tan(x)` for a given angle, with unit selection (degrees/radians) and error handling for undefined values.  

**Execution Steps:**  
1. Open a terminal and navigate to the `Deliverable-1` directory:  
   ```bash
   cd Deliverable-1
   ```
2. Compile the Java file:  
   ```bash
   javac TanCalc.java
   ```
3. Run the application:  
   ```bash
   java TanCalc
   ```

---

## 🎨 Deliverable-2: JavaFX TAN(x) Calculator  

**Description:**  
A GUI-based application using **JavaFX** to compute `tan(x)`. Includes:  
- Dropdown for unit selection (Degrees/Radians)  
- Input validation and error messages  
- Accessibility support  
- Semantic versioning  

**Prerequisites:**  
- **JavaFX SDK** installed.  
- For this setup, JavaFX SDK is located at:  
  ```
  ~/Downloads/javafx-sdk-24.0.2
  ```

**Execution Steps:**  
1. Open a terminal and navigate to the `Deliverable-2` directory:  
   ```bash
   cd Deliverable-2
   ```
2. Compile the JavaFX application:  
   ```bash
   javac --module-path ~/Downloads/javafx-sdk-24.0.2/lib \
         --add-modules javafx.controls,javafx.fxml \
         TanCalcGUI.java
   ```
3. Run the application:  
   ```bash
   java --module-path ~/Downloads/javafx-sdk-24.0.2/lib \
        --add-modules javafx.controls,javafx.fxml \
        TanCalcGUI
   ```

---

## 📜 License  
This project is for educational purposes as part of the **SOEN-6011** course at **Concordia University.** 
