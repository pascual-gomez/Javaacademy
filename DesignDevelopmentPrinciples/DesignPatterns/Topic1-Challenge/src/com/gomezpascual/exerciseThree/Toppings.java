package com.gomezpascual.exerciseThree;

public abstract class Toppings implements HotDog {
    private HotDog hotDog;

    Toppings(HotDog hotDog) {
        this.hotDog = hotDog;
    }

    @Override
    public String prepare() {
        return hotDog.prepare();
    }
}
