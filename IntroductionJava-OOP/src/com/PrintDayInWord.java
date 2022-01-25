package com.gomezpascual;

public class PrintDayInWord {
    /*
    Write a program called PrintDayInWord which prints “Sunday”, “Monday”, ... “Saturday”
    if the int variable "dayNumber" is 0, 1, ..., 6, respectively.  Otherwise, it shall print
    "Not a valid day". Use (a) a "nested-if" statement; (b) a "switch-case-default" statement.
    **/

    public static void main(String[] args) {
        int dayNumber =  4;

        switch (dayNumber) {
            case 0:
                System.out.println("Sunday");
                break;
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
        }
    }
}
