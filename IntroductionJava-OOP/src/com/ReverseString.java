package com;

import java.util.Scanner;

public class ReverseString {
    /*
    Write a program called ReverseString, which prompts user for a String,
    and prints the reverse of the String by extracting and processing each character.
    **/

    public static void main(String[] args) {
        String strToReverse;
        int strLenght;
        Scanner in = new Scanner(System.in);

        //Read first integer
        System.out.print("Enter a word to reverse: ");
        strToReverse = in.next();
        strLenght = strToReverse.length();

        System.out.print("The reverse of the String " + strToReverse + " is ");

        for (int i = strLenght - 1; i >= 0; i--) {
            System.out.print(strToReverse.charAt(i));
        }

        System.out.println(".");

    }
}
