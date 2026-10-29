package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BankAccountTest {

    private BankAccount account;

    @BeforeEach
    void setUp() {
        account = new BankAccount();
    }

    @Test
    @DisplayName("Új számla egyenlege 0")
    void newAccountHasZeroBalance() {
        assertEquals(0.0, account.getBalance());
    }

    @Test
    @DisplayName("Befizetés növeli az egyenleget")
    void depositIncreasesBalance() {
        account.deposit(1000);

        assertEquals(1000.0, account.getBalance());
    }

    @Test
    @DisplayName("Több befizetés összeadódik")
    void multipleDepositsAreAdded() {
        account.deposit(1000);
        account.deposit(500);

        assertEquals(1500.0, account.getBalance());
    }

    @Test
    @DisplayName("Pénzfelvétel csökkenti az egyenleget")
    void withdrawDecreasesBalance() {
        account.deposit(1000);

        account.withdraw(300);

        assertEquals(700.0, account.getBalance());
    }

    @Test
    @DisplayName("A teljes egyenleg felvehető")
    void canWithdrawEntireBalance() {
        account.deposit(1000);

        account.withdraw(1000);

        assertEquals(0.0, account.getBalance());
    }

    @Test
    @DisplayName("Nem lehet több pénzt felvenni, mint az egyenleg")
    void cannotWithdrawMoreThanBalance() {
        account.deposit(500);

        assertThrows(
            IllegalArgumentException.class,
            () -> account.withdraw(1000)
        );

        assertEquals(500.0, account.getBalance());
    }

    @Test
    @DisplayName("Negatív összeg nem fizethető be")
    void negativeDepositThrowsException() {
        assertThrows(
            IllegalArgumentException.class,
            () -> account.deposit(-100)
        );

        assertEquals(0.0, account.getBalance());
    }

    @Test
    @DisplayName("Nulla összeg nem fizethető be")
    void zeroDepositThrowsException() {
        assertThrows(
            IllegalArgumentException.class,
            () -> account.deposit(0)
        );

        assertEquals(0.0, account.getBalance());
    }

    @Test
    @DisplayName("Negatív összeg nem vehető fel")
    void negativeWithdrawThrowsException() {
        account.deposit(500);

        assertThrows(
            IllegalArgumentException.class,
            () -> account.withdraw(-100)
        );

        assertEquals(500.0, account.getBalance());
    }

    @Test
    @DisplayName("Nulla összeg nem vehető fel")
    void zeroWithdrawThrowsException() {
        account.deposit(500);

        assertThrows(
            IllegalArgumentException.class,
            () -> account.withdraw(0)
        );

        assertEquals(500.0, account.getBalance());
    }
}