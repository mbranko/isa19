# Anotacijama definisana perzistencija POJO klasa

Elementarni primer mapiranja POJO klasa na relacionu bazu na osnovu anotacija.
Koristi se JPA standard za objektno-relaciono mapiranje. 

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

`java -jar build/libs/pr03.jar`

ili pokrenuti klasu `pr03.Test` iz razvojnog okruženja.

## Sadržaj primera

Klasa `Admin` je POJO klasa čije mapiranje na bazu je definisano JPA
anotacijama. Klasa `Test` ilustruje operacije nad instancama klase `Admin`.
