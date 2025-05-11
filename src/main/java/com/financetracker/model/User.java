/**
 * Represents a user of the Finance Tracker application.
 * Implements encapsulation through private fields with getters/setters.
 */
public class User {
    // Static counter for user IDs
    private static int nextUserId = 1;
    
    // Private fields - encapsulation (requirement 20)
    private int id;
    private String name;
    private String email;
    private TransactionManager transactionManager;
    private BudgetManager budgetManager;
    
    /**
     * Constructor for User class
     * (requirement 16)
     * 
     * @param name User's name
     * @param email User's email address
     */
    public User(String name, String email) {
        // Using this keyword (requirement 23)
        this.id = nextUserId++;
        this.name = name;
        this.email = email;
        this.transactionManager = new TransactionManager();
        this.budgetManager = new BudgetManager();
    }
    
    /**
     * Overloaded constructor with ID parameter
     * Example of method overloading (requirement 12)
     * 
     * @param id Unique identifier
     * @param name User's name
     * @param email User's email address
     */
    public User(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.transactionManager = new TransactionManager();
        this.budgetManager = new BudgetManager();
    }
    
    // Getter and setter methods - part of encapsulation (requirement 20)
    
    public int getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public TransactionManager getTransactionManager() {
        return transactionManager;
    }
    
    public BudgetManager getBudgetManager() {
        return budgetManager;
    }
    
    /**
     * Returns a string representation of the User
     * Overrides toString method from Object class
     * Example of method overriding (requirement 11)
     * 
     * @return String representation of the user
     */
    @Override
    public String toString() {
        return "User{id=" + id + ", name='" + name + "', email='" + email + "'}";
    }
}
