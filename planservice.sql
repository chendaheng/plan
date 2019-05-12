/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50719
Source Host           : localhost:3306
Source Database       : zhuriplan

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2019-05-12 11:37:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for brand
-- ----------------------------
DROP TABLE IF EXISTS `brand`;
CREATE TABLE `brand` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `abbr` varchar(20) NOT NULL,
  `description` varchar(255) NOT NULL,
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
  `name` varchar(100) NOT NULL,
  `code` varchar(50) NOT NULL,
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
  `name` varchar(100) NOT NULL,
  `description` varchar(255) NOT NULL,
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
  `name` varchar(100) NOT NULL,
  `abbr` varchar(50) NOT NULL,
  `description` varchar(255) NOT NULL,
  `groupName` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES ('1', '江苏A客户', 'A客户', '钻石VIP', '客户服务部');
INSERT INTO `customer` VALUES ('2', '浙江B客户', 'B客户', '黄金VIP', '客户服务部');
INSERT INTO `customer` VALUES ('3', '上海C客户', 'C客户', '普通VIP', '客户服务部');
INSERT INTO `customer` VALUES ('4', '零一', '01', 'what', '财务审计部');
INSERT INTO `customer` VALUES ('5', '一零', '10', 'the', '规划发展部');
INSERT INTO `customer` VALUES ('6', '一一', '11', 'fuck', '设计管理部');

