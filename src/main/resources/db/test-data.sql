DELETE FROM customers;
INSERT INTO customers(ID, CREATIONTIME, UPDATETIME, VERSION, CREDITCARD, EMAIL, NAME, PHONE) VALUES
(1, TIMESTAMP '2017-10-10 08:45:56.468', TIMESTAMP '2017-10-10 08:45:56.468', 1,'234523843p948524956', 'adrgzgr', 'zgdgz','2347562837546');

DELETE FROM purchases;


DELETE FROM products;
INSERT INTO products(ID, CREATIONTIME, UPDATETIME, VERSION, PRICE ,PRODUCTNAME, PURCHASE_ID) VALUES
(1, TIMESTAMP '2017-10-10 08:45:56.468', TIMESTAMP '2017-10-10 08:45:56.468', 1,10, 'caixa de cerveja', 1),
(2, TIMESTAMP '2017-10-10 08:45:56.468', TIMESTAMP '2017-10-10 08:45:56.468', 1,10, 'caixa de cerveja', 1),
(3, TIMESTAMP '2017-10-10 08:45:56.468', TIMESTAMP '2017-10-10 08:45:56.468', 1,10, 'caixa de cerveja', 1),
(4, TIMESTAMP '2017-10-10 08:45:56.468', TIMESTAMP '2017-10-10 08:45:56.468', 1,10, 'caixa de cerveja', 1),
(5, TIMESTAMP '2017-10-10 08:45:56.468', TIMESTAMP '2017-10-10 08:45:56.468', 1,10, 'caixa de cerveja', 1),
(6, TIMESTAMP '2017-10-10 08:45:56.468', TIMESTAMP '2017-10-10 08:45:56.468', 1,10, 'caixa de cerveja', 1);
