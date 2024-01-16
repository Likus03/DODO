INSERT INTO WORKERS (firstname, surname, phonenumber, workertype) VALUES ('Tom', 'Cat', '80443789123', 'ADMIN');
INSERT INTO WORKERS (firstname, surname, phonenumber, workertype) VALUES ('Bin', 'Ran', '80443777123', 'COURIER');
INSERT INTO WORKERS (firstname, surname, phonenumber, workertype) VALUES ('Tim', 'Bush', '80443789123', 'COURIER');
INSERT INTO WORKERS (firstname, surname, phonenumber, workertype) VALUES ('Alex', 'Bon', '80442599163', 'MANAGER');
INSERT INTO WORKERS (firstname, surname, phonenumber, workertype) VALUES ('Rick', 'Gan', '80443971123', 'KITCHEN_WORKER');
INSERT INTO WORKERS (firstname, surname, phonenumber, workertype) VALUES ('Jake', 'Zek', '80443171123', 'COURIER');

INSERT INTO USERS (login, password, worker_ID) VALUES ('admin', 'admin', 1);
INSERT INTO USERS (login, password, worker_ID) VALUES ('33', '33', 2);
INSERT INTO USERS (login, password, worker_ID) VALUES ('1', '1', 3);
INSERT INTO USERS (login, password, worker_ID) VALUES ('11', '11', 4);
INSERT INTO USERS (login, password, worker_ID) VALUES ('gg', '22', 5);
INSERT INTO USERS (login, password, worker_ID) VALUES ('55', '55', 6);

INSERT INTO ORDERS(address, completed, cost, deliverytime, decribe, worker_id) VALUES ('Miroshnichenko 32, 34', TRUE, 32.4, '2024-01-02 12:30', 'Pepperoni', 2);
INSERT INTO ORDERS(address, completed, cost, deliverytime, decribe) VALUES ('Kireeva 43, 62', FALSE, 76.4, '2024-01-02 15:50', 'Margherita');
INSERT INTO ORDERS(address, completed, cost, deliverytime, decribe) VALUES ('Mihalova 42, 63', FALSE, 23.8, '2024-01-02 17:10', 'Hawai');
INSERT INTO ORDERS(address, completed, cost, deliverytime, decribe) VALUES ('Pushkinskaya 21, 90', FALSE, 41.0, '2024-01-02 17:40', 'Double Pepperoni');
INSERT INTO ORDERS(address, completed, cost, deliverytime, decribe) VALUES ('Volgagradskaya 97, 87', FALSE, 31.5, '2024-01-02 18:00', 'Chicken BBQ');
INSERT INTO ORDERS(address, completed, cost, deliverytime, decribe) VALUES ('Uruchskaya 77, 32', FALSE, 27.3, '2024-01-02 18:00', 'Carbonara');

