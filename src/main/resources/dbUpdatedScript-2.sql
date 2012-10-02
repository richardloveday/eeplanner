
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


/** Camp form changes. */
ALTER TABLE `camp` CHANGE `ageRange6_7` `studentLevel1` int(10) UNSIGNED NULL DEFAULT NULL;
ALTER TABLE `camp` CHANGE `ageRange8_10` `studentLevel2` int(10) UNSIGNED NULL DEFAULT NULL;
ALTER TABLE `camp` CHANGE `ageRange11_12` `studentLevel3` int(10) UNSIGNED NULL DEFAULT NULL;
ALTER TABLE `camp` CHANGE `ageRange13_14` `studentLevel4` int(10) UNSIGNED NULL DEFAULT NULL;
ALTER TABLE `camp` ADD `studentLevel5` int(10) UNSIGNED NULL DEFAULT NULL  AFTER `studentLevel4`;
ALTER TABLE `camp` ADD `studentLevel6` int(10) UNSIGNED NULL DEFAULT NULL  AFTER `studentLevel5`;
ALTER TABLE `camp` ADD `studentLevel7` int(10) UNSIGNED NULL DEFAULT NULL  AFTER `studentLevel6`;
ALTER TABLE `camp` ADD `studentLevel8` int(10) UNSIGNED NULL DEFAULT NULL  AFTER `studentLevel7`;
ALTER TABLE `camp` ADD `splitRoleNeeded` int(10) UNSIGNED NULL DEFAULT '0'  AFTER `schoolContactID`;
ALTER TABLE `camp` ADD `otherNotes` text NULL DEFAULT NULL  AFTER `splitRoleNeeded`;
ALTER TABLE `camp` ADD `headTeacher` text NULL DEFAULT NULL  AFTER `splitRoleNeeded`;
ALTER TABLE `camp` ADD `adminSchoolName` text NULL DEFAULT NULL  AFTER `splitRoleNeeded`;
ALTER TABLE `camp` ADD `adminSchoolAddress` text NULL DEFAULT NULL  AFTER `splitRoleNeeded`;
ALTER TABLE `camp` ADD `timetablingNotes` text NULL DEFAULT NULL  AFTER `splitRoleNeeded`;
ALTER TABLE `camp` ADD `finalRegLastYear` int(10) UNSIGNED NULL DEFAULT NULL  AFTER `splitRoleNeeded`;
ALTER TABLE `camp` ADD `finalRegCurrentYear` int(10) UNSIGNED NULL DEFAULT NULL  AFTER `splitRoleNeeded`;

/* 4:16:00 AM local */ 
/* CHANGES 24th MAY 2012 change syntax on column types is not supported on the cloud based db instance we have, so...*/
ALTER TABLE `camp` ADD `dailyHours2` varchar(100) NULL DEFAULT '0' ;
UPDATE `camp` SET `dailyHours2` = `dailyHours`;

ALTER TABLE `camp` ADD `materialsSent2` varchar(100) NULL DEFAULT '0' ;
UPDATE `camp` SET `materialsSent2` = `materialsSent`;

alter table camp drop column dailyHours;
alter table camp drop column materialsSent;

ALTER TABLE `camp` ADD `dailyHours` varchar(100) NULL DEFAULT '0' ;
UPDATE `camp` SET `dailyHours` = `dailyHours2`;

ALTER TABLE `camp` ADD `materialsSent` varchar(100) NULL DEFAULT '0' ;
UPDATE `camp` SET `materialsSent` = `materialsSent2`;

alter table camp drop column dailyHours2;
alter table camp drop column materialsSent2;
/* CHANGES 24th MAY 2012 */


/* 11:25:08  local */
/* changes 26 sept 2012 */
ALTER TABLE `staff` ADD `job_2` ENUM('teacher','coordinator','drama','drama coordinator','activityleader','activity leader')  NULL  DEFAULT NULL;
UPDATE `staff` SET job_2 = job;
ALTER TABLE `staff` DROP COLUMN job;
UPDATE `staff` SET job_2 = 'drama coordinator' WHERE job_2 = 'drama';
UPDATE `staff` SET job_2 = 'activity leader' WHERE job_2 = 'activityleader';
ALTER TABLE `staff` ADD `job` ENUM('teacher','coordinator','drama coordinator','activity leader')  NULL  DEFAULT NULL;
UPDATE `staff` SET job = job_2;
ALTER TABLE `staff` DROP COLUMN job_2;

/* changes 01 Oct 2012 */
ALTER TABLE `campstaff` ADD `job_2` ENUM('teacher','coordinator','drama','activityleader','activityCoordinator','dptCoordinator','courseSpecialist','drama coordinator','activity leader')  NULL  DEFAULT NULL;
UPDATE `campstaff` SET job_2 = job;
ALTER TABLE `campstaff` DROP COLUMN job;
UPDATE `campstaff` SET job_2 = 'drama coordinator' WHERE job_2 = 'drama';
UPDATE `campstaff` SET job_2 = 'activity leader' WHERE job_2 = 'activityleader';
ALTER TABLE `campstaff` ADD `job` ENUM('teacher','coordinator','activityCoordinator','dptCoordinator','courseSpecialist','drama coordinator','activity leader')  NULL  DEFAULT NULL;
UPDATE `campstaff` SET job = job_2;
ALTER TABLE `campstaff` DROP COLUMN job_2;



