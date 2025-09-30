USE `employee_directory`;

DROP TABLE IF EXISTS `authorities`;
DROP TABLE IF EXISTS `users`;

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `password` varchar(68) NOT NULL,
  `enabled` tinyint NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Inserting data for table `users`
--

INSERT INTO `users` 
VALUES 
('sushanth','{noop}sushanth',1),
('naveen','{noop}naveen',1),
('vijay','{noop}vijay',1);

INSERT INTO `users` 
VALUES 
('sushanth','{bcrypt}$2a$12$aiXWECwctnKw/RLZ4gt2ceXJANngBTEBECGbOswLMnYDoNaxyqRy6',1),
('naveen',  '{bcrypt}$2a$12$m7.6jGVH8WlLQ4zrwhbYWOyGnhS4dPgN8/2eE7IrSqeP8mUkHuihe',1),
('vijay',   '{bcrypt}$2a$12$.pvMrjr.E7eegWR0IUNjmeLQA4jegGqFc5c89KwzXhTjRGPjOa55O',1);

select * from users;
--
-- Table structure for table `authorities`
--

CREATE TABLE `authorities` (
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL,
  UNIQUE KEY `authorities_idx_1` (`username`,`authority`),
  CONSTRAINT `authorities_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Inserting data for table `authorities`
--

INSERT INTO `authorities` 
VALUES 
('sushanth','ROLE_EMPLOYEE'),
('naveen','ROLE_EMPLOYEE'),
('naveen','ROLE_MANAGER'),
('vijay','ROLE_EMPLOYEE'),
('vijay','ROLE_MANAGER'),
('vijay','ROLE_ADMIN');

select * from authorities;
