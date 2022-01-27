package com.gomezpascual;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Memory {

    public static final int MEMORY_SIZE = 200;
    public static ArrayList<Process> memory = new ArrayList<>(MEMORY_SIZE);
    static
    {
        for (int i = 0; i < 200; i++) {
            memory.add(null);
        }
    }

    public static void addProcess(Process process) {
        //Add process to memory
        try {
            if (checkAvailability(process.size)) {
                int indexToAdd = 0;
                for (int i = 0; i < MEMORY_SIZE; i++) {
                    //Find position to add new process
                    if (memory.get(i) == null) {
                        indexToAdd = i;
                        break;
                    }
                }

                for (int i = indexToAdd; i < (indexToAdd + process.size); i++) {
                    memory.set(i, process);
                }
                printMemory();
            }
        } catch (MemoryOverflowException e) {
            System.out.println(e);
        }
    }

    public static void removeProcess(int id) {
        //Delete process
        for (int i = 0; i < MEMORY_SIZE; i++) {
            if (memory.get(i) != null) {
                if (memory.get(i).id == id) {
                    memory.set(i, null);
                }
            }
        }

        organizeMemory();
        printMemory();
    }

    public static void organizeMemory() {
        Collections.sort(memory,
                Comparator.nullsLast(
                        Comparator.comparing(
                                Process::getId)));
    }

    public static void printMemory() {
        //Print memory
        for(int i = 19; i >= 0; i--) {
            for(int j = 0; j < 10; j++) {
                if (memory.get((i*10)+j) == null) {
                    System.out.print("**** ");
                } else {
                    System.out.print(memory.get((i*10)+j).getString() + " ");
                }
            }
            System.out.println();
        }
    }

    private static boolean checkAvailability(int size) throws MemoryOverflowException {
        int freeSpaces = 0;

        for (Process process: memory) {
            if (process == null) freeSpaces++;
        }

        if (freeSpaces <= size) {
            throw new MemoryOverflowException("Memory is full. This process cannot be added.");
        }
            return true;
    }
}
