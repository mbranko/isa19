# Ilustracija pristupa bazi iz servleta

Prethodni primer je prerađen tako da se za svaku nit za obradu zahteva na serveru
koristi posebna konekcija, a konekcije se pri tome recikliraju u okviru
connection pool strukture.

## Potrebne stvari

* [Gradle](https://gradle.org)

## Priprema primera

Ako se koristi neko od razvojnih okruženja, projekat se može pripremiti za njih pomoću komande

`gradle eclipse`

ili 

`gradle idea`

Nakon toga se projekat može otvoriti u izabranom alatu i podešavanja za projekat će već biti inicijalizovana.

## Pokretanje primera

Iz osnovnog foldera pokrenuti

`gradle appRunWar`

pa zatim otvoriti browser na adresi (GET zahtev): http://localhost:8080/pr03/list

## Sadržaj primera

Web aplikacija ima dva servleta. `InitDbServlet` ima zadatak samo da kreira
šemu baze podataka i napuni je početnim podacima. `ListTeachersServlet`
sada uzima konekcije iz *resource pool*-a na takav način da svaka nit koristi
posebnu konekciju prema bazi. Nakon upotrebe konekcija se ne zatvara već se
vraća u pool za kasnije korišćenje.

Prilikom uzimanja svake konekcije iz poola na konzoli servera se ispisuje
podatak o tome koja konekcija iz poola je u pitanju.