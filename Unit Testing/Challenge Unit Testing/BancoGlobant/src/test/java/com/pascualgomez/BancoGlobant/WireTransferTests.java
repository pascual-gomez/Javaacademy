package com.pascualgomez.BancoGlobant;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class WireTransferTests {

    @InjectMocks
    private WireTransferService wireTransferService;

    @Mock
    private BankAccountDAO bankAccountDAO;

    @Test
    void should_WireTransfer_When_BalanceOK() throws InsufficientFundsException, InvalidTargetFundsException {
        //given
        BankAccount bankAccount = new BankAccount("savings", "Pascual",
                "Gomez", 12, 300.0, 5,"Globant");
        BankAccount bankAccount2 = new BankAccount("savings", "Pascual",
                "Gomez", 10, 100.0, 5,"Globant");
        when(bankAccountDAO.get(12)).thenReturn(bankAccount);
        when(bankAccountDAO.get(10)).thenReturn(bankAccount2);

        //when
        boolean expected = wireTransferService.wireTransfer(bankAccount.getId(), bankAccount2.getId(), 200.0);

        //then
        assertEquals(expected, true);
        assertEquals(bankAccount.getBalance(), 100.0);
        assertEquals(bankAccount2.getBalance(), 300.0);
    }

    @Test
    void should_ThrowException_When_BalanceInsufficient() throws InsufficientFundsException, InvalidTargetFundsException {
        //given
        BankAccount bankAccount = new BankAccount("savings", "Pascual",
                "Gomez", 12, 100.0, 5,"Globant");
        BankAccount bankAccount2 = new BankAccount("savings", "Pascual",
                "Gomez", 10, 100.0, 5,"Globant");
        when(bankAccountDAO.get(12)).thenReturn(bankAccount);
        when(bankAccountDAO.get(10)).thenReturn(bankAccount2);

        //when
        Executable executable = () -> wireTransferService.wireTransfer(bankAccount.getId(), bankAccount2.getId(), 200.0);

        //then
        assertThrows(InsufficientFundsException.class, executable);
    }

    @Test
    void should_ThrowException_When_TargetInvalidFunds() throws InsufficientFundsException, InvalidTargetFundsException {
        //given
        BankAccount bankAccount = new BankAccount("savings", "Pascual",
                "Gomez", 12, 300.0, 5,"Globant");
        BankAccount bankAccount2 = new BankAccount("current", "Pascual",
                "Gomez", 10, 1000.0, 5,"Globant");
        when(bankAccountDAO.get(12)).thenReturn(bankAccount);
        when(bankAccountDAO.get(10)).thenReturn(bankAccount2);

        //when
        Executable executable = () -> wireTransferService.wireTransfer(bankAccount.getId(), bankAccount2.getId(), 200.0);

        //then
        assertThrows(InvalidTargetFundsException.class, executable);
    }

    @Test
    void should_debitMoreMoney_When_BankIsNotGlobant() throws InsufficientFundsException, InvalidTargetFundsException {
        //given
        BankAccount bankAccount = new BankAccount("savings", "Pascual",
                "Gomez", 12, 30000.0, 5,"Globant");
        BankAccount bankAccount2 = new BankAccount("current", "Pascual",
                "Gomez", 10, 10000.0, 3,"Globant");
        when(bankAccountDAO.get(12)).thenReturn(bankAccount);
        when(bankAccountDAO.get(10)).thenReturn(bankAccount2);

        //when
        wireTransferService.wireTransfer(bankAccount.getId(), bankAccount2.getId(), 20000.0);
        double actual = bankAccount.getBalance();
        double expected = 6500;

        //then
        assertEquals(expected, actual);
    }

    @Test
    void should_Debit3Percent_When_WireIsMoreThan1500000() throws InsufficientFundsException, InvalidTargetFundsException {
        //given
        BankAccount bankAccount = new BankAccount("savings", "Pascual",
                "Gomez", 12, 5000000.0, 5,"Globant");
        BankAccount bankAccount2 = new BankAccount("current", "Pascual",
                "Gomez", 10, 1000000.0, 3,"Globant");
        when(bankAccountDAO.get(12)).thenReturn(bankAccount);
        when(bankAccountDAO.get(10)).thenReturn(bankAccount2);

        //when
        wireTransferService.wireTransfer(bankAccount.getId(), bankAccount2.getId(), 2000000.0);
        double expected = 1000000 + (2000000 * 0.97);
        double actual = bankAccount2.getBalance();
        //then
        assertEquals(expected, actual);
    }
}
