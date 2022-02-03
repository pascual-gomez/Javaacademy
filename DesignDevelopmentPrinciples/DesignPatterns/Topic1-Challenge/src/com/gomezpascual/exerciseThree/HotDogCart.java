package com.gomezpascual.exerciseThree;

public class HotDogCart {
    public static void main(String[] args) {
        HotDog hotDog1 = new Sauce(new HotDogConcrete());
        System.out.println(hotDog1.prepare());

        HotDog hotDog2 = new Chips(new Bacon(new Sauce(new Sauce(new HotDogConcrete()))));
        System.out.println(hotDog2.prepare());

    }
}
