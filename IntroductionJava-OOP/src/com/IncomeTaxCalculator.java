package com.gomezpascual;

public class IncomeTaxCalculator {

    public static void main(String[] args) {
        final double TAX_RATE_ABOVE_20K = 0.1;
        final double TAX_RATE_ABOVE_40K = 0.2;
        final double TAX_RATE_ABOVE_60K = 0.3;

        int taxableIncome = 62000;
        double taxPayable;

        if (taxableIncome <= 20000) {         // [0, 20000]
            taxPayable = 0;
        } else if (taxableIncome <= 40000) {  // [20001, 40000]
            taxPayable = taxableIncome * TAX_RATE_ABOVE_20K;
        } else if (taxableIncome <= 60000) {  // [40001, 60000]
            taxPayable = taxableIncome * TAX_RATE_ABOVE_40K;
        } else {                              // [60001, ]
            taxPayable = taxableIncome * TAX_RATE_ABOVE_60K;
        }

        // Print results rounded to 2 decimal places
          System.out.printf("The income tax payable is: $%.2f%n", taxPayable);
    }
}
