package com.financetracker.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.financetracker.interfaces.FinancialEntity;
import com.financetracker.model.Transaction;

/**
 * Utility class with generic methods for financial operations
 * Demonstrates use of generics (requirement 19)
 */
public class FinancialUtility {
    
    /**
     * Generic method to filter a list based on a condition
     * Demonstrates generics (requirement 19)
     * 
     * @param <T> Type parameter
     * @param list List to filter
     * @param filter Filter implementation
     * @return Filtered list
     */
    public static <T> List<T> filter(List<T> list, Filter<T> filter) {
        List<T> result = new ArrayList<>();
        
        for (T item : list) {
            if (filter.accept(item)) {
                result.add(item);
            }
        }
        
        return result;
    }
    
    /**
     * Generic method to find maximum value in a list
     * 
     * @param <T> Type parameter extending Comparable
     * @param list List to search
     * @return Maximum value
     */
    public static <T extends Comparable<T>> T findMax(List<T> list) {
        if (list.isEmpty()) {
            return null;
        }
        
        T max = list.get(0);
        
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).compareTo(max) > 0) {
                max = list.get(i);
            }
        }
        
        return max;
    }
    
    /**
     * Generic method to find minimum value in a list
     * 
     * @param <T> Type parameter extending Comparable
     * @param list List to search
     * @return Minimum value
     */
    public static <T extends Comparable<T>> T findMin(List<T> list) {
        if (list.isEmpty()) {
            return null;
        }
        
        T min = list.get(0);
        
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).compareTo(min) < 0) {
                min = list.get(i);
            }
        }
        
        return min;
    }
    
    /**
     * Generic method to compute average of amounts in a list of financial entities
     * 
     * @param <T> Type parameter extending FinancialEntity
     * @param entities List of financial entities
     * @return Average amount
     */
    public static <T extends FinancialEntity> double computeAverage(List<T> entities) {
        if (entities.isEmpty()) {
            return 0.0;
        }
        
        double sum = 0.0;
        
        for (T entity : entities) {
            sum += entity.getAmount();
        }
        
        return sum / entities.size();
    }
    
    /**
     * Generic filter interface
     * Part of generics implementation (requirement 19)
     * 
     * @param <T> Type parameter
     */
    public interface Filter<T> {
        /**
         * Determine if an item passes the filter
         * 
         * @param item Item to check
         * @return true if accepted, false otherwise
         */
        boolean accept(T item);
    }
    
    /**
     * Example filter implementation for transactions by date
     */
    public static class DateFilter implements Filter<Transaction> {
        private Date startDate;
        private Date endDate;
        
        /**
         * Constructor for DateFilter
         * 
         * @param startDate Start date
         * @param endDate End date
         */
        public DateFilter(Date startDate, Date endDate) {
            this.startDate = startDate;
            this.endDate = endDate;
        }
        
        @Override
        public boolean accept(Transaction transaction) {
            Date transactionDate = transaction.getDate();
            return !transactionDate.before(startDate) && !transactionDate.after(endDate);
        }
    }
    
    /**
     * Example filter implementation for transactions by amount
     */
    public static class AmountFilter implements Filter<Transaction> {
        private double minAmount;
        private double maxAmount;
        
        /**
         * Constructor for AmountFilter
         * 
         * @param minAmount Minimum amount
         * @param maxAmount Maximum amount
         */
        public AmountFilter(double minAmount, double maxAmount) {
            this.minAmount = minAmount;
            this.maxAmount = maxAmount;
        }
        
        @Override
        public boolean accept(Transaction transaction) {
            double amount = transaction.getAmount();
            return amount >= minAmount && amount <= maxAmount;
        }
    }
    
    /**
     * Calculate compound interest
     * 
     * @param principal Initial amount
     * @param rate Annual interest rate (decimal)
     * @param time Time in years
     * @param compoundingFrequency Number of times interest is compounded per year
     * @return Final amount after compound interest
     */
    public static double calculateCompoundInterest(
            double principal, double rate, double time, int compoundingFrequency) {
        
        return principal * Math.pow(1 + (rate / compoundingFrequency), compoundingFrequency * time);
    }
    
    /**
     * Calculate simple interest
     * 
     * @param principal Initial amount
     * @param rate Annual interest rate (decimal)
     * @param time Time in years
     * @return Interest earned
     */
    public static double calculateSimpleInterest(double principal, double rate, double time) {
        return principal * rate * time;
    }
    
    /**
     * Calculate loan payment (PMT)
     * 
     * @param loanAmount Loan amount
     * @param annualInterestRate Annual interest rate (decimal)
     * @param loanTermInYears Loan term in years
     * @return Monthly payment amount
     */
    public static double calculateLoanPayment(
            double loanAmount, double annualInterestRate, int loanTermInYears) {
        
        // Convert annual rate to monthly
        double monthlyRate = annualInterestRate / 12;
        
        // Convert years to months
        int numberOfPayments = loanTermInYears * 12;
        
        // Calculate payment
        return (loanAmount * monthlyRate) / (1 - Math.pow(1 + monthlyRate, -numberOfPayments));
    }
}