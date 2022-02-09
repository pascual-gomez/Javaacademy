package com.gomezpascual;

public class New implements OrderState {

    @Override
    public double handleCancellation() {
        System.out.println("It's a new order. No processing done");
        return 0;
    }
}
