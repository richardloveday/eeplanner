
DROP TABLE `payment`;
DROP TABLE `family`;

-- add table template

ALTER TABLE `campstaff` ADD `contract_date` DATE  NULL  AFTER `returned`;

	
ALTER TABLE `staff` ADD `travelOutside`      	tinyint(3) UNSIGNED NOT NULL DEFAULT '0'  AFTER `approved`;
ALTER TABLE `staff` ADD `travelWithinLondon` 	tinyint(3) UNSIGNED NOT NULL DEFAULT '0'  AFTER `travelOutside`;
ALTER TABLE `contact` ADD `accountHolderName` 	varchar(100) NULL DEFAULT NULL;
ALTER TABLE `contact` ADD `accountNumber` 		varchar(100) NULL DEFAULT NULL;
ALTER TABLE `contact` ADD `accountSortCode` 	varchar(100) NULL DEFAULT NULL;
ALTER TABLE `contact` ADD `nationalInsuranceNumber` varchar(100) NULL DEFAULT NULL;
ALTER TABLE `contact` ADD `student` 			tinyint(3) UNSIGNED NOT NULL DEFAULT '0';
ALTER TABLE `staff` ADD `officeNotes` 			text NULL DEFAULT NULL;
ALTER TABLE `staff` ADD `mixedRole` 			tinyint(3) UNSIGNED NOT NULL DEFAULT '0';
ALTER TABLE `staff` ADD `prefAgeAny` 			tinyint(3) UNSIGNED NOT NULL DEFAULT '0';
ALTER TABLE `staff` ADD `prefAgeGroup1` 		tinyint(3) UNSIGNED NOT NULL DEFAULT '0';
ALTER TABLE `staff` ADD `prefAgeGroup2` 		tinyint(3) UNSIGNED NOT NULL DEFAULT '0';
ALTER TABLE `staff` ADD `prefActivityArt` 		int UNSIGNED NOT NULL DEFAULT '0';
ALTER TABLE `staff` ADD `prefActivitySport` 		int UNSIGNED NOT NULL DEFAULT '0';
ALTER TABLE `staff` ADD `prefActivityDrama` 		int UNSIGNED NOT NULL DEFAULT '0';
ALTER TABLE `staff` ADD `prefActivityAny` 		int UNSIGNED NOT NULL DEFAULT '0';
ALTER TABLE `staff` ADD `staffNotes` 			text NULL DEFAULT NULL;
ALTER TABLE `staff` ADD `parentID`      		int(11) SIGNED NOT NULL DEFAULT '0'  AFTER `ID`;
ALTER TABLE `staff` ADD `hash`      		 	varchar(100) NULL DEFAULT NULL AFTER `parentID`;

ALTER TABLE `staffavailability` ADD `note` varchar(1000) NULL DEFAULT NULL  AFTER `available7`;


/* 13/03/2012 11:51:32 PM local */ 
ALTER TABLE `flightstaff` DROP `transferNeeded`;
ALTER TABLE `flightstaff` DROP `infoSent`;
ALTER TABLE `flight` ADD `notes` text NULL DEFAULT NULL;
ALTER TABLE `itinerary` DROP `transfer_1_id`;
ALTER TABLE `itinerary` DROP `transfer_2_id`;
ALTER TABLE `itinerary` ADD `notes` text NULL DEFAULT NULL;


/* 06/04/2012 11:40:01 PM local */ 
DROP TABLE `flightstaff`;
DROP TABLE `flightcamp`;


/* Spring-Data Changes - 2:17:19 AM local */ 
ALTER TABLE `flight` DROP `itineraryID`;
ALTER TABLE `flight` ADD `returnFlightNumber` varchar(100) NULL DEFAULT NULL  AFTER `flightNumber`;

