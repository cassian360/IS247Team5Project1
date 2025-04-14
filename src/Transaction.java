package com.example.financetracker; // Main package

import java.time.LocalDate;
import java.time.format.DateTimeFormatter; // For better date formatting in toString

/**
 * Represents a single financial transaction (income or expense). Immutable once created.
 */
public class Transaction {
    private final LocalDate date;
    private final String description;
    private final double amount; // Stick with double for simplicity requested
    private final TransactionType type;
    private final Category category;

    // Formatter for consistent date output
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE; // YYYY-MM-DD

    public Transaction(LocalDate date, String description, double amount, TransactionType type, Category category) throws TrackerException {
        // Use guard clauses for validation
        if (date == null) throw new TrackerException("Transaction date cannot be null.");
        if (description == null || description.trim().isEmpty()) throw new TrackerException("Transaction description cannot be empty.");
        if (amount <= 0) throw new TrackerException("Transaction amount must be positive. Use type (INCOME/EXPENSE) to indicate direction.");
        if (type == null) throw new TrackerException("Transaction type cannot be null.");
        if (category == null) throw new TrackerException("Transaction category cannot be null.");

        this.date = date;
        this.description = description.trim();
        this.amount = amount;
        this.type = type;
        this.category = category;
    }

    // --- Getters ---
    public LocalDate getDate() { return date; }
    public String getDescription() { return description; }
    public double getAmount() { return amount; }
    public TransactionType getType() { return type; }
    public Category getCategory() { return category; }

    @Override
    public String toString() {
        return String.format("%s | %-15s | %-8s | %8.2f | %s",
                date.format(DATE_FORMATTER),
                category.getName(), // Use category's simple toString
                type,
                (type == TransactionType.EXPENSE ? -amount : amount), // Show expense as negative for clarity
                description);
    }

    // equals/hashCode based on content might be useful later, but often identity or an ID is used.
    // Skipping for now to keep it simpler.
}
