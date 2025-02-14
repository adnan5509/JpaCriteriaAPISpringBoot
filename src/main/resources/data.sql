-- Insert data into the Employee table
INSERT INTO EMPLOYEE (ID, NAME, AGE, SALARY) VALUES (1, 'John Doe', 28, 50000.00);
INSERT INTO EMPLOYEE (ID, NAME, AGE, SALARY) VALUES (2, 'Jane Smith', 34, 65000.00);
INSERT INTO EMPLOYEE (ID, NAME, AGE, SALARY) VALUES (3, 'Mark Johnson', 25, 45000.00);
INSERT INTO EMPLOYEE (ID, NAME, AGE, SALARY) VALUES (4, 'Emma Brown', 30, 60000.00);
INSERT INTO EMPLOYEE (ID, NAME, AGE, SALARY) VALUES (5, 'Liam Wilson', 40, 75000.00);
INSERT INTO EMPLOYEE (ID, NAME, AGE, SALARY) VALUES (6, 'Sophia Taylor', 27, 48000.00);
INSERT INTO EMPLOYEE (ID, NAME, AGE, SALARY) VALUES (7, 'James Anderson', 33, 62000.00);
INSERT INTO EMPLOYEE (ID, NAME, AGE, SALARY) VALUES (8, 'Olivia Thomas', 29, 52000.00);
INSERT INTO EMPLOYEE (ID, NAME, AGE, SALARY) VALUES (9, 'William Jackson', 35, 58000.00);
INSERT INTO EMPLOYEE (ID, NAME, AGE, SALARY) VALUES (10, 'Charlotte White', 31, 55000.00);
INSERT INTO EMPLOYEE (ID, NAME, AGE, SALARY) VALUES (11, 'Noah Harris', 26, 47000.00);
INSERT INTO EMPLOYEE (ID, NAME, AGE, SALARY) VALUES (12, 'Isabella Martin', 32, 63000.00);
INSERT INTO EMPLOYEE (ID, NAME, AGE, SALARY) VALUES (13, 'Mason Lee', 28, 51000.00);
INSERT INTO EMPLOYEE (ID, NAME, AGE, SALARY) VALUES (14, 'Amelia Perez', 36, 67000.00);
INSERT INTO EMPLOYEE (ID, NAME, AGE, SALARY) VALUES (15, 'Ethan Young', 29, 56000.00);
INSERT INTO EMPLOYEE (ID, NAME, AGE, SALARY) VALUES (16, 'Mia Carter', 25, 49000.00);
INSERT INTO EMPLOYEE (ID, NAME, AGE, SALARY) VALUES (17, 'Lucas Evans', 37, 70000.00);
INSERT INTO EMPLOYEE (ID, NAME, AGE, SALARY) VALUES (18, 'Ava Mitchell', 33, 58000.00);
INSERT INTO EMPLOYEE (ID, NAME, AGE, SALARY) VALUES (19, 'Logan Phillips', 30, 52000.00);
INSERT INTO EMPLOYEE (ID, NAME, AGE, SALARY) VALUES (20, 'Ella Scott', 35, 60000.00);

-- Insert data into the AccessCard table
INSERT INTO ACCESS_CARD (ID, ISSUE_DATE, IS_ACTIVE, FIRMWARE_VERSION, EMPLOYEE_ID) VALUES
(1, '2025-01-01', TRUE, 'v1.0', 1),
(2, '2025-01-02', TRUE, 'v1.1', 2),
(3, '2025-01-03', FALSE, 'v1.0', 3),
(4, '2025-01-04', TRUE, 'v1.2', 4),
(5, '2025-01-05', FALSE, 'v1.3', 5),
(6, '2025-01-06', TRUE, 'v1.0', 6),
(7, '2025-01-07', TRUE, 'v1.1', 7),
(8, '2025-01-08', FALSE, 'v1.0', 8),
(9, '2025-01-09', TRUE, 'v1.2', 9),
(10, '2025-01-10', TRUE, 'v1.3', 10),
(11, '2025-01-11', TRUE, 'v1.0', 11),
(12, '2025-01-12', TRUE, 'v1.1', 12),
(13, '2025-01-13', FALSE, 'v1.0', 13),
(14, '2025-01-14', TRUE, 'v1.2', 14),
(15, '2025-01-15', TRUE, 'v1.3', 15),
(16, '2025-01-16', TRUE, 'v1.0', 16),
(17, '2025-01-17', TRUE, 'v1.1', 17),
(18, '2025-01-18', FALSE, 'v1.0', 18),
(19, '2025-01-19', TRUE, 'v1.2', 19),
(20, '2025-01-20', TRUE, 'v1.3', 20);

