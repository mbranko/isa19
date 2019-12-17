# Asinhrono pozivanje koda kod EJB komponenti

*Message-driven beans* su EJB komponente namenjene za asinhronu konzumaciju
poruka. Poruke se mogu distribuirati putem redova (*queue*) ili tema
(*topic*). U slučaju redova svaka poruka se konzumira tačno jednom, dok
kod tema svi koji su pretplaćeni na datu temu dobijaju istu poruku na obradu.

## Potrebne stvari

* [Gradle](https://gradle.org)

## Priprema primera

Ako se koristi neko od razvojnih okruženja, projekat se može pripremiti 
za njih pomoću komande

`gradle eclipse`

ili 

`gradle idea`

Nakon toga se projekat može otvoriti u izabranom alatu i podešavanja za 
projekat će već biti inicijalizovana.

## Pokretanje primera

Iz osnovnog foldera pokrenuti

`gradle jar`

pa zatim pokrenuti

`java -jar build/libs/pr01.jar`

ili pokrenuti klasu `pr01.Test` iz razvojnog okruženja.

## Sadržaj primera

Klasa `Test` sadrži `main`. Poziva session bean koji će asinhrono pozivati
dva MDB-a, gde je prvi vezan za *queue* a drugi za *topic*. Reference na
queue i topic će dobiti pomoću dependency injection.
