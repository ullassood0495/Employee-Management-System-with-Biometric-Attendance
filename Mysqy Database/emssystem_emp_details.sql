CREATE DATABASE  IF NOT EXISTS `emssystem` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `emssystem`;
-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: emssystem
-- ------------------------------------------------------
-- Server version	5.7.11-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `emp_details`
--

DROP TABLE IF EXISTS `emp_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `emp_details` (
  `emp_id` int(11) NOT NULL,
  `emp_fname` varchar(45) NOT NULL,
  `emp_lname` varchar(45) DEFAULT NULL,
  `emp_desig` varchar(45) DEFAULT NULL,
  `emp_dept` int(11) DEFAULT NULL,
  `emp_basesalary` decimal(10,2) NOT NULL,
  `emp_incentive` decimal(10,2) DEFAULT NULL,
  `emp_contact` varchar(10) NOT NULL,
  PRIMARY KEY (`emp_id`),
  KEY `<<FK>> dept_id` (`emp_dept`),
  CONSTRAINT `departmentid` FOREIGN KEY (`emp_dept`) REFERENCES `depts` (`dept_id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `employeeid` FOREIGN KEY (`emp_id`) REFERENCES `employee_login` (`emp_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `emp_details`
--

LOCK TABLES `emp_details` WRITE;
/*!40000 ALTER TABLE `emp_details` DISABLE KEYS */;
INSERT INTO `emp_details` VALUES (1,'Sahil','Aggrawal','Accounts',1,152000.00,20000.00,'9996413883'),(2,'Rahul','Rana','Accounts',1,130000.00,20000.00,'9996413883'),(10,'Ullas','Sood','Manager',1,10000.00,2000.00,'1234567890'),(12,'aastha','aggarwal','Manager',3,12000.00,3000.00,'1234567890'),(13,'Ullas','Sood','Manager',2,10000.00,2000.00,'1234567890'),(14,'razor','rana','Manager',3,50000.00,500.00,'9466251645');
/*!40000 ALTER TABLE `emp_details` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-05-06  7:53:56
