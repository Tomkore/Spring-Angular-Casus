-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema test
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema test
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `test` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `test` ;

-- -----------------------------------------------------
-- Table `test`.`roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `test`.`roles` (
                                              `id` BIGINT NOT NULL AUTO_INCREMENT,
                                              `title` VARCHAR(45) NOT NULL,
                                              `permissions` VARCHAR(255) NOT NULL,
                                              PRIMARY KEY (`id`))
    ENGINE = InnoDB
    AUTO_INCREMENT = 7
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `test`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `test`.`users` (
                                              `id` BIGINT NOT NULL AUTO_INCREMENT,
                                              `first_name` VARCHAR(45) NOT NULL,
                                              `last_name` VARCHAR(45) NOT NULL,
                                              `email` VARCHAR(90) NOT NULL,
                                              `password` VARCHAR(255) NOT NULL,
                                              PRIMARY KEY (`id`))
    ENGINE = InnoDB
    AUTO_INCREMENT = 12
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `test`.`user_roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `test`.`user_roles` (
                                                   `id` BIGINT NOT NULL AUTO_INCREMENT,
                                                   `user_id` BIGINT NOT NULL,
                                                   `role_id` BIGINT NOT NULL,
                                                   PRIMARY KEY (`id`),
                                                   INDEX `fk_User_roles_Roles1_idx` (`role_id` ASC) VISIBLE,
                                                   INDEX `fk_User_roles_Users_idx` (`user_id` ASC) VISIBLE,
                                                   CONSTRAINT `fk_User_roles_Roles1`
                                                       FOREIGN KEY (`role_id`)
                                                           REFERENCES `test`.`roles` (`id`)
                                                           ON DELETE RESTRICT
                                                           ON UPDATE CASCADE,
                                                   CONSTRAINT `fk_User_roles_Users`
                                                       FOREIGN KEY (`user_id`)
                                                           REFERENCES `test`.`users` (`id`)
                                                           ON DELETE CASCADE
                                                           ON UPDATE CASCADE)
    ENGINE = InnoDB
    AUTO_INCREMENT = 2
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