-- Insert Payslips for all employees (2 payslips each)
INSERT INTO PAYSLIP (ID, PERIOD_START_DATE, PERIOD_END_DATE, SALARY, PAYSLIP_EMPLOYEE) VALUES
(1, '2025-01-01', '2025-01-31', 5000.00, 1),
(2, '2025-02-01', '2025-02-28', 5000.00, 1),
(3, '2025-01-01', '2025-01-31', 6500.00, 2),
(4, '2025-02-01', '2025-02-28', 6500.00, 2),
(5, '2025-01-01', '2025-01-31', 4500.00, 3),
(6, '2025-02-01', '2025-02-28', 4500.00, 3),
(7, '2025-01-01', '2025-01-31', 6000.00, 4),
(8, '2025-02-01', '2025-02-28', 6000.00, 4),
(9, '2025-01-01', '2025-01-31', 7500.00, 5),
(10, '2025-02-01', '2025-02-28', 7500.00, 5),
(11, '2025-01-01', '2025-01-31', 4800.00, 6),
(12, '2025-02-01', '2025-02-28', 4800.00, 6),
(13, '2025-01-01', '2025-01-31', 6200.00, 7),
(14, '2025-02-01', '2025-02-28', 6200.00, 7),
(15, '2025-01-01', '2025-01-31', 5200.00, 8),
(16, '2025-02-01', '2025-02-28', 5200.00, 8),
(17, '2025-01-01', '2025-01-31', 5800.00, 9),
(18, '2025-02-01', '2025-02-28', 5800.00, 9),
(19, '2025-01-01', '2025-01-31', 5500.00, 10),
(20, '2025-02-01', '2025-02-28', 5500.00, 10),
(21, '2025-01-01', '2025-01-31', 4700.00, 11),
(22, '2025-02-01', '2025-02-28', 4700.00, 11),
(23, '2025-01-01', '2025-01-31', 6300.00, 12),
(24, '2025-02-01', '2025-02-28', 6300.00, 12),
(25, '2025-01-01', '2025-01-31', 5100.00, 13),
(26, '2025-02-01', '2025-02-28', 5100.00, 13),
(27, '2025-01-01', '2025-01-31', 6700.00, 14),
(28, '2025-02-01', '2025-02-28', 6700.00, 14),
(29, '2025-01-01', '2025-01-31', 5600.00, 15),
(30, '2025-02-01', '2025-02-28', 5600.00, 15),
(31, '2025-01-01', '2025-01-31', 4900.00, 16),
(32, '2025-02-01', '2025-02-28', 4900.00, 16),
(33, '2025-01-01', '2025-01-31', 7000.00, 17),
(34, '2025-02-01', '2025-02-28', 7000.00, 17),
(35, '2025-01-01', '2025-01-31', 5800.00, 18),
(36, '2025-02-01', '2025-02-28', 5800.00, 18),
(37, '2025-01-01', '2025-01-31', 5200.00, 19),
(38, '2025-02-01', '2025-02-28', 5200.00, 19),
(39, '2025-01-01', '2025-01-31', 6000.00, 20),
(40, '2025-02-01', '2025-02-28', 6000.00, 20);

-- Insert Address for all employees
INSERT INTO Address (id, building_number, street, city, country, postal_code, employee_id) VALUES
(1, 101, 'Main St', 'New York', 'USA', '10001', 1),
(2, 102, 'Broadway', 'Los Angeles', 'USA', '90001', 2),
(3, 103, 'Lakeview Ave', 'Chicago', 'USA', '60601', 3),
(4, 104, 'Elm St', 'Houston', 'USA', '77001', 4),
(5, 105, 'Pine St', 'Phoenix', 'USA', '85001', 5),
(6, 106, 'Oak St', 'Philadelphia', 'USA', '19019', 6),
(7, 107, 'Maple St', 'San Antonio', 'USA', '78201', 7),
(8, 108, 'Cedar Ave', 'San Diego', 'USA', '92101', 8),
(9, 109, 'Birch Blvd', 'Dallas', 'USA', '75201', 9),
(10, 110, 'Aspen Dr', 'San Jose', 'USA', '95101', 10),
(11, 111, 'Magnolia Ln', 'Austin', 'USA', '73301', 11),
(12, 112, 'Willow Rd', 'Jacksonville', 'USA', '32099', 12),
(13, 113, 'Spruce Ct', 'Fort Worth', 'USA', '76101', 13),
(14, 114, 'Hickory Dr', 'Columbus', 'USA', '43085', 14),
(15, 115, 'Cypress Ave', 'Charlotte', 'USA', '28201', 15),
(16, 116, 'Sequoia Blvd', 'San Francisco', 'USA', '94101', 16),
(17, 117, 'Fir Way', 'Indianapolis', 'USA', '46201', 17),
(18, 118, 'Redwood Ln', 'Seattle', 'USA', '98101', 18),
(19, 119, 'Palm St', 'Denver', 'USA', '80201', 19),
(20, 120, 'Poplar Dr', 'Boston', 'USA', '02101', 20);
