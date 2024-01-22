INSERT INTO WORKERS (firstname, surname, phonenumber, workertype) VALUES ('Tom', 'Cat', '80443789123', 'ADMIN');
INSERT INTO WORKERS (firstname, surname, phonenumber, workertype) VALUES ('Bin', 'Ran', '80443777123', 'COURIER');
INSERT INTO WORKERS (firstname, surname, phonenumber, workertype) VALUES ('Tim', 'Bush', '80443789123', 'COURIER');
INSERT INTO WORKERS (firstname, surname, phonenumber, workertype) VALUES ('Alex', 'Bon', '80442599163', 'MANAGER');
INSERT INTO WORKERS (firstname, surname, phonenumber, workertype) VALUES ('Rick', 'Gan', '80443971123', 'KITCHEN_WORKER');
INSERT INTO WORKERS (firstname, surname, phonenumber, workertype) VALUES ('Jake', 'Zek', '80443171123', 'COURIER');

INSERT INTO USERS (login, password, worker_ID) VALUES ('admin', '$2a$10$Xj1LX.Nh1NiN58lL/Oc0tesb1c9f2P1gp8Qn9wLKA4Fl//TTw7VpW', 1);
INSERT INTO USERS (login, password, worker_ID) VALUES ('33', '$2a$10$G2Yzo3u3Dm0MdXcm87GpzORI0lNKv10nGHJ7hXtDxF6CBzCoTfyEW', 2);
INSERT INTO USERS (login, password, worker_ID) VALUES ('1', '$2a$10$l2oTKxCkjVMSSNy82YAUb.a4oKMDL59fTk.kEcqwmvvcpIalgLFve', 3);
INSERT INTO USERS (login, password, worker_ID) VALUES ('11', '$2a$10$0Sp5nLrD5SdTmDc9.BlzTeEkLyhH1hYOvLHq3v9j7/vnZInHpSAKS', 4);
INSERT INTO USERS (login, password, worker_ID) VALUES ('22', '$2a$10$H6HG1Ldrk3E/uJL5h56VCOqU0wcWfFdrcjtuJK9Ws.ERQ9tIEgYTi', 5);
INSERT INTO USERS (login, password, worker_ID) VALUES ('55', '$2a$10$u.VV7QvPpuT7hmKe7Xu9z.SrHugFgsYDFXCyFK9fYhNuUGeoxJ4ym', 6);

INSERT INTO ORDERS(address, completed, cost, deliverytime, describe, worker_id) VALUES ('Miroshnichenko 32, 34', TRUE, 32.4, '2024-01-02 12:30', 'Pepperoni', 2);
INSERT INTO ORDERS(address, completed, cost, deliverytime, describe, worker_id) VALUES ('Kireeva 43, 62', true, 76.4, '2024-01-02 15:50', 'Margherita', 2);
INSERT INTO ORDERS(address, completed, cost, deliverytime, describe) VALUES ('Mihalova 42, 63', FALSE, 23.8, '2024-01-02 17:10', 'Hawai');
INSERT INTO ORDERS(address, completed, cost, deliverytime, describe) VALUES ('Pushkinskaya 21, 90', FALSE, 41.0, '2024-01-02 17:40', 'Double Pepperoni');
INSERT INTO ORDERS(address, completed, cost, deliverytime, describe) VALUES ('Volgagradskaya 97, 87', FALSE, 31.5, '2024-01-02 18:00', 'Chicken BBQ');
INSERT INTO ORDERS(address, completed, cost, deliverytime, describe) VALUES ('Uruchskaya 77, 32', FALSE, 27.3, '2024-01-02 18:00', 'Carbonara');

INSERT INTO WORKSCHEDULE(datework, endtime, starttime, worker_id) VALUES ('2024-01-15', '20:00:00','13:00:00', 5);
INSERT INTO WORKSCHEDULE(datework, endtime, starttime, worker_id) VALUES ('2024-01-16', '20:00:00','10:00:00', 5);
INSERT INTO WORKSCHEDULE(datework, endtime, starttime, worker_id) VALUES ('2024-01-17', '15:00:00','10:00:00', 5);
INSERT INTO WORKSCHEDULE(datework, endtime, starttime, worker_id) VALUES ('2024-01-18', '22:00:00','15:00:00', 5);
INSERT INTO WORKSCHEDULE(datework, endtime, starttime, worker_id) VALUES ('2024-01-19', '23:00:00','10:00:00', 5);
INSERT INTO WORKSCHEDULE(datework, endtime, starttime, worker_id) VALUES ('2024-01-20', '23:00:00','08:00:00', 5);
INSERT INTO WORKSCHEDULE(datework, endtime, starttime, worker_id) VALUES ('2024-01-21', '20:00:00','10:00:00', 5);
INSERT INTO WORKSCHEDULE(datework, endtime, starttime, worker_id) VALUES ('2024-01-25', '20:00:00','10:00:00', 5);