package com.gomezpascual;

public class Fibonacci {
    /*
    Write a program called Fibonacci to print the first 20 Fibonacci numbers F(n),
    where F(n)=F(n–1)+F(n–2) and F(1)=F(2)=1. Also compute their average. The output shall look like:

    The first 20 Fibonacci numbers are:
    1 1 2 3 5 8 13 21 34 55 89 144 233 377 610 987 1597 2584 4181 6765
    The average is 885.5
    **/

    public static void main(String[] args) {
        int n = 3;
        int fn = 0;
        int fnMinus1 = 1;
        int fnMinus2 = 1;
        int nMax = 20;
        int sum = fnMinus1 + fnMinus2;
        double average;

        System.out.println("The first " + nMax + " Fibonacci numbers are:");
        System.out.print(fnMinus1 + " " + fnMinus2);

        for (int number = n; number <= nMax; number++) {
            fn = fnMinus1 + fnMinus2;
            System.out.print(" " + fn);

            sum = sum + fn;

            fnMinus2 = fnMinus1;
            fnMinus1 = fn;
        }

        System.out.println();
        average = (double)sum / (double)nMax;
        System.out.println("The average is " + average);
    }
}
