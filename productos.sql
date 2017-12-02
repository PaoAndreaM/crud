# SQL Manager 2005 Lite for MySQL 3.6.5.1
# ---------------------------------------
# Host     : localhost
# Port     : 3306
# Database : Crud


SET FOREIGN_KEY_CHECKS=0;

CREATE DATABASE `Crud`
    CHARACTER SET 'latin1'
    COLLATE 'latin1_swedish_ci';

#
# Structure for the `categoria` table : 
#

CREATE TABLE `categoria` (
  `idCategoria` int(11) NOT NULL auto_increment,
  `nombreCat` varchar(50) NOT NULL,
  PRIMARY KEY  (`idCategoria`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Structure for the `productos` table : 
#

CREATE TABLE `productos` (
  `idProducto` int(11) NOT NULL auto_increment,
  `nombre` varchar(50) NOT NULL,
  `idCategoria` int(11) NOT NULL,
  `descripcion` varchar(50) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `precioUnitario` double(15,3) NOT NULL,
  `precioTotal` double(15,3) NOT NULL,
  PRIMARY KEY  (`idProducto`),
  KEY `idCategoria` (`idCategoria`),
  CONSTRAINT `productos_fk` FOREIGN KEY (`idCategoria`) REFERENCES `categoria` (`idCategoria`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

