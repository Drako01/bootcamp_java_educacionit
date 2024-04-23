CREATE DATABASE IF NOT EXISTS bootcamp;
USE bootcamp;

CREATE TABLE `alumnos` (
  `legajo` int unsigned NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `edad` int unsigned DEFAULT NULL,
  `especialidad` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`legajo`),
  UNIQUE KEY `legajo_UNIQUE` (`legajo`)
)