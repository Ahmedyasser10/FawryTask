package fawry;

import fawry.cart.Cart;
import fawry.model.*;
import fawry.service.Checkout;
import fawry.user.Customer;

public class Main {
    public static void main(String[] args) {
        Product cheese = new Cheese("Cheese", 100, 10, false, 200);
        Product biscuits = new Biscuits("Biscuits", 150, 5, false, 700);
        Product tv = new TV("TV", 1000, 2, false, 10000);
        Product scratchCard = new MobileScratchCard("ScratchCard", 50, 10, false);

        Customer customer = new Customer("Ahmed Yassor", 1000);
        Cart cart = new Cart();

        cart.add(cheese, 2);
        cart.add(biscuits, 1);
        cart.add(scratchCard, 1);

        Checkout.process(customer, cart);
    }
}