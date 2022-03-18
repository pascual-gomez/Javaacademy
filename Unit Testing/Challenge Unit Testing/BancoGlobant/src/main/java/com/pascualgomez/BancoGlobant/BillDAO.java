package com.pascualgomez.BancoGlobant;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class BillDAO {

    private final Map<String, Bill> bills = new HashMap<>();

    public Bill get(String id) {
        return bills.get(id);
    }

}
