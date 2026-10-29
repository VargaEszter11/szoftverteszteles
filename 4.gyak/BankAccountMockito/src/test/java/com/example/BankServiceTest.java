package com.example;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class BankServiceTest {

    @Test
    void depositSendsNotification() {

        NotificationService notificationService =
            mock(NotificationService.class);

        BankService bankService =
            new BankService(notificationService);

        BankAccount account =
            new BankAccount();

        bankService.deposit(account, 1000);

        assertEquals(
            1000.0,
            account.getBalance()
        );        

        verify(notificationService)
            .send("Deposit successful");
    }
}