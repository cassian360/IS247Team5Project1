import java.util.Date;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Main class for the Finance Tracker application.
 * This class contains the entry point and main menu functionality.
 * 
 * @author Your Name
 * @version 1.0
 */
public class Main {
    // Static variable for application name
    private static final String APP_NAME = "Finance Tracker v1.0";
    
    // Scanner for user input
    private static final Scanner scanner = new Scanner(System.in);
    
    // User account
    private static User currentUser;
    
    /**
     * Main method - entry point of the application
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("Welcome to " + APP_NAME);
        System.out.println("------------------------------");
        
        try {
            login();
            showMainMenu();
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
            e.printStackTrace();
        } finally {
            scanner.close();
            System.out.println("Thank you for using " + APP_NAME);
        }
    }
    
    /**
     * Simple login functionality
     */
    private static void login() {
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter your email: ");
        String email = scanner.nextLine();
        
        // Create new user with unique ID
        currentUser = new User(name, email);
        System.out.println("\nWelcome, " + currentUser.getName() + "!");
    }
    
    /**
     * Displays and handles the main menu
     */
    private static void showMainMenu() {
        boolean exit = false;
        
        while (!exit) {
            System.out.println("\n===== MAIN MENU =====");
            System.out.println("1. Add Transaction");
            System.out.println("2. View Transactions");
            System.out.println("3. View Reports");
            System.out.println("4. Manage Budget");
            System.out.println("5. User Settings");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            
            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // consume newline
                
                // Using switch statement (requirement 3)
                switch (choice) {
                    case 1:
                        addTransactionMenu();
                        break;
                    case 2:
                        viewTransactions();
                        break;
                    case 3:
                        generateReports();
                        break;
                    case 4:
                        manageBudget();
                        break;
                    case 5:
                        userSettings();
                        break;
                    case 0:
                        exit = true;
                        System.out.println("Exiting application...");
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number.");
                scanner.nextLine(); // consume invalid input
            }
        }
    }
    
