package fawry;

import fawry.cart.Cart;
import fawry.model.*;
import fawry.service.Checkout;
import fawry.user.Customer;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        LocalDate futureDate = LocalDate.of(2025, 12, 31);

        Product cheese = new Cheese("Cheese", 100, 10, futureDate, 200);
        Product biscuits = new Biscuits("Biscuits", 150, 5, futureDate, 700);
        Product tv = new TV("TV", 1000, 2, null, 10000); // no expiry
        Product scratchCard = new MobileScratchCard("ScratchCard", 50, 10, null); // no expiry

        Customer customer = new Customer("Ahmed Yassor", 1000);
        Cart cart = new Cart();

        try {
            cart.add(cheese, 2);
            cart.add(biscuits, 1);
            cart.add(scratchCard, 1);

            Checkout.process(customer, cart);
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println("Checkout failed: " + e.getMessage());
        }
    }
}
