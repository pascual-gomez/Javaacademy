package com.gomezpascual;

import java.awt.event.WindowStateListener;

/**
 * Singleton pattern using lazy initialization holder class. This ensures that, we have a lazy initialization
 * without worrying about synchronization.
 */
public class LazyRegistryIODH {

    private LazyRegistryIODH() {
        System.out.println("Instance created.");
    }

    //Encapsulated class that loads when getInstance() is called
    private static class RegistryHolder {
        static LazyRegistryIODH INSTANCE = new LazyRegistryIODH();
    }

    //Method to get unique instancec
    public static LazyRegistryIODH getInstance() {
        return RegistryHolder.INSTANCE;
    }
}
