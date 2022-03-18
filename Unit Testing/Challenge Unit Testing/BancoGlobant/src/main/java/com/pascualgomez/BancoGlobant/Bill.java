package com.pascualgomez.BancoGlobant;

import java.time.LocalDate;

public class Bill {

    int companyId;
    long billId;
    LocalDate expireDate;
    double priceToPay;

    Bill(int companyId, int billId, LocalDate expireDate, double priceToPay) {
        this.companyId = companyId;
        this.billId = billId;
        this.expireDate = expireDate;
        this.priceToPay = priceToPay;
    }

    public int getCompanyId() {
        return companyId;
    }

    public long getBillId() {
        return billId;
    }

    public LocalDate getExpireDate() {
        return expireDate;
    }

    public double getPriceToPay() {
        return priceToPay;
    }
}
