package hu.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class BankAccountTest {

    @Test
    void newAccountHasZeroBalance() {
        BankAccount account = new BankAccount();

        assertEquals(0, account.getBalance());
    }

    @Test
    void depositIncreasesBalance() {
        BankAccount account = new BankAccount();

        account.deposit(1000);

        assertEquals(1000, account.getBalance());
    }

    @Test
    void multipleDepositsAddUp() {
        BankAccount account = new BankAccount();

        account.deposit(1000);
        account.deposit(500);
        account.deposit(250.5);

        assertEquals(1750.5, account.getBalance());
    }

    @Test
    void withdrawDecreasesBalance() {
        BankAccount account = new BankAccount();
        account.deposit(1000);

        account.withdraw(300);

        assertEquals(700, account.getBalance());
    }

    @Test
    void wholeBalanceCanBeWithdrawn() {
        BankAccount account = new BankAccount();
        account.deposit(1000);

        account.withdraw(1000);

        assertEquals(0, account.getBalance());
    }

    @Test
    void withdrawMoreThanBalanceThrows() {
        BankAccount account = new BankAccount();
        account.deposit(1000);

        assertThrows(IllegalArgumentException.class, () -> account.withdraw(1000.01));
        assertEquals(1000, account.getBalance());
    }

    @Test
    void negativeDepositThrows() {
        BankAccount account = new BankAccount();

        assertThrows(IllegalArgumentException.class, () -> account.deposit(-100));
        assertEquals(0, account.getBalance());
    }

    @Test
    void zeroDepositThrows() {
        BankAccount account = new BankAccount();

        assertThrows(IllegalArgumentException.class, () -> account.deposit(0));
    }

    @Test
    void negativeWithdrawalThrows() {
        BankAccount account = new BankAccount();
        account.deposit(1000);

        assertThrows(IllegalArgumentException.class, () -> account.withdraw(-100));
        assertEquals(1000, account.getBalance());
    }

    @Test
    void zeroWithdrawalThrows() {
        BankAccount account = new BankAccount();
        account.deposit(1000);

        assertThrows(IllegalArgumentException.class, () -> account.withdraw(0));
    }
}
