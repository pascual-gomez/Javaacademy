package com.gomezpascual.exerciseTwo;

import java.util.ArrayList;
import java.util.List;

//Abstract class product
abstract class Product {
    private String name;
    private int price;

    //List to attach subscribers
    private List<ProductObserver> observers = new ArrayList<>();

    //Constructor
    Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    //Methods each product must implement
    public void attach(ProductObserver observer) {
        observers.add(observer);
        System.out.println("Subscribed to " + this.getName());
    }

    public  void detach(ProductObserver observer) {
        observers.remove(observer);
        System.out.println("Unsubscribed from " + this.getName());
    }

    public void updatePrice(int price) {
        this.price = price;
        System.out.println(this.getName() + "'s price updated to " + this.getPrice());
        observers.forEach(o->o.updated(this));
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