-- ----------------------------
-- Table structure for dictionarycategory
-- ----------------------------
DROP TABLE IF EXISTS `dictionarycategory`;
CREATE TABLE `dictionarycategory` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `category` varchar(100) NOT NULL,
  `code` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `category` (`category`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dictionarycategory
-- ----------------------------
INSERT INTO `dictionarycategory` VALUES ('1', '性别', 'SEX');
INSERT INTO `dictionarycategory` VALUES ('2', '项目类型', 'projectType');

-- ----------------------------
-- Table structure for plan
-- ----------------------------
DROP TABLE IF EXISTS `plan`;
CREATE TABLE `plan` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `number` varchar(50) NOT NULL,
  `name` varchar(100) NOT NULL,
  `rangeId` int(11) NOT NULL,
  `type` tinyint(4) NOT NULL COMMENT '1代表预测计划，2代表系列计划，3代表款式组计划，4代表款式计划',
  `isRoot` bit(1) NOT NULL,
  `parentId` int(11) NOT NULL,
  `planObjectId` int(11) NOT NULL,
  `projectType` varchar(100) NOT NULL COMMENT '属性值来自数据字典',
  `order` tinyint(11) NOT NULL DEFAULT '0',
  `quantity` int(11) NOT NULL,
  `productId` int(11) NOT NULL,
  `productDate` date NOT NULL,
  `productDateType` varchar(100) NOT NULL COMMENT '属性值来自数据字典',
  `startDate` date NOT NULL,
  `endDate` date NOT NULL,
  `proposal` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `state` tinyint(4) NOT NULL COMMENT '1为已制定，2为已提交，3为被驳回，4为已审核，5为已下发，6为已删除',
  `createrName` varchar(100) NOT NULL,
  `deptName` varchar(100) NOT NULL,
  `createTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `rejectReason` varchar(255) DEFAULT NULL,
  `deleterName` varchar(100) DEFAULT NULL,
  `deleteTime` datetime DEFAULT NULL COMMENT '额外属性',
  `haveException` bit(1) NOT NULL DEFAULT b'0' COMMENT '0为false，1为true',
  `note` varchar(255) DEFAULT '',
  PRIMARY KEY (`id`),
  KEY `rangeId` (`rangeId`),
  KEY `plan_ibfk_2` (`productId`),
  CONSTRAINT `plan_ibfk_1` FOREIGN KEY (`rangeId`) REFERENCES `range` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `plan_ibfk_2` FOREIGN KEY (`productId`) REFERENCES `product` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of plan
-- ----------------------------
INSERT INTO `plan` VALUES ('1', 'JX125001', '系列A计划', '1', '2', '', '0', '1', '头样', '0', '20', '1', '2020-04-30', '交货日期', '2019-05-01', '2020-06-10', '爱丽丝的', '啥问你', '5', '张三', '设计管理部', '2019-05-03 15:26:31', null, null, null, '\0', '');

-- ----------------------------
-- Table structure for planexception
-- ----------------------------
DROP TABLE IF EXISTS `planexception`;
CREATE TABLE `planexception` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `number` varchar(20) NOT NULL,
  `planId` int(11) NOT NULL,
  `cause` varchar(255) NOT NULL,
  `userName` varchar(100) NOT NULL,
  `createTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `planId` (`planId`),
  CONSTRAINT `planexception_ibfk_1` FOREIGN KEY (`planId`) REFERENCES `plan` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of planexception
-- ----------------------------

-- ----------------------------
-- Table structure for plantemplate
-- ----------------------------
DROP TABLE IF EXISTS `plantemplate`;
CREATE TABLE `plantemplate` (
  `id` int(11) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `planName` varchar(20) DEFAULT NULL,
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
  `planId` int(11) NOT NULL,
  `executerId` int(11) NOT NULL COMMENT '计划被下发人员的id',
  PRIMARY KEY (`planId`,`executerId`),
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
  `number` varchar(50) NOT NULL,
  `name` varchar(100) NOT NULL,
  `description` varchar(255) NOT NULL,
  `deptName` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `number` (`number`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('1', 'p02', '工艺单', '工艺单产品', '客户服务部');
INSERT INTO `product` VALUES ('2', 'p03', '样板', '样板产品', '客户服务部');
INSERT INTO `product` VALUES ('3', 'p01', '面料', '面料产品', '客户服务部');
INSERT INTO `product` VALUES ('4', 'adsf', '测试', 'just for test', '逐日科技');

-- ----------------------------
-- Table structure for range
-- ----------------------------
DROP TABLE IF EXISTS `range`;
CREATE TABLE `range` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `number` varchar(50) NOT NULL,
  `name` varchar(100) NOT NULL,
  `brandId` int(11) NOT NULL,
  `clothingLevelId` int(11) NOT NULL,
  `styleQuantity` int(11) NOT NULL DEFAULT '0',
  `addingMode` tinyint(4) NOT NULL COMMENT '1代表手动，2代表绑定',
  `state` tinyint(4) NOT NULL DEFAULT '1' COMMENT '1代表未绑定，2代表绑定',
  `createrId` int(11) NOT NULL,
  `createrName` varchar(100) NOT NULL,
  `deptName` varchar(100) NOT NULL,
  `createTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `note` varchar(255) DEFAULT '',
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
INSERT INTO `range` VALUES ('1', 'XL20190101001', 'Fall-2019(07/08/09)', '1', '2', '10', '1', '2', '3', '张三', '信息管理', '2019-04-21 23:03:09', '系列备注1', '\0', '\0', '\0');
INSERT INTO `range` VALUES ('2', 'XL20190101002', 'Spring-2019(01/02/03)', '2', '2', '5', '1', '2', '3', '张三', '信息管理', '2019-04-21 23:04:20', '系列备注2', '\0', '\0', '\0');
INSERT INTO `range` VALUES ('3', 'XL20190501003', 'Winter-2019(10/11/12)', '3', '3', '5', '1', '2', '3', '张三', '信息管理', '2019-04-21 23:04:50', '系列备注3', '\0', '\0', '\0');
INSERT INTO `range` VALUES ('4', 'XL20190501004', 'Summer-2019(08/09/10)', '4', '1', '2', '1', '1', '3', '张三', '信息管理', '2019-04-21 23:05:28', '系列备注4', '\0', '\0', '\0');

-- ----------------------------
-- Table structure for style
-- ----------------------------
DROP TABLE IF EXISTS `style`;
CREATE TABLE `style` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `number` varchar(50) NOT NULL,
  `rangeId` int(11) NOT NULL,
  `styleGroupId` int(11) DEFAULT NULL,
  `styleGroupNumber` varchar(50) DEFAULT '',
  `styleGroupName` varchar(100) DEFAULT '',
  `addingMode` tinyint(4) NOT NULL COMMENT '1为手动，2为导入',
  `state` tinyint(4) NOT NULL DEFAULT '1' COMMENT '1为未绑定，2为绑定',
  `createrId` int(11) NOT NULL,
  `createrName` varchar(100) NOT NULL,
  `deptName` varchar(100) NOT NULL,
  `createTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `havePlan` bit(1) NOT NULL DEFAULT b'0' COMMENT '0为false，1为true',
  PRIMARY KEY (`id`),
  KEY `rangeId` (`rangeId`),
  CONSTRAINT `style_ibfk_1` FOREIGN KEY (`rangeId`) REFERENCES `range` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of style
-- ----------------------------
INSERT INTO `style` VALUES ('1', '10190114(CX1901)', '1', '1', 'KSZ20190101001', '款式1组', '1', '2', '3', '张三', '信息管理', '2019-05-03 15:02:54', '');
INSERT INTO `style` VALUES ('2', '10190114(CX1902)', '1', '1', 'KSZ20190101001', '款式1组', '1', '2', '3', '张三', '信息管理', '2018-08-21 12:00:00', '\0');
INSERT INTO `style` VALUES ('3', '10190114(CX1903)', '1', '1', 'KSZ20190101001', '款式1组', '1', '2', '3', '张三', '信息管理', '2018-08-23 12:00:00', '\0');
INSERT INTO `style` VALUES ('4', '10190114(CX1904)', '1', '2', 'KSZ20190101002', '款式2组', '1', '2', '3', '张三', '信息管理', '2018-08-24 12:00:00', '\0');
INSERT INTO `style` VALUES ('5', '10190114(CX1905)', '1', '2', 'KSZ20190101002', '款式2组', '1', '2', '3', '张三', '信息管理', '2018-08-25 12:00:00', '\0');
INSERT INTO `style` VALUES ('6', '10190114(CX1906)', '2', '3', 'KSZ20190101003', '款式3组', '1', '2', '3', '张三', '信息管理', '2018-08-26 12:00:00', '\0');
INSERT INTO `style` VALUES ('7', '10190114(CX1907)', '2', '3', 'KSZ20190101003', '款式3组', '1', '2', '3', '张三', '信息管理', '2018-08-27 12:00:00', '\0');
INSERT INTO `style` VALUES ('8', '10190114(CX1908)', '3', '4', 'KSZ20190101004', '款式4组', '1', '2', '3', '张三', '信息管理', '2018-08-28 12:00:00', '\0');

-- ----------------------------
-- Table structure for stylegroup
-- ----------------------------
DROP TABLE IF EXISTS `stylegroup`;
CREATE TABLE `stylegroup` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `number` varchar(50) NOT NULL,
  `name` varchar(100) NOT NULL,
  `rangeId` int(11) NOT NULL,
  `state` tinyint(4) NOT NULL DEFAULT '1' COMMENT '1为未绑定，2为绑定',
  `createrId` int(11) NOT NULL,
  `createrName` varchar(100) NOT NULL,
  `deptName` varchar(100) NOT NULL,
  `createTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `havePlan` bit(1) NOT NULL DEFAULT b'0' COMMENT '0为false，1为true',
  PRIMARY KEY (`id`),
  KEY `rangeId` (`rangeId`),
  CONSTRAINT `stylegroup_ibfk_1` FOREIGN KEY (`rangeId`) REFERENCES `range` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of stylegroup
-- ----------------------------
INSERT INTO `stylegroup` VALUES ('1', 'KSZ20190101001', '款式1组', '1', '2', '3', '张三', '信息管理', '2018-07-20 12:00:00', '\0');
INSERT INTO `stylegroup` VALUES ('2', 'KSZ20190101002', '款式2组', '1', '2', '3', '张三', '信息管理', '2018-07-22 12:00:00', '\0');
INSERT INTO `stylegroup` VALUES ('3', 'KSZ20190101003', '款式3组', '2', '2', '3', '张三', '信息管理', '2018-07-24 12:00:01', '\0');
INSERT INTO `stylegroup` VALUES ('4', 'KSZ20190101004', '款式4组', '3', '2', '3', '张三', '信息管理', '2018-07-26 12:00:01', '\0');

-- ----------------------------
-- Table structure for test
-- ----------------------------
DROP TABLE IF EXISTS `test`;
CREATE TABLE `test` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `createTime` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of test
-- ----------------------------
INSERT INTO `test` VALUES ('1', '2019-06-12');
INSERT INTO `test` VALUES ('5', '2019-05-12');

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
  `userName` varchar(100) NOT NULL,
  `customerId` int(11) NOT NULL,
  `brandId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `customerId` (`customerId`),
  KEY `brandId` (`brandId`),
  CONSTRAINT `user_customer_brand_ibfk_1` FOREIGN KEY (`customerId`) REFERENCES `customer` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `user_customer_brand_ibfk_2` FOREIGN KEY (`brandId`) REFERENCES `brand` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_customer_brand
-- ----------------------------
INSERT INTO `user_customer_brand` VALUES ('1', '3', '张三', '1', '1');
INSERT INTO `user_customer_brand` VALUES ('2', '3', '张三', '1', '2');
INSERT INTO `user_customer_brand` VALUES ('3', '4', '李四', '1', '2');
INSERT INTO `user_customer_brand` VALUES ('4', '4', '李四', '2', '3');
INSERT INTO `user_customer_brand` VALUES ('5', '4', '李四', '3', '4');
INSERT INTO `user_customer_brand` VALUES ('6', '3', '张三', '2', '3');
INSERT INTO `user_customer_brand` VALUES ('7', '3', '张三', '3', '4');
INSERT INTO `user_customer_brand` VALUES ('8', '5', '王五', '1', '1');

-- ----------------------------
-- View structure for planexceptionsearch
-- ----------------------------
DROP VIEW IF EXISTS `planexceptionsearch`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `planexceptionsearch` AS select `planexception`.`id` AS `id`,`planexception`.`number` AS `number`,`planexception`.`planId` AS `planId`,`plan`.`number` AS `planNumber`,`plan`.`name` AS `planName`,`customer`.`name` AS `customerName`,`brand`.`name` AS `brandName`,`range`.`name` AS `rangeName`,`planexception`.`cause` AS `cause`,`planexception`.`userName` AS `userName`,`planexception`.`createTime` AS `createTime`,`user_customer_brand`.`userId` AS `userId`,`plan`.`planObjectId` AS `planObjectId`,`plan`.`type` AS `type` from (((((`planexception` join `plan` on((`planexception`.`planId` = `plan`.`id`))) join `range` on((`plan`.`rangeId` = `range`.`id`))) join `brand` on((`range`.`brandId` = `brand`.`id`))) join `customer` on((`brand`.`customerId` = `customer`.`id`))) join `user_customer_brand` on(((`user_customer_brand`.`customerId` = `customer`.`id`) and (`user_customer_brand`.`brandId` = `brand`.`id`)))) ;

-- ----------------------------
-- View structure for plansearch
-- ----------------------------
DROP VIEW IF EXISTS `plansearch`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `plansearch` AS select `plan`.`id` AS `id`,`plan`.`number` AS `number`,`plan`.`name` AS `name`,`plan`.`rangeId` AS `rangeId`,`plan`.`type` AS `type`,`plan`.`isRoot` AS `isRoot`,`plan`.`parentId` AS `parentId`,`plan`.`planObjectId` AS `planObjectId`,`plan`.`projectType` AS `projectType`,`plan`.`quantity` AS `quantity`,`plan`.`productId` AS `productId`,`plan`.`productDate` AS `productDate`,`plan`.`productDateType` AS `productDateType`,`plan`.`startDate` AS `startDate`,`plan`.`endDate` AS `endDate`,`plan`.`proposal` AS `proposal`,`plan`.`description` AS `description`,`plan`.`state` AS `state`,`plan`.`createrName` AS `createrName`,`plan`.`deptName` AS `deptName`,`plan`.`createTime` AS `createTime`,`plan`.`rejectReason` AS `rejectReason`,`plan`.`deleterName` AS `deleterName`,`plan`.`deleteTime` AS `deleteTime`,`plan`.`haveException` AS `haveException`,`plan`.`note` AS `note`,`range`.`number` AS `rangeNumber`,`range`.`name` AS `rangeName`,`brand`.`id` AS `brandId`,`brand`.`name` AS `brandName`,`customer`.`id` AS `customerId`,`customer`.`name` AS `customerName`,`range`.`isCompleted` AS `isCompleted`,`user_customer_brand`.`userId` AS `userId`,`clothinglevel`.`id` AS `clothingLevelId`,`clothinglevel`.`name` AS `clothingLevelName` from (((((`plan` join `range` on((`plan`.`rangeId` = `range`.`id`))) join `brand` on((`range`.`brandId` = `brand`.`id`))) join `customer` on((`brand`.`customerId` = `customer`.`id`))) join `user_customer_brand` on(((`user_customer_brand`.`customerId` = `customer`.`id`) and (`user_customer_brand`.`brandId` = `brand`.`id`)))) join `clothinglevel` on((`range`.`clothingLevelId` = `clothinglevel`.`id`))) ;

-- ----------------------------
-- View structure for rangesearch
-- ----------------------------
DROP VIEW IF EXISTS `rangesearch`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `rangesearch` AS select `range`.`id` AS `id`,`range`.`number` AS `number`,`range`.`name` AS `name`,`range`.`brandId` AS `brandId`,`range`.`clothingLevelId` AS `clothingLevelId`,`range`.`styleQuantity` AS `styleQuantity`,`range`.`addingMode` AS `addingMode`,`range`.`state` AS `state`,`range`.`createrId` AS `createrId`,`range`.`createrName` AS `createrName`,`range`.`createTime` AS `createTime`,`range`.`note` AS `note`,`range`.`havePredictPlan` AS `havePredictPlan`,`range`.`havePlan` AS `havePlan`,`range`.`isCompleted` AS `isCompleted`,`brand`.`name` AS `brandName`,`customer`.`name` AS `customerName`,`clothinglevel`.`name` AS `clothinglevelName`,`user_customer_brand`.`userId` AS `userId`,`brand`.`customerId` AS `customerId` from ((((`range` join `brand` on((`range`.`brandId` = `brand`.`id`))) join `customer` on((`brand`.`customerId` = `customer`.`id`))) join `clothinglevel` on((`range`.`clothingLevelId` = `clothinglevel`.`id`))) join `user_customer_brand` on(((`user_customer_brand`.`customerId` = `customer`.`id`) and (`user_customer_brand`.`brandId` = `brand`.`id`)))) ;

-- ----------------------------
-- View structure for stylegroupsearch
-- ----------------------------
DROP VIEW IF EXISTS `stylegroupsearch`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `stylegroupsearch` AS select `stylegroup`.`id` AS `id`,`stylegroup`.`number` AS `number`,`stylegroup`.`name` AS `name`,`stylegroup`.`rangeId` AS `rangeId`,`stylegroup`.`state` AS `state`,`stylegroup`.`createrId` AS `createrId`,`stylegroup`.`createrName` AS `createrName`,`stylegroup`.`deptName` AS `deptName`,`stylegroup`.`createTime` AS `createTime`,`stylegroup`.`havePlan` AS `havaPlan`,`range`.`number` AS `rangeNumber`,`range`.`name` AS `rangeName`,`brand`.`id` AS `brandId`,`brand`.`name` AS `brandName`,`customer`.`id` AS `customerId`,`customer`.`name` AS `customerName`,`clothinglevel`.`id` AS `clothingLevelId`,`clothinglevel`.`name` AS `clothingLevelName`,`user_customer_brand`.`userId` AS `userId` from (((((`stylegroup` join `range` on((`stylegroup`.`rangeId` = `range`.`id`))) join `brand` on((`range`.`brandId` = `brand`.`id`))) join `customer` on((`brand`.`customerId` = `customer`.`id`))) join `clothinglevel` on((`range`.`clothingLevelId` = `clothinglevel`.`id`))) join `user_customer_brand` on(((`user_customer_brand`.`customerId` = `customer`.`id`) and (`user_customer_brand`.`brandId` = `brand`.`id`)))) ;

-- ----------------------------
-- View structure for stylesearch
-- ----------------------------
DROP VIEW IF EXISTS `stylesearch`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `stylesearch` AS select `style`.`id` AS `id`,`style`.`number` AS `number`,`style`.`rangeId` AS `rangeId`,`style`.`styleGroupId` AS `styleGroupId`,`style`.`styleGroupNumber` AS `styleGroupNumber`,`style`.`styleGroupName` AS `styleGroupName`,`style`.`addingMode` AS `addingMode`,`style`.`state` AS `state`,`style`.`createrId` AS `createrId`,`style`.`createrName` AS `createrName`,`style`.`deptName` AS `deptName`,`style`.`createTime` AS `createTime`,`style`.`havePlan` AS `havePlan`,`range`.`number` AS `rangeNumber`,`range`.`name` AS `rangeName`,`brand`.`name` AS `brandName`,`brand`.`id` AS `brandId`,`customer`.`id` AS `customerId`,`customer`.`name` AS `customerName`,`clothinglevel`.`id` AS `clothingLevelId`,`clothinglevel`.`name` AS `clothingLevelName`,`user_customer_brand`.`userId` AS `userId` from (((((`style` join `range` on((`style`.`rangeId` = `range`.`id`))) join `brand` on((`range`.`brandId` = `brand`.`id`))) join `customer` on((`brand`.`customerId` = `customer`.`id`))) join `clothinglevel` on((`range`.`clothingLevelId` = `clothinglevel`.`id`))) join `user_customer_brand` on(((`user_customer_brand`.`customerId` = `customer`.`id`) and (`user_customer_brand`.`brandId` = `brand`.`id`)))) ;
