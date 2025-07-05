package fawry.model;

public abstract class Product {
    protected String name;
    protected double price;
    protected int quantity;
    protected boolean expired;
    protected boolean requiresShipping;

    public Product(String name, double price, int quantity, boolean expired, boolean requiresShipping) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.expired = expired;
        this.requiresShipping = requiresShipping;
    }

    public boolean isAvailable(int requested) {
        return !expired && quantity >= requested;
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

    public boolean isExpired() {
        return expired;
    }

    public boolean needsShipping() {
        return requiresShipping;
    }
}