CREATE PROCEDURE povezi(
  IN ime_ VARCHAR(25),
  IN prezime_ VARCHAR(35),
  IN naziv_ VARCHAR(150))
BEGIN
  DECLARE nas_id INT;
  DECLARE pred_id INT;

SELECT nastavnik_id INTO nas_id FROM nastavnici
  WHERE ime=ime_ AND prezime=prezime_;
SELECT predmet_id INTO pred_id FROM predmeti
  WHERE naziv=naziv_;
INSERT INTO predaje (nastavnik_id, predmet_id)
  VALUES (nas_id, pred_id);
END//