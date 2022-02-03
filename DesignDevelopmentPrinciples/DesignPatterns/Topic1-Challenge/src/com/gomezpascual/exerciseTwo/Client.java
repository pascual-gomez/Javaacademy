package com.gomezpascual.exerciseTwo;

public class Client {
    public static void main(String[] args) {
        ProductOne productOne = new ProductOne();
        ProductTwo productTwo = new ProductTwo();
        ProductThree productThree = new ProductThree();
        ProductOne productOne1 = new ProductOne();

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
        productThree.attach(price);
        productTwo.updatePrice(20);
        productThree.updatePrice(30);
        productOne1.attach(price);

        System.out.println("*********************");

        //Print current state of subscription lists
        System.out.println("List One: ");
        ProductOne.getSubsList();
        System.out.println("List Two: ");
        ProductTwo.getSubsList();
        System.out.println("List Three: ");
        ProductThree.getSubsList();

    }
}
