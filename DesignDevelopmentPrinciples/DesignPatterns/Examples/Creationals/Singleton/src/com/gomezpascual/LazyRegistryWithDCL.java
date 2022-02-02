package com.gomezpascual;

/**
 * This class demonstrates singleton pattern using Double Checked Locking or "classic" singleton.
 * This is also a lazy initializing singleton.
 * Although this implementation solves the multi-threading issue with lazy initialization using volatile
 * and double check locking, the volatile keyword is guaranteed to work only after JVMs starting with
 * version 1.5 and later.
 */
public class LazyRegistryWithDCL {
    //Volatile is important for the DCL
    public static volatile LazyRegistryWithDCL INSTANCE;

    private LazyRegistryWithDCL() {

    }

    //Method to get unique instance
    public static LazyRegistryWithDCL getInstance() {
        //Double check lock
        if (INSTANCE == null) {
            //Check with two threads INSTANCE is null
            synchronized (LazyRegistryWithDCL.class) {
                if (INSTANCE == null) {
                    INSTANCE = new LazyRegistryWithDCL();
                }
            }
        }

        return INSTANCE;
    }
}
