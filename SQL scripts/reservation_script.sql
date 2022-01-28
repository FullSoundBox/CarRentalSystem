INSERT INTO `carrentaldb`.`reservation` (`reservation_id`, `amount`, `pickup_date`, `return_date`,`reservation_status`,`car_id`,`customer_id`)
VALUES 
('3', '2000', '20210101', '20210102', 'RETURNED', '1', '2'),
('4', '8000', '20210201', '20210208', 'RETURNED', '5', '3'),
('5', '4000', '20210307', '20210314', 'CANCELLED', '7', '3'),
('6', '3000', '20220119', '20220125', 'ACTIVE', '14', '3');
INSERT INTO `carrentaldb`.`reservation` (`reservation_id`, `amount`, `pickup_date`, `return_date`,`reservation_status`,`car_id`,`customer_id`)
VALUES
('7', '3000', '20220119', '20220125', 'ACTIVE', '15', '3'),
('8', '3000', '20220119', '20220125', 'ACTIVE', '18', '3'),
('9', '3000', '20220119', '20220125', 'ACTIVE', '19', '3'),
('10', '3000', '20220119', '20220125', 'ACTIVE', '20', '3');
INSERT INTO `carrentaldb`.`reservation` (`reservation_id`, `amount`, `pickup_date`, `return_date`,`reservation_status`,`car_id`,`customer_id`)
VALUES
('11', '3000', '20220120', '20220124', 'MISSING', '10', '5'),
('12', '3000', '20220127', '20220131', 'TOPICKUP', '2', '4');

