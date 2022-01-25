package com;

import java.util.Scanner;

public class SquarePattern {
    /**
     * Write a program called SquarePattern that prompts user for the size (a non-negative integer in int);
     * and prints the following square pattern using two nested for-loops.
     */
    public static void main(String[] args) {
        int size;
        Scanner in = new Scanner(System.in);

        //Read first integer
        System.out.print("Enter the size: ");
        size = in.nextInt();

        for (int row = 1; row <= size; row++) {
            for (int col = 1; col <= size; col++) {
                System.out.print("# ");
            }

            System.out.println();
        }
    }
}
