package com.gomezpascual.exerciseThree;

public class Chips extends Toppings {

    public Chips(HotDog hotDog) {
        super(hotDog);
    }

    public String decorate() {
        return super.prepare() + prepareWithChips();
    }

    private String prepareWithChips() {
        return " with chips";
    }
}

