package com.pascualgomez.BancoGlobant;

import org.springframework.stereotype.Service;

@Service
public class BillPaymentService {

    private final BankAccountDAO bankAccountDAO;
    private final BillDAO billDAO;

    public BillPaymentService(BankAccountDAO bankAccountDAO, BillDAO billDAO) {
        this.bankAccountDAO = bankAccountDAO;
        this.billDAO = billDAO;
    }

    public boolean payBill(int bankAccountID, long billID) throws InsufficientFundsException, InvalidBillIdException {
        BankAccount bankAccount = bankAccountDAO.get(bankAccountID);
        Bill bill = billDAO.get(billID);

        double price = bill.getPriceToPay();

        //Current account discount
        double discount = calculateDiscount(bankAccount, price);
        price -= discount;

        //Verify funds and bill ID
        if (verifyFunds(bankAccount, price) && validateBillID(bill.getBillId())) {
            bankAccount.setBalance(bankAccount.getBalance() - price);
            System.out.println("Successful payment!");
            return true;
        }

        return false;
    }

    public boolean verifyFunds(BankAccount bankAccount, double amount) throws InsufficientFundsException{

        if (bankAccount.getBalance() < amount*1.2) {
            throw new InsufficientFundsException("Insufficient funds to transfer.");
        }

        return true;
    }

    public double calculateDiscount(BankAccount bankAccount, double amount) {
        return bankAccount.getType().equals("current") ? amount*0.1 : 0.0;
    }

    public boolean validateBillID(long billID) throws InvalidBillIdException {
        if (billID / 100000 == 0 && billID / 1000000 == 0) {
            return true;
        } else {
            throw new InvalidBillIdException("Invalid Bill ID.");
        }
    }


}
