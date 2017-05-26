-- MySQL dump 10.13  Distrib 5.7.12, for Win32 (AMD64)
--
-- Host: localhost    Database: db_oficina_mecanica
-- ------------------------------------------------------
-- Server version	5.7.18-log

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
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clientes` (
  `codigo_cliente` smallint(6) NOT NULL AUTO_INCREMENT,
  `nome_cliente` varchar(50) NOT NULL,
  `dataNasc_cliente` varchar(50) NOT NULL,
  `cpf_cliente` varchar(50) NOT NULL,
  `endereco_cliente` varchar(50) NOT NULL,
  `bairro_cliente` varchar(50) NOT NULL,
  `cep_cliente` varchar(50) NOT NULL,
  `cidade_cliente` varchar(50) NOT NULL,
  `estado_cliente` varchar(50) NOT NULL,
  `email_cliente` varchar(50) NOT NULL,
  `telefone_cliente` varchar(50) NOT NULL,
  `celular_cliente` varchar(50) NOT NULL,
  PRIMARY KEY (`codigo_cliente`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` VALUES (1,'Paulo de Souza','21/03/1983','333.333.333-33','AV: São Carlos, 1004','Centro','11.111-111','São Carlos','SP 	 ','Paulo.Souza@hotmail.com','(16)3343-1838','(33)93333-3333'),(2,'','  /  /    ','   .   .   -  ','','','  .   -   ','','AC 	','asdfasdfsfafs','(  )    -    ','(22)92222-2222'),(3,'Testando Cliente control','  /  /    ','111.111.111-11','','','  .   -   ','','AC 	','','(  )    -    ','(22)92222-2222');
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fornecedores`
--

DROP TABLE IF EXISTS `fornecedores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fornecedores` (
  `codigo_forn` smallint(6) NOT NULL AUTO_INCREMENT,
  `nome_forn` varchar(50) NOT NULL,
  `telefone_forn` varchar(50) NOT NULL,
  `email_forn` varchar(50) NOT NULL,
  `celular_forn` varchar(50) NOT NULL,
  `cnpj_forn` varchar(50) NOT NULL,
  `endereco_forn` varchar(50) NOT NULL,
  `bairro_forn` varchar(50) NOT NULL,
  `cep_forn` varchar(50) NOT NULL,
  `cidade_forn` varchar(50) NOT NULL,
  `estado_forn` varchar(50) NOT NULL,
  PRIMARY KEY (`codigo_forn`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fornecedores`
--

LOCK TABLES `fornecedores` WRITE;
/*!40000 ALTER TABLE `fornecedores` DISABLE KEYS */;
INSERT INTO `fornecedores` VALUES (1,'adfasdfsf','222222222222222','hhhhhhhhhhhhhhhhhhhhhhh','2222222222','','sdfsdf','sdfsdfsadf','','','SC 	 '),(2,'gggggggggggggggggggggggg','2222222222222','hhhhhhhhhhhhhhhhhhhhhhh','','','hhhhhhhhhhhhhhhh','lllllllllllllllllllllllllllll','','','SP 	 ');
/*!40000 ALTER TABLE `fornecedores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `funcionarios`
--

DROP TABLE IF EXISTS `funcionarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `funcionarios` (
  `codigo_func` smallint(6) NOT NULL AUTO_INCREMENT,
  `nome_func` varchar(50) NOT NULL,
  `cpf_func` varchar(50) NOT NULL,
  `senha_func` varchar(50) NOT NULL,
  `login_func` varchar(50) NOT NULL,
  `cargo_func` varchar(50) NOT NULL,
  `endereco_func` varchar(50) NOT NULL,
  `bairro_func` varchar(50) NOT NULL,
  `cep_func` varchar(50) NOT NULL,
  `cidade_func` varchar(50) NOT NULL,
  `estado_func` varchar(50) NOT NULL,
  `email_func` varchar(50) NOT NULL,
  `telefone_func` varchar(50) NOT NULL,
  `celular_func` varchar(50) NOT NULL,
  PRIMARY KEY (`codigo_func`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcionarios`
--

LOCK TABLES `funcionarios` WRITE;
/*!40000 ALTER TABLE `funcionarios` DISABLE KEYS */;
INSERT INTO `funcionarios` VALUES (1,'Paulo de Souza','345.459.540-50','Paulo123','PSouza','Mecânico','Rua: 9 de julho, 1049','Centro','10.050-000','São Carlos','SP','PSouza@hotmail.com','(16)3343-5020','(16)99553-3011');
/*!40000 ALTER TABLE `funcionarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `itens_venda`
--

DROP TABLE IF EXISTS `itens_venda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `itens_venda` (
  `codigo_venda` smallint(6) NOT NULL,
  `codigo_produto` smallint(6) NOT NULL,
  `quant_produto` int(11) NOT NULL,
  PRIMARY KEY (`codigo_venda`,`codigo_produto`),
  KEY `codigo_produto` (`codigo_produto`),
  CONSTRAINT `itens_venda_ibfk_1` FOREIGN KEY (`codigo_venda`) REFERENCES `clientes` (`codigo_cliente`),
  CONSTRAINT `itens_venda_ibfk_2` FOREIGN KEY (`codigo_produto`) REFERENCES `produto` (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `itens_venda`
--

LOCK TABLES `itens_venda` WRITE;
/*!40000 ALTER TABLE `itens_venda` DISABLE KEYS */;
/*!40000 ALTER TABLE `itens_venda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produto`
--

DROP TABLE IF EXISTS `produto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `produto` (
  `codigo` smallint(6) NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  `descricao` varchar(50) NOT NULL,
  `preco_compra` double NOT NULL,
  `preco_venda` double NOT NULL,
  `quantidade` int(11) NOT NULL,
  `fk_codigo_forn` smallint(6) DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  KEY `fk_fornecedor` (`fk_codigo_forn`),
  CONSTRAINT `fk_fornecedor` FOREIGN KEY (`fk_codigo_forn`) REFERENCES `fornecedores` (`codigo_forn`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produto`
--

LOCK TABLES `produto` WRITE;
/*!40000 ALTER TABLE `produto` DISABLE KEYS */;
/*!40000 ALTER TABLE `produto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `venda`
--

DROP TABLE IF EXISTS `venda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `venda` (
  `codigo_venda` smallint(6) NOT NULL AUTO_INCREMENT,
  `valor_venda` varchar(50) NOT NULL,
  `data_venda` varchar(50) NOT NULL,
  `fk_codigo_cliente` smallint(6) NOT NULL,
  PRIMARY KEY (`codigo_venda`),
  KEY `fk_codigo_cliente` (`fk_codigo_cliente`),
  CONSTRAINT `venda_ibfk_1` FOREIGN KEY (`fk_codigo_cliente`) REFERENCES `clientes` (`codigo_cliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venda`
--

LOCK TABLES `venda` WRITE;
/*!40000 ALTER TABLE `venda` DISABLE KEYS */;
/*!40000 ALTER TABLE `venda` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-05-26  7:33:34
