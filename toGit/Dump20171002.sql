CREATE DATABASE  IF NOT EXISTS `testschema` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `testschema`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: testschema
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
-- Table structure for table `authors`
--

DROP TABLE IF EXISTS `authors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `authors` (
  `ID_author` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID_author`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authors`
--

LOCK TABLES `authors` WRITE;
/*!40000 ALTER TABLE `authors` DISABLE KEYS */;
INSERT INTO `authors` VALUES (1,'Eminem'),(2,'Rihanna'),(3,'Noize MC'),(4,'Oxxxymiron'),(5,'Lev Leschenko'),(6,'Drake'),(7,'SOAD'),(8,'Linkin Park'),(9,'Jah Khalib'),(10,'Horus'),(11,'John'),(12,'Alphavite'),(13,'Kobzon'),(14,'author1'),(15,'Billy Talent'),(16,'author2');
/*!40000 ALTER TABLE `authors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `downloaded_songs`
--

DROP TABLE IF EXISTS `downloaded_songs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `downloaded_songs` (
  `ID_song` int(11) NOT NULL,
  `ID_user` int(11) NOT NULL,
  `download_time` datetime DEFAULT NULL,
  PRIMARY KEY (`ID_song`,`ID_user`),
  KEY `AK_FK_USER` (`ID_user`),
  KEY `AK_FK_SONG` (`ID_song`),
  CONSTRAINT `FK2l85rm4fef5g55dmsu3r9lk3l` FOREIGN KEY (`ID_song`) REFERENCES `songs` (`ID_song`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_1` FOREIGN KEY (`ID_user`) REFERENCES `users` (`ID_user`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_Reference_2` FOREIGN KEY (`ID_song`) REFERENCES `songs` (`ID_song`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FKewas42nw3o3q6v6ei17rv16gm` FOREIGN KEY (`ID_user`) REFERENCES `users` (`ID_user`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `downloaded_songs`
--

LOCK TABLES `downloaded_songs` WRITE;
/*!40000 ALTER TABLE `downloaded_songs` DISABLE KEYS */;
INSERT INTO `downloaded_songs` VALUES (1,1,'2016-11-01 10:00:00'),(1,3,'2016-11-01 10:20:00'),(1,27,NULL),(1,34,NULL),(1,40,NULL),(2,27,NULL),(3,1,'2016-11-01 11:05:00'),(3,2,'2016-11-01 13:00:00'),(4,27,NULL),(5,1,'2016-11-11 10:00:00'),(5,27,NULL),(7,3,'2016-11-03 10:00:00'),(7,5,'2016-11-08 10:00:00'),(8,8,'2016-11-04 10:00:00'),(9,27,NULL),(10,6,'2016-01-01 10:10:00'),(11,4,'2016-11-05 10:15:00'),(11,6,'2016-11-05 12:00:00'),(11,34,NULL),(11,39,NULL),(11,40,NULL),(17,27,NULL),(18,27,NULL);
/*!40000 ALTER TABLE `downloaded_songs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `songs`
--

DROP TABLE IF EXISTS `songs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `songs` (
  `ID_author` int(11) NOT NULL,
  `song_name` varchar(50) DEFAULT NULL,
  `ID_song` int(11) NOT NULL AUTO_INCREMENT,
  `download_count` int(11) DEFAULT '0',
  PRIMARY KEY (`ID_song`),
  KEY `AK_FK_AUTHOR` (`ID_author`),
  CONSTRAINT `FKid20uq8dp7clf0p2xvm1heltd` FOREIGN KEY (`ID_author`) REFERENCES `authors` (`ID_author`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `songs`
--

LOCK TABLES `songs` WRITE;
/*!40000 ALTER TABLE `songs` DISABLE KEYS */;
INSERT INTO `songs` VALUES (1,'Rap God',1,2),(1,'WTP',2,0),(1,'White America',3,1),(1,'Slim Shady',4,0),(2,'Diamond',5,1),(2,'Man Down',6,0),(3,'Jordan',7,2),(4,'Imperial',8,1),(5,'Victory Day',9,0),(6,'Too Good',10,1),(7,'Chop Suey',11,2),(8,'In The End',12,0),(9,'Do it',13,0),(10,'Fudzi',14,0),(8,'new song',15,0),(8,'new song',16,0),(12,'top RAP',17,0),(8,'New Divide',18,0),(13,'Hello',19,0),(14,'song1',20,0),(15,'Fallen Leaves',21,0),(16,'songs2',22,0);
/*!40000 ALTER TABLE `songs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `songs_authors`
--

DROP TABLE IF EXISTS `songs_authors`;
/*!50001 DROP VIEW IF EXISTS `songs_authors`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `songs_authors` AS SELECT 
 1 AS `id_song`,
 1 AS `song_name`,
 1 AS `id_author`,
 1 AS `name`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `user_status`
--

DROP TABLE IF EXISTS `user_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_status` (
  `status` varchar(5) DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_status_status_uindex` (`status`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_status`
--

LOCK TABLES `user_status` WRITE;
/*!40000 ALTER TABLE `user_status` DISABLE KEYS */;
INSERT INTO `user_status` VALUES ('Admin',1),('User',4);
/*!40000 ALTER TABLE `user_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `ID_user` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(30) DEFAULT NULL,
  `password` varchar(256) NOT NULL,
  `status_id` int(11) DEFAULT '2',
  PRIMARY KEY (`ID_user`),
  KEY `AK_FK_status` (`status_id`),
  CONSTRAINT `FK7te4jcygsrgdpp4ivkydots3` FOREIGN KEY (`status_id`) REFERENCES `user_status` (`id`),
  CONSTRAINT `FK_Reference_4` FOREIGN KEY (`status_id`) REFERENCES `user_status` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'Admin','1234',1),(2,'Sam','sammy11',4),(3,'alex2007','1488kek',4),(4,'medved','preved',4),(5,'genius','niceattempt1',4),(6,'darkstalker','1234',4),(7,'ivanov','1234',4),(8,'musicfan','1234',4),(9,'addbot','1234',4),(10,'matt','1231',4),(14,'test','1221',4),(19,'test111','11111',4),(20,'test1488','1488\\',4),(21,'Add','ssss',4),(22,'kek','cheburek',4),(23,'lilpep','$2a$10$VHJ5.0ap83iGc3KmbhdEF.wTyJF2i821fOfV7YFh4TuphQWguo3qO',4),(24,'peppa','$2a$10$PYOQetF9AyEhc6GV6yqgIuOvgGvAT4jKgMvZ.LvoL4CAWBeN7aPUW',4),(25,'odmen','$2a$10$z6rghSZzRBA2diT865PnQO7vvZZK2eURMJpjJIwisWqnQ97Ffj3xS',1),(26,'yurii','$2a$10$2uGSrcOmX1sWZKO.XL4b2OsCBjiqwo.ONk9V0mPYQ84D65Es2dqii',1),(27,'kekis','$2a$10$Cn5egnb31q0mvVguO5mu0Ofy1rvWhGTA85wHQMt6c0DJGE8wVx9J2',1),(28,'petro','$2a$10$RePBiitW4fMneyO5ug7suu9zF82gGrtJFXRyROnZM9XMG6.SZyeQu',1),(29,'kostil','$2a$10$qMkyCyWDBo/mN9rGDVIHiuCviZH4UFzEX5VoHCtyjh8x11HHemWvy',1),(30,'ejik','$2a$10$MbSsQY24SHhS1Xd17KgB0.7f7l0EOhkS34xK07otZcHTcaP2OwtJS',1),(31,'proCode','$2a$10$Y4.De5NaBfBlTfzlRSnzteasOZ9C4wqOaeD9hW1T2IRDXUncu8xtC',1),(32,'testir','$2a$10$xBQIaaAaZ6.pg02GF2ljJuV1w4.SjaWsxz.dg8f4J9.ZD7ZJ.7Az2',1),(33,'testtest','$2a$10$3lidBo1GWT/DmnP3YbIB8OgSi6.JoufCsO0.bO2CgVLzriL3x2Wxy',1),(34,'uzver','$2a$10$hJotPrJSQSoyOH5J2Bdc5eqWNBGC9EF3UTYfTOVUphmgZv8W1ok3a',4),(35,'trololo','$2a$10$1AUz5t7rM./4/P5a0l9WWOzRNvYJ7Kh8TtPwBEDBGNKKV4Gb2bIty',1),(36,'priv','$2a$10$O/SPMOREf00/2R7A7dADSuQntQNXJ6U/LQpk7qSMU.MDbXKT74DHq',4),(37,'petrov','$2a$10$tyiNu35jywqIBHOKGNv1w.P0Tn.oy65lIDm/3K8jembbYC0qcJqkW',4),(38,'nikita','$2a$10$u1rTQg4HRzTyUgagANwbsezzPukWDYiglxScMw4BgjVYU/8KK60ja',4),(39,'marusya','$2a$10$voHPPpEwM91rNl.oeJ/ICONeLaOx4JYIK631Nm8Sf0W4CFcbW4dxm',4),(40,'Administrator','$2a$10$UqpVVl5EcVaeRBXis4DkiupjXKEP0SX2WfpMzczW08awPnODDUugO',1),(41,'test9','$2a$10$e4LOlYj606RoitqQvJ7aqOUfU9VNQG8/sOQWke4qigUCN7eYflra.',4);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Final view structure for view `songs_authors`
--

/*!50001 DROP VIEW IF EXISTS `songs_authors`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `songs_authors` AS select `s`.`ID_song` AS `id_song`,`s`.`song_name` AS `song_name`,`a`.`ID_author` AS `id_author`,`a`.`name` AS `name` from (`songs` `s` join `authors` `a` on((`s`.`ID_author` = `a`.`ID_author`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-10-02 22:32:08
