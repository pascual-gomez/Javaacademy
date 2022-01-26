package com.gomezpascual;

abstract class Process {

    int size;
    String id;
    int count = 1;

    Process(char type, int min, int max) {
        count++;
        setId(count, type);
        setSize(min, max);
    }

    public void setId(int id, char type) {
        this.id = type + "00" + id;
    }

    public void setSize(int min, int max) {
        this.size = (int) (Math.random() * (max-min+1) + min);
    }
}
