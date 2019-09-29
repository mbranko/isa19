# Primer osnovnog HTTP servera

Ovaj primer predstavlja implementaciju elementarnog HTTP servera u Javi.

## Potrebne stvari

* [Gradle](https://gradle.org)

## Korisne stvari

* [Eclipse](https://www.eclipse.org)
* [IntelliJ IDEA](https://www.jetbrains.com/idea/)
* [Postman](https://www.getpostman.com)

## Priprema primera

Ako se koristi neko od razvojnih okruženja, projekat se može pripremiti za njih pomoću komande

`gradle eclipse`

ili 

`gradle idea`

Nakon toga se projekat može otvoriti u izabranom alatu i podešavanja za projekat će već biti inicijalizovana.

## Pokretanje primera

Iz osnovnog foldera pokrenuti

`gradle jar`

pa zatim pokrenuti

`java -jar build/libs/pr01.jar`

ili pokrenuti klasu `pr01.Server` iz razvojnog okruženja.

Potom u browseru ili Postmanu poslati GET zahtev na adresu `http://localhost:8080`. Nakon toga isprobati i slanje POST 
zahteva na isti URL.

## Sadržaj primera

Klasa `pr01.Server` je ulazna tačka programa gde se zauzima port 8080 i u beskonačnoj petlji čeka na otvaranje TCP 
konekcije. Za svaku otvorenu konekciju pokreće se posebna nit za obradu zahteva. 

Klasa `ThreadZaObraduZahteva` predstavlja nit za obradu zahteva. Analizira se samo prvi red HTTP zahteva, odnosno samo 
HTTP metoda u okviru prvog reda. Ako je u pitanju `GET` metoda, vraća se odgovor sa statusom `200` i pozdravnom HTML 
stranicom a u suprotnom šalje se odgovor sa statusom `405` (*Method not allowed*).

## HTTP statusi

Pregledna i čitka lista HTTP status kodova nalazi se na https://httpstatuses.com 