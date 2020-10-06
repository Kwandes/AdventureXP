DROP DATABASE adventurexp;

CREATE DATABASE adventurexp;

CREATE TABLE `activities` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `description` varchar(512) NOT NULL,
  `price` double NOT NULL,
  `group_size` varchar(45) NOT NULL,
  `duration` int(11) NOT NULL,
  `start_time` varchar(512) NOT NULL,
  `age_restriction` int(11) NOT NULL,
  `height_restriction` int(11) NOT NULL,
  `full_description` varchar(512) NOT NULL,
  PRIMARY KEY (`id`))

