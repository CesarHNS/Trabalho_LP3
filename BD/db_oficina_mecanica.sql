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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fornecedores`
--

LOCK TABLES `fornecedores` WRITE;
/*!40000 ALTER TABLE `fornecedores` DISABLE KEYS */;
INSERT INTO `fornecedores` VALUES (1,'Alberto Ribeiro','3241234','fasdfsaf','2134124','12341234','adsfasdf','sdfasf','1312341241','asdfasf','AC 	 '),(2,'Roberto Dias','3241234','llllllllllllllllll','2134124','12341234','bghstat','dherassf','1312341241','ioçluyiyuj','AC 	 '),(3,'Fabio de Souza','3241234','fasdfsaf','2134124','12341234','adsfasdf','sdfasf','1312341241','asdfasf','AC 	 '),(4,'Bruno Correia','3343-4567','Bruno@hotmail.com','2134124','12341234','bghstat','dherassf','1312341241','ioçluyiyuj','AC 	 ');
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
-- Table structure for table `itens_venda_produto`
--

DROP TABLE IF EXISTS `itens_venda_produto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `itens_venda_produto` (
  `codigo_venda` smallint(6) NOT NULL,
  `codigo_produto` smallint(6) NOT NULL,
  `quant_produto` int(11) NOT NULL,
  PRIMARY KEY (`codigo_venda`,`codigo_produto`),
  KEY `codigo_produto` (`codigo_produto`),
  CONSTRAINT `itens_venda_fk_1` FOREIGN KEY (`codigo_venda`) REFERENCES `venda` (`codigo_venda`),
  CONSTRAINT `itens_venda_fk_2` FOREIGN KEY (`codigo_produto`) REFERENCES `produto` (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `itens_venda_produto`
--

LOCK TABLES `itens_venda_produto` WRITE;
/*!40000 ALTER TABLE `itens_venda_produto` DISABLE KEYS */;
INSERT INTO `itens_venda_produto` VALUES (127,1,5),(127,2,1);
/*!40000 ALTER TABLE `itens_venda_produto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ordem_servico`
--

DROP TABLE IF EXISTS `ordem_servico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ordem_servico` (
  `codigo_os` smallint(6) NOT NULL AUTO_INCREMENT,
  `veiculo` varchar(150) NOT NULL,
  `defeito` varchar(150) NOT NULL,
  `servico` smallint(6) DEFAULT NULL,
  `funcionario` smallint(6) DEFAULT NULL,
  `valor` double DEFAULT NULL,
  `cliente` smallint(6) NOT NULL,
  `data_os` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`codigo_os`),
  KEY `fk_servico` (`servico`),
  KEY `fk_fucionario` (`funcionario`),
  KEY `fk_cliente` (`cliente`),
  CONSTRAINT `fk_cliente` FOREIGN KEY (`cliente`) REFERENCES `clientes` (`codigo_cliente`),
  CONSTRAINT `fk_fucionario` FOREIGN KEY (`funcionario`) REFERENCES `funcionarios` (`codigo_func`),
  CONSTRAINT `fk_servico` FOREIGN KEY (`servico`) REFERENCES `serv` (`codigo_serv`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ordem_servico`
--

LOCK TABLES `ordem_servico` WRITE;
/*!40000 ALTER TABLE `ordem_servico` DISABLE KEYS */;
/*!40000 ALTER TABLE `ordem_servico` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produto`
--

LOCK TABLES `produto` WRITE;
/*!40000 ALTER TABLE `produto` DISABLE KEYS */;
INSERT INTO `produto` VALUES (1,'Arruela','asdfsaf',1,3,0,1),(2,'Cabo de Vela','keijfkjsdf',20,32,9,3);
/*!40000 ALTER TABLE `produto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `serv`
--

DROP TABLE IF EXISTS `serv`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `serv` (
  `codigo_serv` smallint(6) NOT NULL AUTO_INCREMENT,
  `nome_serv` varchar(50) NOT NULL,
  `preco_serv` varchar(50) NOT NULL,
  PRIMARY KEY (`codigo_serv`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `serv`
--

LOCK TABLES `serv` WRITE;
/*!40000 ALTER TABLE `serv` DISABLE KEYS */;
INSERT INTO `serv` VALUES (1,'Balanceamento','250.0'),(2,'Alinhamento','150.0');
/*!40000 ALTER TABLE `serv` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `veiculo`
--

DROP TABLE IF EXISTS `veiculo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `veiculo` (
  `codigo_veiculo` smallint(6) NOT NULL AUTO_INCREMENT,
  `nome_veiculo` varchar(50) NOT NULL,
  `montadora` varchar(50) NOT NULL,
  `placa` varchar(50) NOT NULL,
  `codigo_cliente` smallint(6) NOT NULL,
  PRIMARY KEY (`codigo_veiculo`,`codigo_cliente`),
  KEY `codigo_veiculo` (`codigo_veiculo`),
  KEY `fk_codigo_cliente` (`codigo_cliente`),
  CONSTRAINT `fk_codigo_cliente` FOREIGN KEY (`codigo_cliente`) REFERENCES `clientes` (`codigo_cliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `veiculo`
--

LOCK TABLES `veiculo` WRITE;
/*!40000 ALTER TABLE `veiculo` DISABLE KEYS */;
/*!40000 ALTER TABLE `veiculo` ENABLE KEYS */;
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
  `fk_cliente` smallint(6) DEFAULT NULL,
  PRIMARY KEY (`codigo_venda`),
  KEY `cod_fk_cliente` (`fk_cliente`),
  CONSTRAINT `cod_fk_cliente` FOREIGN KEY (`fk_cliente`) REFERENCES `clientes` (`codigo_cliente`)
) ENGINE=InnoDB AUTO_INCREMENT=129 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venda`
--

LOCK TABLES `venda` WRITE;
/*!40000 ALTER TABLE `venda` DISABLE KEYS */;
INSERT INTO `venda` VALUES (127,'47.0','04/06/2017',1);
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

-- Dump completed on 2017-06-05 23:34:23
