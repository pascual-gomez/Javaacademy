package com.gomezpascual.exerciseThree;

public class Sauce extends Toppings {

    public Sauce(HotDog hotDog) {
        super(hotDog);
    }

    public String prepare() {
        return super.prepare() + prepareWithSauce();
    }

    private String prepareWithSauce() {
        return " with sauce";
    }
}
