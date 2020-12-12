# Primeri za klasične probleme u transakcionom radu

 * *lost update*: kada transakcioni režim zapravo i ne postoji, rollback
   jedne transakcije može da poništi i rezultate druge uspešne transakcije
 * *read uncommitted*: posledica čitanja podataka koji su parcijalni
   rezultat druge transakcije koja je u toku i nije još potvrđena
 * *unrepeatable read*: čitanje potvrđenih izmena, ali dva puta u toku iste
   transakcije može da vrati različite rezultate
 * *phantom read*: čitanje potvrđenih izmena, ali dva puta u toku iste
   transakcije može da vrati različiti broj redova u rezultatu

## Potrebne stvari

* [Gradle](https://gradle.org)
* [MySQL](https://mysql.com) ili [MariaDB](https://mariadb.org)

## Priprema primera

Ako se koristi neko od razvojnih okruženja, projekat se može pripremiti
za njih pomoću komande

`gradle eclipse`

ili

`gradle idea`

Nakon toga se projekat može otvoriti u izabranom alatu i podešavanja za
projekat će već biti inicijalizovana.

## Kreiranje baze podataka

Za pokretanje primera potrebna je MySQL ili MariaDB baza podataka sa
sledećom šemom i korisnikom:

```sql
CREATE DATABASE txtest CHARACTER SET utf8;
CREATE USER 'txtest'@'localhost' IDENTIFIED BY 'txtest';
GRANT ALL PRIVILEGES ON txtest.* to 'txtest'@'localhost';
FLUSH PRIVILEGES;
```

## Pokretanje primera

Iz osnovnog foldera pokrenuti

`gradle build`

pa zatim pokrenuti

`java -jar build/libs/pr03.jar`

ili pokrenuti klasu `pr03.Main` iz razvojnog okruženja.

## Sadržaj primera

Klasa `Main` sadrži `main`. Pokreće četiri primera koji ilustruju različite
probleme u radu sa transakcijama.
