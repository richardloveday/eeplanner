
DROP TABLE `payment`;
DROP TABLE `family`;

-- add table template

CREATE TABLE `template` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(100) DEFAULT NULL,
  `text` longtext,
  `edited_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UNIQUE` (`type`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

INSERT INTO `template` (`id`, `type`, `text`, `edited_date`)
VALUES
	(1, 'Contract_of_a_staff_member', '{\\rtf1\\ansi\\ansicpg1252\\cocoartf1038\\cocoasubrtf360\n{\\fonttbl\\f0\\fnil\\fcharset0 Calibri;}\n{\\colortbl;\\red255\\green255\\blue255;}\n{\\info\n{\\title Dear}\n{\\author Carol Syder}\n{\\*\\company Packard Bell NEC}}\\paperw11900\\paperh16840\\margl1134\\margr1134\\margb993\\margt474\\vieww11900\\viewh14740\\viewkind1\n\\deftab720\n\\pard\\pardeftab720\\ri-6\\sb120\\ql\\qnatural\n\n\\f0\\b\\fs28 \\cf0 Name of Employee:  ${staff.contact.firstNames} ${staff.contact.secondName}\\\nName of School: 	${camp.name}		Position:  ${campStaff.job?capitalize}\\\nCourse Dates:  	${camp.start?string.short} - ${camp.end?string.short}	Pay: \\\'a???? per week\\\n\\pard\\pardeftab720\\ri-6\\sb120\\qj\n\n\\b0\\fs24 \\cf0 I undertake to work on the short term courses run by the English Experience in the destination country in accordance with the above details.\\\nI accept that the wages shown in this contract and travel reimbursement shown in my offer letter will be paid at the end of the month in which the camp ends at the agreed rates. My holiday pay is included in my wage according to U.K regulations.\\\nI accept that I am employed as a temporary worker over a two week period. My basic hours of work will be variable per week and I will be expected to be flexible and to work the hours required in accordance with the needs of the business. \\\nI have read a copy of the relevant Job Description and agree to fulfil the responsibilities outlined.  I understand that the English Experience team is responsible for the well being of the students at all times whilst they are on school premises.\\\nI agree to arrive at the school at least 30 minutes prior to the start of lessons and will ensure that all students have left or are being supervised by a responsible adult before leaving the premises at the scheduled time.  I will also attend the staff meeting at the end of each camp day.   \\\nI will adhere to any rules and regulations made by the school in terms of discipline and student conduct.   I have read and agree to the terms of the Staff Conduct and Student Behaviour Policy 2011.\\\nI agree to provide a signed Children\\\'92s Act Form and correct Tax Form before the start of the camp.\\\nIf I should cancel, I am aware that I am liable for any expenses incurred by the English Experience. If I cancel more than one month before the camp then I will be charged \\\'a350, and if I cancel less than one month before the camp I will be charged \\\'a3200 to cover administrative and travel costs. \\\nThe English Experience (UK) Ltd retains the right to cancel this contract in the event of the school cancelling the course, reducing the numbers of students or changing the dates.\\\nI understand that personal travel insurance and any cost incurred for excess baggage is my responsibility and that I will obtain an EHIC Card to carry with me at all times whilst in Europe.\\\n\\pard\\pardeftab720\\ri-6\\sb120\\sa100\\ql\\qnatural\n\\cf0 I accept that I will not solicit any current clients or employees of the English Experience (UK) Ltd and I will not use the English Experience (UK) Ltd logo or materials in order to set up a business in direct competition with the English Experience (UK) LTD.\\\n\\pard\\pardeftab720\\ri-6\\sb120\\ql\\qnatural\n\n\\b \\cf0 \\ul \\ulc0 Signed\\\n\\pard\\pardeftab720\\ri-6\\sb120\\ql\\qnatural\n\\cf0 \\ulnone Employee:  \\\'85\\\'85\\\'85\\\'85\\\'85\\\'85\\\'85\\\'85\\\'85\\\'85\\\'85\\\'85\\\'85\\\'85\\\'85\\\'85\\\'85\\\'85\\\'85\\\'85\\\'85\\\'85....                             Date: .....\\\'85\\\'85\\\'85\\\'85\\\'85\\\'85\\\'85......\\\nPrint Name: \\\'85\\\'85\\\'85\\\'85\\\'85\\\'85\\\'85\\\'85\\\'85\\\'85\\\'85\\\'85\\\'85\\\'85\\\'85\\\'85\\\'85\\\'85\\\'85\\\'85\\\'85\\\'85..\\\nEmployer:                     					     Date:\n\\b0 ${campStaff.contractDate?string(\"dd MMMM yyyy\")}\\\n\\pard\\tx720\\tx1335\\pardeftab720\\ri-6\\sb120\\ql\\qnatural\n\n\\b \\cf0  	            Carol Syder	\\\n		Company Director	\\\n}', '2011-12-05 04:45:30');


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
