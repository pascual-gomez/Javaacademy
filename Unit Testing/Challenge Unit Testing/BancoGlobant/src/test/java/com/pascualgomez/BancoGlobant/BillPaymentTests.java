package com.pascualgomez.BancoGlobant;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

@ExtendWith(MockitoExtension.class)
public class BillPaymentTests {

    @InjectMocks
    private BillPaymentService billPaymentService;

    @Mock
    private BillDAO billDAO;

    @Mock
    private BankAccountDAO bankAccountDAO;

    @Test
    void should_Pay_When_BalanceIsOK() throws InsufficientFundsException, InvalidTargetFundsException, InvalidBillIdException {
        //given
        Bill bill = new Bill(02,0012345,
                LocalDate.of(2020, 01, 01), 200.0);
        BankAccount bankAccount = new BankAccount("savings", "Pascual",
                "Gomez", 10, 300.0, 5,"Globant");

        when(billDAO.get(0012345)).thenReturn(bill);
        when(bankAccountDAO.get(10)).thenReturn(bankAccount);

        //when
        boolean actual = billPaymentService.payBill(bankAccount.getId(), bill.getBillId());

        //then
        assertTrue(actual);
    }

    @Test
    void should_ThrowException_When_FundsInsufficient()
            throws InsufficientFundsException, InvalidTargetFundsException, InvalidBillIdException {
        //given
        Bill bill = new Bill(02,0012345,
                LocalDate.of(2020, 01, 01), 100.0);
        BankAccount bankAccount = new BankAccount("savings", "Pascual",
                "Gomez", 10, 100.0, 5,"Globant");

        when(billDAO.get(0012345)).thenReturn(bill);
        when(bankAccountDAO.get(10)).thenReturn(bankAccount);

        //when
        Executable executable = () -> billPaymentService.payBill(bankAccount.getId(), bill.getBillId());

        //then
        assertThrows(InsufficientFundsException.class, executable);
    }

    @Test
    void should_Discount10Percent_When_AccountIsCurrent()
            throws InsufficientFundsException, InvalidTargetFundsException, InvalidBillIdException {
        //given
        Bill bill = new Bill(02,0012345,
                LocalDate.of(2020, 01, 01), 100.0);
        BankAccount bankAccount = new BankAccount("current", "Pascual",
                "Gomez", 10, 200.0, 5,"Globant");

        when(billDAO.get(0012345)).thenReturn(bill);
        when(bankAccountDAO.get(10)).thenReturn(bankAccount);

        //when
        billPaymentService.payBill(bankAccount.getId(), bill.getBillId());
        double actual = bankAccount.getBalance();
        double expected = 200 - 90;

        //then
        assertEquals(expected, actual);
    }

    @Test
    void should_ThrowException_When_BillIDIsWrong() throws InsufficientFundsException, InvalidTargetFundsException, InvalidBillIdException {
        //given
        Bill bill = new Bill(02,112345,
                LocalDate.of(2020, 01, 01), 200.0);
        BankAccount bankAccount = new BankAccount("savings", "Pascual",
                "Gomez", 10, 300.0, 5,"Globant");

        when(billDAO.get(112345)).thenReturn(bill);
        when(bankAccountDAO.get(10)).thenReturn(bankAccount);

        //when
        Executable executable = () -> billPaymentService.payBill(bankAccount.getId(), bill.getBillId());

        //then
        assertThrows(InvalidBillIdException.class, executable);
    }



}
