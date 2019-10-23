drop schema if exists coffeevan;
create schema coffeevan character set utf8 collate utf8_general_ci;

USE coffeevan;

CREATE TABLE `coffee_sort` (
  `id` int(11) AUTO_INCREMENT,
  `sort` varchar(45),
  PRIMARY KEY (`id`),
  UNIQUE KEY `sort` (`sort`)
);

CREATE TABLE `coffee_type` (
  `id` int(11) AUTO_INCREMENT,
  `type` varchar(45),
  `weight` int(11),
  PRIMARY KEY (`id`),
  UNIQUE KEY `type` (`type`)
);

CREATE TABLE `products` (
  `id` int(11) AUTO_INCREMENT,
  `price` double,
  `sort_id` int(11),
  `type_id` int(11),
  `art` int(11),
  PRIMARY KEY (`id`),
  UNIQUE KEY `art` (`art`),
  FOREIGN KEY (`sort_id`) REFERENCES `coffee_sort` (`id`),
  FOREIGN KEY (`type_id`) REFERENCES `coffee_type` (`id`)
);


INSERT INTO `coffee_sort` VALUES (1,'Арабіка'),(3,'Ліберіка'),(2,'Робуста');

INSERT INTO `coffee_type` VALUES (1,'Зернова',10),(2,'Мелена',9),(3,'Розчинна в банці',8),(4,'Розчинна в пакеті',7);

INSERT INTO `products` VALUES (1,2450,1,1,1),(2,2340,1,2,2),(3,1600,1,3,3),(4,1610,1,4,4),(5,2200,2,1,5),(6,2295,2,2,6),(7,1520,2,3,7),(8,1470,2,4,8),(9,2100,3,1,9),(10,2250,3,2,10),(11,1440,3,3,11),(12,1330,3,4,12);


