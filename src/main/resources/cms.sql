-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: 120.78.164.247    Database: cms
-- ------------------------------------------------------
-- Server version	5.7.20-0ubuntu0.16.04.1

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
-- Table structure for table `cms_article`
--

DROP TABLE IF EXISTS `cms_article`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cms_article` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(245) DEFAULT NULL,
  `listStyle` varchar(45) DEFAULT NULL,
  `content` text,
  `source` text,
  `publishTime` varchar(45) DEFAULT NULL,
  `readTimes` int(11) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  `thumbUp` int(11) DEFAULT NULL,
  `thumbDown` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `category_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_article_user_id_idx` (`user_id`),
  KEY `fk_article_category_id_idx` (`category_id`),
  CONSTRAINT `fk_article_category_id` FOREIGN KEY (`category_id`) REFERENCES `cms_category` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_article_user_id` FOREIGN KEY (`user_id`) REFERENCES `cms_user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=152 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cms_article`
--

LOCK TABLES `cms_article` WRITE;
/*!40000 ALTER TABLE `cms_article` DISABLE KEYS */;
INSERT INTO `cms_article` VALUES (1,'测试',NULL,'这是一篇好文章',NULL,'2018-09-18 21:49:35',8,NULL,NULL,NULL,NULL,1),(143,'sdcsc','1','sdcsc','sdc','2018-09-26 15:00:20',0,'未审核',NULL,NULL,NULL,NULL),(149,'test','1','test','\'\'','2018-09-26 15:12:09',0,'未审核',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `cms_article` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cms_article_file`
--

DROP TABLE IF EXISTS `cms_article_file`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cms_article_file` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `article_id` bigint(20) DEFAULT NULL,
  `file_id` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_ca_file_id_idx` (`file_id`),
  KEY `fk_ca_article_id_idx` (`article_id`),
  CONSTRAINT `fk_ca_article_id` FOREIGN KEY (`article_id`) REFERENCES `cms_article` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_ca_file_id` FOREIGN KEY (`file_id`) REFERENCES `cms_file` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cms_article_file`
--

LOCK TABLES `cms_article_file` WRITE;
/*!40000 ALTER TABLE `cms_article_file` DISABLE KEYS */;
/*!40000 ALTER TABLE `cms_article_file` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cms_category`
--

DROP TABLE IF EXISTS `cms_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cms_category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `comment` varchar(45) DEFAULT NULL,
  `no` int(11) DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_category_category_id_idx` (`parent_id`),
  CONSTRAINT `fk_category_category_id` FOREIGN KEY (`parent_id`) REFERENCES `cms_category` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=168 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cms_category`
--

LOCK TABLES `cms_category` WRITE;
/*!40000 ALTER TABLE `cms_category` DISABLE KEYS */;
INSERT INTO `cms_category` VALUES (1,'推荐','点击量高的文章',NULL,NULL),(165,'美术','美术是一门课程',1,NULL),(166,'123','321',1,1),(167,'www','122',1,165);
/*!40000 ALTER TABLE `cms_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cms_comment`
--

DROP TABLE IF EXISTS `cms_comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cms_comment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `content` text,
  `commentTime` varchar(45) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  `article_id` bigint(20) DEFAULT NULL,
  `customer_id` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_comment_article_id_idx` (`article_id`),
  CONSTRAINT `fk_comment_article_id` FOREIGN KEY (`article_id`) REFERENCES `cms_article` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cms_comment`
--

LOCK TABLES `cms_comment` WRITE;
/*!40000 ALTER TABLE `cms_comment` DISABLE KEYS */;
INSERT INTO `cms_comment` VALUES (1,'这篇文章写得不错','2018-09-19 11:21:25','通过',1,NULL);
/*!40000 ALTER TABLE `cms_comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cms_file`
--

DROP TABLE IF EXISTS `cms_file`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cms_file` (
  `id` varchar(256) NOT NULL,
  `groupName` varchar(256) DEFAULT NULL,
  `uploadTime` varchar(45) DEFAULT NULL,
  `fileSize` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cms_file`
--

LOCK TABLES `cms_file` WRITE;
/*!40000 ALTER TABLE `cms_file` DISABLE KEYS */;
INSERT INTO `cms_file` VALUES ('M00/00/01/rBApFluhsFCALgjqAADqH9LyZnY746.jpg','group1','2018-09-19 10:11:28',NULL),('M00/00/02/rBApFluq-S2AYD1_AAgXWvl26mg018.jpg','group1','2018-09-26 11:12:45',530266);
/*!40000 ALTER TABLE `cms_file` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cms_roles`
--

DROP TABLE IF EXISTS `cms_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cms_roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cms_roles`
--

LOCK TABLES `cms_roles` WRITE;
/*!40000 ALTER TABLE `cms_roles` DISABLE KEYS */;
INSERT INTO `cms_roles` VALUES (1,'超级管理员'),(2,'普通用户');
/*!40000 ALTER TABLE `cms_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cms_roles_user`
--

DROP TABLE IF EXISTS `cms_roles_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cms_roles_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rid` int(11) DEFAULT '2',
  `uid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `rid` (`rid`),
  KEY `roles_user_ibfk_2` (`uid`),
  CONSTRAINT `roles_user_ibfk_1` FOREIGN KEY (`rid`) REFERENCES `cms_roles` (`id`),
  CONSTRAINT `roles_user_ibfk_2` FOREIGN KEY (`uid`) REFERENCES `cms_user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=131 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cms_roles_user`
--

LOCK TABLES `cms_roles_user` WRITE;
/*!40000 ALTER TABLE `cms_roles_user` DISABLE KEYS */;
INSERT INTO `cms_roles_user` VALUES (8,2,7),(9,1,7),(17,2,7);
/*!40000 ALTER TABLE `cms_roles_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cms_user`
--

DROP TABLE IF EXISTS `cms_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cms_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(64) DEFAULT NULL,
  `nickname` varchar(64) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `enabled` tinyint(1) DEFAULT '1',
  `email` varchar(64) DEFAULT NULL,
  `userface` varchar(255) DEFAULT NULL,
  `regTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=85 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cms_user`
--

LOCK TABLES `cms_user` WRITE;
/*!40000 ALTER TABLE `cms_user` DISABLE KEYS */;
INSERT INTO `cms_user` VALUES (7,'sang','江南一点雨','202cb962ac59075b964b07152d234b70',1,'sang123@qq.com','https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1514093920321&di=913e88c23f382933ef430024afd9128a&imgtype=0&src=http%3A%2F%2Fp.3761.com%2Fpic%2F9771429316733.jpg','2017-12-21 13:30:29'),(52,'yangff','yff','wodemiam',0,'2147@qq.com',NULL,NULL),(76,'xuge','geer','xugedemima',0,'1234@qq.com',NULL,NULL),(77,'111','11','',0,'111',NULL,NULL),(78,'111','11','',0,'111',NULL,NULL),(79,'111','11','',0,'111',NULL,NULL),(80,'111','11','',0,'111',NULL,NULL),(82,'111','11','',0,'111',NULL,NULL),(83,'111','11','',0,'111',NULL,NULL),(84,'111','11','111',0,'111',NULL,NULL);
/*!40000 ALTER TABLE `cms_user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-09-26 15:20:45
