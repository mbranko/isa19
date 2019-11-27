# Tri načina za upravljanje transakcijama u EJB

Ilustracija tri načina za upravljanje transakcijama kod EJB komponenti:
 * *container-managed*: deklarativno upravljanje transakcijama na osnovu anotacija od strane EJB kontejnera 
 * *bean-managed*: programsko (ručno) upravljanje transakcijama od strane EJB komponente
 * *client-managed*: programsko (ručno) upravljanje transakcijama od strane klijenta 

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

Klasa `Test` sadrži `main`. Pokreće tri primera koji ilustruju različite
načine za kontrolu transakcija.
