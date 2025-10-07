# 🎓 Grade Calculator & Student Management System

A simple **Object-Oriented Java application** for managing student information and calculating course grades.  
This project demonstrates core Java concepts such as **inheritance, encapsulation, object composition, and user input handling**.

---

## 📁 Project Structure

├── Course.java
├── GradeCalculator.java
├── Main.java
├── Person.java
└── Student.java

markdown
Copy code

### File Descriptions

- **`Person.java`** – Base class representing a person, containing shared attributes (e.g., name, ID).  
- **`Student.java`** – Subclass of `Person`, representing a student with enrolled courses and grade information.  
- **`Course.java`** – Models a course, including course code, title, and grade components.  
- **`GradeCalculator.java`** – Contains logic for calculating weighted averages or final grades based on assignments, exams, etc.  
- **`Main.java`** – The entry point of the program. Handles user input/output and integrates all classes.

---

## 🧠 Features

- Add and manage student information  
- Assign students to multiple courses  
- Calculate final grades using weighted components  
- Display results in a clean, formatted output  
- Built using core Java OOP principles  

---

## ⚙️ How to Run

### Prerequisites
- Java 8 or newer installed on your system  
- A terminal or IDE (e.g., IntelliJ, Eclipse, VS Code)

### Steps
1. Clone this repository:
   ```bash
   git clone https://github.com/yourusername/grade-calculator.git
   ```
2. Navigate to the project directory:
```bash
cd grade-calculator
```
3. Compile all Java files:
```bash
javac *.java
```
4. Run the main class:
```bash
java Main
```
