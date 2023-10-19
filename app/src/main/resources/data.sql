-- CREATE TABLE Authority
-- (
--     id   BIGINT AUTO_INCREMENT PRIMARY KEY,
--     name VARCHAR(255)
-- );
--
-- CREATE TABLE Account
-- (
--     id                    BIGINT AUTO_INCREMENT PRIMARY KEY,
--     USERNAME              VARCHAR(255),
--     PASSWORD              VARCHAR(255),
--     EMAIL                 VARCHAR(255),
--     EMAIL_VERIFIED        BOOLEAN,
--     SECOND_FACTOR_ENABLED BOOLEAN,
--     CREATION_DATE         DATETIME
-- );
--
-- CREATE TABLE Account_Authority
-- (
--     account_id   BIGINT,
--     authority_id BIGINT,
--     PRIMARY KEY (account_id, authority_id),
--     FOREIGN KEY (account_id) REFERENCES Account (id),
--     FOREIGN KEY (authority_id) REFERENCES Authority (id)
-- );
--
-- CREATE TABLE Workout
-- (
--     id            BIGINT AUTO_INCREMENT PRIMARY KEY,
--     name          VARCHAR(50),
--     description   VARCHAR(250),
--     totalDuration BIGINT,
--     isPublic      BOOLEAN,
--     account_id    BIGINT
-- );
--
-- CREATE TABLE Exercise
-- (
--     id         BIGINT AUTO_INCREMENT PRIMARY KEY,
--     name       VARCHAR(255),
--     duration   BIGINT,
--     workout_id BIGINT
-- );



INSERT INTO Account (USERNAME, PASSWORD, EMAIL, EMAIL_VERIFIED, SECOND_FACTOR_ENABLED, CREATION_DATE)
VALUES ('admin', '$2a$10$ZvpJ1kkkdv7TGFdhumrDP.updwnFc97kxvUIg1WEhb4XkB94P3/Mq', 'admin@fitfusion.ch', TRUE, FALSE,
        CURRENT_TIMESTAMP()),
       ('user', '$2a$10$0mxmoCN37uZPWgq3mpm0mOyxPdVCpAmL/qbC1/2jfJIDvf6Y46ncK', 'user@fitfusion.ch', TRUE, FALSE,
        CURRENT_TIMESTAMP());

INSERT INTO Authority (name)
VALUES ('ROLE_USER'),
       ('ROLE_ADMIN');

INSERT INTO Account_Authority (account_id, authority_id)
VALUES (1, 2),
       (1, 1),
       (2, 1);

INSERT INTO Workout (name, description, TOTAL_DURATION, IS_PUBLIC, account_id)
VALUES ('Basic Workout', 'A basic workout routine.', 77, TRUE, 1),
       ('Advanced Workout', 'An advanced workout routine.', 52, FALSE, 1),
       ('Very Workout', 'An advanced workout routine.', 27, TRUE,2);

INSERT INTO Exercise (name, duration, workout_id)
VALUES ('Push-up', 25, 1),
       ('Sit-up', 27, 1),
       ('Push-up', 25, 1),
       ('Sit-up', 27, 2),
       ('Push-up', 25, 2),
       ('Sit-up', 27, 3);


