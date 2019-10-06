# Spring i AOP

### Osnovni AOP pojmovi

**Aspect** je klasa koja implementira funkcionalnost koja je zajednička 
većem broju drugih klasa. Funkcionalnost se smatra ortogonalnom
(nezavisnom) od osnovne poslovne logike koju druge klase implementiraju. Na 
primer, pisanje u log fajl ili upravljanje transakcijama je nešto što se 
tipično implementira pomoću aspekata.

**Join Point** je specifična tačka u programu kao što je izvršavanje metode,
obrada izuzetaka, promena vrednosti promenljive, itd. Kod Spring AOP join 
point može biti samo izvršavanje metode.

**Advice** je akcija koja se preduzima za dati join point. Implementira se
kao metoda koja se izvršava kada program dođe do određenog join pointa
a pointcut uslov je ispunjen.

**Pointcut** je izraz koji određuje da li dati advice treba da se izvrši ili
ne.

**Target object** je objekat na koji se primenjuje advice. Spring AOP ovo
postiže tako što se uvek rukuje referencama na proxy objekte. Proxy objekat
je instanca klase koja nasleđuje našu klasu a kod njenih metoda je dopunjen
logikom za pozivanje aspekata.

**Weaving** je proces povezivanja aspekata sa objektima radi kreiranja 
"savetovanih" proxy objekata. Ovaj proces se može raditi kao compile-time, 
load-time ili run-time. Spring AOP ga uvek radi run-time.

### Vrste AOP saveta

**Before advice** se izvršava pre metode na koju se aspekt odnosi.

**After (finally) advice** se izvršava nakon što se metoda na koju se aspekt
odnosi završi, bilo u slučaju da se završi normalno ili da baci izuzetak.

**After returning advice** se izvršava nakon što se metoda na koju se aspekt
odnosi završi normalno - ne i u slučaju da je bacila izuzetak.

**After throwing advice** se izvršava nakon što se metoda na koju se aspekt
odnosi završi neuspešno bacanjem izuzetka.

**Around advice** svojim izvršavanjem *obuhvata* metodu i može da odluči da
li će dopustiti izvršavanje metode ili ne. Ovakav advice mora da pozove metodu
i prosledi vraćen rezultat.

## Potrebne stvari

* [Gradle](https://gradle.org)

## Priprema primera

Ako se koristi neko od razvojnih okruženja, projekat se može pripremiti za 
njih pomoću komande

`gradle eclipse`

ili 

`gradle idea`

Nakon toga se projekat može otvoriti u izabranom alatu i podešavanja za 
projekat će već biti inicijalizovana.

## Bildovanje primera

`gradle build`

## Pokretanje primera

`gradle run`

## Sadržaj primera

Klasa `AOPApp` pokreće primer. Kreira se jedan bean klase `CountBean`.
Za njegove metode vezani su aspekti `LoggerAspect` i `TransactionAspect`.
Vezivanje je urađeno pomoću posebno napisanih anotacija za ovu namenu, a
u samom aspektu je navedeno da je uslov vezivanja pojavljivanje anotacije.

`LoggerAspect` definiše jedan *before advice* i jedan *after advice*.

`TransactionAspect` definiše jedan *around advice*.