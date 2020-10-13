# Primer osnovnog HTTP servera

Ovaj primer predstavlja implementaciju elementarnog HTTP servera u JavaScriptu.

## Potrebne stvari

* [Node.js](https://nodejs.org)

## Korisne stvari

* [Postman](https://www.getpostman.com)

## Pokretanje primera

Iz osnovnog foldera pokrenuti

`node server.js`

Potom u browseru ili Postmanu poslati GET zahtev na adresu
`http://localhost:9090`. Nakon toga isprobati i slanje POST zahteva na isti
URL.

## Sadržaj primera

Fajl `server.js` sadrži elementarnu implemnetaciju HTTP servera u JavaScriptu.
Funkcija za obradu zahteva poziva se asinhrono, po prispeću zahteva, u okviru
petlje za obradu događaja kojom upravlja Node.js, odnosno JavaScript
interpreter.

U okviru obrade zahteva proverava se samo metoda zahteva koga je poslao
klijent. U slučaju da je primljen GET zahtev, vraća se odgovor 200, a u svim
ostalim slučajevima vraća se odgovor 405 (*Method not allowed*).

## HTTP statusi

Pregledna i čitka lista HTTP status kodova nalazi se na
https://httpstatuses.com
