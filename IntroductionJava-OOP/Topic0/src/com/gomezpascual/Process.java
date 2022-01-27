package com.gomezpascual;

public class Process implements Comparable<Process> {

    int size;
    int id;
    static int count = 1;
    char type;

    Process(char type, int min, int max) {
        setId(count);
        setSize(min, max);
        this.type = type;
        count++;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSize(int min, int max) {
        this.size = (int) (Math.random() * (max-min+1) + min);
    }

    public String getString() {
        return new String(this.type + String.format("%03d", this.id));
    }

    @Override
    public int compareTo(Process o) {
        Integer thisID = this.id;
        Integer argumentID = o.id;
        return thisID.compareTo(argumentID);
    }
}
