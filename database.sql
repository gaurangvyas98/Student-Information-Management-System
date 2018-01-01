/*
SQLyog Enterprise Trial - MySQL GUI v7.11 
MySQL - 6.0.0-alpha-community-nt-debug : Database - student1
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`student1` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `student1`;

/*Table structure for table `branch` */

DROP TABLE IF EXISTS `branch`;

CREATE TABLE `branch` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `branch` */

insert  into `branch`(`id`,`name`) values (1,'IT'),(2,'CSA'),(3,'ECE'),(4,'MECH'),(5,'EE'),(6,'SWE'),(7,'CIVIL');

/*Table structure for table `course` */

DROP TABLE IF EXISTS `course`;

CREATE TABLE `course` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `course` */

insert  into `course`(`id`,`name`) values (1,'BTECH'),(2,'MTECH'),(3,'BCA'),(4,'MCA'),(5,'BBA'),(6,'MBA'),(7,'ARCH');

/*Table structure for table `faculty_registration` */

DROP TABLE IF EXISTS `faculty_registration`;

CREATE TABLE `faculty_registration` (
  `empid` varchar(25) NOT NULL DEFAULT '',
  `name` varchar(50) DEFAULT NULL,
  `dob` varchar(12) DEFAULT NULL,
  `mobile` varchar(14) DEFAULT NULL,
  `email` varchar(40) DEFAULT NULL,
  `dateofjoining` varchar(15) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`empid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `faculty_registration` */

insert  into `faculty_registration`(`empid`,`name`,`dob`,`mobile`,`email`,`dateofjoining`,`address`,`password`) values ('123','abhishek','00/00/0000','92909090909090','a@gmail.com','00-00-0000','jaipur','rat123');

/*Table structure for table `feedback` */

DROP TABLE IF EXISTS `feedback`;

CREATE TABLE `feedback` (
  `enrollment` varchar(20) NOT NULL,
  `course` varchar(20) DEFAULT NULL,
  `branch` varchar(20) DEFAULT NULL,
  `feedback` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`enrollment`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `feedback` */

insert  into `feedback`(`enrollment`,`course`,`branch`,`feedback`) values ('123','btech','it','jhlhjklhkLbhjklHdkl');

/*Table structure for table `notice` */

DROP TABLE IF EXISTS `notice`;

CREATE TABLE `notice` (
  `id` int(10) DEFAULT NULL,
  `date` varchar(15) DEFAULT NULL,
  `subject` varchar(50) DEFAULT NULL,
  `notice` varchar(300) DEFAULT NULL,
  `branch` int(10) DEFAULT NULL,
  `uploaded_by` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `notice` */

insert  into `notice`(`id`,`date`,`subject`,`notice`,`branch`,`uploaded_by`) values (123,'00-00-0000','456','456',456,'456');

/*Table structure for table `student_registration` */

DROP TABLE IF EXISTS `student_registration`;

CREATE TABLE `student_registration` (
  `enrollment` varchar(25) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `roll` varchar(15) DEFAULT NULL,
  `dob` varchar(12) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `mobile` varchar(14) DEFAULT NULL,
  `email` varchar(40) DEFAULT NULL,
  `branch` varchar(10) DEFAULT NULL,
  `course` varchar(100) DEFAULT NULL,
  `semester` int(5) DEFAULT NULL,
  `dateofjoining` varchar(15) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `student_registration` */

insert  into `student_registration`(`enrollment`,`name`,`roll`,`dob`,`gender`,`mobile`,`email`,`branch`,`course`,`semester`,`dateofjoining`,`address`,`password`) values ('123','abhishek','123','00/00/0000','male','9090909090','a@gmail.com','cs',NULL,1,'00-00-0000','jaipur','rat123'),('','','','1/1/2010','Select','','','IT','SELECT',1,'1/1/2010','',''),('','','','1/1/2010','Select','','','IT','SELECT',1,'1/1/2010','',''),('12345','Gaurang','12345','1/1/2010','Male','303030300','a@gmail.com','CIVIL','ARCH',1,'1/1/2010','			','g123');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
