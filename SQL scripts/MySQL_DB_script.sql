CREATE DATABASE CarRentalDB;
USE CarRentalDB;

CREATE TABLE car(
	carId INT NOT NULL,
	color VARCHAR(45),
	brand VARCHAR(45),
	model VARCHAR(45),
	carclass VARCHAR(45),
	price FLOAT,
	available BIT,
    PRIMARY KEY (carId)
);

CREATE TABLE customer(
	customerId INT NOT NULL,
	carname VARCHAR(45),
	mobile VARCHAR(45),
	email VARCHAR(45),
    PRIMARY KEY (customerId)
);

CREATE TABLE reservation(
	reservationId INT NOT NULL,
	amount DECIMAL,
	pickupDate DATE,
	returnDate DATE,
	reservstatus VARCHAR(15) NOT NULL,
    carId INT NOT NULL,
    customerId INT NOT NULL,
    PRIMARY KEY (reservationId),
	FOREIGN KEY (carId) REFERENCES car(carId),
	FOREIGN KEY (customerId) REFERENCES customer(customerId)
);
