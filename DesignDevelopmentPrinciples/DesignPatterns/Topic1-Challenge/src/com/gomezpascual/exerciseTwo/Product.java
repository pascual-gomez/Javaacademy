package com.gomezpascual.exerciseTwo;

import java.util.ArrayList;
import java.util.List;

//Abstract class product
abstract class Product {
    private String name;
    private int price;

    //List to attach subscribers
    private List<ProductObserver> observers;

    //Constructor
    Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    //Methods each product must implement
    public void attach(ProductObserver observer) {
        this.addObserver(observer);
        System.out.println("Subscribed to " + this.getName());
    }

    public  void detach(ProductObserver observer) {
        this.removeObserver(observer);
        System.out.println("Unsubscribed from " + this.getName());
    }

    public void updatePrice(int price) {
        this.price = price;
        System.out.println(this.getName() + "'s price updated to " + this.getPrice());
        this.notifyObservers();
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public abstract void addObserver(ProductObserver observer);
    public abstract void removeObserver(ProductObserver observer);
    public abstract void notifyObservers();
}
