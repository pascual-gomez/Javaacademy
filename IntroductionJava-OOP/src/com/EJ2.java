package com;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class EJ2 {

    private static ArrayList<User> dataBase = new ArrayList<>(10);
    private static HashMap<Integer, String> cacheMemory = new HashMap<Integer, String>(5);

    public static void main(String[] args) {

        dataBase.add(new User(1, "Sergio"));
        dataBase.add(new User(2, "Oscar"));
        dataBase.add(new User(3, "Sandra"));
        dataBase.add(new User(4, "Camila"));
        dataBase.add(new User(5, "Julio"));
        dataBase.add(new User(6, "Ana"));
        dataBase.add(new User(7, "Estela"));
        dataBase.add(new User(8, "Luisa"));
        dataBase.add(new User(9, "Carlos"));
        dataBase.add(new User(10, "Laura"));

        System.out.println("Welcome:");

        while (true) {
            int answer;
            Scanner in = new Scanner(System.in);

            //Read number
            System.out.println("Select an option ");
            System.out.println("1. Query by ID ");
            System.out.println("2. End program ");
            answer = in.nextInt();

            if (answer == 1) {
                System.out.print("Enter ID: ");

                int id = in.nextInt();

                if (cacheMemory.containsKey(id)) {
                    System.out.println("Cache Memory contains this user.");
                    System.out.println("User:");
                    System.out.println("ID: " + id);
                    System.out.println("Name: " + cacheMemory.get(id));
                } else {

                    boolean userFound = false;

                    for (User user: dataBase) {
                        if (user.id == id) {
                            System.out.println("Data Base contains this user.");
                            System.out.println("User:");
                            System.out.println("ID:  " + user.id);
                            System.out.println("Name: " + user.name);

                            cacheMemory.put(user.id, user.name);
                            userFound = true;
                            break;
                        }
                    }

                    if (!userFound) System.out.println("This user does not exist in the DB.");
                }

            } else if (answer == 2) {
                break;
            } else {
                System.out.println("Select a valid option.");
                continue;
            }
        }

    }

}

class User {
    int id;
    String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }
}