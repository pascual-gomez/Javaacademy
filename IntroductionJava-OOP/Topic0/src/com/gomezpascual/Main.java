package com.gomezpascual;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Memory.printMemory();

        Scanner in = new Scanner(System.in);

        running:
        while (true) {
            System.out.println("Write your command: ");
            System.out.println("Create a process: c + process type, ");
            System.out.println("Delete a process: d + process id");
            System.out.println("Quit program: q");

            String answer = in.nextLine();
            char[] answerChars = answer.toCharArray();
            //answer.getChars(0, answer.length(), answerChars, 0);

            if (validateCommand(answerChars)) {
                switch (answerChars[0]) {
                    case 'c':
                        //add process
                        if (answerChars[1] == 's') Memory.addProcess(new SystemProcess());
                        if (answerChars[1] == 'a') Memory.addProcess(new AppProcess());
                        break;
                    case 'd':
                        //delete process
                        Memory.removeProcess(answerChars[3]);
                        break;
                    case 'q':
                        //quit program
                        break running;
                    default:
                        System.out.println("Enter a valid command");
                        break;
                }
            } else {
                System.out.println("Enter a valid command.");
            }
        }

    }

    public static boolean validateCommand(char[] answer) {

        if (answer[0] == 'd' && answer.length == 4) {
            String str1 = new String(Arrays.copyOfRange(answer, 1, 3));

            if (str1.matches("-?\\d+")) return true;

        } else if (answer[0] == 'c' && answer.length == 2) {
            if (answer[1] == 's' || answer[1] == 'a') return true;

        }else if (answer[0] == 'q' && answer.length == 1) {
            return true;
        }

        return false;
    }

}
