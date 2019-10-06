# EJB: bean1 zove bean2 uz uspostavljanje veza pomoću dependency injection

Jedan bean dobija referencu na drugog pomoću dependency injection mehanizma
koga pruža EJB kontejner.

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

`gradle alljars`

## Pokretanje primera

`java -jar build/libs/Server.jar`

`java -jar build/libs/Client.jar`

## Sadržaj primera

Klasa `Server` inicijalizuje EJB kontejner koji će automatski prepoznati
sve EJB komponente u classpath-u i registrovati ih. Klasa `Client` je
klijentski program koji će pronaći i pozvati `PurchaseBean`.

`PurchaseBean` će interno pozivati `PaymentBean` za šta mu je potrebna
referenca na njega. Referencu će dobaviti pomoću *dependency injection*
mehanizma.

Treba obratiti pažnju na ispravnost međusobnog pozivanja session beanova.

| Tip poziva             | Ispravnost |
| ---------------------- | ---------- |
| stateless -> stateful  | OK         |
| stateless -> stateless | OK         |
| stateful  -> stateful  | OK         |
| stateful  -> stateless | zabranjeno |
