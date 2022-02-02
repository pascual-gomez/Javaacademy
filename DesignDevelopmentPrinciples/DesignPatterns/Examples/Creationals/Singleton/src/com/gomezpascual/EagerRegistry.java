package com.gomezpascual;
/**
 * This class uses eager initialization of singleton instance.
 */
public class EagerRegistry {

    //Instance is created and initialized as soon as class is loaded
    private static final EagerRegistry INSTANCE = new EagerRegistry();

    private EagerRegistry() {

    }

    //Method to get unique instance
    public static EagerRegistry getInstance() {
        return INSTANCE;
    }
}