package com.gomezpascual;

public class Government {
    // Static variable reference of type Government
    private static Government single_instance = null;

    // Declaring a variable of type String for President of the United States
    public String potus;

    // Private constructor
    private Government() {
        potus = "Joe Biden";
    }

    // Static method to create instance of Singleton class
    public static Government getInstance() {
        if (single_instance == null)
            single_instance = new Government();

        return single_instance;
    }

}
