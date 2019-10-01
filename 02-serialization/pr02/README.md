# Serijalizacija: Protocol Buffers

Ovaj primer ilustruje mogućnosti prilikom serijalizacije objekata pomoću
Protocol Buffers formata.

## Potrebne stvari

* [Gradle](https://gradle.org)
* [Protocol Buffers Compiler](https://github.com/protocolbuffers/protobuf)

## Korisne stvari

* [Eclipse](https://www.eclipse.org)
* [IntelliJ IDEA](https://www.jetbrains.com/idea/)
* [Postman](https://www.getpostman.com)

## Priprema primera

Ako se koristi neko od razvojnih okruženja, projekat se može pripremiti za
njih pomoću komande

`gradle eclipse`

ili 

`gradle idea`

Nakon toga se projekat može otvoriti u izabranom alatu i podešavanja za
projekat će već biti inicijalizovana.

## Pokretanje primera

Iz osnovnog foldera pokrenuti

`gradle run`

U Postmanu poslati sledeće GET zahteve:

 * **TODO** Protobuf serijalizacija sa ugnježdavanjem
   * Podaci o jednom studentu, sa ugnježdenim ocenama i predmetima: 
     http://localhost:4567/api/studenti/E1234?format=json1
   * Podaci o svim studentima, sa ugnježdenim ocenama i predmetima: 
     http://localhost:4567/api/studenti?format=json1
   * Podaci o jednoj oceni, sa ugnježdenim predmetom i studentom
     http://localhost:4567/api/ocene/1?format=json1

  * **TODO** Protobuf erijalizacija sa referenciranjem
    * Podaci o oceni, sa referencama na predmet i studenta
      http://localhost:4567/api/ocene/1?format=json2
    * Podaci o svim ocenama, sa referencama na predmet i studenta
      http://localhost:4567/api/ocene?format=json2

