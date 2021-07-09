-- Creacion de la base de datos
CREATE DATABASE challenge_sofka;
USE challenge_sofka;

-- Creacion de la tabla de conductores
CREATE TABLE `drivers` (
		`id_driver` INT NOT NULL AUTO_INCREMENT,
		`name_driver` VARCHAR(100) NOT NULL,
		`username_driver` VARCHAR(50) NOT NULL,
      `nationality_driver` VARCHAR(50) NOT NULL,
		PRIMARY KEY (`id_driver`)
  );
  
-- Creacion de la tabla de podios
CREATE TABLE `podiums` (
		`id_podium` INT NOT NULL AUTO_INCREMENT,
		`competition_length` INT NOT NULL,
		`first_place_name` VARCHAR(50) NOT NULL,
      `first_place_nationality` VARCHAR(50) NOT NULL,
		`second_place_name` VARCHAR(50) NOT NULL,
      `second_place_nationality` VARCHAR(50) NOT NULL,
		`third_place_name` VARCHAR(50) NOT NULL,
      `third_place_nationality` VARCHAR(50) NOT NULL,
		PRIMARY KEY (`id_podium`)
  );

-- Creacion de la tabla de podios
CREATE TABLE `vehicles` (
		`id_vehicle` INT NOT NULL AUTO_INCREMENT,
		`vehicle_brand` VARCHAR(30) NOT NULL,
		`vehicle_colour` VARCHAR(30) NOT NULL,
		`vehicle_model` VARCHAR(50) NOT NULL,
		PRIMARY KEY (`id_vehicle`)
  );

-- Insercion de valores en la tabla de conductores
INSERT INTO `drivers` (`name_driver`, `username_driver`, `nationality_driver`) VALUES 
	('Juan Camilo Cardona', 'camilo11', 'Colombia'),
	('Andres Bedoya Osorio', 'andre-0510', 'Peru'),
	('Marcela Marin Otalvaro', 'marce_03', 'Paraguay'),
	('Johnatan Silva Giraldo', 'jonsilva99', 'Colombia'),
	('Alejandro Ocampo Perez', 'alejocampo111', 'Mexico'),
	('Carolina Montoya Morales', 'caro-mont', 'Mexico'),
	('Luis Rodriguez Villada', 'lucho-rv', 'Colombia'),
	('Laura Tobon Amariles', 'laura-tobon', 'Chile'),
	('Rocio Gaviria Ochoa', 'rocio_gav1', 'Argentina'),
	('Juan Carlos Chica Alvarez', 'juan-cca', 'Brasil');

-- Insercion de valores en la tabla de vehiculos
INSERT INTO `vehicles` (`vehicle_brand`, `vehicle_colour`, `vehicle_model`) VALUES 
	('Chevrolet', 'Negro', 'Orlando'),
	('Mazda', 'Verde', 'Cruze'),
	('Renault', 'Gris', 'Duster'),
	('Nissan', 'Azul', 'GT-R'),
	('Kia', 'Negro', 'Picanto'),
	('Toyota', 'Gris', '4Runner'),
	('Volkswagen', 'Verde', 'Voyage'),
	('Suzuki', 'Rojo', 'Spresso'),
	('Nissan', 'Negro', 'X-Trail'),
	('Toyota', 'Blanco', 'Fortuner');

-- Insercion de valores en la tabla de podiums
INSERT INTO `podiums` (`competition_length`, `first_place_name`, `first_place_nationality`, `second_place_name`, `second_place_nationality`, `third_place_name`, `third_place_nationality`) VALUES 
	('7', 'Johnatan Silva Giraldo', 'Colombia', 'Raul Osorio Osorio', 'Brasil', 'Luis Rodriguez Villada', 'Colombia'),
	('15', 'Luis Rodriguez Villada', 'Colombia', 'Laura Tobon Amariles', 'Chile', 'Juan Carlos Chica Alvarez', 'Brasil'),
	('4', 'Juan Camilo Cardona', 'Colombia', 'Andres Bedoya Osorio', 'Peru', 'Carolina Montoya Morales', 'Mexico'),
	('5', 'Juan Carlos Chica Alvarez', 'Brasil', 'Alejandro Ocampo Perez', 'Mexico', 'Rocio Gaviria Ochoa', 'Argentina'),
	('8', 'Johnatan Silva Giraldo', 'Colombia', 'Laura Tobon Amariles', 'Chile', 'Alejandro Ocampo Perez', 'Mexico');

  