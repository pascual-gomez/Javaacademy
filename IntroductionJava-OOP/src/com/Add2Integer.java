package com.gomezpascual;

import java.util.Scanner;

public class Add2Integer {
    /*
    Write a program called Add2Integers that prompts user to enter two integers.
    The program shall read the two integers as int; compute their sum; and print the result.
    For example,

    Enter first integer: 8
    Enter second integer: 9
    The sum is: 17
    **/

    public static void main(String[] args) {
        //Declare variables
        int number1, number2, sum;

        Scanner in = new Scanner(System.in);

        //Read first integer
        System.out.print("Enter the first integer: ");
        number1 = in.nextInt();

        // Read second integer
        System.out.print("Enter the second integer: ");
        number2 = in.nextInt();

        in.close();

        // Compute and display sum
        sum = number1 + number2;
        System.out.println("The sum is: " + sum);

    }
}
