package com.pascualgomez.BancoGlobant;

public class BankAccount {

    String type;
    String ownerName;
    String ownerLastname;
    int id;
    double balance;

    int bankId;
    String bankName;

    public String getType() {
        return type;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getOwnerLastname() {
        return ownerLastname;
    }

    public int getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public int getBankId() {
        return bankId;
    }

    public String getBankName() {
        return bankName;
    }
}
