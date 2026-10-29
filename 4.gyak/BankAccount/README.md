# BankAccount

3. feladat – Java, Maven, JUnit 5.

A `BankAccount` osztály egy egyszerű bankszámlát modellez (`deposit`, `withdraw`, `getBalance`).
Az induló egyenleg 0. A 0 vagy negatív összegű befizetés és pénzfelvétel, valamint a többletfelvétel
`IllegalArgumentException`-t dob, és az egyenleg nem változik.

Tesztek: `BankAccountTest` (JUnit 5).

## Futtatás

Követelmények: Java 21 és Maven.

```
cd 4.gyak/BankAccount
mvn clean test
```
