package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class BankServiceMockAnnotationTest {

    @Mock
    private NotificationService notificationService;

    @InjectMocks
    private BankService bankService;

    @Test
    void depositSendsNotificationWithManualMock() {

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

    @Test
    void depositSendsNotificationWithAnnotations() {

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
