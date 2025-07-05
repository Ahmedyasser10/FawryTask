package fawry.service;

import fawry.cart.Cart;
import fawry.cart.CartItem;
import fawry.model.Product;
import fawry.model.Shippable;
import fawry.user.Customer;

import java.util.ArrayList;
import java.util.List;

public class Checkout {
    public static void process(Customer customer, Cart cart) {
        if (cart.isEmpty()) throw new IllegalStateException("Cart is empty!");

        double subtotal = 0;
        List<Shippable> shippableItems = new ArrayList<>();

        for (CartItem item : cart.getItems()) {
            Product p = item.product;
            if (!p.isAvailable(item.quantity))
                throw new IllegalStateException("Product out of stock or expired: " + p.getName());

            subtotal += item.getTotalPrice();

            if (p.needsShipping() && p instanceof Shippable) {
                for (int i = 0; i < item.quantity; i++) {
                    shippableItems.add((Shippable) p);
                }
            }
        }

        double shippingFee = shippableItems.isEmpty() ? 0 : 30;
        double total = subtotal + shippingFee;

        if (!customer.canAfford(total))
            throw new IllegalStateException("Insufficient balance.");

        customer.deduct(total);
        cart.getItems().forEach(i -> i.product.decreaseQuantity(i.quantity));

        if (!shippableItems.isEmpty()) {
            ShippingService.ship(shippableItems);
        }

        System.out.println("** Checkout receipt **");
        for (CartItem i : cart.getItems()) {
            System.out.printf("%dx %s\t%.0f\n", i.quantity, i.product.getName(), i.getTotalPrice());
        }
        System.out.println("----------------------");
        System.out.printf("Subtotal\t%.0f\n", subtotal);
        System.out.printf("Shipping\t%.0f\n", shippingFee);
        System.out.printf("Amount\t\t%.0f\n", total);
    }
}
