package com.gomezpascual;

public class Paid implements OrderState {

    @Override
    public double handleCancellation() {
        System.out.println("Contact payment gateway to rollback transaction.");
        return 10;
    }
}
