# Primer opsega vidljivosti za Spring komponente

Ilustracija pristupa Spring komponentama koje imaju različit *scope*. Postoji 
šest različitih mogućnosti za *scope*:

* `singleton`: podrazumevani opseg; kreira se jedna instanca objekta za ceo
Spring kontekst (`ApplicationContext`)
* `prototype`: kreira se nova instanca objekta svaki put kada se objekat 
zatraži
* `request`: kreira se nova instanca objekta za svaki HTTP zahtev
* `session`: kreira se nova instanca objekta za svaku HTTP sesiju
* `globalSession`: kreira se nova instanca objekta za svaku globalnu HTTP 
sesiju (za portlet aplikacije)
* `application`: kreira se jedna instanca objekta za ceo `ServletContext`

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

`gradle run`

## Pokretanje primera

Otvorite browser na adresi 
[http://localhost:8080/scopes](http://localhost:8080/scopes)

## Sadržaj primera

`ScopesController` je klasa koja opslužuje zahteve poslate na `/scopes` URL.
U njene atribute će biti upisane komponente različitih opsega. Vrednosti
brojača iz tih komponenti će biti korišćene u prikazu.

Za prikaz HTML sadržaja se koristi template stranica `scopes.html` pisana za
*Thymeleaf* template engine. 