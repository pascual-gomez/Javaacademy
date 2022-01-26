package com;

import java.util.Scanner;

public class GradesStatistics {
    /*
    Write a program which prompts user for the number of students in a class (a non-negative integer),
    and saves it in an int variable called numStudents. It then prompts user for the grade of each of
    the students (integer between 0 to 100) and saves them in an int array called grades. The program
    shall then compute and print the average (in double rounded to 2 decimal places) and minimum/maximum
    (in int).
     */
    public static void main(String[] args) {
        int students = 0;
        Scanner in = new Scanner(System.in);

        //Read number of students
        System.out.print("Enter the number of students: ");
        students = in.nextInt();

        int[] grades = new int[students];

        for (int i = 1; i <= students; i++) {
            //Read grades
            System.out.println("Enter the grade for student " + i + ":");
            grades[i-1] = in.nextInt();
        }

        int sum = 0;
        int min = 100;
        int max = 0;

        for (int grade: grades) {
            sum += grade;

            if (grade > max) max = grade;
            if (grade < min) min = grade;
        }

        double average = (double)sum / (double)students;

        System.out.println("The average is " + average);
        System.out.println("The maximum is " + max);
        System.out.println("The minimum is " + min);

    }
}
