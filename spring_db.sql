-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: localhost    Database: spring_db
-- ------------------------------------------------------
-- Server version	8.0.20

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
  `idLugar` int NOT NULL AUTO_INCREMENT,
  `lugar` varchar(45) NOT NULL,
  `codigoPostal` varchar(45) NOT NULL,
  `idPermiso` int NOT NULL,
  PRIMARY KEY (`idLugar`),
  KEY `fkPermiso_idx` (`idPermiso`),
  CONSTRAINT `fkPermiso` FOREIGN KEY (`idPermiso`) REFERENCES `permiso` (`idPermiso`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lugar`
--

LOCK TABLES `lugar` WRITE;
/*!40000 ALTER TABLE `lugar` DISABLE KEYS */;
/*!40000 ALTER TABLE `lugar` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `permiso`
--

DROP TABLE IF EXISTS `permiso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `permiso` (
  `idPermiso` int NOT NULL AUTO_INCREMENT,
  `fecha` date NOT NULL,
  PRIMARY KEY (`idPermiso`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permiso`
--

LOCK TABLES `permiso` WRITE;
/*!40000 ALTER TABLE `permiso` DISABLE KEYS */;
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
  `idPermisoDiario` int NOT NULL,
  PRIMARY KEY (`idPermisoDiario`),
  CONSTRAINT `fk_permisodiario` FOREIGN KEY (`idPermisoDiario`) REFERENCES `permiso` (`idPermiso`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permisodiario`
--

LOCK TABLES `permisodiario` WRITE;
/*!40000 ALTER TABLE `permisodiario` DISABLE KEYS */;
/*!40000 ALTER TABLE `permisodiario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `permisoperiodo`
--

DROP TABLE IF EXISTS `permisoperiodo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `permisoperiodo` (
  `cantDias` int NOT NULL,
  `vacaciones` tinyint NOT NULL,
  `idPermisoPeriodo` int NOT NULL,
  PRIMARY KEY (`idPermisoPeriodo`),
  CONSTRAINT `fk_permisoperiodo` FOREIGN KEY (`idPermisoPeriodo`) REFERENCES `persona` (`idPersona`)
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
  `idPersona` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `dni` int NOT NULL,
  PRIMARY KEY (`idPersona`),
  UNIQUE KEY `dni_UNIQUE` (`dni`),
  UNIQUE KEY `idPersona_UNIQUE` (`idPersona`),
  CONSTRAINT `fk_permiso` FOREIGN KEY (`idPersona`) REFERENCES `permiso` (`idPermiso`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persona`
--

LOCK TABLES `persona` WRITE;
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
/*!40000 ALTER TABLE `persona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rodado`
--

DROP TABLE IF EXISTS `rodado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rodado` (
  `idRodado` int NOT NULL AUTO_INCREMENT,
  `dominio` varchar(45) NOT NULL,
  `vehiculo` varchar(45) NOT NULL,
  PRIMARY KEY (`idRodado`),
  UNIQUE KEY `idRodado_UNIQUE` (`idRodado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rodado`
--

LOCK TABLES `rodado` WRITE;
/*!40000 ALTER TABLE `rodado` DISABLE KEYS */;
/*!40000 ALTER TABLE `rodado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `id` int NOT NULL AUTO_INCREMENT,
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
  `id` int NOT NULL AUTO_INCREMENT,
  `apellido` varchar(45) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `tipo_documento` varchar(255) NOT NULL,
  `dni` varchar(45) NOT NULL,
  `email` varchar(75) NOT NULL,
  `username` varchar(45) NOT NULL,
  `enabled` bit(1) DEFAULT b'1',
  `password` varchar(255) NOT NULL,
  `role_id` int NOT NULL,
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

-- Dump completed on 2021-05-27 19:07:34
