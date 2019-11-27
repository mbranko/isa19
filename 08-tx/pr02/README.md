# Pesimističko i optimističko zaključavanje

Ilustracija pesimističkog i optimističkog zaključavanja prilikom
pristupa jednoj tabeli.

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

`java -jar build/libs/pr02.jar`

ili pokrenuti klasu `pr02.Test` iz razvojnog okruženja.

## Sadržaj primera

Klasa `BankAccount` u oba primera je predstavlja entity oko koga se vrši 
zaključavanje pristupa. U oba primera kreiraju se dva threada koji rade
sledeće:
 * **prvi thread** učitava objekat, čeka tri sekunde (da bi drugi thread 
   dobio priliku da radi), dodaje 10000 na račun i završava transakciju.
 * **drugi thread** čeka 2 sekunde, učitava objekat, skida 500 sa računa
   i završava transakciju.
   
U slučaju optimističkog zaključavanja prvi thread će dobiti 
`OptimisticLockException` kao signal da je druga transakcija u međuvremenu
promenila objekat.

U slučaju pesimističkog zaključavanja obe transakcije će se uspešno
završiti uz odgovarajuće čekanje izazvano zaključavanjem i operacije
čitanja za dati objekat odnosno red u bazi. Ovakav način zaključavanja
zove se *exclusive lock*, za razliku od *shared lock* gde je se dopušta
da više paralelnih transakcija čita isti objekat.
