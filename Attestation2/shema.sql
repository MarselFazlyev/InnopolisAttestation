create table product (
                         id serial primary key ,
                         description varchar(255) not null ,
                         price int check (price>0),
                         amount int check (amount>=0));

INSERT  INTO  product (description, price, amount) VALUES ('Jacket',10000,3);
INSERT  INTO  product (description, price, amount) VALUES ('Pants',6000,5);
INSERT  INTO  product (description, price, amount) VALUES ('Coat',30000,1);
INSERT  INTO  product (description, price, amount) VALUES ('Shoes',25000,1);

create table customer (
                          id serial primary key ,
                          name varchar(255) not null ,
                          lastname varchar(255) not null
);

INSERT  INTO  customer (name,lastname) VALUES ('Dmitry','Donskoy');
INSERT  INTO  customer (name, lastname) VALUES ('Sergey','Beznogov');
INSERT  INTO  customer (name, lastname) VALUES ('Carevna','Lyagushka');

CREATE TABLE "order"
(
    product_id  serial references product ("id"),
    customer_id serial references customer ("id"),
    date        date,
    amount      int check (amount >= 0));

INSERT  INTO  "order"(product_id, customer_id, date, amount) VALUES (1,2,'01.12.2022',10);
INSERT  INTO  "order"(product_id, customer_id, date, amount) VALUES (4,1,'04.03.2022',2);
INSERT  INTO  "order"(product_id, customer_id, date, amount) VALUES (2,3,'12.07.2022',8);
INSERT  INTO  "order"(product_id, customer_id, date, amount) VALUES (3,3,'09.05.2022',1);
INSERT  INTO  "order"(product_id, customer_id, date, amount) VALUES (4,1,'03.11.2022',6);



