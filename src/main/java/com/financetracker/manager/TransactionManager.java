import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.function.Predicate;

/**
 * Class for managing user transactions
 * Uses ArrayList and Stack data structures
 */
public class TransactionManager {
    // ArrayList for storing transactions (requirement 13)
    private ArrayList<Transaction> transactions;
    
    // Stack for undo functionality (requirement 14)
    private Stack<Transaction> recentlyDeletedTransactions;
    
    /**
     * Constructor for TransactionManager
     */
    public TransactionManager() {
        this.transactions = new ArrayList<>();
        this.recentlyDeletedTransactions = new Stack<>();
    }
    
    /**
     * Add a transaction to the list
     * 
     * @param transaction Transaction to add
     */
    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }
    
    /**
     * Remove a transaction by ID
     * 
     * @param transactionId ID of transaction to remove
     * @return true if successful, false otherwise
     */
    public boolean removeTransaction(int transactionId) {
        for (int i = 0; i < transactions.size(); i++) {
            if (transactions.get(i).getId() == transactionId) {
                // Push to undo stack before removing
                recentlyDeletedTransactions.push(transactions.get(i));
                transactions.remove(i);
                return true;
            }
        }
        return false;
    }
    
    /**
     * Undo the most recent transaction deletion
     * Uses Stack data structure (requirement 14)
     * 
     * @return true if successful, false if no transaction to restore
     */
    public boolean undoDelete() {
        if (recentlyDeletedTransactions.isEmpty()) {
            return false;
        }
        
        Transaction transaction = recentlyDeletedTransactions.pop();
        transactions.add(transaction);
        return true;
    }
    
    /**
     * Get all transactions
     * 
     * @return List of all transactions
     */
    public List<Transaction> getAllTransactions() {
        return new ArrayList<>(transactions);
    }
    
    /**
     * Get transactions by type
     * 
     * @param type Transaction type (Income or Expense)
     * @return List of matching transactions
     */
    public List<Transaction> getTransactionsByType(String type) {
        List<Transaction> result = new ArrayList<>();
        
        for (Transaction t : transactions) {
            if (t.getType().equals(type)) {
                result.add(t);
            }
        }
        
        return result;
    }
    
    /**
     * Get transactions by category
     * 
     * @param category Transaction category
     * @return List of matching transactions
     */
    public List<Transaction> getTransactionsByCategory(String category) {
        List<Transaction> result = new ArrayList<>();
        
        for (Transaction t : transactions) {
            if (t.getCategory().equals(category)) {
                result.add(t);
            }
        }
        
        return result;
    }
    
    /**
     * Get transactions by custom filter
     * Uses Predicate (functional interface)
     * 
     * @param filter Predicate for filtering transactions
     * @return List of matching transactions
     */
    public List<Transaction> getTransactionsByFilter(Predicate<Transaction> filter) {
        List<Transaction> result = new ArrayList<>();
        
        for (Transaction t : transactions) {
            if (filter.test(t)) {
                result.add(t);
            }
        }
        
        return result;
    }
    
    /**
     * Get transactions by date range
     * 
     * @param startDate Start date
     * @param endDate End date
     * @return List of matching transactions
     */
    public List<Transaction> getTransactionsByDateRange(Date startDate, Date endDate) {
        return getTransactionsByFilter(t -> 
            !t.getDate().before(startDate) && !t.getDate().after(endDate)
        );
    }
    
    /**
     * Calculate total balance (income - expenses)
     * 
     * @return Current balance
     */
    public double getBalance() {
        double balance = 0.0;
        
        for (Transaction t : transactions) {
            balance += t.getSignedAmount();
        }
        
        return balance;
    }
    
    /**
     * Get total income
     * 
     * @return Total income amount
     */
    public double getTotalIncome() {
        double total = 0.0;
        
        for (Transaction t : transactions) {
            if (t instanceof Income) {
                total += t.getAmount();
            }
        }
        
        return total;
    }
    
    /**
     * Get total expenses
     * 
     * @return Total expense amount
     */
    public double getTotalExpenses() {
        double total = 0.0;
        
        for (Transaction t : transactions) {
            if (t instanceof Expense) {
                total += t.getAmount();
            }
        }
        
        return total;
    }
    
    /**
     * Get expenses grouped by category
     * Uses Map data structure (requirement 15)
     * 
     * @return Map of category to total amount
     */
    public Map<String, Double> getExpensesByCategory() {
        Map<String, Double> categoryMap = new HashMap<>();
        
        for (Transaction t : transactions) {
            if (t instanceof Expense) {
                String category = t.getCategory();
                Double currentAmount = categoryMap.getOrDefault(category, 0.0);
                categoryMap.put(category, currentAmount + t.getAmount());
            }
        }
        
        return categoryMap;
    }
    
    /**
     * Get income grouped by category
     * Uses Map data structure (requirement 15)
     * 
     * @return Map of category to total amount
     */
    public Map<String, Double> getIncomeByCategory() {
        Map<String, Double> categoryMap = new HashMap<>();
        
        for (Transaction t : transactions) {
            if (t instanceof Income) {
                String category = t.getCategory();
                Double currentAmount = categoryMap.getOrDefault(category, 0.0);
                categoryMap.put(category, currentAmount + t.getAmount());
            }
        }
        
        return categoryMap;
    }
    
    /**
     * Display all transactions
     */
    public void displayAllTransactions() {
        if (transactions.isEmpty()) {
            System.out.println("No transactions to display.");
            return;
        }
        
        for (Transaction t : transactions) {
            System.out.println(t);
        }
        
        // Print summary using printf (requirement 25)
        System.out.printf("\nSummary: %d transactions, Balance: $%.2f\n", 
                          transactions.size(), getBalance());
    }
