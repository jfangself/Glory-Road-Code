/*
SQLyog 企业版 - MySQL GUI v7.14 
MySQL - 5.5.36 : Database - auction
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`auction` /*!40100 DEFAULT CHARACTER SET gbk */;

USE `auction`;

/*Table structure for table `auction_user` */

DROP TABLE IF EXISTS `auction_user`;

CREATE TABLE `auction_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `userpass` varchar(50) NOT NULL,
  `email` varchar(100) NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=gbk;

/*Data for the table `auction_user` */

insert  into `auction_user`(`user_id`,`username`,`userpass`,`email`) values (1,'tomcat','tomcat','spring_test@163.com'),(2,'mysql','mysql','spring_test@163.com');

/*Table structure for table `bid` */

DROP TABLE IF EXISTS `bid`;

CREATE TABLE `bid` (
  `bid_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `item_id` int(11) NOT NULL,
  `bid_price` double NOT NULL,
  `bid_date` date NOT NULL,
  PRIMARY KEY (`bid_id`),
  UNIQUE KEY `item_id` (`item_id`,`bid_price`),
  KEY `FK17CFD5A919C26` (`item_id`),
  KEY `FK17CFDAB0B5DF1` (`user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=gbk;

/*Data for the table `bid` */

insert  into `bid`(`bid_id`,`user_id`,`item_id`,`bid_price`,`bid_date`) values (1,2,1,250,'2014-09-16'),(2,1,3,25000,'2014-09-12');

/*Table structure for table `item` */

DROP TABLE IF EXISTS `item`;

CREATE TABLE `item` (
  `item_id` int(11) NOT NULL AUTO_INCREMENT,
  `item_name` varchar(255) NOT NULL,
  `item_remark` varchar(255) DEFAULT NULL,
  `item_desc` varchar(255) DEFAULT NULL,
  `kind_id` int(11) NOT NULL,
  `addtime` date NOT NULL,
  `endtime` date NOT NULL,
  `init_price` double NOT NULL,
  `max_price` double NOT NULL,
  `owner_id` int(11) NOT NULL,
  `winer_id` int(11) DEFAULT NULL,
  `state_id` int(11) NOT NULL,
  PRIMARY KEY (`item_id`),
  KEY `FK317B138C5E4E` (`state_id`),
  KEY `FK317B1371643773` (`winer_id`),
  KEY `FK317B13B2144086` (`kind_id`),
  KEY `FK317B1316F20E09` (`owner_id`)
) ENGINE=MyISAM AUTO_INCREMENT=19 DEFAULT CHARSET=gbk;

/*Data for the table `item` */

insert  into `item`(`item_id`,`item_name`,`item_remark`,`item_desc`,`kind_id`,`addtime`,`endtime`,`init_price`,`max_price`,`owner_id`,`winer_id`,`state_id`) values (1,'主板','老式主板','老主板，还可以用',1,'2014-09-13','2014-10-18',230,250,1,2,2),(2,'显卡','老式显卡','老显卡，还可以用',1,'2014-09-09','2014-09-16',210,210,2,NULL,3),(3,'老房子','老式房子','40年的老房子',2,'2014-09-09','2014-09-13',21000,25000,2,1,2);

/*Table structure for table `kind` */

DROP TABLE IF EXISTS `kind`;

CREATE TABLE `kind` (
  `kind_id` int(11) NOT NULL AUTO_INCREMENT,
  `kind_name` varchar(50) NOT NULL,
  `kind_desc` varchar(255) NOT NULL,
  PRIMARY KEY (`kind_id`)
) ENGINE=MyISAM AUTO_INCREMENT=94 DEFAULT CHARSET=gbk;

/*Data for the table `kind` */

insert  into `kind`(`kind_id`,`kind_name`,`kind_desc`) values (1,'电脑硬件','这里并不是很主流的产品，但价格绝对令你心动'),(2,'房产','提供非常稀缺的房源');

/*Table structure for table `state` */

DROP TABLE IF EXISTS `state`;

CREATE TABLE `state` (
  `state_id` int(11) NOT NULL AUTO_INCREMENT,
  `state_name` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`state_id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=gbk;

/*Data for the table `state` */

insert  into `state`(`state_id`,`state_name`) values (1,'拍卖中'),(2,'拍卖成功'),(3,'流拍');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
