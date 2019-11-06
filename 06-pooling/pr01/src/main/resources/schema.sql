CREATE TABLE nastavnici
(
    NASTAVNIK_ID  INTEGER               not null,
    IME           VARCHAR(25)           not null,
    PREZIME       VARCHAR(35)           not null,
    ZVANJE        VARCHAR(15)           not null,
    primary key (NASTAVNIK_ID)
);

CREATE TABLE predmeti
(
    PREDMET_ID    INTEGER               not null,
    NAZIV         VARCHAR(150)          not null,
    primary key (PREDMET_ID)
);

CREATE TABLE predaje
(
    PREDMET_ID    INTEGER                not null,
    NASTAVNIK_ID  INTEGER                not null,
    primary key (PREDMET_ID, NASTAVNIK_ID),
    foreign key (PREDMET_ID) references predmeti (PREDMET_ID) on delete cascade,
    foreign key (NASTAVNIK_ID) references nastavnici (NASTAVNIK_ID) on delete cascade
);
