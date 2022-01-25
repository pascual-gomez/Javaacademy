package com;

import java.util.Scanner;

public class Bin2Dec {
    /*
    Write a program called Bin2Dec to convert an input
    binary string into its equivalent decimal number. Your output shall look like:

    Enter a Binary string: 1011
    The equivalent decimal number for binary "1011" is: 11

    Enter a Binary string: 1234
    error: invalid binary string "1234"
    **/

    public static void main(String[] args) {
        //Declare variables to use
        int binaryNumber;
        int decimalNumber = 0;
        Scanner in = new Scanner(System.in);

        //Read binary number
        System.out.print("Enter a binary number: ");
        binaryNumber = in.nextInt();

        int number = binaryNumber;
        boolean isValid = true;

        while (number > 0) {
            if (number % 10 > 1) {
                isValid = false;
            }
            number /= 10;
        }

        number = binaryNumber;
        int pos = 1;

        while (number > 0) {
            decimalNumber += (number % 10) * pos;
            number /= 10;
            pos *= 2;
        }

        if (isValid) {
            System.out.println("The equivalent decimal number for binary \"" + binaryNumber + "\" is: " + decimalNumber);
        } else {
            System.out.println("error: invalid binary string \"" + binaryNumber + "\"");
        }

    }
}
