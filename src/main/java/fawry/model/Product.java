package fawry.model;

import java.time.LocalDate;

public abstract class Product {
    protected String name;
    protected double price;
    protected int quantity;
    protected LocalDate expirationDate;
    protected boolean requiresShipping;

    public Product(String name, double price, int quantity, LocalDate expirationDate, boolean requiresShipping) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.expirationDate = expirationDate;
        this.requiresShipping = requiresShipping;
    }

    public boolean isExpired() {
        return expirationDate != null && expirationDate.isBefore(LocalDate.now());
    }

    public boolean isAvailable(int requested) {
        return !isExpired() && quantity >= requested;
    }

    public void decreaseQuantity(int amount) {
        this.quantity -= amount;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public boolean needsShipping() {
        return requiresShipping;
    }
}
