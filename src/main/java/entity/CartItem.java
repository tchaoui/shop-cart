package fr.pmu.coursepmu.entity;

public   class CartItem {
    String product;
    int quantity;
    double price;

    CartItem(String product, int quantity, double price) {
        this.product = product;
        this.quantity = quantity;
        this.price = price;
    }

    double getTotal() {
        return quantity * price;
    }
}