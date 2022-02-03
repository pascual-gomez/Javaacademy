package com.gomezpascual.exerciseTwo;

public class Client {
    public static void main(String[] args) {
        ProductOne productOne = new ProductOne();
        ProductTwo productTwo = new ProductTwo();
        ProductThree productThree = new ProductThree();

        PriceObserver price = new PriceObserver();

        //First subscription to Product One
        productOne.attach(price);
        productOne.updatePrice(20);
        productOne.detach(price);
        productOne.updatePrice(15);

        System.out.println("*********************");

        //Second subscription to Products One and Two
        productOne.attach(price);
        productTwo.attach(price);
        productOne.updatePrice(12);
        productTwo.updatePrice(18);
        productTwo.detach(price);
        productThree.attach(price);
        productTwo.updatePrice(20);
        productThree.updatePrice(30);

    }
}
