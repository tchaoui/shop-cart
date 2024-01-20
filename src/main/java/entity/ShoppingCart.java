package fr.pmu.coursepmu.entity;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private static final String JSON_FILE_PATH = "c:\\temp\\cart_result.json";



    public List<fr.pmu.coursepmu.entity.CartItem> cartItems;

    public ShoppingCart() {
        this.cartItems = new ArrayList<>();
    }

    public void addItem(String product, int quantity, double price) {
        for (fr.pmu.coursepmu.entity.CartItem item : cartItems) {
            if (item.product.equals(product)) {
                System.out.println("Product " + product + " is already in the cart. Skipping...");
                return;
            }
        }

        cartItems.add(new fr.pmu.coursepmu.entity.CartItem(product, quantity, price));
    }

    public void printCart() {
        System.out.println("Product\t\t\tQuantity\tPrice\t\tTotal");
        System.out.println("--------------------------------------------------------");

        double grandTotal = 0;
        for (fr.pmu.coursepmu.entity.CartItem item : cartItems) {
            System.out.printf("%-20s%-16d%-16.2f%.2f%n", item.product, item.quantity, item.price, item.getTotal());
            grandTotal += item.getTotal();
        }

        System.out.println("--------------------------------------------------------");
        System.out.printf("%-36s%.2f%n", "Total", grandTotal);

        generateJsonFile();
    }

    public void generateJsonFile() {
        try (FileWriter writer = new FileWriter(JSON_FILE_PATH)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(cartItems, writer);
            System.out.println("JSON file generated successfully at: " + JSON_FILE_PATH);
        } catch (IOException e) {
            System.out.println("Error generating JSON file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        cart.addItem("Pen", 3, 1.50);
        cart.addItem("Book", 2, 8.00);

        cart.printCart();
    }
}