set schema 'project0';

CREATE TABLE user_info(

user_id integer PRIMARY KEY,
username VARCHAR(10),
password VARCHAR(15) NOT NULL,
firstname VARCHAR(15) NOT NULL,
lastname VARCHAR (15) NOT NULL,
age integer NOT NULL,
balance integer NOT NULL

);

CREATE TABLE user_transaction(

transaction_id serial PRIMARY KEY,
user_id serial NOT NULL,
withdrawl integer,
deposit integer REFERENCES user_info(user_id)

);