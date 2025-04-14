package com.example.financetracker; // Main package

// Import only classes from *outside* this package
import java.time.LocalDate;
import java.time.YearMonth;

/**
 * Main application entry point to demonstrate the ExpenseTracker.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("--- Welcome to Simple Finance Tracker ---");

        // Current date/time provided: Monday, April 14, 2025 at 4:10:50 PM EDT
        // Let's use April 2025 for our example data
        LocalDate today = LocalDate.of(2025, 4, 14);
        YearMonth currentMonth = YearMonth.from(today);

        ExpenseTracker tracker = new ExpenseTracker();

        try {
            System.out.println("\n--- Setting up Budgets ---");
            tracker.setBudget("Groceries", 350.00);
            tracker.setBudget("Transport", 100.00);
            tracker.setBudget("Dining Out", 150.00);
            tracker.setBudget("Rent", 1400.00); // Rent category created automatically

            System.out.println("\n--- Logging Transactions for " + currentMonth + " ---");
            // Use the simplified addTransaction method
            tracker.addTransaction(today.withDayOfMonth(1), "Monthly Salary", 4500.00, TransactionType.INCOME, "Salary");
            tracker.addTransaction(today.withDayOfMonth(1), "Rent Payment", 1400.00, TransactionType.EXPENSE, "Rent");
            tracker.addTransaction(today.withDayOfMonth(3), "Grocery Store Trip", 85.50, TransactionType.EXPENSE, "Groceries");
            tracker.addTransaction(today.withDayOfMonth(5), "Gas Bill", 65.00, TransactionType.EXPENSE, "Utilities"); // Category created
            tracker.addTransaction(today.withDayOfMonth(7), "Bus Pass", 50.00, TransactionType.EXPENSE, "Transport");
            tracker.addTransaction(today.withDayOfMonth(10), "Dinner with Friends", 60.00, TransactionType.EXPENSE, "Dining Out");
            tracker.addTransaction(today.withDayOfMonth(12), "More Groceries", 42.30, TransactionType.EXPENSE, "Groceries");
            tracker.addTransaction(today.withDayOfMonth(14), "Coffee Shop", 5.75, TransactionType.EXPENSE, "Dining Out"); // Add today's transaction

            // Demonstrate Undo
            System.out.println("\n--- Testing Undo ---");
            tracker.undoLastTransaction(); // Undoes the "Coffee Shop" transaction
            tracker.undoLastTransaction(); // Undoes the "More Groceries" transaction

            // Re-add one transaction
            System.out.println("\n--- Re-adding a Transaction ---");
             tracker.addTransaction(today.withDayOfMonth(12), "Grocery Top-up", 40.10, TransactionType.EXPENSE, "Groceries");


            // Add transaction for previous month (to show filtering)
             tracker.addTransaction(today.minusMonths(1).withDayOfMonth(25), "Old Expense", 99.00, TransactionType.EXPENSE, "Miscellaneous");


            // --- Generate Report for the Current Month ---
            tracker.generateMonthlyReport(currentMonth);

            // --- Generate Report for Previous Month ---
            tracker.generateMonthlyReport(currentMonth.minusMonths(1));

            // --- Display Final State (Optional) ---
            System.out.println("\n--- Final List of Categories ---");
            tracker.getCategories().forEach(cat -> System.out.println("- " + cat.getName()));

            System.out.println("\n--- Final List of Budgets ---");
            tracker.getBudgets().forEach(System.out::println);


        } catch (TrackerException e) {
            System.err.println("Operation Error: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            // Catch validation errors from Category constructor etc.
            System.err.println("Input Error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
            e.printStackTrace();
        }

        System.out.println("\n--- Finance Tracker Demo Finished ---");
    }
}
