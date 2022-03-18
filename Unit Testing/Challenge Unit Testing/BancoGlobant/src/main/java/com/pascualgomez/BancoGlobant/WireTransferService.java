package com.pascualgomez.BancoGlobant;

import org.springframework.stereotype.Service;

@Service
public class WireTransferService {

    private final BankAccountDAO bankAccountDAO;

    public WireTransferService(BankAccountDAO bankAccountDAO) {
        this.bankAccountDAO = bankAccountDAO;
    }

    //Transfer

    public void wireTransfer(int sourceAccountID, int targetAccountID, double amount) throws InvalidTargetFundsException, InsufficientFundsException {

        BankAccount sourceAccount = bankAccountDAO.get(sourceAccountID);
        BankAccount targetAccount = bankAccountDAO.get(targetAccountID);
        double amountToTransfer = amount;
        double amountToDebit = amount;

        //Verify funds
        verifyFunds(sourceAccount, amount);

        //validate bank
        double diffBankFee = validateBank(targetAccount) ? 0.0 : 3500.0;
        amountToDebit += diffBankFee;

        //validate current account
        if (targetAccount.getType().equals("current")) {
            validateAmountForCurrentAccount(targetAccount, amountToDebit);
        }

        //calculate Taxes
        double taxes = calculateTaxes(amount);
        amountToTransfer -= taxes;

        System.out.println(toStringTransferResults(sourceAccountID, targetAccountID,
                amountToTransfer, amountToDebit, taxes, diffBankFee));
    }

    public boolean verifyFunds(BankAccount bankAccount, double amount) throws InsufficientFundsException{

        if (bankAccount.getBalance() < amount) {
            throw new InsufficientFundsException("Insufficient funds to transfer.");
        }

        return true;
    }

    public double calculateTaxes(double amount) {

        return amount > 1500000.0 ? amount * 0.03 : 0;

    }

    public void validateAmountForCurrentAccount(BankAccount bankAccount,
                                                double amount) throws InvalidTargetFundsException{

        if (bankAccount.getBalance() > 3*amount) {
            throw new InvalidTargetFundsException("Balance in the target current account " +
                    "is invalid for the amount to transfer.");
        }
    }

    public boolean validateBank(BankAccount targetAccount) {
        return targetAccount.getBankId() == 5;
    }

    public String toStringTransferResults(int sourceID, int targetID,
                                          double amountToTransfer, double amountToDebit,
                                          double taxes, double bankFee) {
        return "Successful transfer!" +  "\n" +
                "From: " + sourceID +  "\n" +
                "To: " + targetID +  "\n" + "\n" +
                "Transfered amount: " + amountToTransfer + "\n" +
                "Bank fee: " + bankFee + "\n" +
                "Tax: " + taxes + "\n" +
                "Debited amount: " + amountToDebit;
    }

}
