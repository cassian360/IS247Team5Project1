package com.financetracker.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.financetracker.manager.TransactionManager;
import com.financetracker.model.Expense;
import com.financetracker.model.Income;
import com.financetracker.model.Transaction;

/**
 * Class for generating financial reports
 * Uses Java library classes (requirement 21)
 */
public class ReportGenerator {
    private TransactionManager transactionManager;
    
    // Using Java library class Random (requirement 21)
    private Random random = new Random();
    
    /**
     * Constructor for ReportGenerator
     * 
     * @param transactionManager TransactionManager to generate reports from
     */
    public ReportGenerator(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }
    
    /**
     * Generate income summary report
     */
    public void generateIncomeSummary() {
        System.out.println("\n===== INCOME SUMMARY REPORT =====");
        
        // Get total income
        double totalIncome = transactionManager.getTotalIncome();
        
        // Get income by category
        Map<String, Double> incomeByCategory = transactionManager.getIncomeByCategory();
        
        // Using Java library class Date and Calendar (requirement 21)
        Calendar calendar = Calendar.getInstance();
        Date currentDate = calendar.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        
        // Print report
        System.out.println("Date: " + dateFormat.format(currentDate));
        System.out.printf("Total Income: $%.2f\n\n", totalIncome);
        
        if (incomeByCategory.isEmpty()) {
            System.out.println("No income data available.");
            return;
        }
        
        System.out.println("Income by Category:");
        for (Map.Entry<String, Double> entry : incomeByCategory.entrySet()) {
            String category = entry.getKey();
            double amount = entry.getValue();
            double percentage = (amount / totalIncome) * 100;
            
            System.out.printf("- %s: $%.2f (%.1f%%)\n", category, amount, percentage);
        }
        
        // Display some statistics
        System.out.println("\nStatistics:");
        System.out.printf("- Average Income Per Transaction: $%.2f\n", 
                         calculateAverageIncomePerTransaction());
    }
    
    /**
     * Generate expense summary report
     */
    public void generateExpenseSummary() {
        System.out.println("\n===== EXPENSE SUMMARY REPORT =====");
        
        // Get total expenses
        double totalExpenses = transactionManager.getTotalExpenses();
        
        // Get expenses by category
        Map<String, Double> expensesByCategory = transactionManager.getExpensesByCategory();
        
        // Using Java library class Date and Calendar (requirement 21)
        Calendar calendar = Calendar.getInstance();
        Date currentDate = calendar.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        
        // Print report
        System.out.println("Date: " + dateFormat.format(currentDate));
        System.out.printf("Total Expenses: $%.2f\n\n", totalExpenses);
        
        if (expensesByCategory.isEmpty()) {
            System.out.println("No expense data available.");
            return;
        }
        
        System.out.println("Expenses by Category:");
        for (Map.Entry<String, Double> entry : expensesByCategory.entrySet()) {
            String category = entry.getKey();
            double amount = entry.getValue();
            double percentage = (amount / totalExpenses) * 100;
            
            System.out.printf("- %s: $%.2f (%.1f%%)\n", category, amount, percentage);
        }
        
        // Display some statistics
        System.out.println("\nStatistics:");
        System.out.printf("- Average Expense Per Transaction: $%.2f\n", 
                         calculateAverageExpensePerTransaction());
    }
    
