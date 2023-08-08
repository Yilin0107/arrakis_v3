INSERT INTO employee (employee_id, employee_name, employee_surname, employee_email, employee_department, employee_role, employee_password_hash)
VALUES
       (1000, 'Georgiana', 'Stoica', 'stoicag@db.com', 'operations', 'senior', NULL),
       (1001, 'Ceyda', 'Akbulut', 'akbulutc@db.com', 'operations', 'junior', NULL),
       (1002, 'Yilin', 'Liu', 'liuy@db.com', 'operations', 'senior', NULL),
       (1003, 'Murtaza', 'Wani', 'wanim@db.com', 'operations', 'manager', NULL),
       (1004, 'Mahreen', 'Chaiwalla', 'chaiwallam@db.com', 'operations', 'senior', NULL);

INSERT INTO bond (isin, bond_currency, cusip, face_value, issuer_name, bond_maturity_date, status, type, employee_id)
VALUES
        ('XS1988387210', 'USD', NULL, 1000, 'BNPParibasIssu 4,37% Microsoft Corp (USD)', '2021-08-05', 'active', 'CORP', 1000),
        ('USN0280EAR64', 'USD', '123456780', 900, 'Airbus 3.15% USD', '2021-07-30', 'active', 'CORP', 1000),
        ('A12356111', 'USD', '123456bh0', 900, 'UBS Facebook (USD)', '2021-09-30', 'active', 'CORP', 1000),
        ('USU02320AG12', 'USD', NULL, 900, 'Amazon', '2021-08-03', 'active', 'CORP', 1003),
        ('GB00B6460505', 'GBP', 'BDCHBW8', 900, 'HM Treasury United Kingdon', '2021-08-09', 'active', 'GOVN', 1002),
        ('GB00B6460506', 'GBP', 'BDCHBW8', 900, 'HM Treasury United Kingdon', '2021-08-09', 'active', 'GOVN', 1002),
        ('GB00B6460507', 'GBP', 'BDCHBW8', 900, 'HM Treasury United Kingdon', '2021-08-09', 'active', 'GOVN', 1002),
        ('GB00B6460508', 'GBP', 'BDCHBW8', 900, 'HM Treasury United Kingdon', '2021-08-09', 'active', 'GOVN', 1002),
        ('GB00B6460509', 'GBP', 'BDCHBW8', 900, 'HM Treasury United Kingdon', '2021-08-09', 'active', 'GOVN', 1002),
        ('GB00B6460510', 'GBP', 'BDCHBW8', 900, 'HM Treasury United Kingdon', '2021-08-09', 'active', 'GOVN', 1002),
        ('GB00B6460511', 'GBP', 'BDCHBW8', 900, 'HM Treasury United Kingdon', '2021-08-09', 'active', 'GOVN', 1002),
        ('GB00B6460512', 'GBP', 'BDCHBW8', 900, 'HM Treasury United Kingdon', '2021-08-09', 'active', 'GOVN', 1002),
        ('GB00B6460513', 'GBP', 'BDCHBW8', 900, 'HM Treasury United Kingdon', '2021-08-09', 'active', 'GOVN', 1002),
        ('GB00B6460514', 'GBP', 'BDCHBW8', 900, 'HM Treasury United Kingdon', '2021-08-09', 'active', 'GOVN', 1002),
        ('GB00B6460515', 'GBP', 'BDCHBW8', 900, 'HM Treasury United Kingdon', '2021-08-09', 'active', 'GOVN', 1002),
        ('US87973RAA86', 'USD', '87973RAA8', 690, 'TEMASEK FINL I LTD GLOBAL MEDIUM TERM NTS BOOK ENTRY REG S', '2021-08-06', 'active', 'SOVN', 1003),
        ('IE00B29LNP31', 'USD', '87973RAA8', 340, 'First Norway Alpha Kl.IV', '2030-12-22', 'active', 'SOVN', 1003);


