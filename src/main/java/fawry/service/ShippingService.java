package fawry.service;

import fawry.model.Shippable;
import java.util.*;

public class ShippingService {
    public static void ship(List<Shippable> items) {
        System.out.println("** Shipment notice **");

        Map<String, ItemInfo> groupedItems = new LinkedHashMap<>();
        double totalWeight = 0;

        for (Shippable item : items) {
            String name = item.getName();
            double weight = item.getWeight();

            groupedItems.computeIfAbsent(name, k -> new ItemInfo(0, 0));
            groupedItems.get(name).quantity += 1;
            groupedItems.get(name).weight += weight;

            totalWeight += weight;
        }

        for (Map.Entry<String, ItemInfo> entry : groupedItems.entrySet()) {
            System.out.printf("%dx %s %.0fg\n", entry.getValue().quantity, entry.getKey(), entry.getValue().weight);
        }

        System.out.printf("Total package weight %.1fkg\n", totalWeight / 1000.0);
    }

    private static class ItemInfo {
        int quantity;
        double weight;

        ItemInfo(int quantity, double weight) {
            this.quantity = quantity;
            this.weight = weight;
        }
    }
}
