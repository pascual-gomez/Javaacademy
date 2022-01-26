package com.gomezpascual;

public class Memory {

    private static String[] memory = new String[200];

    public static boolean addProcess(Process process) {
        //Add process to memory
        return true;
    }

    public static boolean removeProcess(int id) {
        //Delete process
        return true;
    }

    public static boolean organizeMemory() {
        //Organize memory
        return true;
    }

    public static void printMemory() {
        //Print memory
        for(int i = 1; i <= 20; i++) {
            for(int j = 1; j <= 10; i++) {
                if (memory[i*j] == null) {
                    System.out.print("**** ");
                } else {
                    System.out.print(memory[i*j]);
                }
            }
            System.out.println();
        }
    }

    private boolean checkAvailability(int size) {
        //check space is available in memory
        return true;
    }
}