INSERT INTO trade (trade_id, isin, trade_type, trade_currency, quantity, trade_settlement_date, trade_status, trade_date, unit_price, coupon_percent, book_name, bond_holder)
VALUES
        (1, 'XS1988387210', 'buy', 'USD', 50, '2021-08-04', 'open', '2021-05-13', 90, 4.37, 'Trading_book_1', 'AZ Holdings Inc'),
        (2, 'XS1988387210', 'sell', 'GBP', 40, '2021-08-04', 'open', '2021-02-04', 89.56, 4.37, 'Trading_book_1', 'AZ Holdings Inc'),
        (3, 'USN0280EAR64', 'buy', 'USD', 1000, '2021-08-23', 'open', '2021-05-13', 105.775, 3.15, 'Trading_book_2', 'Acme co'),
        (4, 'USN0280EAR64', 'sell', 'GBP', 900, '2021-09-10', 'open', '2021-02-04', 105.775, 3.15, 'Trading_book_2', 'Acme+A1:R5 Co'),
        (5, 'A12356111', 'buy', 'USD', 50, '2021-08-23', 'open', '2021-05-13', 90, 2, 'Trading_book_3', 'Sovereign Investments'),
        (6, 'USN0280EAR64', 'buy', 'USD', 1000, '2021-08-23', 'open', '2021-05-13', 105.775, 3.15, 'Trading_book_2', 'Astra Trading Ltd'),
        (7, 'A12356111', 'sell', 'USD', 50, '2021-08-23', 'open', '2021-05-13', 90, 2, 'Trading_book_2', 'Sovereign Investments'),
        (8, 'USU02320AG12', 'buy', 'GBP', 60, '2021-09-27', 'open', '2021-04-02', 98.56, 3.15, 'Trading_book_4', 'Muncipal Gov Of Orange County'),
        (9, 'USU02320AG12', 'buy', 'USD', 50, '2021-08-23', 'open', '2021-08-23', 98.56, 3.15, 'Trading_book_4', 'Muncipal Gov Of Orange County'),
        (10, 'GB00B6460505', 'buy', 'GBP', 1100, '2021-09-27', 'open', '2021-09-27', 110.35, 0.75, 'Trading_book_6', 'Goldman Sachs'),
        (11, 'GB00B6460506', 'sell', 'GBP', 900, '2021-09-28', 'open', '2021-09-28', 110.35, 0.75, 'Trading_book_6', 'Goldman Sachs'),
        (12, 'GB00B6460507', 'buy', 'GBP', 2000, '2021-09-29', 'open', '2021-09-29', 110.35, 0.75, 'Trading_book_6', 'UBS'),
        (13, 'GB00B6460508', 'sell', 'GBP', 2000, '2021-09-30', 'open', '2021-09-30', 110.35, 0.75, 'Trading_book_6', 'UBS'),
        (14, 'GB00B6460509', 'buy', 'GBP', 1000, '2021-10-01', 'open', '2021-10-01', 110.35, 0.75, 'Trading_book_6', 'Barclays'),
        (15, 'GB00B6460510', 'buy', 'GBP', 900, '2019-10-02', 'open', '2019-10-02', 110.35, 0.75, 'Trading_book_6', 'Barclays'),
        (16, 'GB00B6460511', 'sell', 'GBP', 1900, '2019-10-03', 'open', '2019-10-03', 110.35, 0.75, 'Trading_book_6', 'Barclays'),
        (17, 'GB00B6460512', 'buy', 'GBP', 600, '2018-10-04', 'open', '2018-10-04', 110.35, 0.75, 'Trading_book_6', 'British Telecom'),
        (18, 'GB00B6460513', 'buy', 'GBP', 600, '2019-10-05', 'open', '2019-10-05', 110.35, 0.75, 'Trading_book_6', 'Pension Holdings'),
        (19, 'GB00B6460514', 'buy', 'GBP', 700, '2021-06-06', 'open', '2021-06-06', 110.35, 0.75, 'Trading_book_6', 'Pension Holdings'),
        (20, 'GB00B6460515', 'sell', 'GBP', 1300, '2021-10-07', 'open', '2011-10-07', 110.35, 0.75, 'Trading_book_6', 'Pension Holdings'),
        (21, 'US87973RAA86', 'buy', 'USD', 60, '2021-09-27', 'open', '2012-04-02', 100.13, 2.02, 'Trading_book_4', 'Zurich Pension fund 4'),
        (22, 'US87973RAA86', 'buy', 'USD', 50, '2021-08-23', 'open', '2012-08-23', 100.13, 2.02, 'Trading_book_4', 'Zurich Pension fund 4'),
        (23, 'US87973RAA86', 'buy', 'USD', 75, '2021-09-27', 'open', '2013-04-02', 100.13, 2.02, 'Trading_book_4', 'Zurich Pension fund 4'),
        (24, 'US87973RAA86', 'buy', 'USD', 50, '2021-08-23', 'open', '2014-08-23', 100.13, 2.02, 'Trading_book_4', 'Zurich Pension fund 4'),
        (25, 'IE00B29LNP31', 'buy', 'USD', 300, '2021-09-27', 'open', '2016-04-02', 98.76, 1.123, 'Trading_book_4', 'Zurich Pension fund 4'),
        (26, 'IE00B29LNP31', 'buy', 'USD', 300, '2021-08-23', 'open', '2012-08-23', 98.76, 1.123, 'Trading_book_4', 'Zurich Pension fund 4'),
        (27, 'IE00B29LNP31', 'buy', 'USD', 300, '2021-09-27', 'open', '2013-04-02', 98.76, 1.123, 'Trading_book_4', 'Zurich Pension fund 4'),
        (28, 'IE00B29LNP31', 'sell', 'USD', 300, '2021-08-23', 'open', '2015-08-23', 98.76, 1.123, 'Trading_book_4', 'Zurich Pension fund 4');

