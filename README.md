# 💰 Finance Tracker – Java Console Application

A comprehensive command-line Java application to manage personal finances. Track income and expenses, set category-based budgets, and generate insightful financial reports — all with robust object-oriented design and modern Java features.

---

## 👥 Team Members

* Oseiwe Ohonsi
* Chesed Peabody
* Samantha Morehead
* Yash Phogat

---

## 📚 Table of Contents

* [Overview](#-overview)
* [Features](#-features)
* [Technology Stack](#-technology-stack)
* [Project Structure](#-project-structure)
* [Installation](#-installation)
* [Usage](#-usage)
* [Java Concepts Demonstrated](#-java-concepts-demonstrated)
* [UML Diagram](#-uml-diagram)
* [Code Walkthrough Highlights](#-code-walkthrough-highlights)
* [Contributing](#-contributing)
* [License](#-license)

---

## 📌 Overview

**Finance Tracker** is a Java-based console application that provides tools for managing personal finances. It offers structured ways to record transactions, enforce budgets, and generate monthly financial insights. Ideal for students or anyone looking to build better financial habits using Java fundamentals.

---

## 🚀 Features

### ✅ Transaction Management

* Add income and expense entries
* Categorize transactions
* View detailed transaction history

### ✅ Budget Management

* Set overall monthly and category-specific budgets
* Monitor actual spending vs. budget

### ✅ Financial Reporting

* Income and expense summaries
* Monthly overviews with key metrics
* Simple financial statistics

### ✅ User Management

* User profiles with basic info
* Manage individual user settings

---

## 🛠️ Technology Stack

* **Language:** Java 11+
* **Architecture:** Object-Oriented Programming (OOP)
* **Interface:** Command-Line Interface (CLI)
* **Build Tool:** Manual (Javac) or Maven (optional)
* **Version Control:** Git + GitHub

---

## 📁 Project Structure

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

---

## ⚙️ Installation

### Using Terminal

1. Clone the repository:

   ```bash
   git clone https://github.com/yourusername/FinanceTracker.git
   cd FinanceTracker
   ```

2. Compile the application:

   ```bash
   javac -d bin src/main/java/com/financetracker/Main.java
   ```

3. Run the application:

   ```bash
   java -cp bin com.financetracker.Main
   ```

> ⚠️ Make sure you're using Java 11 or newer.

---

## 🧪 Usage

1. **Starting the Application**

   * Run the Main class
   * Enter your name and email when prompted

2. **Adding Transactions**

   * Select "Add Transaction" from the main menu
   * Choose transaction type (Income or Expense)
   * Enter amount, description, and category

3. **Managing Budgets**

   * Select "Manage Budget" from the main menu
   * Set total budget amount
   * Allocate budget to specific categories

4. **Viewing Reports**

   * Select "View Reports" from the main menu
   * Choose report type (Income, Expense, or Monthly Overview)

---

## 🧠 Java Concepts Demonstrated

This application fulfills a robust list of core Java and OOP principles:

| ✅ Concept             | 💡 Description                              |
| --------------------- | ------------------------------------------- |
| Scanner Class         | For all CLI user input                      |
| Variables & Constants | Throughout all modules                      |
| Switch Statements     | Menu-driven navigation                      |
| Conditional Operators | Logical decisions                           |
| Multiple Classes      | >5 interlinked classes                      |
| Inheritance           | `Income` and `Expense` extend `Transaction` |
| Interfaces            | `FinancialEntity` interface                 |
| Abstract Classes      | `Transaction` base class                    |
| Exceptions            | Custom exception handling                   |
| Recursion             | Used in select utility logic                |
| Method Overriding     | `toString()`, custom behavior               |
| Method Overloading    | Multiple constructors                       |
| ArrayList             | Used to store user data and transactions    |
| Stack                 | Undo feature for transactions               |
| Map                   | Budget per category and report metrics      |
| Constructors          | Parameterized and default                   |
| Super Keyword         | In subclass constructors                    |
| Abstraction           | Clean APIs via abstract/interface use       |
| Generics              | Utility classes with flexible types         |
| Encapsulation         | Private fields + getters/setters            |
| Java Libraries        | `Date`, `Calendar`, `Random`, etc.          |
| Static Methods        | Utility and constants                       |
| This Keyword          | Used in constructors and logic              |
| Lists                 | `ArrayList`, `List` interface               |
| Println / Printf      | Console output formatting                   |
| GitHub Integration    | Source-controlled via Git                   |
| JavaDoc               | Full documentation in `/docs/javadoc/`      |

---

## 📊 UML Diagram

Below is a simplified UML class diagram showcasing the application's core architecture:

---

## 🎯 Code Walkthrough Highlights

* **Transaction** is an abstract class that forms the base for both `Income` and `Expense`.
* **Manager package** centralizes all transaction-related logic and uses `ArrayList` and `Stack` for management and undo capabilities.
* **Interfaces and custom exceptions** keep the design clean, flexible, and robust.

Explore each class from `src/main/java/com/financetracker/` to see Java best practices in action.

---

## 🤝 Contributing

Want to make this project better?

1. Fork the repository
2. Create a feature branch: `git checkout -b your-feature`
3. Commit your changes: `git commit -m "Added feature"`
4. Push the branch: `git push origin your-feature`
5. Submit a Pull Request 🚀

---

## 📄 License

This project is licensed under the **MIT License**. See the [LICENSE](LICENSE) file for more information.

---
