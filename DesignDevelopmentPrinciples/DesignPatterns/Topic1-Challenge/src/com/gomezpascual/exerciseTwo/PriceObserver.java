package com.gomezpascual.exerciseTwo;

public class PriceObserver implements ProductObserver {

    @Override
    public void updated(Product product) {
        int price = product.getPrice();
        System.out.println("NOTIFICATION: " + product.getName() + " price changed to " + price);
    }
}
