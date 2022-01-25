package com;

import java.util.Scanner;

public class SumOfDigitsInt {
    /*
        Write a program that prompts user for a positive integer. The program shall read
        the input as int; compute and print the sum of all its digits. For examples,
        Enter a positive integer: 12345
        The sum of all digits is: 15
    **/

    public static void main(String[] args) {
        int number;
        int sum = 0;

        Scanner in = new Scanner(System.in);

        //Read first integer
        System.out.print("Enter an integer: ");
        number = in.nextInt();

        in.close();

        // Compute and display sum
        while (number > 0) {

            sum += (number % 10);
            number /= 10;
        }

        System.out.println("The sum is: " + sum);

    }
}
