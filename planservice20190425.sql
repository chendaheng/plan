/*
Navicat MySQL Data Transfer

Source Server         : self
Source Server Version : 80013
Source Host           : localhost:3306
Source Database       : planservice

Target Server Type    : MYSQL
Target Server Version : 80013
File Encoding         : 65001

Date: 2019-04-24 22:46:41
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for brand
-- ----------------------------
DROP TABLE IF EXISTS `brand`;
CREATE TABLE `brand` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `abbr` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `customerId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `customerId` (`customerId`),
  CONSTRAINT `brand_ibfk_1` FOREIGN KEY (`customerId`) REFERENCES `customer` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of brand
-- ----------------------------
INSERT INTO `brand` VALUES ('1', 'AAA品牌', 'AAA', '服装AAA品牌', '1');
INSERT INTO `brand` VALUES ('2', 'BBB品牌', 'BBB', '服装BBB品牌', '1');
INSERT INTO `brand` VALUES ('3', 'CCC品牌', 'CCC', '服装CCC品牌', '2');
INSERT INTO `brand` VALUES ('4', 'DDD品牌', 'DDD', '服装DDD品牌', '3');

-- ----------------------------
-- Table structure for categoryproperty
-- ----------------------------
DROP TABLE IF EXISTS `categoryproperty`;
CREATE TABLE `categoryproperty` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `categoryId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `categoryId` (`categoryId`),
  CONSTRAINT `categoryproperty_ibfk_1` FOREIGN KEY (`categoryId`) REFERENCES `dictionarycategory` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of categoryproperty
-- ----------------------------
INSERT INTO `categoryproperty` VALUES ('1', '男人', 'man', '1');
INSERT INTO `categoryproperty` VALUES ('2', '女人', 'women', '1');
INSERT INTO `categoryproperty` VALUES ('3', '阴阳人', 'inflame', '1');

-- ----------------------------
-- Table structure for clothinglevel
-- ----------------------------
DROP TABLE IF EXISTS `clothinglevel`;
CREATE TABLE `clothinglevel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of clothinglevel
-- ----------------------------
INSERT INTO `clothinglevel` VALUES ('1', '品牌', '品牌层次');
INSERT INTO `clothinglevel` VALUES ('2', '时装', '时装层次');
INSERT INTO `clothinglevel` VALUES ('3', '精品', '精品层次');

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `abbr` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `groupId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES ('1', '江苏A客户', 'A客户', '钻石VIP', '1');
INSERT INTO `customer` VALUES ('2', '浙江B客户', 'B客户', '黄金VIP', '2');
INSERT INTO `customer` VALUES ('3', '上海C客户', 'C客户', '普通VIP', '3');

-- ----------------------------
-- Table structure for dictionarycategory
-- ----------------------------
DROP TABLE IF EXISTS `dictionarycategory`;
CREATE TABLE `dictionarycategory` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `category` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `category` (`category`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dictionarycategory
-- ----------------------------
INSERT INTO `dictionarycategory` VALUES ('1', '性别', 'SEX');
INSERT INTO `dictionarycategory` VALUES ('2', '项目类型', 'projectType');

-- ----------------------------
-- Table structure for exception
-- ----------------------------
DROP TABLE IF EXISTS `exception`;
CREATE TABLE `exception` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `number` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `planId` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  `reason` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `createTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `planId` (`planId`),
  CONSTRAINT `exception_ibfk_1` FOREIGN KEY (`planId`) REFERENCES `plan` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of exception
-- ----------------------------

-- ----------------------------
-- Table structure for plan
-- ----------------------------
DROP TABLE IF EXISTS `plan`;
CREATE TABLE `plan` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `number` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `rangeId` int(11) NOT NULL,
  `type` tinyint(4) NOT NULL COMMENT '1代表预测计划，2代表系列计划，3代表款式组计划，4代表款式计划',
  `level` int(11) NOT NULL COMMENT 'level为1表示根计划，其子计划level为2，依次递增',
  `parentLevel` int(11) NOT NULL COMMENT '根计划的parentLevel为0',
  `planObjectId` int(11) NOT NULL,
  `projectType` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '属性值来自数据字典',
  `order` tinyint(11) NOT NULL DEFAULT '0',
  `quantity` int(11) NOT NULL,
  `productId` int(11) NOT NULL,
  `productDate` date NOT NULL,
  `porductDateType` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '属性值来自数据字典',
  `startDate` date NOT NULL,
  `endDate` date NOT NULL,
  `proposal` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `state` tinyint(4) NOT NULL COMMENT '1为已制定，2为已提交，3为被驳回，4为已审核，5为已下发，6为已删除',
  `createrId` int(11) NOT NULL,
  `createrName` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `createTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `rejectReason` varchar(255) DEFAULT NULL,
  `deleteTime` datetime DEFAULT NULL COMMENT '额外属性',
  `haveException` bit(1) NOT NULL DEFAULT b'0' COMMENT '0为false，1为true',
  `note` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '',
  PRIMARY KEY (`id`),
  KEY `rangeId` (`rangeId`),
  KEY `plan_ibfk_2` (`productId`),
  CONSTRAINT `plan_ibfk_1` FOREIGN KEY (`rangeId`) REFERENCES `range` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `plan_ibfk_2` FOREIGN KEY (`productId`) REFERENCES `product` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of plan
-- ----------------------------

-- ----------------------------
-- Table structure for plantemplate
-- ----------------------------
DROP TABLE IF EXISTS `plantemplate`;
CREATE TABLE `plantemplate` (
  `id` int(11) DEFAULT NULL,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `planName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `parentId` int(11) DEFAULT NULL,
  `customerId` int(11) DEFAULT NULL,
  `brandId` int(11) DEFAULT NULL,
  `createrId` int(11) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `isPublic` bit(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of plantemplate
-- ----------------------------

-- ----------------------------
-- Table structure for plan_user
-- ----------------------------
DROP TABLE IF EXISTS `plan_user`;
CREATE TABLE `plan_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `planId` int(11) NOT NULL,
  `executerId` int(11) NOT NULL COMMENT '计划被下发人员的id',
  PRIMARY KEY (`id`),
  KEY `planId` (`planId`),
  CONSTRAINT `plan_user_ibfk_1` FOREIGN KEY (`planId`) REFERENCES `plan` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of plan_user
-- ----------------------------

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `number` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `departmentId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `number` (`number`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('1', 'p02', '工艺单', '工艺单产品', '2');
INSERT INTO `product` VALUES ('2', 'p03', '样板', '样板产品', '3');
INSERT INTO `product` VALUES ('3', 'p01', '面料', '面料产品', '1');

-- ----------------------------
-- Table structure for range
-- ----------------------------
DROP TABLE IF EXISTS `range`;
CREATE TABLE `range` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `number` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `brandId` int(11) NOT NULL,
  `clothingLevelId` int(11) NOT NULL,
  `styleQuantity` int(11) NOT NULL DEFAULT '0',
  `addingMode` tinyint(4) NOT NULL COMMENT '1代表手动，2代表绑定',
  `state` tinyint(4) NOT NULL DEFAULT '1' COMMENT '1代表未绑定，2代表绑定',
  `createrId` int(11) NOT NULL,
  `createrName` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `createTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `note` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '',
  `havePredictPlan` bit(1) NOT NULL DEFAULT b'0' COMMENT '0为false，1为true',
  `havePlan` bit(1) NOT NULL DEFAULT b'0' COMMENT '0为false，1为true',
  `isCompleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '0为false，1为true',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`),
  KEY `range_ibfk_1` (`brandId`),
  KEY `clothingLevelId` (`clothingLevelId`),
  CONSTRAINT `range_ibfk_1` FOREIGN KEY (`brandId`) REFERENCES `brand` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `range_ibfk_2` FOREIGN KEY (`clothingLevelId`) REFERENCES `clothinglevel` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of range
-- ----------------------------
INSERT INTO `range` VALUES ('1', 'XL20190101001', 'Fall-2019(07/08/09)', '1', '1', '10', '1', '2', '3', '张三', '2019-04-21 23:03:09', '系列备注1', '\0', '\0', '\0');
INSERT INTO `range` VALUES ('2', 'XL20190101002', 'Spring-2019(01/02/03)', '2', '2', '5', '1', '2', '3', '张三', '2019-04-21 23:04:20', '系列备注2', '\0', '\0', '\0');
INSERT INTO `range` VALUES ('3', 'XL20190501003', 'Winter-2019(10/11/12)', '3', '3', '5', '1', '2', '3', '张三', '2019-04-21 23:04:50', '系列备注3', '\0', '\0', '\0');
INSERT INTO `range` VALUES ('4', 'XL20190501004', 'Summer-2019(08/09/10)', '4', '1', '2', '1', '1', '3', '张三', '2019-04-21 23:05:28', '系列备注4', '\0', '\0', '\0');

-- ----------------------------
-- Table structure for style
-- ----------------------------
DROP TABLE IF EXISTS `style`;
CREATE TABLE `style` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `number` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `rangeId` int(11) NOT NULL,
  `styleGroupId` int(11) DEFAULT NULL,
  `styleGroupNumber` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '',
  `styleGroupName` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '',
  `addingMode` tinyint(4) NOT NULL COMMENT '1为手动，2为导入',
  `state` tinyint(4) NOT NULL DEFAULT '1' COMMENT '1为未绑定，2为绑定',
  `createrId` int(11) NOT NULL,
  `createrName` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `createTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `havePlan` bit(1) NOT NULL DEFAULT b'0' COMMENT '0为false，1为true',
  PRIMARY KEY (`id`),
  KEY `rangeId` (`rangeId`),
  CONSTRAINT `style_ibfk_1` FOREIGN KEY (`rangeId`) REFERENCES `range` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of style
-- ----------------------------
INSERT INTO `style` VALUES ('1', '10190114(CX1901)', '1', '1', 'KSZ20190101001', '款式1组', '1', '2', '3', '张三', '2018-08-20 12:00:00', '\0');
INSERT INTO `style` VALUES ('2', '10190114(CX1902)', '1', '1', 'KSZ20190101001', '款式1组', '1', '2', '3', '张三', '2018-08-21 12:00:00', '\0');
INSERT INTO `style` VALUES ('3', '10190114(CX1903)', '1', '1', 'KSZ20190101001', '款式1组', '1', '2', '3', '张三', '2018-08-23 12:00:00', '\0');
INSERT INTO `style` VALUES ('4', '10190114(CX1904)', '1', '2', 'KSZ20190101002', '款式2组', '1', '2', '3', '张三', '2018-08-24 12:00:00', '\0');
INSERT INTO `style` VALUES ('5', '10190114(CX1905)', '1', '2', 'KSZ20190101002', '款式2组', '1', '2', '3', '张三', '2018-08-25 12:00:00', '\0');
INSERT INTO `style` VALUES ('6', '10190114(CX1906)', '2', '3', 'KSZ20190101003', '款式3组', '1', '2', '3', '张三', '2018-08-26 12:00:00', '\0');
INSERT INTO `style` VALUES ('7', '10190114(CX1907)', '2', '3', 'KSZ20190101003', '款式3组', '1', '2', '3', '张三', '2018-08-27 12:00:00', '\0');
INSERT INTO `style` VALUES ('8', '10190114(CX1908)', '3', '4', 'KSZ20190101004', '款式4组', '1', '2', '3', '张三', '2018-08-28 12:00:00', '\0');

-- ----------------------------
-- Table structure for stylegroup
-- ----------------------------
DROP TABLE IF EXISTS `stylegroup`;
CREATE TABLE `stylegroup` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `number` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `rangeId` int(11) NOT NULL,
  `state` tinyint(4) NOT NULL DEFAULT '1' COMMENT '1为未绑定，2为绑定',
  `createrId` int(11) NOT NULL,
  `createrName` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `createTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `havePlan` bit(1) NOT NULL DEFAULT b'0' COMMENT '0为false，1为true',
  PRIMARY KEY (`id`),
  KEY `rangeId` (`rangeId`),
  CONSTRAINT `stylegroup_ibfk_1` FOREIGN KEY (`rangeId`) REFERENCES `range` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of stylegroup
-- ----------------------------
INSERT INTO `stylegroup` VALUES ('1', 'KSZ20190101001', '款式1组', '1', '2', '3', '张三', '2018-07-20 12:00:00', '\0');
INSERT INTO `stylegroup` VALUES ('2', 'KSZ20190101002', '款式2组', '1', '2', '3', '张三', '2018-07-22 12:00:00', '\0');
INSERT INTO `stylegroup` VALUES ('3', 'KSZ20190101003', '款式3组', '2', '2', '3', '张三', '2018-07-24 12:00:01', '\0');
INSERT INTO `stylegroup` VALUES ('4', 'KSZ20190101004', '款式4组', '3', '2', '3', '张三', '2018-07-26 12:00:01', '\0');

-- ----------------------------
-- Table structure for user_brand
-- ----------------------------
DROP TABLE IF EXISTS `user_brand`;
CREATE TABLE `user_brand` (
  `userId` int(11) NOT NULL,
  `brandId` int(11) NOT NULL,
  PRIMARY KEY (`userId`,`brandId`),
  KEY `brandId` (`brandId`),
  CONSTRAINT `user_brand_ibfk_1` FOREIGN KEY (`brandId`) REFERENCES `brand` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_brand
-- ----------------------------

-- ----------------------------
-- Table structure for user_customer
-- ----------------------------
DROP TABLE IF EXISTS `user_customer`;
CREATE TABLE `user_customer` (
  `userId` int(11) NOT NULL,
  `customerId` int(11) NOT NULL,
  PRIMARY KEY (`userId`,`customerId`),
  KEY `customerId` (`customerId`),
  CONSTRAINT `user_customer_ibfk_1` FOREIGN KEY (`customerId`) REFERENCES `customer` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_customer
-- ----------------------------

-- ----------------------------
-- Table structure for user_customer_brand
-- ----------------------------
DROP TABLE IF EXISTS `user_customer_brand`;
CREATE TABLE `user_customer_brand` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `customerId` int(11) NOT NULL,
  `brandId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `customerId` (`customerId`),
  KEY `brandId` (`brandId`),
  CONSTRAINT `user_customer_brand_ibfk_1` FOREIGN KEY (`customerId`) REFERENCES `customer` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `user_customer_brand_ibfk_2` FOREIGN KEY (`brandId`) REFERENCES `brand` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_customer_brand
-- ----------------------------
SET FOREIGN_KEY_CHECKS=1;
