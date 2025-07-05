package fawry.model;

public class MobileScratchCard extends Product {
    public MobileScratchCard(String name, double price, int quantity, boolean expired) {
        super(name, price, quantity, expired, false);
    }
}