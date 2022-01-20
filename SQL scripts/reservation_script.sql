INSERT INTO `carrentaldb`.`reservation` (`reservationId`, `amount`, `pickupDate`, `returnDate`,`reservstatus`,`carId`,`customerId`)
VALUES 
('1', '2000', '20210101', '20210102', 'RETURNED', '1', '2'),
('2', '8000', '20210201', '20210208', 'RETURNED', '5', '3'),
('3', '4000', '20210307', '20210314', 'CANCELLED', '7', '3'),
('4', '3000', '20220119', '20220125', 'ACTIVE', '14', '3');

SELECT * FROM reservation