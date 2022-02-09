package com.gomezpascual;

public class Cancelled implements OrderState {

    @Override
    public double handleCancellation() {
        throw new IllegalStateException("Cancelled order. Cannot cancel anymore.");
    }
}
