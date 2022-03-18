package com.pascualgomez.BancoGlobant;

import java.time.LocalDate;

public class Bill {

    int companyId;
    int billId;
    LocalDate expireDate;
    double priceToPay;

    public int getCompanyId() {
        return companyId;
    }

    public int getBillId() {
        return billId;
    }

    public LocalDate getExpireDate() {
        return expireDate;
    }

    public double getPriceToPay() {
        return priceToPay;
    }
}
