CREATE TABLE netology.customers (
                                    id serial NOT NULL,
                                    name varchar(50) NOT NULL,
                                    surname varchar(50) NOT NULL,
                                    age int NOT NULL check (age > 0),
                                    phone_number  varchar(50),
                                    PRIMARY KEY(id)
);
CREATE TABLE netology.orders (
                                 id serial NOT NULL,
                                 date date NOT NULL,
                                 product_name varchar(50) NOT NULL,
                                 customer_id int NOT NULL,
                                 amount int NOT NULL,
                                 PRIMARY KEY(id),
                                 CONSTRAINT fk_customer
                                     FOREIGN KEY(customer_id)
                                         REFERENCES netology.customers(id)
);

INSERT INTO netology.customers (name,surname,age,phone_number) VALUES ('Denis', 'Petrov', 10, '+79000000000');
INSERT INTO netology.customers (name,surname,age,phone_number) VALUES ('Alexey', 'Ivanov', 15, '+79111111111');
INSERT INTO netology.customers (name,surname,age,phone_number) VALUES ('Anna', 'Vasilyeva', 20, '+79222222222');
INSERT INTO netology.customers (name,surname,age,phone_number) VALUES ('Olga', 'First', 25, '+79333333333');
INSERT INTO netology.customers (name,surname,age,phone_number) VALUES ('Ivan', 'Second', 30, '+79444444444');


INSERT INTO netology.orders (date,customer_id,product_name,amount) VALUES (CURRENT_DATE, 1, 'Pensil', 10);
INSERT INTO netology.orders (date,customer_id,product_name,amount) VALUES (CURRENT_DATE, 2, 'Paper', 15);
INSERT INTO netology.orders (date,customer_id,product_name,amount) VALUES (CURRENT_DATE, 3, 'Ink', 20);
INSERT INTO netology.orders (date,customer_id,product_name,amount) VALUES (CURRENT_DATE, 4, 'Phone', 30);
INSERT INTO netology.orders (date,customer_id,product_name,amount) VALUES (CURRENT_DATE, 5, 'Chair', 40);


INSERT INTO netology.orders (date,customer_id,product_name,amount) VALUES (CURRENT_DATE, 1, 'One', 10);
INSERT INTO netology.orders (date,customer_id,product_name,amount) VALUES (CURRENT_DATE, 2, 'Two', 15);
INSERT INTO netology.orders (date,customer_id,product_name,amount) VALUES (CURRENT_DATE, 3, 'Three', 20);
INSERT INTO netology.orders (date,customer_id,product_name,amount) VALUES (CURRENT_DATE, 4, 'Four', 30);
INSERT INTO netology.orders (date,customer_id,product_name,amount) VALUES (CURRENT_DATE, 5, 'Five', 40);
