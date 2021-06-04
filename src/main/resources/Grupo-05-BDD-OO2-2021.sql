-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: localhost    Database: spring_db
-- ------------------------------------------------------
-- Server version	8.0.23

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
-- Table structure for table `lugar`
--

DROP TABLE IF EXISTS `lugar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lugar` (
  `id_lugar` bigint NOT NULL AUTO_INCREMENT,
  `codigo_postal` varchar(8) NOT NULL,
  `lugar` varchar(45) NOT NULL,
  PRIMARY KEY (`id_lugar`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lugar`
--

LOCK TABLES `lugar` WRITE;
/*!40000 ALTER TABLE `lugar` DISABLE KEYS */;
INSERT INTO `lugar` VALUES (1,'1834','MonteGrande'),(2,'1977','Lomas de zamora'),(3,'1999','Lanus'),(4,'2099','Las Toninas'),(5,'2100','Mar del tuyu');
/*!40000 ALTER TABLE `lugar` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pemisos_lugares`
--

DROP TABLE IF EXISTS `pemisos_lugares`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pemisos_lugares` (
  `fk_lugar` int NOT NULL,
  `fk_permiso` bigint NOT NULL,
  PRIMARY KEY (`fk_lugar`,`fk_permiso`),
  KEY `FK5xtvd1sleq8j9ib7iv8sex22a` (`fk_permiso`),
  CONSTRAINT `FK5xtvd1sleq8j9ib7iv8sex22a` FOREIGN KEY (`fk_permiso`) REFERENCES `lugar` (`id_lugar`),
  CONSTRAINT `FKj9ae46shsntn6112cwugk8lf2` FOREIGN KEY (`fk_lugar`) REFERENCES `permiso` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pemisos_lugares`
--

LOCK TABLES `pemisos_lugares` WRITE;
/*!40000 ALTER TABLE `pemisos_lugares` DISABLE KEYS */;
INSERT INTO `pemisos_lugares` VALUES (1,1),(2,1),(1,5),(2,5);
/*!40000 ALTER TABLE `pemisos_lugares` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `permiso`
--

DROP TABLE IF EXISTS `permiso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `permiso` (
  `id` int NOT NULL AUTO_INCREMENT,
  `fecha` date NOT NULL,
  `id_persona` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK8woob4cm5meiecdgbmeej96am` (`id_persona`),
  CONSTRAINT `FK8woob4cm5meiecdgbmeej96am` FOREIGN KEY (`id_persona`) REFERENCES `persona` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permiso`
--

LOCK TABLES `permiso` WRITE;
/*!40000 ALTER TABLE `permiso` DISABLE KEYS */;
INSERT INTO `permiso` VALUES (1,'2021-06-04',1),(2,'2021-06-04',5);
/*!40000 ALTER TABLE `permiso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `permisodiario`
--

DROP TABLE IF EXISTS `permisodiario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `permisodiario` (
  `motivo` varchar(45) NOT NULL,
  `id` int NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FKnwt8k1cayvtinytftu3xs1gdw` FOREIGN KEY (`id`) REFERENCES `permiso` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permisodiario`
--

LOCK TABLES `permisodiario` WRITE;
/*!40000 ALTER TABLE `permisodiario` DISABLE KEYS */;
INSERT INTO `permisodiario` VALUES ('vacaciones',1),('trabajo',2);
/*!40000 ALTER TABLE `permisodiario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `permisoperiodo`
--

DROP TABLE IF EXISTS `permisoperiodo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `permisoperiodo` (
  `cant_dias` int NOT NULL,
  `vacaciones` tinyint(1) NOT NULL DEFAULT '0',
  `id` int NOT NULL,
  `fk_id_rodado` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKsgmliwygkdbrvyk87vfojcp4r` (`fk_id_rodado`),
  CONSTRAINT `FKf0x3rqglvfna95kng7h0lj07` FOREIGN KEY (`id`) REFERENCES `permiso` (`id`),
  CONSTRAINT `FKsgmliwygkdbrvyk87vfojcp4r` FOREIGN KEY (`fk_id_rodado`) REFERENCES `rodado` (`id_rodado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permisoperiodo`
--

LOCK TABLES `permisoperiodo` WRITE;
/*!40000 ALTER TABLE `permisoperiodo` DISABLE KEYS */;
/*!40000 ALTER TABLE `permisoperiodo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `persona`
--

DROP TABLE IF EXISTS `persona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `persona` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `apellido` varchar(45) NOT NULL,
  `dni` bigint NOT NULL,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_hlwyecu2r9wagqayhej1kt5wy` (`dni`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persona`
--

LOCK TABLES `persona` WRITE;
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
INSERT INTO `persona` VALUES (1,'velez',38705112,'matias'),(2,'ibanez',38705100,'diego'),(3,'sassenus',40303030,'milagros'),(4,'ortiz',40303333,'aylen'),(5,'bermudez',41666666,'luz'),(6,'pere<',70602033,'juan'),(7,'lopez',10999999,'franco'),(8,'perez',10999777,'franco');
/*!40000 ALTER TABLE `persona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rodado`
--

DROP TABLE IF EXISTS `rodado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rodado` (
  `id_rodado` int NOT NULL AUTO_INCREMENT,
  `dominio` varchar(255) NOT NULL,
  `vehiculo` varchar(255) NOT NULL,
  PRIMARY KEY (`id_rodado`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rodado`
--

LOCK TABLES `rodado` WRITE;
/*!40000 ALTER TABLE `rodado` DISABLE KEYS */;
INSERT INTO `rodado` VALUES (1,'bww999','Auto');
/*!40000 ALTER TABLE `rodado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `enabled` bit(1) DEFAULT NULL,
  `tipo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,_binary '','ROLE_ADMIN'),(2,_binary '','ROLE_AUDITOR');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `email` varchar(255) DEFAULT NULL,
  `enabled` tinyint(1) NOT NULL DEFAULT '1',
  `password` varchar(255) DEFAULT NULL,
  `tipo_documento` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `id` bigint NOT NULL,
  `role_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKn82ha3ccdebhokx3a8fgdqeyy` (`role_id`),
  CONSTRAINT `FKn82ha3ccdebhokx3a8fgdqeyy` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
  CONSTRAINT `FKq9e1epiqip339syujm4brhw7u` FOREIGN KEY (`id`) REFERENCES `persona` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('aaa@aaa.com',1,'$2a$10$lpeTNBUGJfHxsJNOkAF5IuS5eLZUOuL8vlHMd/9O0rL5Cb3rp.uk6','dni','mati',1,1);
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

-- Dump completed on 2021-06-04 11:41:49
