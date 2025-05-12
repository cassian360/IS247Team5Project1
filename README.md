# Finance Tracker Application

A comprehensive Java-based finance and expense tracking application that allows users to manage
their personal finances, track expenses, set budgets, and generate financial reports.

## Team Members

- Oseiwe Ohonsi
- Chesed Peabody
- Samantha
- Yash

## Project Overview

Finance Tracker is a console-based Java application designed to help users manage their personal
finances. The application provides a comprehensive solution for tracking income and expenses,
setting and monitoring budgets, and generating reports to analyze spending patterns.

## Features

- **Transaction Management**
  - Add income and expense transactions
  - Categorize transactions
  - View transaction history

- **Budget Management**
  - Set overall monthly budget
  - Set category-specific budgets
  - Track budget vs. actual spending

- **Financial Reports**
  - Income summary reports
  - Expense summary reports
  - Monthly overview reports
  - Financial statistics

- **User Management**
  - User profiles with basic information
  - User settings management

## Project Structure

```
FinanceTracker/
└── src/
    └── main/
        └── java/
            └── com/
                └── financetracker/
                    ├── Main.java                 # Application entry point
                    ├── model/                    # Data models
                    │   ├── Transaction.java      # Abstract base class
                    │   ├── Income.java           # Income transaction type
                    │   ├── Expense.java          # Expense transaction type
                    │   ├── User.java             # User profile
                    │   ├── Budget.java           # Budget implementation
                    │   └── SavingsGoal.java      # Savings goal implementation
                    ├── manager/                  # Management classes
                    │   ├── TransactionManager.java # Manages transactions
                    │   └── BudgetManager.java    # Manages budgets
                    ├── util/                     # Utility classes
                    │   ├── FinancialUtility.java # Financial calculations
                    │   └── ReportGenerator.java  # Generates reports
                    ├── interfaces/               # Interfaces
                    │   └── FinancialEntity.java  # Financial entity interface
                    └── exception/                # Custom exceptions
                        ├── InvalidAmountException.java
                        ├── InvalidCategoryException.java
                        └── InsufficientFundsException.java
```

## Java Concepts Implemented

This project demonstrates the following Java concepts:

1. Scanner Class - Used for user input 
2. Variables and Constants - Used throughout all classes
3. Switch Statements - Used in menu navigation
4. Conditional Operators - Used in logical operations
5. Multiple Classes - Project includes more than 5 classes
6. Inheritance - Transaction is the parent class for Income and Expense
7. Interfaces - FinancialEntity interface implemented by various classes
8. Abstract Classes - Transaction is an abstract class
9. Exceptions - Custom exceptions for handling errors
10. Recursion - Used in financial calculations
11. Method Overriding - toString() and other methods are overridden
12. Method Overloading - Multiple constructors with different parameters
13. ArrayList - Used to store collections of transactions
14. Stacks - Used for undo functionality
15. Map - Used to store category budgets and statistics
16. Constructors - Used in all classes
17. Super Keyword - Used in subclass constructors
18. Abstraction - Implemented through abstract classes and interfaces
19. Generics - Used in utility classes for flexible data handling
20. Encapsulation - Private fields with getter/setter methods
21. Java Library Classes - Date, Calendar, Random, etc.
22. Static Variables and Methods - Used for shared data and utility functions
23. This Keyword - Used in constructors and methods
24. Lists - Used for data collections
25. Println and Printf Methods - Used for console output
26. GitHub Projects - Code is organized for GitHub
27. JavaDoc - Comprehensive documentation
28. Code on GitHub - Available in this repository
29. UML Diagrams - Included in the documentation

## Setup and Running

### Compiling the Project

```bash
# Navigate to the src/main/java directory
cd src/main/java

# Compile the project
javac com/financetracker/Main.java
```

### Running the Application

```bash
# From the src/main/java directory
java com.financetracker.Main
```

## Generating JavaDocs

```bash
# Navigate to the src/main/java directory
cd src/main/java

# Generate JavaDoc
javadoc -d ../../docs/javadoc -sourcepath . com.financetracker com.financetracker.model com.financetracker.manager com.financetracker.util com.financetracker.interfaces com.financetracker.exception
```

## Usage Guide

1. **Starting the Application**
   - Run the Main class
   - Enter your name and email when prompted

2. **Adding Transactions**
   - Select "Add Transaction" from the main menu
   - Choose transaction type (Income or Expense)
   - Enter amount, description, and category

3. **Managing Budgets**
   - Select "Manage Budget" from the main menu
   - Set total budget amount
   - Allocate budget to specific categories

4. **Viewing Reports**
   - Select "View Reports" from the main menu
   - Choose report type (Income, Expense, or Monthly Overview)

## License

This project is licensed under the MIT License.
