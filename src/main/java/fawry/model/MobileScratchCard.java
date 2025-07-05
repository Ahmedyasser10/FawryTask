package fawry.model;

import java.time.LocalDate;

public class MobileScratchCard extends Product {
    public MobileScratchCard(String name, double price, int quantity, LocalDate expirationDate) {
        super(name, price, quantity, expirationDate, false);
    }
}
