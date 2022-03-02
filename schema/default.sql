CREATE SCHEMA delivery;

CREATE TABLE `user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `email` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `picture` varchar(300) DEFAULT NULL,
  `role` int NOT NULL,
  `created_date` datetime DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`id`)
 ) engine=InnoDB;

CREATE TABLE restaurant (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(64) DEFAULT NULL,
  `address` varchar(64) DEFAULT NULL,
  `call_number` varchar(64) DEFAULT NULL,
  `owner_id` bigint DEFAULT NULL,

  PRIMARY KEY (`id`),
  KEY `restaurant_FK` (`owner_id`),
  CONSTRAINT `restaurant_FK` FOREIGN KEY (`owner_id`) REFERENCES `user` (`id`)

 ) engine=InnoDB;

CREATE TABLE menu (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(64) DEFAULT NULL,
  `description` varchar(64) DEFAULT NULL,
  `price` int DEFAULT NULL,
  `restaurant_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_menu_restaurant` (`restaurant_id`),
  CONSTRAINT `fk_menu_restaurant` FOREIGN KEY (`restaurant_id`) REFERENCES `restaurant` (`id`) ON DELETE CASCADE
 ) engine=InnoDB;

CREATE TABLE `order` (
  `order_id` bigint NOT NULL AUTO_INCREMENT,
  `menu_id` bigint DEFAULT NULL,
  `orderer_id` bigint DEFAULT NULL,
  `status` int DEFAULT NULL,
  PRIMARY KEY (`order_id`),
  UNIQUE KEY `unq_order_menu_id` (`menu_id`),
  KEY `order_FK` (`orderer_id`),
  CONSTRAINT `fk_order_menu` FOREIGN KEY (`menu_id`) REFERENCES `menu` (`id`) ON DELETE CASCADE,
  CONSTRAINT `order_FK` FOREIGN KEY (`orderer_id`) REFERENCES `user` (`id`)
 ) engine=InnoDB;