    /**
     * Generate monthly overview report
     */
    public void generateMonthlyOverview() {
        System.out.println("\n===== MONTHLY OVERVIEW REPORT =====");
        
        // Get current date info
        Calendar calendar = Calendar.getInstance();
        int currentMonth = calendar.get(Calendar.MONTH);
        int currentYear = calendar.get(Calendar.YEAR);
        
        // Format month name
        SimpleDateFormat monthFormat = new SimpleDateFormat("MMMM yyyy");
        Date currentDate = calendar.getTime();
        
        // Print report header
        System.out.println("Month: " + monthFormat.format(currentDate));
        
        // Calculate start and end dates for the month
        Calendar startCal = Calendar.getInstance();
        startCal.set(currentYear, currentMonth, 1, 0, 0, 0);
        Date startDate = startCal.getTime();
        
        Calendar endCal = Calendar.getInstance();
        endCal.set(currentYear, currentMonth, endCal.getActualMaximum(Calendar.DAY_OF_MONTH), 23, 59, 59);
        Date endDate = endCal.getTime();
        
        // Get transactions for this month
        List<Transaction> monthlyTransactions = 
            transactionManager.getTransactionsByDateRange(startDate, endDate);
        
        // Calculate totals
        double monthlyIncome = 0.0;
        double monthlyExpenses = 0.0;
        
        for (Transaction t : monthlyTransactions) {
            if (t instanceof Income) {
                monthlyIncome += t.getAmount();
            } else if (t instanceof Expense) {
                monthlyExpenses += t.getAmount();
            }
        }
        
        double monthlyBalance = monthlyIncome - monthlyExpenses;
        
        // Print summary
        System.out.printf("Total Income: $%.2f\n", monthlyIncome);
        System.out.printf("Total Expenses: $%.2f\n", monthlyExpenses);
        System.out.printf("Balance: $%.2f\n", monthlyBalance);
        
        // Estimate trend
        System.out.println("\nMonthly Analysis:");
        if (monthlyBalance > 0) {
            System.out.println("- You saved money this month! Great job!");
            // Using factorial recursion for savings calculation (requirement 10)
            double savingsPotential = calculateSavingsPotential(5);
            System.out.printf("- If you maintain this saving rate, you could save approximately $%.2f in 5 months.\n", 
                             savingsPotential);
        } else {
            System.out.println("- You spent more than you earned this month.");
            System.out.println("- Consider reviewing your budget to reduce expenses.");
        }
        
        // Provide a random financial tip
        System.out.println("\nFinancial Tip: " + getRandomFinancialTip());
    }
    
    /**
     * Calculate average income per transaction
     * 
     * @return Average income amount
     */
    private double calculateAverageIncomePerTransaction() {
        List<Transaction> incomes = transactionManager.getTransactionsByType("Income");
        
        if (incomes.isEmpty()) {
            return 0.0;
        }
        
        double total = 0.0;
        for (Transaction t : incomes) {
            total += t.getAmount();
        }
        
        return total / incomes.size();
    }
    
    /**
     * Calculate average expense per transaction
     * 
     * @return Average expense amount
     */
    private double calculateAverageExpensePerTransaction() {
        List<Transaction> expenses = transactionManager.getTransactionsByFilter(t -> t instanceof Expense);
        
        if (expenses.isEmpty()) {
            return 0.0;
        }
        
        double total = 0.0;
        for (Transaction t : expenses) {
            total += t.getAmount();
        }
        
        return total / expenses.size();
    }
    
    /**
     * Calculate potential savings based on current rate
     * Uses recursion (requirement 10)
     * 
     * @param months Number of months
     * @return Potential savings amount
     */
    private double calculateSavingsPotential(int months) {
        // Base case
        if (months <= 0) {
            return 0;
        }
        
        // Get current month's balance
        Calendar calendar = Calendar.getInstance();
        int currentMonth = calendar.get(Calendar.MONTH);
        int currentYear = calendar.get(Calendar.YEAR);
        
        Calendar startCal = Calendar.getInstance();
        startCal.set(currentYear, currentMonth, 1, 0, 0, 0);
        Date startDate = startCal.getTime();
        
        Calendar endCal = Calendar.getInstance();
        endCal.set(currentYear, currentMonth, endCal.getActualMaximum(Calendar.DAY_OF_MONTH), 23, 59, 59);
        Date endDate = endCal.getTime();
        
        List<Transaction> monthlyTransactions = 
            transactionManager.getTransactionsByDateRange(startDate, endDate);
        
        double monthlyIncome = 0.0;
        double monthlyExpenses = 0.0;
        
        for (Transaction t : monthlyTransactions) {
            if (t instanceof Income) {
                monthlyIncome += t.getAmount();
            } else if (t instanceof Expense) {
                monthlyExpenses += t.getAmount();
            }
        }
        
        double monthlyBalance = monthlyIncome - monthlyExpenses;
        
        // Recursive case - this month's savings plus future months
        return monthlyBalance + calculateSavingsPotential(months - 1);
    }
    
    /**
     * Get a random financial tip
     * Uses Java Random class (requirement 21)
     * 
     * @return Random financial tip
     */
    private String getRandomFinancialTip() {
        String[] tips = {
            "Try the 50/30/20 rule: 50% needs, 30% wants, 20% savings.",
            "Set up automatic transfers to your savings account.",
            "Review your subscriptions and cancel unused ones.",
            "Use cashback credit cards for regular purchases.",
            "Cook at home more often to save on food expenses.",
            "Consider investing in low-cost index funds for long-term growth.",
            "Build an emergency fund covering 3-6 months of expenses.",
            "Track every expense to identify spending patterns.",
            "Compare prices before making major purchases.",
            "Negotiate bills like insurance and internet regularly."
        };
        
        return tips[random.nextInt(tips.length)];
    }
}