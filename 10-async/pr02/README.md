# Asinhrono pozivanje metoda u Springu

Primer pozivanja asinhronih metoda Spring beanova u slučajevima kada
metoda ne vraća odnosno vraća rezultat.

## Potrebne stvari

* [Gradle](https://gradle.org)

## Priprema primera

Ako se koristi neko od razvojnih okruženja, projekat se može pripremiti za 
njih pomoću komande

`gradle eclipse`

ili 

`gradle idea`

Nakon toga se projekat može otvoriti u izabranom alatu i podešavanja za 
projekat će već biti inicijalizovana.

## Bildovanje primera

`gradle build`

## Pokretanje primera

`gradle run`

## Sadržaj primera

Klasa `AsyncApp` pokreće primer. Kreira se jedan bean klase `PaymentClient`.
Ovaj bean će dobiti referencu na `PaymentProcessor` pomoću dependency 
injection. `PaymentProcessor` ima dve metode, obe anotirane sa `@Async`, gde
jedna ne vraća rezultat a druga vraća. Obe se pozivaju iz `PaymentClient`
beana, i rezultat se prihvata u asinhronom maniru.
