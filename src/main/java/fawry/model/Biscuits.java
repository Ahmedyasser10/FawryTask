package fawry.model;

public class Biscuits extends Product implements Shippable {
    private double weight;

    public Biscuits(String name, double price, int quantity, boolean expired, double weight) {
        super(name, price, quantity, expired, true);
        this.weight = weight;
    }

    @Override
    public double getWeight() {
        return weight;
    }
}