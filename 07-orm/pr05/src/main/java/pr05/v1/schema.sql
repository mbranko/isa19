CREATE TABLE v1_creditcard (
  id         INTEGER      NOT NULL AUTO_INCREMENT,
  owner      VARCHAR(50)  NOT NULL,
  number     VARCHAR(20)  NOT NULL,
  exp_month  VARCHAR(2)   NOT NULL,
  exp_year   VARCHAR(4)   NOT NULL,
  PRIMARY KEY (id)
) ENGINE = InnoDB;

CREATE TABLE v1_bankaccount (
  id         INTEGER      NOT NULL AUTO_INCREMENT,
  owner      VARCHAR(50)  NOT NULL,
  number     VARCHAR(20)  NOT NULL,
  bank_name  VARCHAR(100) NOT NULL,
  swift      VARCHAR(8)   NOT NULL,
  PRIMARY KEY (id)
) ENGINE = InnoDB;
