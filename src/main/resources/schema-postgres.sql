
CREATE TABLE customer(id serial PRIMARY KEY,
 name VARCHAR(255),
 rebate_type VARCHAR(255));
CREATE TABLE product(id serial PRIMARY KEY, name VARCHAR(255),  standard_price DOUBLE PRECISION);