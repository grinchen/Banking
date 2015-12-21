CREATE DATABASE `banking`;
USE `banking`;

CREATE TABLE `client` (
	`id` INT AUTO_INCREMENT,
	`username` VARCHAR(30) NOT NULL,
	`password` VARCHAR(30) NOT NULL,
    `firstname` VARCHAR(30) NOT NULL,
    `lastname` VARCHAR(30) NOT NULL,
	`email` VARCHAR(30) NOT NULL,
	PRIMARY KEY(`id`)); 

CREATE TABLE `account` (
	`id` INT AUTO_INCREMENT,
    `current_account` BIGINT(16) NOT NULL,
	`balance` DEC(9,2) NOT NULL,
	`id_client` INT NOT NULL,
	PRIMARY KEY(`id`),
    UNIQUE INDEX (`current_account`),
	FOREIGN KEY (`id_client`) REFERENCES `client`(id)); 

CREATE TABLE `payment` (
	`id` INT AUTO_INCREMENT,
    `total` DEC(9,2) NOT NULL,
    `id_payeraccount` INT NOT NULL,
    `id_recipientaccount` INT NOT NULL,
	PRIMARY KEY(`id`),
    FOREIGN KEY (`id_payeraccount`) REFERENCES `account`(id),
    FOREIGN KEY (`id_recipientaccount`) REFERENCES `account`(id)); 
