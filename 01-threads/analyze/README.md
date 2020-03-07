# Poređenje rada servera

Java i Node.js serveri su tako napisani da 
* obrada svakog sedmog zahteva traje bar 250ms
* obrada svakog jedanaestog zahteva traje bar 450ms
* obrada svakog sedamdesetsedmog zahteva traje bar 700ms

Pokušaćemo da izmerimo performanse u radu servera i uočimo razlike 
u funkcionisanju višenitnih i jednonitnih servera.

## Potrebne stvari

* Apache Bench (ab)
* gnuplot
* bash

## Priprema

1. Pokrenuti Java server iz prvog primera u jednom terminalu
```bash
cd ../pr01
java -jar build/libs/pr01.jar
```

2. Pokrenuti Node.js server iz drugog primera u drugom terminalu
```bash
cd ../pr02
node server.js
```

## Pokretanje primera

Skript `analyze.sh` prima 2 parametra:
```bash
./analyze.sh [broj-zahteva] [broj-istovremenih]
```

Podrazumevane vrednosti su

* ukupan broj zahteva: 1000
* broj istovremenih zahteva: 5

Pokrenuti skript u trećem terminalu:
```bash
./analyze.sh 1000 5
```

Dobijeni grafikoni će prikazati:

* Vreme trajanja obrade HTTP zahteva za sve zahteve grupisane u okviru iste sekunde
* Vreme trajanja obrade zahteva grupisano po dužini vremenskog perioda

(po dva za Java i Node.js servere)
