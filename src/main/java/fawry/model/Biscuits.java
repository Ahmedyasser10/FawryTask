package fawry.model;

import java.time.LocalDate;

public class Biscuits extends Product implements Shippable {
    private double weight;

    public Biscuits(String name, double price, int quantity, LocalDate expirationDate, double weight) {
        super(name, price, quantity, expirationDate, true);
        this.weight = weight;
    }

    @Override
    public double getWeight() {
        return weight;
    }
}
