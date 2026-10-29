package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

class ExchangeRateServiceTest {

    @Test
    void mockReturnsTheConfiguredRate() {

        ExchangeRateService rateService =
            mock(ExchangeRateService.class);

        when(
            rateService.getRate("EUR", "HUF")
        ).thenReturn(400.0);

        assertEquals(
            400.0,
            rateService.getRate("EUR", "HUF")
        );
    }
}
