/*
Navicat MySQL Data Transfer

Source Server         : self
Source Server Version : 80013
Source Host           : localhost:3306
Source Database       : planservice

Target Server Type    : MYSQL
Target Server Version : 80013
File Encoding         : 65001

Date: 2019-04-17 18:49:50
*/

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `abbr` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `description` varchar(50) NOT NULL,
  `groupId` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for brand
-- ----------------------------
DROP TABLE IF EXISTS `brand`;
CREATE TABLE `brand` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `abbr` varchar(10) NOT NULL,
  `description` varchar(50) NOT NULL,
  `customerId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `customerId` (`customerId`),
  CONSTRAINT `brand_ibfk_1` FOREIGN KEY (`customerId`) REFERENCES `customer` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for clothinglevel
-- ----------------------------
DROP TABLE IF EXISTS `clothinglevel`;
CREATE TABLE `clothinglevel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `number` varchar(20) NOT NULL,
  `name` varchar(20) NOT NULL,
  `description` varchar(50) NOT NULL,
  `departmentId` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for range
-- ----------------------------
DROP TABLE IF EXISTS `range`;
CREATE TABLE `range` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `number` varchar(20) NOT NULL,
  `name` varchar(20) NOT NULL,
  `customerId` int(11) NOT NULL,
  `brandId` int(11) NOT NULL,
  `clothingLevelId` int(11) NOT NULL,
  `styleQuantity` int(11) DEFAULT '0',
  `addingMode` tinyint(4) NOT NULL,
  `state` tinyint(4) NOT NULL DEFAULT '1' COMMENT '1代表未绑定，2代表绑定',
  `createTime` datetime NOT NULL,
  `note` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `havePlan` bit(1) NOT NULL DEFAULT b'0' COMMENT '0为false，1为true',
  `isCompleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '0为false，1为true',
  PRIMARY KEY (`id`),
  KEY `customerId` (`customerId`),
  KEY `brandId` (`brandId`),
  KEY `clothingTypeId` (`clothingLevelId`),
  CONSTRAINT `range_ibfk_1` FOREIGN KEY (`customerId`) REFERENCES `customer` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `range_ibfk_2` FOREIGN KEY (`brandId`) REFERENCES `brand` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `range_ibfk_3` FOREIGN KEY (`clothingLevelId`) REFERENCES `clothinglevel` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for stylegroup
-- ----------------------------
DROP TABLE IF EXISTS `stylegroup`;
CREATE TABLE `stylegroup` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `number` varchar(20) NOT NULL,
  `name` varchar(20) NOT NULL,
  `rangeId` int(11) NOT NULL,
  `state` tinyint(4) NOT NULL DEFAULT '1' COMMENT '1为未绑定，2为绑定',
  `createTime` datetime NOT NULL,
  `havePlan` bit(1) NOT NULL DEFAULT b'0' COMMENT '0为false，1为true',
  PRIMARY KEY (`id`),
  KEY `rangeId` (`rangeId`),
  CONSTRAINT `stylegroup_ibfk_1` FOREIGN KEY (`rangeId`) REFERENCES `range` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for style
-- ----------------------------
DROP TABLE IF EXISTS `style`;
CREATE TABLE `style` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `number` varchar(20) NOT NULL,
  `rangeId` int(11) NOT NULL,
  `styleGroupId` int(11) DEFAULT NULL,
  `styleGroupNumber` varchar(20) DEFAULT '',
  `styleGroupName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '',
  `addingMode` tinyint(4) NOT NULL,
  `state` tinyint(4) NOT NULL DEFAULT '1' COMMENT '1为未绑定，2未绑定',
  `createTime` datetime NOT NULL,
  `havePlan` bit(1) NOT NULL DEFAULT b'0' COMMENT '0为false，1为true',
  PRIMARY KEY (`id`),
  KEY `rangeId` (`rangeId`),
  CONSTRAINT `style_ibfk_1` FOREIGN KEY (`rangeId`) REFERENCES `range` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- -- ----------------------------
-- -- Records of customer
-- -- ----------------------------
INSERT INTO `customer` VALUES (1,"江苏A客户","A客户","钻石VIP",88801);
INSERT INTO `customer` VALUES (2,"浙江B客户","B客户","黄金VIP",88802);
INSERT INTO `customer` VALUES (3,"上海C客户","C客户","普通VIP",88803);

-- -- ----------------------------
-- -- Records of brand
-- -- ----------------------------
INSERT INTO `brand` VALUES(1,"AAA品牌","AAA","服装AAA品牌",1);
INSERT INTO `brand` VALUES(2,"BBB品牌","BBB","服装BBB品牌",1);
INSERT INTO `brand` VALUES(3,"CCC品牌","CCC","服装CCC品牌",2);
INSERT INTO `brand` VALUES(4,"DDD品牌","DDD","服装DDD品牌",3);

-- -- ----------------------------
-- -- Records of clothinglevel
-- -- ----------------------------
INSERT INTO `clothinglevel` VALUES(1,"时装","时装层次");
INSERT INTO `clothinglevel` VALUES(2,"精品","精品层次");
INSERT INTO `clothinglevel` VALUES(3,"品牌","品牌层次");

-- ----------------------------
-- -- Records of product
-- -- ----------------------------
INSERT INTO `product`  VALUES(1,"p01","面料","面料产品",1);
INSERT INTO `product`  VALUES(2,"p02","工艺单","工艺单产品",2);
INSERT INTO `product`  VALUES(3,"p03","样板","样板产品",3);

