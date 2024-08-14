CREATE TABLE IF NOT EXISTS cars (
    id int PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    color VARCHAR(255) NOT NULL,
    length int NOT NULL,
    weight int NOT NULL,
    velocity int NOT NULL
);