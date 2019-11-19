# Mapiranje nasleđivanja na relacioni model

Ilustracija četiri različita načina za mapiranje nasleđivanja
na relacioni model.

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

`java -jar build/libs/pr05.jar`

ili pokrenuti klasu `pr05.Test` iz razvojnog okruženja.

## Sadržaj primera

Primeri četiri varijante za mapiranje nasleđivanja. U svim varijantama 
koriste se sledeće klase:

 * `BillingDetails` - apstraktna klasa sa jednim atributom
 * `CreditCard`     - konkretna klasa sa podacima o kreditnoj kartici
 * `BankAccount`    - konkretna klasa sa podacima o bankovnom računu

**1) Jedna tabela po konkretnoj klasi sa implicitnim polimorfizmom:**
Ovde nema eksplicitnog mapiranja nasleđivanja - konkretne klase naslednice se
mapiraju na odvojene tabele, a apstraktna klasa roditelj nije entity; njeni
atributi se nasleđuju u konkretnim klasama i mapiraju na odgovarajuće kolone.

**2) Jedna tabela po konkretnoj klasi:**
Ovde se i apstraktna klasa proglašava za entity (iako neće biti mapirana na
tabelu, naznačava se način mapiranja nasleđivanja posebnom `@Inheritance` 
anotacijom). Na taj način se moze koristiti u JPA-QL upitima.

**3) Jedna tabela po hijerarhiji nasledjivanja:**
Za svaku (celu) hijerarhiju nasleđivanja formira se jedna tabela, sa unijom
svih kolona koje su potrebne za sve klase naslednice. Tip svakog objekta
predstavljenim jednim redom u bazi određuje se pomoću vrednosti posebne
kolone ("discriminator column"). U roditeljskoj klasi mora se navesti koja je
to kolona.

**4) Jedna tabela za svaku klasu:**
Veze nasleđivanja se ovde prikazuju pomoću spoljnih ključeva. Čak i apstraktne
klase se mapiraju na tabele u bazi. U tabelama koje odgovaraju klasama 
naslednicama ne ponavljaju se nasleđeni propertiji.

U svakom od primera nalazi se i jedan `schema.sql` fajl koji prikazuje
kakva šema baze će se dobiti za izabranu strategiju mapiranja nasleđivanja.
