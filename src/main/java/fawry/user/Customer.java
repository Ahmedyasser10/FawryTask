package fawry.user;

import fawry.cart.Cart;

public class Customer {
    private String name;
    private double balance;
    private Cart cart;

    public Customer(String name, double balance) {
        this.name = name;
        this.balance = balance;
        this.cart = new Cart(); 
    }

    public Cart getCart() {
        return cart;
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
