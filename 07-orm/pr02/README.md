# Primer POJO objekata koji umeju sami da se snime u bazu

Program radi isto što i prethodni primer, samo je sada klasa User
dopunjena implementacijom operacija prema bazi podataka tako da
je "glavni program" sada daleko čitljiviji.

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

Klasa `Test` sadrži `main`. Otvara vezu sa bazom podataka, kreira inicijalnu 
šemu, kreira tri objekta u memoriji, snima objekte u bazu, pronalazi objekat
u bazi po ID-u i ažurira objekat u memoriji i u bazi.

Klasa `User` predstavlja model podataka sa kojim radi naš program. U ovom
primeru, klasa je dopunjena metodama koje implementiraju standardne operacije
prema bazi podataka.
