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

## 🛠 Deliverable-3: Code Quality Enhancements & Standards Compliance  

**Description:**  
Deliverable 3 focuses on improving and standardizing the existing **Deliverable-1 (console)** and **Deliverable-2 (GUI)** codebases to comply with established programming standards, debugging practices, and static analysis requirements.  

**Key Improvements:**  
- Adopted **Google Java Style** across all source files  
- Added missing JavaDocs for classes and methods  
- Configured **Checkstyle** to scan both main and test files  
- Implemented **Semantic Versioning** in `Version.java`  
- Used **JUnit 5** for unit testing (both console and GUI components)  
- Applied **PMD** for static code analysis and resolved violations  
- Debugged applications using **JDB (Java Debugger)**
- Ensured GUI adheres to  User Interface Design Principles. 
- Ensured GUI accessibility compliance **(Java Accessibility API)** 

**Execution Steps:**  

### Run Console Version (TanCalcD1)  
```bash
mvn exec:java -Dexec.mainClass="com.example.sep.TanCalcD1"
```

###Run JavaFX GUI Version (TanCalcGuiD2)
```bash
mvn javafx:run -DmainClass=com.example.sep.TanCalcGuiD2
```

## 🎯 Programming Style  

Chosen Style: Google Java Style  

Key Rules Implemented:  
- Indentation: 2 spaces  
- Method names in camelCase  
- Braces at the end of the line (`} else {`)  
- Maximum line length: 100 characters  

Reference:  
[Google Java Style](https://checkstyle.org/styleguides/google-java-style-20220203/javaguide.html)

File: [Programming Style Screenshot](https://github.com/JayanthApagundi/SOEN-6011/blob/main/SEP/Programming_Style.png)

## 🛠 Code Style Verification (Checkstyle)

This project uses **Checkstyle** with the **Google Java Style Guide** to ensure consistent coding standards.

**Proof of Conformance:**
- [Initial Checkstyle Report (with warnings)](https://github.com/JayanthApagundi/SOEN-6011/blob/main/SEP/SEP_Checkstyle_Results_Before_2.pdf)
- [Final Checkstyle Report (no warnings)](https://github.com/JayanthApagundi/SOEN-6011/blob/main/SEP/SEP_Checkstyle_Results_After_2.pdf)

**Reference:**
[CheckStyle Guide](https://checkstyle.org/)



## 📜 License  
This project is for educational purposes as part of the **SOEN-6011** course at **Concordia University.** 
