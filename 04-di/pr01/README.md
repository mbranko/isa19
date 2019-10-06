# Dependency Injection pomoću Google Guice

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

`ServiceMessage` interfejs definiše operacije koje nudi injektovani servis.
`EmailService` je jedna implementacija ovog interfejsa - simulira slanje 
poruke putem emaila. Ova klasa je anotirana sa `@Singleton` što označava
klasama koje rade ubrizgavanje kako treba rukovati ovom klasom. Primer druge
implementacije servisa za slanje poruka je `FacebookService`.

Google Guice omogućava i *setter-based* i *constructor-based* ubrizgavanje.
Klasa koja prima ubrizgani objekat je `MyApp`. U njoj se nalazi primer za
obe vrste ubrizgavanja. 

Da bi Guice znao koji servis da ubrizga, moramo napraviti konfiguraciju za
njega. Konfiguracija je data klasom `AppInjector` koja implementira 
`configure()` metodu.

Klijentska aplikacija je predstavljena klasom `ClientApp`. Objekat `injector`
će poslužiti za instanciranje klasa. 

Klasa `MockMessageService` je lažna (*mock*) implementacija servisa koja će
nam poslužiti prilikom pokretanja JUnit testova. Kao konfiguracija injektora
koristi se anonimna klasa koja implementira `AbstractModule`.
