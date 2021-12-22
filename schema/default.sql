CREATE SCHEMA delivery;

CREATE TABLE `user` (
	id                   bigint  NOT NULL    PRIMARY KEY,
	address              varchar(64)      ,
	phone_number         varchar(64)      ,
	name                 varchar(64)      ,
	`type`               int      ,
	user_id              varchar(64)
 ) engine=InnoDB;

CREATE TABLE restaurant (
	id                   bigint  NOT NULL    PRIMARY KEY,
	name                 varchar(64)      ,
	address              varchar(64)      ,
	call_number          varchar(64)      ,
	owner_id             bigint
 ) engine=InnoDB;

CREATE TABLE menu (
	id                   bigint  NOT NULL    PRIMARY KEY,
	name                 varchar(64)      ,
	description          varchar(64)      ,
	price                int      ,
	restaurant_id        bigint
 ) engine=InnoDB;

CREATE TABLE `order` (
	order_id             bigint  NOT NULL    PRIMARY KEY,
	menu_id              bigint      ,
	orderer_id           bigint      ,
	`status`             int      ,
	CONSTRAINT unq_order_menu_id UNIQUE ( menu_id )
 ) engine=InnoDB;

ALTER TABLE menu ADD CONSTRAINT fk_menu_restaurant FOREIGN KEY ( restaurant_id ) REFERENCES restaurant( id ) ON DELETE CASCADE ON UPDATE NO ACTION;

ALTER TABLE `order` ADD CONSTRAINT fk_order_menu FOREIGN KEY ( menu_id ) REFERENCES menu( id ) ON DELETE CASCADE ON UPDATE NO ACTION;

ALTER TABLE `order` ADD CONSTRAINT fk_order_user FOREIGN KEY ( orderer_id ) REFERENCES `user`( id ) ON DELETE CASCADE ON UPDATE NO ACTION;

ALTER TABLE restaurant ADD CONSTRAINT fk_restaurant_user FOREIGN KEY ( owner_id ) REFERENCES `user`( id ) ON DELETE CASCADE ON UPDATE NO ACTION;
