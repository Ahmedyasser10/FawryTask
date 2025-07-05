package fawry.model;

import java.time.LocalDate;

public class Cheese extends Product implements Shippable {
    private double weight;

    public Cheese(String name, double price, int quantity, LocalDate expirationDate, double weight) {
        super(name, price, quantity, expirationDate, true);
        this.weight = weight;
    }

    @Override
    public double getWeight() {
        return weight;
    }
}
