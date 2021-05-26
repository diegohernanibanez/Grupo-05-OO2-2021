-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: localhost    Database: spring_db
-- ------------------------------------------------------
-- Server version	8.0.17

-- ------ Inicialización de BD -------------
drop database if exists spring_db;
create database if not exists spring_db;
use spring_db;
-- ------------------------------------------


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tipo` varchar(50) NOT NULL,
  `enabled` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'ROLE_ADMIN',_binary ''),(2,'ROLE_AUDITOR',_binary '');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `apellido` varchar(45) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `tipo_documento` varchar(255) NOT NULL,
  `dni` varchar(45) NOT NULL,
  `email` varchar(75) NOT NULL,
  `username` varchar(45) NOT NULL,
  `enabled` bit(1) DEFAULT b'1',
  `password` varchar(255) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`id`,`role_id`),
  KEY `fk_user_role_idx` (`role_id`),
  CONSTRAINT `FKn82ha3ccdebhokx3a8fgdqeyy` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Velez','Mati','DNI','12345678','mati@asd.com','mati',_binary '','$2a$10$A9IQzDnfuwlhTXyBLb2Y7e1KJBGY4QgpdCDwcAUWm.tC.yhO/uSZG',1),(3,'Ibañez','Diego','DNI','38079225','diego.hernan.ibanez@gmail.com','dieguito',_binary '','$2a$10$200DaOGdSfCyDROlnT0LIew0bD0Z27NymKzVntvqxWoN0FXRkiE0q',2),(8,'Sassenus','Milly','DNI','87654321','milly@asd.com','milly',_binary '','$2a$10$XyLWKTcwMoZpmO.T5rZCVO.VkMQsA5x.nnKIzYclEBFe2TiD8XzxK',1),(9,'Ortiz','Aylu','DNI','43215678','Aylu@asd.com','aylu',_binary '','$2a$10$QuxAnPSM3wZdGXgKV8fNDOldvWK8g8aEU8TMzFXoaQ8uEtpm92WbK',2),(11,'-','Inhabilitado','DNÏ','00000000','asd@asd.com','inhabilitado',_binary '\0','$2a$10$qJJL37mMJ88V1iV13u6QtuWpEtzlDV.7.LLXGlf37Sw5I0N3iDetO',1),(12,'-','Inhabilitado2','DNÏ','00000000','asd@asd.com','user',_binary '\0','$2a$10$EdODzvj5x9cMgY/RmFahKungT6LnnRiHyo8fJbbuFVR8jiQ2Z.F1W',2);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-25 21:17:47
