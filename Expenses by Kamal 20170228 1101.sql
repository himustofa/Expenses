-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.22-community-nt


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema mk
--

CREATE DATABASE IF NOT EXISTS mk;
USE mk;

--
-- Definition of table `daily_expenses`
--

DROP TABLE IF EXISTS `daily_expenses`;
CREATE TABLE `daily_expenses` (
  `id` int(11) NOT NULL auto_increment,
  `date` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  `name` varchar(25) default NULL,
  `quantity` int(11) NOT NULL default '0',
  `price` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `daily_expenses`
--

/*!40000 ALTER TABLE `daily_expenses` DISABLE KEYS */;
INSERT INTO `daily_expenses` (`id`,`date`,`name`,`quantity`,`price`) VALUES 
 (1,'2017-02-28 10:56:09','Mobile',0,200),
 (2,'2017-02-28 10:56:18','Transport',0,500),
 (3,'2017-02-28 10:56:24','Food',0,300),
 (4,'2017-02-28 10:56:30','Other',0,100),
 (5,'2017-02-28 10:56:37','Payee',0,150);
/*!40000 ALTER TABLE `daily_expenses` ENABLE KEYS */;


--
-- Definition of table `monthly_expenses`
--

DROP TABLE IF EXISTS `monthly_expenses`;
CREATE TABLE `monthly_expenses` (
  `id` int(11) NOT NULL auto_increment,
  `date` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  `monthlyBill` varchar(25) default NULL,
  `quantity` int(11) NOT NULL default '0',
  `monthlyAmount` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `monthly_expenses`
--

/*!40000 ALTER TABLE `monthly_expenses` DISABLE KEYS */;
INSERT INTO `monthly_expenses` (`id`,`date`,`monthlyBill`,`quantity`,`monthlyAmount`) VALUES 
 (1,'2017-02-28 10:57:03','Gas Bill',0,1000),
 (2,'2017-02-28 10:57:10','Water Bill',0,1500),
 (3,'2017-02-28 10:57:20','Electric Bill',0,3000),
 (4,'2017-02-28 10:57:48','Employee Salary',0,25000),
 (5,'2017-02-28 10:57:59','Security Bill',0,1000),
 (6,'2017-02-28 10:58:08','Other Bill',0,300);
/*!40000 ALTER TABLE `monthly_expenses` ENABLE KEYS */;


--
-- Definition of table `yearly_expenses`
--

DROP TABLE IF EXISTS `yearly_expenses`;
CREATE TABLE `yearly_expenses` (
  `id` int(11) NOT NULL auto_increment,
  `date` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  `monthName` varchar(25) default NULL,
  `quantity` int(11) NOT NULL default '0',
  `monthYearAmount` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `yearly_expenses`
--

/*!40000 ALTER TABLE `yearly_expenses` DISABLE KEYS */;
INSERT INTO `yearly_expenses` (`id`,`date`,`monthName`,`quantity`,`monthYearAmount`) VALUES 
 (1,'2017-02-28 10:58:25','January',0,30000),
 (2,'2017-02-28 10:58:30','February',0,25000),
 (3,'2017-02-28 10:58:36','March',0,45000),
 (4,'2017-02-28 10:58:43','April',0,35000),
 (5,'2017-02-28 10:58:50','May',0,20000),
 (6,'2017-02-28 10:58:56','June',0,21000);
/*!40000 ALTER TABLE `yearly_expenses` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
