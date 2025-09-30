CREATE TABLE IF NOT EXISTS product (
    id UUID DEFAULT RANDOM_UUID(),
    name VARCHAR(100) NOT NULL,
    description VARCHAR(255),
    price DECIMAL(10,2) NOT NULL,
    stock INT,
    PRIMARY KEY (id)
);