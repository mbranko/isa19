DROP TABLE IF EXISTS bank_account;

CREATE TABLE bank_account (
    id              INTEGER      NOT NULL,
    account_number  VARCHAR(25)  NOT NULL,
    balance         DECIMAL(35)  NOT NULL,
    PRIMARY KEY (id)
) ENGINE=INNODB;

INSERT INTO bank_account (id, account_number, balance) VALUES (1, '1234567890123', 1000);
