DROP DATABASE IF EXISTS "reimbursement-database";
CREATE DATABASE "reimbursement-database";

CREATE TABLE users (
    user_id   serial,
    username VARCHAR(50) NOT NULL UNIQUE,
    email VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(50) NOT NULL,
    is_admin BOOLEAN DEFAULT false,
    CONSTRAINT users_pk PRIMARY KEY (user_id)
);

CREATE TABLE reimbursements (
    reimbursement_id serial,
    type VARCHAR(10) NOT NULL,
    message VARCHAR(2000),
    user_id INT,
    approved varchar(8) not null,
    CONSTRAINT reimbursements_users_fk FOREIGN KEY (user_id) REFERENCES users (user_id)
);


INSERT INTO users (username, email, password, is_admin) VALUES ('bchesse', 'frank.cheese@example.com', 'password123', true);
insert into users (username, email, password)
values ('jdoe', 'john.doe@example.com', '123456');

select *
from users;

select *
from reimbursements;
