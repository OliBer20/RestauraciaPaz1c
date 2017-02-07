-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: objednavky
-- ------------------------------------------------------
-- Server version	5.7.15-log

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
-- Table structure for table `polozka`
--

DROP TABLE IF EXISTS `polozka`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `polozka` (
  `id_polozky` int(11) NOT NULL AUTO_INCREMENT,
  `id_kat` int(11) NOT NULL,
  `nazov` varchar(150) NOT NULL,
  `cena` decimal(20,2) NOT NULL,
  PRIMARY KEY (`id_polozky`),
  UNIQUE KEY `nazov` (`nazov`),
  KEY `id_kat` (`id_kat`),
  CONSTRAINT `polozka_ibfk_1` FOREIGN KEY (`id_kat`) REFERENCES `kategoria` (`id_kat`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `polozka`
--

LOCK TABLES `polozka` WRITE;
/*!40000 ALTER TABLE `polozka` DISABLE KEYS */;
INSERT INTO `polozka` VALUES (16,1,'Pepsi',1.20),(17,1,'Fanta',1.20),(18,1,'Coca cola',1.20),(19,1,'Vino 2dcl',5.00),(21,2,'Grilovane Kuracie stehno + ryza',5.40),(22,2,'Bryndzove halusky + slaninka',4.40),(23,2,'Kuracie prsia na vine',7.00);
/*!40000 ALTER TABLE `polozka` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-02-06 18:41:17
