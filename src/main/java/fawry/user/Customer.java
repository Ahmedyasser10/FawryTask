package fawry.user;

public class Customer {
    private String name;
    private double balance;

    public Customer(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public boolean canAfford(double total) {
        return balance >= total;
    }

    public void deduct(double amount) {
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }
}