CREATE TABLE v3_billingdetails (
  id         INTEGER      NOT NULL AUTO_INCREMENT,
  owner      VARCHAR(50)  NOT NULL,
  type       VARCHAR(2)   NOT NULL,
  cc_number  VARCHAR(20),
  exp_month  VARCHAR(2),
  exp_year   VARCHAR(4),
  ba_number  VARCHAR(20),
  bank_name  VARCHAR(100),
  swift      VARCHAR(8),
  PRIMARY KEY (id)
) ENGINE = InnoDB;

