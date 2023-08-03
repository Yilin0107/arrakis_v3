DROP TABLE IF EXISTS bond;
DROP TABLE IF EXISTS trade;
DROP TABLE IF EXISTS employee;

CREATE TABLE IF NOT EXISTS employee (
    employee_id INT PRIMARY KEY,
    employee_name VARCHAR(50),
    employee_surname VARCHAR(50),
    employee_email VARCHAR(150),
    employee_department VARCHAR(50),
    employee_role VARCHAR(50),
    employee_password_hash VARCHAR(100) -- Adjust the length as per your hashing algorithm
);

CREATE TABLE IF NOT EXISTS bond (
    isin VARCHAR(12) PRIMARY KEY,
    bond_currency VARCHAR(50),
    cusip VARCHAR(9),
    face_value INT,
    issuer_name VARCHAR(255),
    bond_maturity_date DATE,
    status VARCHAR(50),
    type VARCHAR(50),
    employee_id INT,
    FOREIGN KEY (employee_id) REFERENCES employee(employee_id)
);

CREATE TABLE IF NOT EXISTS trade (
    trade_id INT PRIMARY KEY,
    isin VARCHAR(12),
    trade_type VARCHAR(50),
    trade_currency VARCHAR(50),
    quantity INT,
    trade_settlement_date DATE,
    trade_status VARCHAR(50),
    trade_date DATE,
    unit_price DECIMAL(10,2),
    coupon_percent DECIMAL(5,3),
    book_name VARCHAR(255),
    bond_holder VARCHAR(255),
    FOREIGN KEY (isin) REFERENCES bond(isin)
);



