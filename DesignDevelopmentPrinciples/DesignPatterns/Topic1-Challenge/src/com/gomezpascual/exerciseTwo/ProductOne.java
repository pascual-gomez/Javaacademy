package com.gomezpascual.exerciseTwo;

import java.util.ArrayList;
import java.util.List;

public class ProductOne extends Product {

    private static List<ProductObserver> observers = new ArrayList<>();

    ProductOne() {
        super("Product One", 10);
    }

    public void addObserver(ProductObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(ProductObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        observers.forEach(o->o.updated(this));
    }

    public static void getSubsList() {
        System.out.print("[");
        for (ProductObserver observer: observers) {
            System.out.print("Subs, ");
        }
        System.out.println("]");
    }

}
