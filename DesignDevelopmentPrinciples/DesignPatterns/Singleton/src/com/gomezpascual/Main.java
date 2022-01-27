package com.gomezpascual;

public class Main {

    public static void main(String[] args) {
	    //Instantiating class Government in three different gov variables
        Government gov1 = Government.getInstance();
        Government gov2 = Government.getInstance();
        Government gov3 = Government.getInstance();

        //Verify they reference all to the same instance
        if (gov1 == gov2 && gov2 == gov3) {
            System.out.println("The three objects point to the same memory location.");
        } else {
            System.out.println("The three object do not point to the same memory location.");
        }
    }
}
