## Project Title
Payroll Management System

## Problem Statement (max 150 words)
Manual payroll calculation is time-consuming and error-prone. This system automates salary calculation for different types of employees efficiently.

## Target User
- Add employee details
- Calculate salary automatically
- Supports full-time and part-time employees

## Core Features
- Add employee details
- Calculate salary automatically
- Supports full-time and part-time employees

## OOP Concepts Used
- Abstraction
- Inheritance
- Polymorphism

## Proposed Architecture Description
The system follows an Object-Oriented architecture where a base class "Employee" defines common attributes like id and name, along with an abstract method calculateSalary().

Two subclasses extend this base class:
- FullTimeEmployee: calculates salary based on fixed monthly salary
- PartTimeEmployee: calculates salary based on hourly rate and hours worked

The application uses polymorphism to call the appropriate calculateSalary() method at runtime depending on the employee type.

A GUI (Graphical User Interface) is implemented using Java Swing, allowing users to input employee details and view salary results.

Overall flow:
User Input (GUI) → Create Employee Object → Salary Calculation → Display Output

## How to Run
1. Open Command Prompt or Terminal
2. Navigate to the project directory

3. Compile the Java files:
   javac payroll/*.java

4. Run the main class:
   java payroll.PayrollGUI

5. The GUI window will open
6. Enter employee details and calculate salary
