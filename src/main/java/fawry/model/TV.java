package fawry.model;

import java.time.LocalDate;

public class TV extends Product implements Shippable {
    private double weight;

    public TV(String name, double price, int quantity, LocalDate expirationDate, double weight) {
        super(name, price, quantity, expirationDate, true);
        this.weight = weight;
    }

    @Override
    public double getWeight() {
        return weight;
    }
}
