package com;

import java.util.Scanner;

public class Odd {
    public static void main(String[] args) {
        int number;
        Scanner in = new Scanner(System.in);

        //Read number
        System.out.print("Enter a number: ");
        number = in.nextInt();

        //Call function
        if (isOdd(number)) {
            System.out.println(number + " is an odd number");
        } else {
            System.out.println(number + " is an even number");
        }
    }

    public static boolean isOdd(int number) {
        return (number % 2) == 1;
    }
}
