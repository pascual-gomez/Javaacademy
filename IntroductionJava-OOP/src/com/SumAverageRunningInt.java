package com.gomezpascual;

public class SumAverageRunningInt {
    /*
        Write a program called SumAverageRunningInt to produce the sum of 1, 2, 3, ..., to 100.
        Store 1 and 100 in variables lowerbound and upperbound, so that we can change their values easily.
        Also compute and display the average. The output shall look like:

        The sum of 1 to 100 is 5050
        The average is 50.5
    **/

    public static void main(String[] args) {
        int sum = 0;
        double average;
        final int LOWERBOUND = 111;
        final int UPPERBOUND = 8899;
        int count = 0;

        for (int number = LOWERBOUND; number <= UPPERBOUND; number++) {
            sum = sum + number;
            count++;
        }

        average = sum / count;

        System.out.println("The sum of " + LOWERBOUND + " to " + UPPERBOUND + " is " + sum);
        System.out.println("The average is " + average);
    }
}
