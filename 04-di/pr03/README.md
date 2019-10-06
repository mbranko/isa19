# Primer korišćenja dependency injection za Spring

Primer korišćenja dependency injection za Spring komponente: anotacija
`@Autowired`.

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

`DIApp` pokreće konzolnu Spring aplikaciju. Kreira instancu `PurchaseBean` i
poziva je. Njoj je potrebna referenca na PaymentBean što će dobiti zahvaljujući
anotaciji `@Autowired`.
