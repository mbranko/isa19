# Različite strategije za izbor primarnog ključa

Ilustracija rada sa prirodnim i surogatnim primarnim ključevima u okviru JPA.

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

`java -jar build/libs/pr06.jar`

ili pokrenuti klasu `pr06.Test` iz razvojnog okruženja.

## Sadržaj primera

Različiti primeri rada sa primarnim ključevima:

**1) Kada se koriste surogatni ključevi:** jedinstvene vrednosti se generišu pomoću
 * identity kolone: `PrimerIdentity`
 * sekvence: `PrimerSequence`
 * posebne tabele sa brojačima: `PrimerTable`
   
**2) Kada se koriste prirodni ključevi:**
Ako se primarni ključ sastoji iz jedne kolone, odgovarajući atribut entitija se
označava sa `@Id`. Ako se primarni ključ sastoji iz više kolona, svaki atribut se
označava sa `@Id`, i mora se napraviti posebna "primary key" klasa koja sadrži sve
atribute koji čine primarni ključ. Ako jedan deo primarnog ključa predstavlja 
spoljni ključ, atribut koji je veza prema roditelju se označava sa `@Id` i 
`@JoinColumns`; PK klasa sadrži u sebi atribut-vezu prema PK klasi roditelja.

