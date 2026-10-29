# BankAccountMockito

4. feladat – Java, Maven, JUnit 5 és Mockito.

- `NotificationService` interfész és `BankService`, amely befizetés után értesítést küld (az értesítési szolgáltatás konstruktoron keresztül kerül be).
- `ExchangeRateService` interfész, amelynek viselkedését a teszt `when(...).thenReturn(...)`-nel állítja be.
- `BankAccount`: a 3. feladatban elkészített számlaosztály, amelyet a `BankService` használ.

Tesztek: `BankServiceTest`, `BankServiceMockAnnotationTest`, `ExchangeRateServiceTest` (`mock()`, `verify()`, `when().thenReturn()`).

## Futtatás

Követelmények: Java 21 és Maven.

```
cd 4.gyak/BankAccountMockito
mvn clean test
```
