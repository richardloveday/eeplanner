-- add table transfer

CREATE TABLE `transfer` (
 `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
 `destination` varchar(45) DEFAULT NULL,
 `priority` tinyint(3) unsigned NOT NULL,
 `manager` varchar(45) DEFAULT NULL,
 `transferNumber` varchar(45) DEFAULT NULL,
 PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

-- add table itinerary

CREATE TABLE `itinerary` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `staffID` int(10) unsigned NOT NULL,
  `year` int(10) DEFAULT NULL,
  `deleted` tinyint(3) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`),
  KEY `staffFK` (`staffID`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;

-- add table itinerary to database


-- add reference to from itinerary table to flight table

ALTER TABLE `eeplanner`.`flight` ADD COLUMN `itineraryID` INT(10) NULL  AFTER `deleted` ;

ALTER TABLE `eeplanner`.`transfer` ADD COLUMN `itineraryID` INT(10) NULL ;


CREATE TABLE `transfercamp` (
  `transferID` int(10) unsigned NOT NULL,
  `campID` int(10) unsigned NOT NULL,
  PRIMARY KEY (`transferID`,`campID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1


-- alter table the transfer table

-- still to be run on monday 25th April


ALTER TABLE `eeplanner`.`transfer` 
ADD COLUMN `carrier` VARCHAR(100) NULL  AFTER `itineraryID` , ADD COLUMN `type` ENUM('independent','company') NULL  AFTER `carrier` , 
ADD COLUMN `outboundArrival` DATETIME NULL  AFTER `type` , ADD COLUMN `outboundDeparture` DATETIME NULL  AFTER `outboundArrival` , 
ADD COLUMN `cost` DECIMAL(10,0) NULL  AFTER `outboundDeparture` , 
ADD COLUMN `numberOfSeats` INT(10) NULL  AFTER `cost` , ADD COLUMN `returnArrival` DATETIME NULL  AFTER `numberOfSeats` , 
ADD COLUMN `returnDeparture` DATETIME NULL  AFTER `returnArrival` , 
ADD COLUMN `deleted` TINYINT(3) NOT NULL  AFTER `returnDeparture` DEFAULT FALSE;

ALTER TABLE `eeplanner`.`transfer` ADD COLUMN `arrivalPoint` VARCHAR(45) NULL  AFTER `deleted` , ADD COLUMN `departurePoint` VARCHAR(45) NULL  AFTER `arrivalPoint` , ADD COLUMN `notes` TEXT NULL  AFTER `departurePoint` ;
ALTER TABLE `eeplanner`.`transfer` ADD COLUMN `campID` INT(10) UNSIGNED NULL DEFAULT NULL ;

-- after 9/05/2011

drop table transfer;
drop table transferCamp;
drop table itinerary;


CREATE TABLE `itinerary` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `staff_id` int(10) unsigned NOT NULL,
  `year` int(10) DEFAULT NULL,
  `deleted` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `camp_id` int(10) unsigned NOT NULL,
  `transfer_1_id` int(10) unsigned NOT NULL,
  `transfer_2_id` int(10) unsigned NOT NULL,
  `flight_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `staffFK` (`staff_id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=latin1;



CREATE TABLE `transfer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `outbound_type` varchar(45) DEFAULT NULL,
  `outbound_reference` varchar(45) DEFAULT NULL,
  `outbound_departure` datetime DEFAULT NULL,
  `outbound_departure_point` varchar(45) DEFAULT NULL,
  `outbound_arrival` datetime DEFAULT NULL,
  `outbound_arrival_point` varchar(45) DEFAULT NULL,
  `outbound_notes` varchar(45) DEFAULT NULL,
  `return_type` varchar(45) DEFAULT NULL,
  `return_reference` varchar(45) DEFAULT NULL,
  `return_departure` datetime DEFAULT NULL,
  `return_departure_point` varchar(45) DEFAULT NULL,
  `return_arrival` datetime DEFAULT NULL,
  `return_arrival_point` varchar(45) DEFAULT NULL,
  `return_notes` varchar(45) DEFAULT NULL,
  `deleted` tinyint(3) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;




