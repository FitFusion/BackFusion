DROP TABLE IF EXISTS Account_Authority;
DROP TABLE IF EXISTS Account;
DROP TABLE IF EXISTS Authority;

CREATE TABLE Authority
(
    id   BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255)
);

CREATE TABLE Account
(
    id                    BIGINT AUTO_INCREMENT PRIMARY KEY,
    USERNAME              VARCHAR(255),
    PASSWORD              VARCHAR(255),
    EMAIL                 VARCHAR(255),
    EMAIL_VERIFIED        BOOLEAN,
    SECOND_FACTOR_ENABLED BOOLEAN,
    CREATION_DATE         DATETIME
);

CREATE TABLE Account_Authority
(
    account_id   BIGINT,
    authority_id BIGINT,
    PRIMARY KEY (account_id, authority_id),
    FOREIGN KEY (account_id) REFERENCES Account (id),
    FOREIGN KEY (authority_id) REFERENCES Authority (id)
);



INSERT INTO Account (USERNAME, PASSWORD, EMAIL, EMAIL_VERIFIED, SECOND_FACTOR_ENABLED, CREATION_DATE)
VALUES ('admin', 'admin', 'admin@fitfusion.ch', TRUE, FALSE, CURRENT_TIMESTAMP()),
       ('user', 'user', 'user@fitfusion.ch', TRUE, FALSE, CURRENT_TIMESTAMP());

INSERT INTO Authority (name)
VALUES ('ROLE_USER'),
       ('ROLE_ADMIN');

INSERT INTO Account_Authority (account_id, authority_id)
VALUES (1, 2),
       (1, 1),
       (2, 1);
