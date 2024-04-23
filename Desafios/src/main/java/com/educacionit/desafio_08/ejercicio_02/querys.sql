CREATE DATABASE IF NOT EXISTS educacionit;
USE educacionit;

CREATE TABLE pais (
    id INT PRIMARY KEY AUTO_INCREMENT,
    descripcion VARCHAR(255) NOT NULL
);

CREATE TABLE provincias (
    id INT PRIMARY KEY AUTO_INCREMENT,
    descripcion VARCHAR(255) NOT NULL,
    pais_id INT,
    FOREIGN KEY (pais_id) REFERENCES pais(id)
);

INSERT INTO pais (descripcion) VALUES ('Argentina');

INSERT INTO provincias (descripcion, pais_id) 
VALUES 
('Buenos Aires', 1),
('Córdoba', 1),
('Santa Fe', 1),
('Mendoza', 1),
('Tucumán', 1),
('Entre Ríos', 1),
('Salta', 1),
('Chaco', 1),
('Corrientes', 1),
('Misiones', 1),
('San Juan', 1),
('Jujuy', 1),
('Río Negro', 1),
('Neuquén', 1),
('Formosa', 1),
('Chubut', 1),
('San Luis', 1),
('Catamarca', 1),
('La Rioja', 1),
('Santiago del Estero', 1),
('Tierra del Fuego', 1),
('La Pampa', 1),
('Santa Cruz', 1);

SELECT * FROM pais;
SELECT * FROM provincias;