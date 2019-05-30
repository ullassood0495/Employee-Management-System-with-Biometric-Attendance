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
-- Table structure for table `leaverequest`
--

DROP TABLE IF EXISTS `leaverequest`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `leaverequest` (
  `emp_id` int(11) NOT NULL,
  `duration` int(11) NOT NULL,
  `fromdate` date NOT NULL,
  `todate` date NOT NULL,
  `reason` varchar(200) NOT NULL,
  `type` varchar(10) NOT NULL,
  `status` varchar(2) NOT NULL DEFAULT 'P',
  `applieddate` date NOT NULL,
  `leave_id` int(11) NOT NULL AUTO_INCREMENT,
  `satus_o` varchar(2) NOT NULL DEFAULT 'P',
  PRIMARY KEY (`leave_id`),
  KEY `<<FK>> emp_id` (`emp_id`),
  CONSTRAINT `EMPLOYEEIDENTIFIER` FOREIGN KEY (`emp_id`) REFERENCES `emp_details` (`emp_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `leaverequest`
--

LOCK TABLES `leaverequest` WRITE;
/*!40000 ALTER TABLE `leaverequest` DISABLE KEYS */;
INSERT INTO `leaverequest` VALUES (1,1,'2019-04-09','2019-04-10','dfsahgtreagv','Casual','R','2019-04-09',1,'R'),(1,2,'2019-04-10','2019-04-12','fagtrsbhrftg','Casual','C','2019-04-10',2,'A'),(2,1,'2019-04-09','2019-04-10','sdfcvasdvvcfdfv rewfg rwe','Casual','C','2019-04-09',3,'A'),(1,1,'2019-04-10','2019-04-11','I want to go home.','Urgent','C','2019-04-10',4,'R'),(1,1,'2019-04-12','2019-04-13','jikjh','Casual','C','2019-04-11',5,'A'),(10,2,'2019-04-13','2019-04-15','i want to go home','Casual','C','2019-04-13',6,'A'),(1,1,'2019-04-13','2019-04-14','asdgvfasrdgv','Casual','P','2019-04-13',7,'P');
/*!40000 ALTER TABLE `leaverequest` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-05-06  7:53:59
