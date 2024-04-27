DROP TABLE IF EXISTS Product;

DROP TABLE IF EXISTS Pedido;

CREATE TABLE Product (
    id SERIAL PRIMARY KEY,
    name VARCHAR(256),
    description TEXT,
    price NUMERIC(2),
    stock INTEGER
);

CREATE TABLE Pedido(
    id SERIAL PRIMARY KEY,
    dni VARCHAR(9),
    nombre VARCHAR(256),
    apellido VARCHAR(256),
    entradaVip BOOLEAN,
    saldoPulsera FLOAT,
    email VARCHAR(256),
    fechaNacimiento DATE,
    direccion VARCHAR(256),
    confirmado BOOLEAN
)