DROP TABLE IF EXISTS bond;
DROP TABLE IF EXISTS trade;

CREATE TABLE IF NOT EXISTS bond (
    isin VARCHAR(12) PRIMARY KEY,
    bond_currency VARCHAR(50),
    cusip VARCHAR(9),
    face_value INT,
    issuer_name VARCHAR(255),
    bond_maturity_date DATE,
    status VARCHAR(50),
    type VARCHAR(50)
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
