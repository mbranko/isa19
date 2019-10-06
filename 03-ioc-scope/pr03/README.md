# Životni ciklus EJB komponenti

Session bean sa metodama za obradu događaja životnog ciklusa.

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
klijentski program koji će pronaći i pozvati *stateful session bean*.

Ovaj stateful session bean ima metode namenjene obradi događaja iz njegovog
životnog ciklusa. U pitanju su metode čije ime nije bitno, nemaju parametre,
a imaju odgovarajuće anotacije:

* `PostConstruct`: poziva se nakon kreiranja komponente a pre njene upotrebe
* `PreDestroy`: poziva se pre uklanjanja komponente
* `PrePassivate`: poziva se pre pasivacije komponente
* `PostActivate`: poziva se nakon aktivacije komponente

Metoda sa anotacijom `Remote` služi da najavi EJB kontejneru da dati bean više
neće biti korišćen. Nakon poziva ove metode dalji pozivi istog beana nisu
dozvoljeni.
