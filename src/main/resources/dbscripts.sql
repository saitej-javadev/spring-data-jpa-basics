-- To create products table
CREATE TABLE products (
    id INT PRIMARY KEY,
    name VARCHAR(20),
    description VARCHAR(100),
    price DECIMAL(8 , 3 )
);

-- To insert data in products table
insert into products (name,description,price) values ('Sony Xperia','from Sony Inc',600.0);
insert into products (name,description,price) values ('Oneplus 8pro','from Oneplus Inc',1200.0);
insert into products (name,description,price) values ('Iphone','from Apple Inc',800.0);
insert into products (name,description,price) values ('S20','from Samsung Inc',1000.0);