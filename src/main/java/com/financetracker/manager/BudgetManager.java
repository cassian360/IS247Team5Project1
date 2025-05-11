import java.util.HashMap;
import java.util.Map;

/**
 * Class for managing user budgets
 */
public class BudgetManager {
    private double totalBudget;
    
    // Map to store category budgets (requirement 15)
    private Map<String, Double> categoryBudgets;
    
    /**
     * Constructor for BudgetManager
     */
    public BudgetManager() {
        this.totalBudget = 0.0;
        this.categoryBudgets = new HashMap<>();
    }
    
    /**
     * Set total budget
     * 
     * @param amount Budget amount
     */
    public void setTotalBudget(double amount) {
        this.totalBudget = amount;
    }
    
    /**
     * Get total budget
     * 
     * @return Total budget amount
     */
    public double getTotalBudget() {
        return totalBudget;
    }
    
    /**
     * Set budget for specific category
     * 
     * @param category Category name
     * @param amount Budget amount
     */
    public void setCategoryBudget(String category, double amount) {
        categoryBudgets.put(category, amount);
    }
    
    /**
     * Get budget for specific category
     * 
     * @param category Category name
     * @return Budget amount for category
     */
    public double getCategoryBudget(String category) {
        return categoryBudgets.getOrDefault(category, 0.0);
    }
    
    /**
     * Get all category budgets
     * 
     * @return Map of all category budgets
     */
    public Map<String, Double> getAllCategoryBudgets() {
        return new HashMap<>(categoryBudgets);
    }
    
    /**
     * Calculate remaining budget after expenses
     * 
     * @param expensesByCategory Map of expenses by category
     * @return Remaining budget by category
     */
    public Map<String, Double> getRemainingBudgets(Map<String, Double> expensesByCategory) {
        Map<String, Double> remainingBudgets = new HashMap<>();
        
        // First, add all category budgets to the result
        for (Map.Entry<String, Double> entry : categoryBudgets.entrySet()) {
            remainingBudgets.put(entry.getKey(), entry.getValue());
        }
        
        // Subtract expenses from corresponding budgets
        for (Map.Entry<String, Double> entry : expensesByCategory.entrySet()) {
            String category = entry.getKey();
            double expense = entry.getValue();
            double budget = remainingBudgets.getOrDefault(category, 0.0);
            remainingBudgets.put(category, budget - expense);
        }
        
        return remainingBudgets;
    }
    
    /**
     * Calculate total remaining budget
     * 
     * @param totalExpenses Total expenses
     * @return Remaining budget
     */
    public double getRemainingTotalBudget(double totalExpenses) {
        return totalBudget - totalExpenses;
    }
    
    /**
     * Check if a category is over budget
     * 
     * @param category Category to check
     * @param expense Current expense in that category
     * @return true if over budget, false otherwise
     */
    public boolean isOverBudget(String category, double expense) {
        double budget = getCategoryBudget(category);
        return expense > budget && budget > 0;
    }
    
    /**
     * Display budget summary
     */
    public void displayBudgetSummary() {
        // Print using printf (requirement 25)
        System.out.printf("Total Budget: $%.2f\n", totalBudget);
        
        if (categoryBudgets.isEmpty()) {
            System.out.println("No category budgets set.");
            return;
        }
        
        System.out.println("\nCategory Budgets:");
        for (Map.Entry<String, Double> entry : categoryBudgets.entrySet()) {
            System.out.printf("- %s: $%.2f\n", entry.getKey(), entry.getValue());
        }
    }
}
