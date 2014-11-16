CREATE DATABASE `retogrupal` /*!40100 DEFAULT CHARACTER SET latin1 */;


CREATE TABLE IF NOT EXISTS `retogrupal`.`interprete` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB DEFAULT CHARSET=latin1;




CREATE TABLE IF NOT EXISTS `retogrupal`.`cancion` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB DEFAULT CHARSET=latin1;




CREATE TABLE IF NOT EXISTS `retogrupal`.`album` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE IF NOT EXISTS `retogrupal`.`interpretexcancion` (
  `cancion_id` INT NOT NULL,
  `interprete_id` INT NOT NULL,
  PRIMARY KEY (`cancion_id`, `interprete_id`),
  INDEX `fk_interpretexcancion_cancion_idx` (`cancion_id` ASC),
  INDEX `fk_interpretexcancion_interprete1_idx` (`interprete_id` ASC),
  CONSTRAINT `fk_interpretexcancion_cancion`
    FOREIGN KEY (`cancion_id`)
    REFERENCES `retogrupal`.`cancion` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_interpretexcancion_interprete1`
    FOREIGN KEY (`interprete_id`)
    REFERENCES `retogrupal`.`interprete` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE IF NOT EXISTS `retogrupal`.`cancionxalbum` (
  `cancion_id` INT NOT NULL,
  `album_id` INT NOT NULL,
  PRIMARY KEY (`cancion_id`, `album_id`),
  INDEX `fk_cancionxalbum_album1_idx` (`album_id` ASC),
  CONSTRAINT `fk_cancionxalbum_cancion1`
    FOREIGN KEY (`cancion_id`)
    REFERENCES `retogrupal`.`cancion` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_cancionxalbum_album1`
    FOREIGN KEY (`album_id`)
    REFERENCES `retogrupal`.`album` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE IF NOT EXISTS `retogrupal`.`votoxcancion` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `fecha` DATETIME NOT NULL,
  `cantidad` int NOT NULL,
  `cancion_id` INT NOT NULL,
  PRIMARY KEY (`id`, `cancion_id`),
  INDEX `fk_votoxcancion_cancion1_idx` (`cancion_id` ASC),
  CONSTRAINT `fk_votoxcancion_cancion1`
    FOREIGN KEY (`cancion_id`)
    REFERENCES `retogrupal`.`cancion` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB  DEFAULT CHARSET=latin1;


CREATE TABLE IF NOT EXISTS `retogrupal`.`votoxalbum` (
  `id` INT NOT NULL,
  `fecha` DATETIME NOT NULL,
  `cantidad` int NOT NULL,
  `album_id` INT NOT NULL,
  PRIMARY KEY (`id`, `album_id`),
  INDEX `fk_votoxalbum_album1_idx` (`album_id` ASC),
  CONSTRAINT `fk_votoxalbum_album1`
    FOREIGN KEY (`album_id`)
    REFERENCES `retogrupal`.`album` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB DEFAULT CHARSET=latin1;

