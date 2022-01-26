package com.gomezpascual;

public class SystemProcess extends Process {

    static final int MAX_SIZE = 15;
    static final int MIN_SIZE = 5;
    static final char TYPE = 's';

    SystemProcess() {
        super(TYPE, MIN_SIZE, MAX_SIZE);
    }

}
