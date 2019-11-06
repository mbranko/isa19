# Ilustracija pristupa bazi iz servleta

Ovaj primer predstavlja naivni pokušaj pristupa relacionoj bazi iz
servleta. Servlet će otvoriti konekciju prema bazi u svojoj `init` metodi
a zatvoriće je u svojoj `destroy` metodi. Na ovaj način, sve niti u kojima
se obrađuju zahtevi pomoću ovog servleta koriste istu konekciju prema
bazi podataka što nije ispravno. Jedna konekcija prema bazi podataka može
se koristiti iz samo jedne niti.


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

pa zatim otvoriti browser na adresi (GET zahtev): http://localhost:8080/pr02/list

## Sadržaj primera

Web aplikacija ima dva servleta. `InitDbServlet` ima zadatak samo da kreira
šemu baze podataka i napuni je početnim podacima. `ListTeachersServlet`
predstavlja primer *neispravnog* korišćenja konekcija za pristup bazi iz
servleta jer će na ovaj način ista konekcija biti korišćena iz više
različitih niti.