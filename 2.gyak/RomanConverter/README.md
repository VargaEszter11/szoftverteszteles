# Arab szám → római szám konverter

JavaScript, QUnit, TDD módszerrel készítve. Az 1 és 3999 közötti egész számokat alakítja római számmá.
Érvénytelen bemenetre (0, negatív, nem egész, 3999 feletti, nem szám, hiányzó érték) üres stringet ad vissza.

## Futtatás

```
cd 2.gyak/RomanConverter
npm install
npm test
```

A függvény: `romanConverter(num)` az `app.js` fájlban.

## Tesztek

A QUnit tesztek a `tests.js` fájlban vannak: alapszimbólumok és ismétlésük, kivonásos jelölés (IV, IX, XL, XC, CD, CM), összetett számok, évszámok, a 3999 határérték és az érvénytelen bemenetek.

## Fejlesztési folyamat

A megoldás TDD-vel készült: minden funkcióhoz külön `(red)` commit tartalmazza az elbukó tesztet, a `(green)` commit pedig a minimális implementációt. A refaktorálás a megfelelő green commitban szerepel.
