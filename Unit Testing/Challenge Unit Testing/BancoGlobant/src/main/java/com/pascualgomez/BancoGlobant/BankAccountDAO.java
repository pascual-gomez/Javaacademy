package com.pascualgomez.BancoGlobant;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class BankAccountDAO {

    private final Map<String, BankAccount> bankAccounts = new HashMap<>();

    public BankAccount get(int id) {
        return bankAccounts.get(id);
    }

}
