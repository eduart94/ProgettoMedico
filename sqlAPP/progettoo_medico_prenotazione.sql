-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: progettoo_medico
-- ------------------------------------------------------
-- Server version	5.5.5-10.1.28-MariaDB

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
-- Table structure for table `prenotazione`
--

DROP TABLE IF EXISTS `prenotazione`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `prenotazione` (
  `idPrenotazione` int(11) NOT NULL AUTO_INCREMENT,
  `nome_dottore` varchar(100) NOT NULL,
  `nome_ambulatorio` varchar(45) NOT NULL,
  `data` date NOT NULL,
  `ora` time(4) NOT NULL,
  `tipologia_prenotazione` varchar(100) NOT NULL,
  `motivazione` varchar(500) NOT NULL,
  `Ambulatorio_idAmbulatorio` int(11) NOT NULL,
  `Utente_idUtente` int(11) NOT NULL,
  `Medico_idMedico` int(11) NOT NULL,
  PRIMARY KEY (`idPrenotazione`),
  KEY `fk_Prenotazione_Ambulatorio1_idx` (`Ambulatorio_idAmbulatorio`),
  KEY `fk_Prenotazione_Utente1_idx` (`Utente_idUtente`),
  KEY `fk_Prenotazione_Medico1_idx` (`Medico_idMedico`),
  CONSTRAINT `fk_Prenotazione_Ambulatorio1` FOREIGN KEY (`Ambulatorio_idAmbulatorio`) REFERENCES `ambulatorio` (`idAmbulatorio`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Prenotazione_Medico1` FOREIGN KEY (`Medico_idMedico`) REFERENCES `medico` (`idMedico`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Prenotazione_Utente1` FOREIGN KEY (`Utente_idUtente`) REFERENCES `utente` (`idUtente`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prenotazione`
--

LOCK TABLES `prenotazione` WRITE;
/*!40000 ALTER TABLE `prenotazione` DISABLE KEYS */;
/*!40000 ALTER TABLE `prenotazione` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-12-13 17:33:30