    /**
     * Menu for adding different types of transactions
     */
    private static void addTransactionMenu() {
        System.out.println("\n----- Add Transaction -----");
        System.out.println("1. Add Income");
        System.out.println("2. Add Expense");
        System.out.println("0. Back to Main Menu");
        System.out.print("Choose an option: ");
        
        try {
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            
            switch (choice) {
                case 1:
                    addIncome();
                    break;
                case 2:
                    addExpense();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Please enter a valid number.");
            scanner.nextLine(); // consume invalid input
        }
    }
    
    /**
     * Add income transaction
     */
    private static void addIncome() {
        try {
            System.out.print("Enter amount: $");
            double amount = scanner.nextDouble();
            scanner.nextLine(); // consume newline
            
            if (amount <= 0) {
                throw new InvalidAmountException("Income amount must be positive");
            }
            
            System.out.print("Enter description: ");
            String description = scanner.nextLine();
            
            System.out.println("Select income category:");
            System.out.println("1. Salary");
            System.out.println("2. Investment");
            System.out.println("3. Gift");
            System.out.println("4. Other");
            System.out.print("Choose category: ");
            
            int categoryChoice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            
            String category;
            // Using conditional operator (requirement 4)
            category = (categoryChoice == 1) ? "Salary" :
                      (categoryChoice == 2) ? "Investment" :
                      (categoryChoice == 3) ? "Gift" : "Other";
            
            // Create income transaction
            Income income = new Income(amount, description, category, new Date());
            
            // Add to user's transaction manager
            currentUser.getTransactionManager().addTransaction(income);
            
            System.out.println("Income added successfully!");
            
        } catch (InvalidAmountException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Please enter valid data.");
            scanner.nextLine(); // consume invalid input
        }
    }
    
    /**
     * Add expense transaction
     */
    private static void addExpense() {
        try {
            System.out.print("Enter amount: $");
            double amount = scanner.nextDouble();
            scanner.nextLine(); // consume newline
            
            if (amount <= 0) {
                throw new InvalidAmountException("Expense amount must be positive");
            }
            
            System.out.print("Enter description: ");
            String description = scanner.nextLine();
            
            System.out.println("Select expense category:");
            System.out.println("1. Food");
            System.out.println("2. Transportation");
            System.out.println("3. Housing");
            System.out.println("4. Entertainment");
            System.out.println("5. Healthcare");
            System.out.println("6. Other");
            System.out.print("Choose category: ");
            
            int categoryChoice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            
            String category;
            switch (categoryChoice) {
                case 1: category = "Food"; break;
                case 2: category = "Transportation"; break;
                case 3: category = "Housing"; break;
                case 4: category = "Entertainment"; break;
                case 5: category = "Healthcare"; break;
                default: category = "Other";
            }
            
            // Method overloading (requirement 12) - using the version with isRecurring parameter
            Expense expense = new Expense(amount, description, category, new Date(), false);
            
            // Add to user's transaction manager
            currentUser.getTransactionManager().addTransaction(expense);
            
            System.out.println("Expense added successfully!");
            
        } catch (InvalidAmountException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Please enter valid data.");
            scanner.nextLine(); // consume invalid input
        }
    }
    
    /**
     * View all transactions
     */
    private static void viewTransactions() {
        System.out.println("\n----- Transaction History -----");
        currentUser.getTransactionManager().displayAllTransactions();
    }
    
    /**
     * Generate and display reports
     */
    private static void generateReports() {
        System.out.println("\n----- Reports -----");
        System.out.println("1. Income Summary");
        System.out.println("2. Expense Summary");
        System.out.println("3. Monthly Overview");
        System.out.println("0. Back to Main Menu");
        System.out.print("Choose a report: ");
        
        try {
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            
            ReportGenerator reportGenerator = new ReportGenerator(currentUser.getTransactionManager());
            
            switch (choice) {
                case 1:
                    reportGenerator.generateIncomeSummary();
                    break;
                case 2:
                    reportGenerator.generateExpenseSummary();
                    break;
                case 3:
                    reportGenerator.generateMonthlyOverview();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Please enter a valid number.");
            scanner.nextLine(); // consume invalid input
        }
    }
    
    /**
     * Budget management functionality
     */
    private static void manageBudget() {
        System.out.println("\n----- Budget Management -----");
        System.out.println("1. Set New Budget");
        System.out.println("2. View Current Budget");
        System.out.println("0. Back to Main Menu");
        System.out.print("Choose an option: ");
        
        try {
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            
            BudgetManager budgetManager = currentUser.getBudgetManager();
            
            switch (choice) {
                case 1:
                    setBudget(budgetManager);
                    break;
                case 2:
                    viewBudget(budgetManager);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Please enter a valid number.");
            scanner.nextLine(); // consume invalid input
        }
    }
    
    /**
     * Set a new budget
     */
    private static void setBudget(BudgetManager budgetManager) {
        try {
            System.out.print("Enter total monthly budget amount: $");
            double totalAmount = scanner.nextDouble();
            scanner.nextLine(); // consume newline
            
            if (totalAmount <= 0) {
                throw new InvalidAmountException("Budget amount must be positive");
            }
            
            budgetManager.setTotalBudget(totalAmount);
            
            // Set category budgets
            System.out.println("Would you like to set category budgets? (y/n): ");
            String response = scanner.nextLine();
            
            if (response.equalsIgnoreCase("y")) {
                setCategoryBudgets(budgetManager, totalAmount);
            }
            
            System.out.println("Budget set successfully!");
            
        } catch (InvalidAmountException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Please enter a valid number.");
            scanner.nextLine(); // consume invalid input
        }
    }
    
    /**
     * Set budgets for specific categories
     */
    private static void setCategoryBudgets(BudgetManager budgetManager, double totalAmount) {
        String[] categories = {"Food", "Transportation", "Housing", "Entertainment", "Healthcare", "Other"};
        double remainingAmount = totalAmount;
        
        for (String category : categories) {
            try {
                System.out.printf("Enter budget for %s ($%.2f remaining): $", category, remainingAmount);
                double amount = scanner.nextDouble();
                scanner.nextLine(); // consume newline
                
                if (amount < 0) {
                    throw new InvalidAmountException("Budget amount cannot be negative");
                }
                
                if (amount > remainingAmount) {
                    throw new InvalidAmountException("Amount exceeds remaining budget");
                }
                
                budgetManager.setCategoryBudget(category, amount);
                remainingAmount -= amount;
                
            } catch (InvalidAmountException e) {
                System.out.println("Error: " + e.getMessage());
                System.out.println("Setting category budget to $0");
                budgetManager.setCategoryBudget(category, 0);
            } catch (InputMismatchException e) {
                System.out.println("Invalid amount. Setting category budget to $0");
                scanner.nextLine(); // consume invalid input
                budgetManager.setCategoryBudget(category, 0);
            }
        }
    }
    
    /**
     * View current budget information
     */
    private static void viewBudget(BudgetManager budgetManager) {
        System.out.println("\n----- Current Budget -----");
        budgetManager.displayBudgetSummary();
    }
    
    /**
     * User settings menu
     */
    private static void userSettings() {
        System.out.println("\n----- User Settings -----");
        System.out.println("1. Update User Information");
        System.out.println("2. Export Data");
        System.out.println("0. Back to Main Menu");
        System.out.print("Choose an option: ");
        
        try {
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            
            switch (choice) {
                case 1:
                    updateUserInfo();
                    break;
                case 2:
                    exportData();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Please enter a valid number.");
            scanner.nextLine(); // consume invalid input
        }
    }
    
    /**
     * Update user information
     */
    private static void updateUserInfo() {
        System.out.println("\n----- Update User Information -----");
        System.out.print("Enter new name (current: " + currentUser.getName() + "): ");
        String name = scanner.nextLine();
        
        System.out.print("Enter new email (current: " + currentUser.getEmail() + "): ");
        String email = scanner.nextLine();
        
        if (!name.isEmpty()) {
            currentUser.setName(name);
        }
        
        if (!email.isEmpty()) {
            currentUser.setEmail(email);
        }
        
        System.out.println("User information updated successfully!");
    }
    
    /**
     * Export user data to file
     */
    private static void exportData() {
        System.out.println("\n----- Export Data -----");
        System.out.println("This would export your financial data to a file.");
        System.out.println("Feature not implemented in this version.");
    }
    
