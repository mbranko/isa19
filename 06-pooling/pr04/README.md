# Resource pooling i stateless session EJBs

Ilustracija primene resource pooling principa na žongliranje stateless
session bean objektima.

## Potrebne stvari

* [Gradle](https://gradle.org)

## Priprema primera

Ako se koristi neko od razvojnih okruženja, projekat se može pripremiti za njih pomoću komande

`gradle eclipse`

ili 

`gradle idea`

Nakon toga se projekat može otvoriti u izabranom alatu i podešavanja za 
projekat će već biti inicijalizovana.

## Bildovanje primera

`gradle alljars`

## Pokretanje primera

`java -jar build/libs/Server.jar`

`java -jar build/libs/Client.jar`

## Sadržaj primera

Klijent će prvo sekvencijalno pozivati 10 puta isti session bean. Pošto je
jedna instanca dovoljna za obradu svih zahteva jer oni stižu sekvencijalno
u vremenu (jedan posle drugog), trebalo bi da se na konzoli ispiše isti
rezultat za sve pozive metoda.

Potom će klijent kreirati 100 niti iz kojih će paralelno biti pozivani
session bean-ovi. Trebalo bi da se u ispisu vidi da je korišćeno više od
jedne instance, ali da su instance tokom vremena bile reciklirane.
