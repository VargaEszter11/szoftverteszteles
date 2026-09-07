# Tesztesetek:

## DiscountCalculator:

1. 10 ezer ft alatt
2. 10 ezer és 24999 közt
3. 25 ezer és 49999 közt
4. 50 ezer felett
5. VIP ügyfélre
6. 20% feletti kedvezményre 
7. negatív pénzre

Hibák: 
>= 10000
< 50000
>= 50000
discount 0.05 legyen
orderValue - orderValue * discount
nincs negatív ellenőrzés

## ParkingFeeCalculator

1. 15 perc alatt
2. 15 perc felett, teljes óra
3. 5000 ft felett ne növekedjen a díj
4. hétvége
5. VIP ügyfélre
6. negatív időre
7. pontosan 15 perc
8. megkezdett órára
9. levonja-e az ingyenes 15 percet

Hibák:
nincs negatív ellenőrzés
<=15
óraszámítás nem vonja le az első 15 percet
részleges óra is 600 ft
VIP esetén jelenleg 20 ft-ot von le

## CinemaTicketCalculator

1. 6 éves kor alatt ingyen
2. 6-17-ig -30%
3. 65 éves kortól -40%
4. diák -20%
5. több kedvezmény esetén a legnagyobb alkalmazódjon
6. 3D-re ad-e hozzá felárat
7. 3D-re nincs kedvezmény
8. negatív életkor
9. 120 felett

Hibák: 
nincs életkor kezelés
<6
>=65
a kedvezmények összeadódnak, de ez nem jó
3D jelenleg 1.8-szorosra növeli az árat pedig csak +800 ft
3D-re nincs kedvezmény

## Szállítási díj

1. 5 kg alatti-elvárt eredmény: 1500 ft
2. pontosan 5 kg-elvárt eredmény: 2500 ft
3. 5 és 20 kg között-elvárt eredmény: 2500 ft
4. pontosan 20 kg-elvárt eredmény: 2500 ft
5. 20 kg felett-elvárt eredmény: 5000 ft
6. MO 20 ezer alatt-elvárt eredmény: az aktuális szállítási ár
7. MO 20 ezer felett-elvárt eredmény: 0 ft
8. külföldre kétszeres-elvárt eredmény: szállítási ár kétszerese
9. expressz szállítás-elvárt eredmény: szállítási ár 150%-a
10. érték negatív-elvárt eredmény: error
11. tömeg negatív-elvárt eredmény: error
12. országkód vegyes írásmód-elvárt eredmény: error
13. MO pontosan 20 ezer-elvárt eredmény: 0 ft
14. 20 ezer felett MO, de expressz-0 ft
15. külföldre expressz-mindkettő szorzó
16. országkód kisbetűvel-success
17. országkód nagybetűvel-success

Hibák:
súlyhatárok
országkód kis-nagybetű érzékeny
expressz felár képlet rossz
rendelési tömeg nincs ellenőrizve
országkód nincs ellenőrzive

## ExamGradeCalculator

1. elmélet nagyobb mint 60 pont
2. gyakorlat nagoybb mint 40 pont
3. elmélet kisebb mint 30 pont
4. gyakotlat kisebb mint 20 pont
5. összpontszám 0-49 - csak valamiből bukással érhető el
6. összpontszám 50-59
7. összpontszám 60-69
8. összpontszám 70-84
9. összpontszám 85-100
10. negatív elméleti pontszám
11. negatív gyakorlati pontszám
12. elmélet és gyakorlat is kisebb mint a minimum

Hibák:
bukás feltételébe || kell
jegy felső határok elcsúszva
bemenet nem validált

## PackageClassifier

1. 2 kg alatt és belefér a méretbe, pontosan a határon
2. 2 kg alatt, méret Medium-tartományba esik
3. 2 kg alatt, méret Large-tartományba esik
4. 2 kg alatt, méret minden tartományt meghalad
5. 2 kg felett de méretben Small-nak megfelelő
6. 2-10 kg között és belefér a méretbe, pontosan a határon
7. 2-10 kg között, méret Large-tartományba esik
8. 2-10 kg között, méret minden tartományt meghalad
9. 10 kg-nél nagyobb de méretben Medium-nak megfelelő
10. 10-30 kg és jó méret, pontosan a határon
11. 10-30 kg de méretben nagy
12. 30 kg felett de jó méret
13. 30 kg felett ÉS méretben is nagy
14. 0 méret
15. negatív méret
16. 0 súly
17. negatív súly

Hibák:
méretek, súlyok nincsenek validálva
small < a <= helyett
mediumnál || kell
