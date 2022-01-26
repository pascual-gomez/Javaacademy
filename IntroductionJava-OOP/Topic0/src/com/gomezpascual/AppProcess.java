package com.gomezpascual;

public class AppProcess extends Process {

    static final int MAX_SIZE = 20;
    static final int MIN_SIZE = 10;
    static final char TYPE = 'a';

    AppProcess() {
        super(TYPE, MIN_SIZE, MAX_SIZE);
    }
}
