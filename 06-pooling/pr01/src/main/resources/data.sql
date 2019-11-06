INSERT INTO nastavnici (nastavnik_id, ime, prezime, zvanje) VALUES
  (1, 'Marko', 'Markovic', 'docent');
INSERT INTO nastavnici (nastavnik_id, ime, prezime, zvanje) VALUES
  (2, 'Petar', 'Petrovic', 'redovni');
INSERT INTO nastavnici (nastavnik_id, ime, prezime, zvanje) VALUES
  (3, 'Nikola', 'Nikolic', 'docent');

INSERT INTO predmeti (predmet_id, naziv) VALUES
  (1, 'Osnovi racunarstva');
INSERT INTO predmeti (predmet_id, naziv) VALUES
  (2, 'Programiranje i programski jezici');
INSERT INTO predmeti (predmet_id, naziv) VALUES
  (3, 'Operativni sistemi');

INSERT INTO predaje (nastavnik_id, predmet_id) VALUES
  (1, 1);
INSERT INTO predaje (nastavnik_id, predmet_id) VALUES
  (2, 2);
INSERT INTO predaje (nastavnik_id, predmet_id) VALUES
  (2, 3);
INSERT INTO predaje (nastavnik_id, predmet_id) VALUES
  (3, 1);
INSERT INTO predaje (nastavnik_id, predmet_id) VALUES
  (3, 3);
