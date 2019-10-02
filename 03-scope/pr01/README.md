# Primer pozivanja stateful, stateless i singleton EJB komponenti

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
klijentski program koji će pronaći tri *session bean* komponente i pozvati
ih preko mreže.

Tri *session bean* komponente su:

* `HelloBean`: *stateless* komponenta koja vraća odgovor na poslati string
* `CountBean`: *stateful* komponenta koja inkrementira brojač
* `SingletonCountBean`: *singleton* komponenta koja inkremetira brojač 

Klijentski program treba pozvati više puta i analizirati rezultate 
izvršavanja.