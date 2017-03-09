-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.67-community-nt


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema medicine
--

CREATE DATABASE IF NOT EXISTS medicine;
USE medicine;

--
-- Definition of table `admin`
--

DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `uname` varchar(25) NOT NULL,
  `pass` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` (`uname`,`pass`) VALUES 
 ('karthik','karthik'),
 ('admin','admin');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;


--
-- Definition of table `doc_registeration`
--

DROP TABLE IF EXISTS `doc_registeration`;
CREATE TABLE `doc_registeration` (
  `doc_name` varchar(45) NOT NULL,
  `specialist` varchar(45) NOT NULL,
  `address` varchar(45) NOT NULL,
  `mobileNo` varchar(45) NOT NULL,
  `pass` varchar(45) NOT NULL,
  `language` varchar(45) NOT NULL,
  `status` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `doc_registeration`
--

/*!40000 ALTER TABLE `doc_registeration` DISABLE KEYS */;
INSERT INTO `doc_registeration` (`doc_name`,`specialist`,`address`,`mobileNo`,`pass`,`language`,`status`) VALUES 
 ('suresh','cheild','chennai','9087654321','suresh','Tamil','out');
/*!40000 ALTER TABLE `doc_registeration` ENABLE KEYS */;


--
-- Definition of table `firstaid_tbl`
--

DROP TABLE IF EXISTS `firstaid_tbl`;
CREATE TABLE `firstaid_tbl` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `medicinename` varchar(45) NOT NULL,
  `quantity` varchar(45) NOT NULL,
  `expiredate` varchar(45) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `firstaid_tbl`
--

/*!40000 ALTER TABLE `firstaid_tbl` DISABLE KEYS */;
INSERT INTO `firstaid_tbl` (`id`,`medicinename`,`quantity`,`expiredate`) VALUES 
 (1,'Anacine','17','2013/12/12'),
 (2,'Action500','18','2013/12/12'),
 (3,'para','18','2013/12/12');
/*!40000 ALTER TABLE `firstaid_tbl` ENABLE KEYS */;


--
-- Definition of table `medicinetbl`
--

DROP TABLE IF EXISTS `medicinetbl`;
CREATE TABLE `medicinetbl` (
  `name` varchar(25) NOT NULL,
  `quantity` varchar(45) NOT NULL,
  `expiredate` varchar(45) NOT NULL,
  `tray1` varchar(45) NOT NULL,
  `tray2` varchar(45) NOT NULL,
  `tray3` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `medicinetbl`
--

/*!40000 ALTER TABLE `medicinetbl` DISABLE KEYS */;
INSERT INTO `medicinetbl` (`name`,`quantity`,`expiredate`,`tray1`,`tray2`,`tray3`) VALUES 
 ('nn','0','2013/12/09','Yes','No','No'),
 ('mm','12','2009/12/12','Yes','No','No'),
 ('kk','0','2014/09/10','Yes','No','No'),
 ('yy','11','2015/09/01','No','Yes','No'),
 ('tt','15','2015/12/09','Yes','No','No'),
 ('ee','0','2019/02/12','Yes','No','No'),
 ('vv','0','2020/12/22','No','Yes','No');
/*!40000 ALTER TABLE `medicinetbl` ENABLE KEYS */;


--
-- Definition of table `nearbyhospatal`
--

DROP TABLE IF EXISTS `nearbyhospatal`;
CREATE TABLE `nearbyhospatal` (
  `hospatalname` varchar(45) NOT NULL,
  `status` varchar(45) NOT NULL,
  `lan` varchar(45) NOT NULL,
  `lot` varchar(45) NOT NULL,
  `location` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `nearbyhospatal`
--

/*!40000 ALTER TABLE `nearbyhospatal` DISABLE KEYS */;
INSERT INTO `nearbyhospatal` (`hospatalname`,`status`,`lan`,`lot`,`location`) VALUES 
 ('A','out','12','12','location'),
 ('B','out','12','12','chennai'),
 ('c','out','12','12','chennai');
/*!40000 ALTER TABLE `nearbyhospatal` ENABLE KEYS */;


--
-- Definition of table `patientinfo`
--

DROP TABLE IF EXISTS `patientinfo`;
CREATE TABLE `patientinfo` (
  `heartbit` varchar(45) NOT NULL,
  `temp` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `patientinfo`
--

/*!40000 ALTER TABLE `patientinfo` DISABLE KEYS */;
INSERT INTO `patientinfo` (`heartbit`,`temp`) VALUES 
 ('004','056');
/*!40000 ALTER TABLE `patientinfo` ENABLE KEYS */;


--
-- Definition of table `patientstatus`
--

DROP TABLE IF EXISTS `patientstatus`;
CREATE TABLE `patientstatus` (
  `docname` varchar(45) NOT NULL,
  `bp` varchar(45) NOT NULL,
  `sugar` varchar(45) NOT NULL,
  `status` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `patientstatus`
--

/*!40000 ALTER TABLE `patientstatus` DISABLE KEYS */;
INSERT INTO `patientstatus` (`docname`,`bp`,`sugar`,`status`) VALUES 
 ('suresh','02 ','056','on');
/*!40000 ALTER TABLE `patientstatus` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
