-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: mydb
-- ------------------------------------------------------
-- Server version	5.7.17-log

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
-- Table structure for table `cycle`
--

DROP TABLE IF EXISTS `cycle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cycle` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cycle`
--

LOCK TABLES `cycle` WRITE;
/*!40000 ALTER TABLE `cycle` DISABLE KEYS */;
INSERT INTO `cycle` VALUES (1,'Математический'),(2,'Гумманитарный'),(3,'Филологический'),(4,'Общеинженерный'),(5,'Компьютерный'),(6,'Медицинский');
/*!40000 ALTER TABLE `cycle` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `department` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department`
--

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` VALUES (1,'МОЭВМ'),(2,'Английский язык и литература'),(3,'Механика');
/*!40000 ALTER TABLE `department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `position`
--

DROP TABLE IF EXISTS `position`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `position` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `position` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `position`
--

LOCK TABLES `position` WRITE;
/*!40000 ALTER TABLE `position` DISABLE KEYS */;
INSERT INTO `position` VALUES (1,'Преподаватель'),(2,'Заведующий кафедрой');
/*!40000 ALTER TABLE `position` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `schedule`
--

DROP TABLE IF EXISTS `schedule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `schedule` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `subject_teacherID` int(11) NOT NULL,
  `group_number` varchar(45) NOT NULL,
  `start_time` datetime NOT NULL,
  `room` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `subject_in_schedule_idx` (`subject_teacherID`),
  CONSTRAINT `subject_in_schedule` FOREIGN KEY (`subject_teacherID`) REFERENCES `subject_teacher` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schedule`
--

LOCK TABLES `schedule` WRITE;
/*!40000 ALTER TABLE `schedule` DISABLE KEYS */;
INSERT INTO `schedule` VALUES (1,1,'АП-17а','2017-09-23 09:45:00',118),(2,1,'АП-17а','2017-09-23 08:00:00',117),(3,2,'АП-22а','2017-09-24 09:45:00',228),(4,4,'АП-17а','2017-09-24 08:00:00',227),(5,3,'АП-17а','2017-09-24 11:30:00',227),(6,9,'АП-20','2017-09-23 08:00:00',113),(7,10,'АП-20','2017-09-23 09:45:00',117);
/*!40000 ALTER TABLE `schedule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subject`
--

DROP TABLE IF EXISTS `subject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subject` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `cycleID` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `subject_in_cycle` (`cycleID`),
  CONSTRAINT `subject_in_cycle` FOREIGN KEY (`cycleID`) REFERENCES `cycle` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subject`
--

LOCK TABLES `subject` WRITE;
/*!40000 ALTER TABLE `subject` DISABLE KEYS */;
INSERT INTO `subject` VALUES (1,'Алгебра',1),(2,'Геометрия',1),(3,'Функциональный анализ',1),(4,'Дискретная математика',1),(5,'Литература 20 века',2),(6,'История',2),(7,'Социология',2),(8,'Философия',2),(9,'Античная литература',2),(10,'Риторика',3),(11,'Английский язык',3),(12,'Русский язык',3),(13,'Немецкий язык',3),(14,'Анлийская литература  ',3),(15,'Теоретическая механика',4),(16,'Физика',4),(17,'Сопромат',4),(18,'Гидравлика',4),(19,'Информатика',5),(20,'ОЗИ',5),(21,'Базы данных',5),(22,'ООП',5),(23,'Биология',6),(24,'Анатомия',6),(25,'Химия',6),(26,'Паразитология',6);
/*!40000 ALTER TABLE `subject` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subject_teacher`
--

DROP TABLE IF EXISTS `subject_teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subject_teacher` (
  `SUBJECT_ID` int(11) NOT NULL,
  `TEACHER_ID` int(11) NOT NULL,
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`ID`),
  KEY `fk_SUBJECT_has_TEACHER_TEACHER1_idx` (`TEACHER_ID`),
  KEY `fk_SUBJECT_has_TEACHER_SUBJECT1_idx` (`SUBJECT_ID`),
  CONSTRAINT `fk_SUBJECT_has_TEACHER_SUBJECT1` FOREIGN KEY (`SUBJECT_ID`) REFERENCES `subject` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_SUBJECT_has_TEACHER_TEACHER1` FOREIGN KEY (`TEACHER_ID`) REFERENCES `teacher` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subject_teacher`
--

LOCK TABLES `subject_teacher` WRITE;
/*!40000 ALTER TABLE `subject_teacher` DISABLE KEYS */;
INSERT INTO `subject_teacher` VALUES (1,1,1),(1,7,2),(2,7,3),(3,7,4),(11,3,5),(14,3,6),(11,5,7),(16,4,8),(17,6,9),(18,6,10);
/*!40000 ALTER TABLE `subject_teacher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher`
--

DROP TABLE IF EXISTS `teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teacher` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `FIO` varchar(128) NOT NULL,
  `adress` varchar(256) DEFAULT NULL,
  `scientific_degree` varchar(45) NOT NULL,
  `positionID` int(11) NOT NULL,
  `phone` varchar(10) DEFAULT NULL,
  `departmentID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `teacher_position_idx` (`positionID`),
  KEY `teacher_department` (`departmentID`),
  CONSTRAINT `teacher_department` FOREIGN KEY (`departmentID`) REFERENCES `department` (`ID`),
  CONSTRAINT `teacher_position` FOREIGN KEY (`positionID`) REFERENCES `position` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher`
--

LOCK TABLES `teacher` WRITE;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
INSERT INTO `teacher` VALUES (1,'Петров Федор Павлович','университетская пл., д.1','профессор',2,'8005553535',1),(2,'Федоров Алексей Павлович','ул.Станкевича, д.23','доцент',1,'0009087867',1),(3,'Андреев Виктор Степанович','ул. Лизюкова, д.53','профессор',2,'3456782211',2),(4,'Петров Петр Романович','ул.Декабристов, д.33','профессор',2,'2345668998',3),(5,'Антонов Игорь Николаевич','университетская пл., д.4','профессор',1,'2887665454',2),(6,'Свиридов Тихон Никитович','ул. Шишкова, д. 46','доцент',1,'2988907766',3),(7,'Саввельев Анатолий Григорьевич','пер. Дальний, д.14','доцент',1,'9655621331',1);
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-09-23 16:32:39
