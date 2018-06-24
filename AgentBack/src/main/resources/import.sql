INSERT INTO `xmlagent`.`agent` (`name`, `surname`, `approved`, `email`, `password`) VALUES ('Dragan','Dulic',1,'dragan.dulic1@gmail.com','vvvv');
INSERT INTO `xmlagent`.`agent` (`name`, `surname`, `approved`, `email`, `password`) VALUES ('Mika','Mikic',1,'donthavename3478@gmail.com','aaaa');



INSERT INTO `xmlagent`.`accommodation` (`category`,`reservedfrom`,`reservedto`,`description`,`free`,`name`,`rating`,`agent_id`,`location_id`) VALUES ('1','01/07/2018','07/07/2018','Kod sajma',1,'Master','2.1','1','1');
INSERT INTO `xmlagent`.`location` (`address`,`city`,`country`) VALUES ('Stojana Novakovića 2,','Novi Sad','Srbija');
INSERT INTO `xmlagent`.`additional_services` (`servicename`,`accommodation_id`) VALUES ('wifi','1');
INSERT INTO `xmlagent`.`additional_services` (`servicename`,`accommodation_id`) VALUES ('tv','1');
INSERT INTO `xmlagent`.`room` (`free`,`number_of_bed`,`accommodation_id`) VALUES (1,'5','1');
INSERT INTO `xmlagent`.`price_plan` (`roomtype`,`accommodation_id`,`january`,`february`,`march`,`april`,`may`,`june`,`july`,`august`,`september`,`october`,`november`,`december`) VALUES ('2','1','1000','1000','1000','1000','1000','1000','1000','1000','1000','1000','1000','1000');


INSERT INTO `xmlagent`.`accommodation` (`category`,`reservedfrom`,`reservedto`,`description`,`free`,`name`,`rating`,`agent_id`,`location_id`) VALUES ('1','01/07/2018','07/07/2018','Kod sajma',1,'Meridian','2.1','1','2');
INSERT INTO `xmlagent`.`location` (`address`,`city`,`country`) VALUES ('Stojana Novakovića 2,','Novi Sad','Srbija');
INSERT INTO `xmlagent`.`additional_services` (`servicename`,`accommodation_id`) VALUES ('wifi','2');
INSERT INTO `xmlagent`.`additional_services` (`servicename`,`accommodation_id`) VALUES ('tv','2');
INSERT INTO `xmlagent`.`room` (`free`,`number_of_bed`,`accommodation_id`) VALUES (1,'5','2');
INSERT INTO `xmlagent`.`price_plan` (`roomtype`,`accommodation_id`,`january`,`february`,`march`,`april`,`may`,`june`,`july`,`august`,`september`,`october`,`november`,`december`) VALUES ('2','2','1000','1000','1000','1000','1000','1000','1000','1000','1000','1000','1000','1000');
