package fawry.model;

public class TV extends Product implements Shippable {
    private double weight;

    public TV(String name, double price, int quantity, boolean expired, double weight) {
        super(name, price, quantity, expired, true);
        this.weight = weight;
    }

    @Override
    public double getWeight() {
        return weight;
    }
}