package com.gomezpascual;

public class Product1ToN {
    /*
    Write a program called Product1ToN to compute the product of integers from 1 to 10
    (i.e., 1×2×3×...×10), as an int. Take note that It is the same as factorial of N.
    **/

    public static void main(String[] args) {

        long result = 1;
        final int UPPERBOUND = 10;

        for (int number = 1; number <= UPPERBOUND; number++) {
            result = result * number;
        }

        System.out.println("The product is " + result);
    }
}
