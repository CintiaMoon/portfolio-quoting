DROP TABLE IF EXISTS Stock;
CREATE TABLE IF NOT EXISTS Intrument(
    symbol		VARCHAR(5) NOT NULL PRIMARY KEY,
    name		VARCHAR(100) NOT NULL
);


CREATE TABLE IF NOT EXISTS Instrument_Transactions  (
    id number NOT NULL PRIMARY KEY,
    instrument_type BIT NOT NULL,
    amount numeric(18, 0) NOT NULL,
    prize numeric(18, 0) NOT NULL,
    oper_type bit NOT NULL,
    txn_date datetime NOT NULL
);


INSERT INTO Instrument_Transactions () values ();
