-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: localhost    Database: bd-bikelock
-- ------------------------------------------------------
-- Server version	8.0.21

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
-- Table structure for table `bicicleta`
--

DROP TABLE IF EXISTS `bicicleta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bicicleta` (
  `id_bicicleta` bigint NOT NULL AUTO_INCREMENT,
  `cor` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `informacoes_adicionais` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `marca` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `modelo` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `nome` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `numero_serie` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `tag` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `tipo` int DEFAULT NULL,
  `tipo_quadro` int DEFAULT NULL,
  `id_cliente` bigint DEFAULT NULL,
  PRIMARY KEY (`id_bicicleta`),
  KEY `FKp3kou5wci4p445f41qcer8ruo` (`id_cliente`),
  CONSTRAINT `FKp3kou5wci4p445f41qcer8ruo` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id_cliente`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bicicleta`
--

LOCK TABLES `bicicleta` WRITE;
/*!40000 ALTER TABLE `bicicleta` DISABLE KEYS */;
INSERT INTO `bicicleta` VALUES (1,NULL,NULL,'Caloi','Barra circular','Fuscão Preto',NULL,NULL,1,1,1),(2,NULL,NULL,'Caloi','Elite 10','Princesa',NULL,NULL,0,2,1),(3,'Laranja','Freio Hidraulico Shimano','Canondalle','Strada Top','fuscao preto','abcde1928',NULL,0,1,1),(4,'Azul','Freio V-Brake SRAM','Specialized','Thriatlon','Trovao Azul','kajsl10201',NULL,3,0,1);
/*!40000 ALTER TABLE `bicicleta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `id_cliente` bigint NOT NULL AUTO_INCREMENT,
  `cpf` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `email` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `municipio` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `nome` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `senha` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `telefone` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `uf` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id_cliente`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'123.456.789-00','fulano@gmail.com','Teresina','Fulano de Tal',NULL,'(86) 3123-4567','PI'),(2,'987.654.321-00','beltrano@gmail.com','Altos','Beltrano da Silva','1234abcd','(86) 95678-4321','PI'),(3,'999.888.777-00','sicrano@gmail.com','Recife','Sicrano Pereira','efgh29819','(81) 99999-6716','PE');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-02-11 15:23:05
