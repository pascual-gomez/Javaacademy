package com.gomezpascual.exerciseThree;

public class Bacon extends Toppings {

    public Bacon(HotDog hotDog) {
        super(hotDog);
    }

    public String prepare() {
        return super.prepare() + prepareWithBacon();
    }

    private String prepareWithBacon() {
        return " with bacon";
    }
}

