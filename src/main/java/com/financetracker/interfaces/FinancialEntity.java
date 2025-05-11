// FinancialEntity.java - Interface
/**
 * Interface for financial entities
 * (requirement 7 - Interface)
 */
public interface FinancialEntity {
    /**
     * Get name of the entity
     * 
     * @return Entity name
     */
    String getName();
    
    /**
     * Get description of the entity
     * 
     * @return Entity description
     */
    String getDescription();
    
    /**
     * Get amount associated with the entity
     * 
     * @return Associated amount
     */
    double getAmount();
    
    /**
     * Check if entity affects balance
     * 
     * @return True if affects balance, false otherwise
     */
    boolean affectsBalance();
}

// Implementers of the interface
/**
 * Budget implementation of FinancialEntity interface
 */
class Budget implements FinancialEntity {
    private String name;
    private String description;
    private double amount;
    
    /**
     * Constructor for Budget
     * 
     * @param name Budget name
     * @param description Budget description
     * @param amount Budget amount
     */
    public Budget(String name, String description, double amount) {
        this.name = name;
        this.description = description;
        this.amount = amount;
    }
    
    @Override
    public String getName() {
        return name;
    }
    
    @Override
    public String getDescription() {
        return description;
    }
    
    @Override
    public double getAmount() {
        return amount;
    }
    
    @Override
    public boolean affectsBalance() {
        return false; // Budget doesn't directly affect balance
    }
}

/**
 * SavingsGoal implementation of FinancialEntity interface
 */
class SavingsGoal implements FinancialEntity {
    private String name;
    private String description;
    private double targetAmount;
    private double currentAmount;
    
    /**
     * Constructor for SavingsGoal
     * 
     * @param name Goal name
     * @param description Goal description
     * @param targetAmount Target amount to save
     */
    public SavingsGoal(String name, String description, double targetAmount) {
        this.name = name;
        this.description = description;
        this.targetAmount = targetAmount;
        this.currentAmount = 0.0;
    }
    
    /**
     * Add funds to savings goal
     * 
     * @param amount Amount to add
     */
    public void addFunds(double amount) {
        this.currentAmount += amount;
    }
    
    /**
     * Get progress percentage
     * 
     * @return Progress as percentage
     */
    public double getProgressPercentage() {
        return (currentAmount / targetAmount) * 100;
    }
    
    @Override
    public String getName() {
        return name;
    }
    
    @Override
    public String getDescription() {
        return description;
    }
    
    @Override
    public double getAmount() {
        return targetAmount;
    }
    
    /**
     * Get current saved amount
     * 
     * @return Current saved amount
     */
    public double getCurrentAmount() {
        return currentAmount;
    }
    
    @Override
    public boolean affectsBalance() {
        return true; // Savings affects balance
    }
}

