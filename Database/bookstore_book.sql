-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: bookstore
-- ------------------------------------------------------
-- Server version	5.7.19-log

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
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `book` (
  `book_id` int(11) NOT NULL AUTO_INCREMENT,
  `isbn` varchar(45) NOT NULL,
  `title` varchar(90) NOT NULL,
  `category` varchar(45) NOT NULL,
  `author` varchar(45) NOT NULL,
  `edition` int(11) NOT NULL,
  `publisher` varchar(45) NOT NULL,
  `pub_year` int(11) NOT NULL,
  `min_thresh` int(11) NOT NULL,
  `buying_price` double(11,2) NOT NULL,
  `selling_price` double(11,2) NOT NULL,
  `cover` varchar(45) NOT NULL,
  `quantity` int(11) NOT NULL,
  `rating` int(11) DEFAULT NULL,
  PRIMARY KEY (`book_id`),
  UNIQUE KEY `book_id_UNIQUE` (`book_id`),
  UNIQUE KEY `ISBN_UNIQUE` (`isbn`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES (1,'9781501139154','Leonardo da Vinci','biography','Walter Isaacson',1,'Simon & Schuster',2017,5,2.50,20.99,'images/da_vinci.jpg',15,NULL),(2,'9781250057266','Einstein and the Rabbi: Searching for the Soul','biography','Naomi Levy',1,'Flatiron Books',2017,5,5.08,27.99,'images/einstein_rabbi.jpg',15,NULL),(3,'9781250044662','Renegades','fantasy','Marissa Meyer',1,'Feiwel & Friends',2017,5,2.16,19.99,'images/renegades.jpg',15,NULL),(4,'9780525555360','Turtles All the Way Down','fiction','John Green',1,'Penguin Young Readers Group',2017,5,1.67,19.99,'images/turtles_down.jpg',15,NULL),(5,'9781616207823','What Unites Us: Reflections on Patriotism','nonfiction','Dan Rather',1,'Algonquin Books of Chapel Hill',2017,5,1.94,22.95,'images/reflections_patriotism.jpg',15,NULL),(6,'9780385490818','The Handmaid\'s Tale','fiction','Margaret Atwood',1,'Knopf Doubleday Publishing Group',1998,5,1.16,15.95,'images/handmaid_tale.jpg',15,NULL),(7,'9781449474256','Milk and Honey','poetry','Rupi Kaur',1,'Andrews McMeel Publishing',2015,5,1.06,14.99,'images/milk_honey.jpg',15,NULL),(8,'9780735224292','Little Fires Everywhere','fiction','Celeste Ng',1,'Penguin Publishing Group',2017,5,4.32,27.00,'images/little_fires.jpg',15,NULL),(9,'9781442242289','War and Genocide: A Concise History of the Holocaust','history','Doris Bergen',3,'Rowman & Littlefield Publishers, Inc.',2016,5,6.81,36.59,'images/war_genocide.jpg',15,NULL),(10,'9781101971062','Homegoing','historical fiction','Yaa Gyasi',1,'Knopf Doubleday Publishing Group',2016,5,2.84,10.99,'images/homegoing.jpg',15,NULL),(11,'9780451157447','Carrie','horror','Stephen King',1,'Penguin Publishing Group',1974,5,1.05,6.99,'images/carrie.jpg',15,NULL),(12,'9781488022722','The Lady Travelers Guide to Larceny with a Dashing Stranger','romance','Victoria Alexander',1,'Harlequin',2017,5,0.75,5.99,'images/lady_traveler.jpg',15,NULL),(13,'9781250122520','The Language of Thorns: Midnight Tales and Dangerous Magic','fantasy','Leigh Bardugo',1,'Imprint',2017,5,3.84,13.29,'images/language_thorns.jpg',15,NULL),(14,'9781496708885','Death by Eggnog','mystery','Alex Erickson',1,'Kensington',2017,5,0.24,3.89,'images/eggnog.jpg',15,NULL),(15,'9781566199155','Les Misérables','historical fiction','Victor Hugo',1,'Barnes & Noble Books',1996,5,5.85,14.99,'images/les_mis.jpg',15,NULL);
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-12-03  4:12:38
