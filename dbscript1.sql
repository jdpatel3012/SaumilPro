-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema account_manager
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema account_manager
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `account_manager` DEFAULT CHARACTER SET utf8 ;
SHOW WARNINGS;
USE `account_manager` ;

-- -----------------------------------------------------
-- Table `account_manager`.`backup_master`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `account_manager`.`backup_master` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `account_manager`.`backup_master` (
  `id` VARCHAR(50) NOT NULL,
  `date` DATETIME NOT NULL,
  `location` VARCHAR(250) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `account_manager`.`txn_type`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `account_manager`.`txn_type` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `account_manager`.`txn_type` (
  `id` VARCHAR(50) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;
CREATE UNIQUE INDEX `type_name_UNIQUE` ON `account_manager`.`txn_type` (`name` ASC);

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `account_manager`.`user_accounts`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `account_manager`.`user_accounts` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `account_manager`.`user_accounts` (
  `id` VARCHAR(50) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `acc_no` VARCHAR(45) NOT NULL,
  `balance` FLOAT NOT NULL DEFAULT '0',
  `active` INT(1) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = 'This table is used to track user accounts';

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `account_manager`.`user_categories`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `account_manager`.`user_categories` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `account_manager`.`user_categories` (
  `id` VARCHAR(50) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `cat_icon` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;
CREATE UNIQUE INDEX `name_UNIQUE` ON `account_manager`.`user_categories` (`name` ASC);

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `account_manager`.`user_tags`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `account_manager`.`user_tags` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `account_manager`.`user_tags` (
  `id` VARCHAR(50) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;
CREATE UNIQUE INDEX `name_UNIQUE` ON `account_manager`.`user_tags` (`name` ASC);

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `account_manager`.`user_txns`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `account_manager`.`user_txns` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `account_manager`.`user_txns` (
  `id` VARCHAR(50) NOT NULL,
  `title` VARCHAR(45) NOT NULL,
  `amt_cr` FLOAT NULL DEFAULT NULL,
  `amt_dr` FLOAT NULL DEFAULT NULL,
  `date` VARCHAR(45) NOT NULL,
  `note` VARCHAR(300) NULL DEFAULT NULL,
  `img` LONGBLOB NULL DEFAULT NULL,
  `img_name` VARCHAR(150) NULL DEFAULT NULL,
  `img_type` VARCHAR(45) NULL DEFAULT NULL,
  `account_id` VARCHAR(50) NOT NULL,
  `category_id` VARCHAR(50) NOT NULL,
  `tag_id` VARCHAR(50) NULL DEFAULT NULL,
  `txn_type_id` VARCHAR(50) NOT NULL,
  `txn_id` VARCHAR(50) NOT NULL,
  `exp` INT(1) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `accID`
    FOREIGN KEY (`account_id`)
    REFERENCES `account_manager`.`user_accounts` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `catID`
    FOREIGN KEY (`category_id`)
    REFERENCES `account_manager`.`user_categories` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `tagID`
    FOREIGN KEY (`tag_id`)
    REFERENCES `account_manager`.`user_tags` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `txnType`
    FOREIGN KEY (`txn_type_id`)
    REFERENCES `account_manager`.`txn_type` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;
CREATE INDEX `accID_idx` ON `account_manager`.`user_txns` (`account_id` ASC);

SHOW WARNINGS;
CREATE INDEX `catID_idx` ON `account_manager`.`user_txns` (`category_id` ASC);

SHOW WARNINGS;
CREATE INDEX `tagID_idx` ON `account_manager`.`user_txns` (`tag_id` ASC);

SHOW WARNINGS;
CREATE INDEX `txnType_idx` ON `account_manager`.`user_txns` (`txn_type_id` ASC);

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `account_manager`.`users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `account_manager`.`users` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `account_manager`.`users` (
  `id` VARCHAR(50) NOT NULL,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;
CREATE UNIQUE INDEX `username_UNIQUE` ON `account_manager`.`users` (`username` ASC);

SHOW WARNINGS;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
