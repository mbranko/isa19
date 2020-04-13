# Old school MVC web app

Primer kompletne web aplikacije koja se sastoji iz sledećih delova:

* entity klase kao model podataka aplikacije
* DAO (data access object) SLSB-ovi koji implementiraju operacije nad 
  entitijima (tj. nad bazom podataka)
* SLSB-ovi koji implementiraju posebne funkcije obrade (npr. procesiranje 
  kreditne kartice)
* servleti koji predstavljaju kontrolere u web aplikaciji sa MVC arhitekturom, 
  pristupaju SLSB-ovima i entitijima
* JSP stranice koje predstavljaju prikaze (view) u MVC modelu
* REST API za udaljene klijente
* konfiguracioni fajlovi za različite delove sistema

## Potrebne stvari

* JDK 1.8
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

`gradle run`

pa zatim otvoriti browser na adresi (GET zahtev): http://localhost:8080/

## Sadržaj primera

Java klase nalaze se u `src/main/java`. Konfiguracioni fajlovi nalaze se
u `src/main/resources`. JSP stranice i `WEB-INF` folder nalaze se u 
`src/main/webapp` - ovo je standardni Gradle i Maven raspored foldera.

Prilikom korišćenja aplikacije prvo se poseti stranica http://localhost:8080/. 
*Tomcat* to tumači kao zahtev za stranicom `index.jsp`. Međutim, u 
`web.xml` fajlu konfigurisan je servlet filter (klasa `AuthorizationFilter`) 
koji presreće sve zahteve i, ako u HTTP sesiji ne pronađe objekat `"user"`, 
preusmerava korisnika na login stranicu.

Na login stranici se popuni HTML forma i pošalje zahtev koji stiže na 
`LoginServlet`. On će pokušati da pronađe korisnika sa datim `username` i 
`password` u bazi, i to pomoću `UserDao` session beana koga dobija injekcijom. 
Ako ga je pronašao, smatramo da je login uspešan. Stavljamo `"user"` objekat 
u session scope. U application scope-u tražimo objekat `"roots"` i, ako ga 
nema, učitavamo ga pomoću session bean-a `CategoryDao` koga dobijamo 
injekcijom. Preusmeravamo korisnika na `index.jsp`.

Na stranici `index.jsp` korisnik može da klikne na link prema određenoj 
kategoriji. Time ga upućujemo na `PickCategoryServlet` koji će, pomoću 
injektovanog `CategoryDao`, učitati kategoriju sa datim ID-jem, staviti je u 
HTTP sesiju i prikaz stranice poveriti `category.jsp`. Za potrebe prikaza 
kategorije u `category.jsp` moramo raspolagati njenim osnovnim atributima, 
vezom prema roditeljskoj kategoriji (`parent`), setom potkategorija 
(`children`) i setom proizvoda (`products`). Setovi su anotacijama 
konfigurisani tako da se učitavaju u *lazy* režimu, a nama će ti podaci biti 
potrebni, pa ih moramo eksplicitno učitati dok još imamo aktivnu JPA sesiju 
(metoda `loadWithChildren` u `CategoryDaoBean`). Ako bismo pokušali da im 
pristupimo u JSP stranici bez prethodnog učitavanja dobili bismo `Exception`.

Na stranici `category.jsp` korisnik može da izabere neku potkategoriju (i 
time prolazi ponovo kroz proces u koraku 4) ili proizvod. Ako izabere proizvod, 
taj zahtev će prihvatiti `PickProductServlet`. Na osnovu dobijenog ID-a 
proizvoda iz zahteva učitaće proizvod iz baze pomoću `ProductDao` session 
beana koga će dobiti injekcijom. Učitani proizvod smešta se u HTTP sesiju i 
prikaz strane poverava `product.jsp`.

Na stranici `product.jsp` prikazuje se forma za naručivanje izabranog proizvoda
u nekoj količini. Podatke iz te forme prihvatiće `AddToCartServlet`. On će 
potražiti objekat `"order"` u HTTP sesiji. Ako ga nema, to znači da je 
korisniku ovo prvi proizvod koji je dodao u korpu, pa se kreira novi 
`PurchaseOrder` (sada je u tranzijetnom stanju) i smešta u HTTP sesiju. Potom 
se odmah kreira i jedna stavka narudžbine `OrderItem` i vezuje za tekući 
`PurchaseOrder` (oba objekta su tranzijentna). `OrderItem` objekat je vezan za 
`Product` objekat koji smo izvukli iz HTTP sesije. Ovaj `Product` objekat je u 
*detached* stanju jer je bio učitan iz baze (potom mu je JPA sesija istekla, 
zato je *detached*) i smešten u HTTP sesiju. Prikaz sadržaja obaviće stranica 
`cart.jsp`.

Na stranici `cart.jsp` korisnik može da bira da li će da ide nazad u katalog 
(preusmeravamo ga na `index.jsp`) ili na plaćanje. Ako izabere ovo drugo, 
uputiće se na stranicu `pay.jsp`.

Na stranici `pay.jsp` unose se podaci o platnoj kartici. Popunjenu formu 
prihvatiće `PaymentServlet` koji će iz HTTP sesije izvući objekte `user` 
(koji je *detached*) i `order` (koji je *transient*). Pozvaće `Purchase` 
session bean (koga dobija injekcijom) radi simulacije provere kreditne 
kartice, stanja u magacinu, itd. Ako taj session bean vrati `true` (a ovde 
uvek vrati) poziva se metoda `add` u beanu `UserDao`. Njen zadatak je da 
vrati usera u JPA sesiju (poziv `em.merge`) kako bi došao u *persistent* 
stanje. Kada `user`-u koji je u perzistentnom stanju dodamo tranzijentni 
`order` u njegov set, taj set će se insertovati u bazu (zbog kaskadnog 
insertovanja, anotacija iznad `Set` atributa u klasi `User`). Automatski će 
se insertovati i sve `OrderItem` stavke ovog `order`-a iz istog razloga 
(anotacija iznad atributa `items` u klasi `PurchaseOrder`). Tek u ovom 
momentu je nova porudžbina upisana u bazu podataka. Nakon toga vraćamo se 
nazad u servlet gde se objekat `order` uklanja iz HTTP sesije jer je 
korisnik upravo platio prethodnu korpu, pa treba da krene od nove (prazne) 
korpe. 
