# SOEN-6011 (Eternity)
 
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

### Run JavaFX GUI Version (TanCalcGuiD2)
```bash
mvn javafx:run -DmainClass=com.example.sep.TanCalcGuiD2
```

## 🎯 Programming Style  

**Chosen Style:** Google Java Style  

Key Rules Implemented:  
- Indentation: 2 spaces  
- Method names in camelCase  
- Braces at the end of the line (`} else {`)  
- Maximum line length: 100 characters  

Reference:  
[Google Java Style](https://checkstyle.org/styleguides/google-java-style-20220203/javaguide.html)

File: [Programming Style Screenshot](https://github.com/JayanthApagundi/SOEN-6011/blob/main/SEP/Programming_Style.png)

## 🛠 Code Style Verification (Checkstyle)

**Tool Used:** [Maven Checkstyle Plugin](https://maven.apache.org/plugins/maven-checkstyle-plugin/) with **Google Java Style**, -This project uses **Checkstyle** with the **Google Java Style Guide** to ensure consistent coding standards.

**Execution Steps:**
1. Ensure Maven is installed and available in your environment.
2. From the project root, run PMD analysis:
   ```bash
   mvn checkstyle:checkstyle
   ```
3. After running, the HTML report can be found at:
   ```
   target/site/checkstyle.html
   ```

**Proof of Conformance:**
- [Initial Checkstyle Report (with warnings)](https://github.com/JayanthApagundi/SOEN-6011/blob/main/SEP/SEP_Checkstyle_Results_Before_2.pdf)
- [Final Checkstyle Report (no warnings)](https://github.com/JayanthApagundi/SOEN-6011/blob/main/SEP/SEP_Checkstyle_Results_After_2.pdf)

**Reference:**
[CheckStyle Guide](https://checkstyle.org/)

## 🐞 Debugging with JDB

**Debugger Used:** Java Debugger (**JDB**)  
**Reference:** [Official JDB Documentation](https://docs.oracle.com/javase/7/docs/technotes/tools/windows/jdb.html)  

As part of Deliverable 3, the project was debugged using **JDB** to validate runtime behavior, inspect variables, and step through execution flow for both **D1** (console-based) and **D2** (JavaFX GUI-based) implementations.  

### D1 Debugging (Console Application)
1. Compile with debugging information:  
   ```bash
   javac -g TanCalcD1.java Version.java
   ```
2. Start JDB and set a breakpoint:
   ```bash
   jdb com.example.sep.TanCalcD1 
   stop at com.example.sep.TanCalcD1:32 
   run
   ```
3. Inspect variables and step through code:
   ```bash
   print x
   step
   next
   cont
   ```
   
### D2 Debugging (GUI Application)
1. Compile with JavaFX module path:
   ```bash
   javac -g \
     --module-path ~/Downloads/javafx-sdk-24.0.2/lib \
     --add-modules javafx.controls,javafx.fxml \
     Version.java TrigCalculator.java TanCalcGuiD2.java TanLauncher.java
   ```
2. Start JDB for JavaFX application:
   ```bash
   jdb \
     -classpath out \
     -sourcepath src/main/java \
     -J--module-path -J"$HOME/Downloads/javafx-sdk-24.0.2/lib" \
     -J--add-modules -Jjavafx.controls,javafx.fxml \
     com.example.sep.TanLauncher
   ```
3. Set breakpoints in GUI logic:
   ```bash
   stop in com.example.sep.TanCalcGuiD2.start
   stop in com.example.sep.TrigCalculator.customTan
   run
   ```
**Snapshots:**
1. [D1- Console Application](https://github.com/JayanthApagundi/SOEN-6011/blob/main/SEP/JDB_SnapShot_D1.png)
2. [D2- GUI Application- 2.1](https://github.com/JayanthApagundi/SOEN-6011/blob/main/SEP/JDB_SnapShot_D2.1.png)
3. [D2- GUI Application- 2.2](https://github.com/JayanthApagundi/SOEN-6011/blob/main/SEP/JDB_SnapShot_D2.2.png)

## 🛠️ Static Code Analysis (PMD)

**Description:**  
The Maven PMD Plugin was used to scan both **main** and **test** Java files for potential code issues such as unused variables, empty catch blocks, and complexity violations.  
This integration ensures PMD runs automatically as part of the Maven build lifecycle, helping maintain consistent code quality.

**Execution Steps:**
1. Ensure Maven is installed and available in your environment.
2. From the project root, run PMD analysis:
   ```bash
   mvn pmd:check
   ```
   or to generate a full HTML report:
   ```bash
   mvn pmd:pmd
   ```
3. After running, the HTML report can be found at:
   ```
   target/site/pmd.html
   ```

**Proof:**  
- [PMD Results](https://github.com/JayanthApagundi/SOEN-6011/blob/main/SEP/SEP_PMD_Results.pdf) **0 violations**

**Reference:**  
[PMD Maven Plugin Documentation](https://maven.apache.org/plugins/maven-pmd-plugin/)

## ♿ Accessibility (Java Accessibility API / JavaFX)

**Reference:**  
[Java Accessibility API](https://docs.oracle.com/en/java/javase/21/access/java-accessibility-overview.html#GUID-17F9FD40-E191-41CE-BCF9-D956F1EF5111__JAVAACCESSIBILITYAPI-98866269)

**Changes Made(D2 – JavaFX):**
- Associated visible labels to controls (`Label#setLabelFor(Node)`) for proper screen reader semantics.
- Provided assistive descriptions via `setAccessibleText(...)` and `setAccessibleHelp(...)`.
- Enabled keyboard-first usage:
  - Logical tab order.
  - Mnemonic on the calculate button (`setMnemonicParsing(true)` with “_Calculate tan(x)”) so **Alt+C** activates it.
- Results area marked as **status** (`AccessibleRole.STATUS`) so screen readers announce updates.
- Clear, plain-language error messages (invalid number, missing unit, undefined tan).

**File:** [TanCalcGuiD2.java](https://github.com/JayanthApagundi/SOEN-6011/blob/main/SEP/src/main/java/com/example/sep/TanCalcGuiD2.java)

## 🧪 Unit Testing (JUnit 5)

**Test files:**
- `src/test/java/com/example/sep/TrigCalculatorTest.java`
  - Verifies `sin(π/2) ≈ 1`, `cos(0) ≈ 1`, `tan(π/4) ≈ 1`
  - Ensures `customTan(π/2)` throws `ArithmeticException`
- `src/test/java/com/example/sep/TanCalcD1Test.java`
  - Simulates stdin/stdout to test console flows:
    - Degrees vs. Radians
    - Undefined cases (cos(x) ≈ 0)
    - Invalid mode handling

**Run all tests:**
```bash
mvn -q test
```

**Run single test class:**
```bash
mvn -q -Dtest=TrigCalculatorTest test
```
or
```bash
mvn -q -Dtest=TanCalcD1Test test
```

**Style & quality:**
- Tests follow Google Java Style (checked by Checkstyle).
- No wildcard imports; methods documented with JavaDocs.
- PMD runs on test sources as part of the Maven reports.

**Troubleshooting:**
- If Maven warns about module path with JDK 22 during tests, ensure maven-surefire-plugin is set (e.g., useModulePath=false) in pom.xml.
- For flaky console I/O assertions, confirm locale/format (tests expect US-style decimals).

## 🎛️ User Interface Design Principles (GUI)

This project’s JavaFX GUI was designed to follow core user interface principles.  
Detailed rationale with statements, discussion, and examples from the code are included in the PDF and LaTeX sources.

**Proof:**
- [Adherence to User Interface Design Principles](https://github.com/JayanthApagundi/SOEN-6011/blob/main/SEP/User_Interface_Design_Principles/User_Interface_Design_Principles.pdf)

**Principles covered:**
- The Principle of **User Profiling**
- The Principle of **Humility**
- The Principle of **Metaphor**
- The Principle of **Feature Exposure**
- The Principle of **State Visualization**
- The Principle of **Coherence**
- The Principle of **Safety**


## 📜 License  
This project is for educational purposes as part of the **SOEN-6011** course at **Concordia University.** 
