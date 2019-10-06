# Primer rukovanja životnim ciklusom za Spring beans

Primer hvatanja događaja iz životnog ciklusa Spring beana: `@PostConstruct`
i `@PreDestroy`.

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

`BeanLifeCycleApp` pokreće konzolnu Spring aplikaciju. Kreira po 2 instance
beana sa opsegom `singleton` odnosno `prototype`. Poziva njihove metode.

`SingletonBean` se instancira jednom.

`PrototypeBean` se instancira onoliko puta koliko se zatraži.

Metoda označena sa `@PostConstruct` će biti pozvana nakon instanciranja beana
i inicijalizacije njegovih svojstava (properties).

Metoda označena sa `@PreDestroy` će biti pozvana neposredno pre uništavanja
beana (ovde na kraju života Spring konteksta). Ova metoda se nikad ne poziva
za beanove sa opsegom `prototype`.