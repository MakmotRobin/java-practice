-- Schema for the SQL exercises.
-- Portable ANSI SQL: runs on MySQL 8, MariaDB 10.4+ and H2 (the test suite uses H2).

DROP TABLE IF EXISTS meals;
DROP TABLE IF EXISTS ingredients;

CREATE TABLE ingredients (
    id               INTEGER      NOT NULL PRIMARY KEY,
    name             VARCHAR(255) NOT NULL,
    contains_lactose BOOLEAN      NOT NULL,
    vegetarian       BOOLEAN      NOT NULL,
    vegan            BOOLEAN      NOT NULL,
    gluten_free      BOOLEAN      NOT NULL
);

CREATE TABLE meals (
    id       INTEGER      NOT NULL PRIMARY KEY,
    name     VARCHAR(255) NOT NULL,
    price    DECIMAL(6, 2) NOT NULL,
    calories INTEGER      NOT NULL
);
