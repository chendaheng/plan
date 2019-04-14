
drop table if exists `warehouseStockInPlan`;
create table if not exists `warehouseStockInPlan` (
    `id` int not null AUTO_INCREMENT,
    `planSerialNo` varchar(20) not null,
    `entryType` tinyint(4) not null,
    `vouchSerialNo` varchar(20),
    `vouchType` tinyint(4),
    `deptId` int,
    `onwerId` int,
    `startDate` datetime,
    `arrivalDate` datetime,
    `deliveryId` int,
    `deliveryAddrId` int,
    `warehouseId` int,
    `receivingAddrId` int,
    `operUserId` int,
    `status` int,
    `note` varchar(100),
    primary key (`id`) using BTREE
)engine=InnoDB default charset=utf8;


drop table if exists `warehouseStockInPlanDetail`;
create table if not exists `warehouseStockInPlanDetail` (
    `id` int not null AUTO_INCREMENT,
    `planSerialNo` varchar(20) not null,
    `materialCode` varchar(20) not null,
    `unitId` int not null,
    `planQuantity` int not null,
    `arrivalQuantity` int not null,
    `price` int not null,
    `taxPrice` int not null,
    `status` int not null,
    `note` varchar(100),
    primary key (`id`) using BTREE
)engine=InnoDB default charset=utf8;

-- -- ----------------------------
-- -- Records of warehouseStockInPlan
-- -- ----------------------------

INSERT INTO `warehouseStockInPlan` VALUES (1,'plan001',1,'purchase001',1,99901,9901,'2018-08-20 10:00:00',NULL,66601,666010,3331,33100,3301,0,NULL);
INSERT INTO `warehouseStockInPlan` VALUES (2,'plan002',1,'purchase002',1,99901,9901,'2018-08-21 10:00:00',NULL,66601,666010,3331,33100,3301,0,NULL);
INSERT INTO `warehouseStockInPlan` VALUES (3,'plan003',1,'purchase003',1,99902,9902,'2018-08-22 10:00:00',NULL,66601,666010,3331,33100,3301,0,NULL);
INSERT INTO `warehouseStockInPlan` VALUES (4,'plan004',1,'purchase004',1,99901,9901,'2018-08-23 10:00:00',NULL,66602,666020,3332,33200,3302,0,NULL);
INSERT INTO `warehouseStockInPlan` VALUES (5,'plan005',1,'purchase005',1,99901,9901,'2018-08-24 10:00:00',NULL,66601,666010,3332,33200,3302,0,NULL);
INSERT INTO `warehouseStockInPlan` VALUES (6,'plan006',1,'purchase006',1,99901,9901,'2018-08-25 10:00:00',NULL,66601,666010,3332,33200,3302,0,NULL);
INSERT INTO `warehouseStockInPlan` VALUES (7,'plan007',1,'purchase007',1,99902,9902,'2018-08-26 10:00:00',NULL,66601,666010,3332,33200,3302,0,NULL);
INSERT INTO `warehouseStockInPlan` VALUES (8,'plan008',1,'purchase008',1,99901,9901,'2018-08-27 10:00:00',NULL,66601,666010,3332,33200,3302,0,NULL);
INSERT INTO `warehouseStockInPlan` VALUES (9,'plan009',1,'purchase009',1,99902,9902,'2018-08-28 10:00:00',NULL,66601,666010,3333,33300,3302,0,NULL);
INSERT INTO `warehouseStockInPlan` VALUES (10,'plan010',1,'purchase010',1,99901,9901,'2018-08-29 10:00:00',NULL,66601,666010,3333,33300,3303,0,NULL);
INSERT INTO `warehouseStockInPlan` VALUES (11,'plan011',1,'purchase011',1,99901,9901,'2018-08-30 10:00:00',NULL,66601,666010,3333,33300,3303,0,NULL);
INSERT INTO `warehouseStockInPlan` VALUES (12,'plan012',1,'purchase012',1,99903,9903,'2018-08-31 10:00:00',NULL,66602,666020,3333,33300,3303,0,NULL);
INSERT INTO `warehouseStockInPlan` VALUES (13,'plan013',1,'purchase013',1,99902,9902,'2018-09-01 10:00:00',NULL,66602,666020,3333,33300,3303,0,NULL);
INSERT INTO `warehouseStockInPlan` VALUES (14,'plan014',1,'purchase014',1,99903,9903,'2018-09-02 10:00:00',NULL,66602,666020,3333,33300,3303,0,NULL);

-- -- ----------------------------
-- -- Records of warehouseStockInPlanDetail
-- -- ----------------------------
-- INSERT INTO `warehouseStockInPlanDetail` VALUES (1,'plan001','m00010',1,200,0,20,25,0,NULL);
-- INSERT INTO `warehouseStockInPlanDetail` VALUES (2,'plan002','m00020',1,300,0,25,28,0,NULL);
-- INSERT INTO `warehouseStockInPlanDetail` VALUES (3,'plan003','m00030',1,200,0,30,33,0,NULL);
-- INSERT INTO `warehouseStockInPlanDetail` VALUES (4,'plan004','m00040',1,300,0,32,35,0,NULL);
-- INSERT INTO `warehouseStockInPlanDetail` VALUES (5,'plan005','m00050',1,200,0,33,37,0,NULL);
-- INSERT INTO `warehouseStockInPlanDetail` VALUES (6,'plan006','m00060',1,300,0,40,43,0,NULL);
-- INSERT INTO `warehouseStockInPlanDetail` VALUES (7,'plan007','m00070',1,200,0,45,48,0,NULL);
-- INSERT INTO `warehouseStockInPlanDetail` VALUES (8,'plan008','m00080',1,300,0,22,26,0,NULL);
-- INSERT INTO `warehouseStockInPlanDetail` VALUES (9,'plan009','m00090',1,200,0,21,27,0,NULL);
-- INSERT INTO `warehouseStockInPlanDetail` VALUES (10,'plan010','m00100',1,300,0,67,70,0,NULL);
-- INSERT INTO `warehouseStockInPlanDetail` VALUES (11,'plan010','m00101',1,300,0,50,55,0,NULL);
-- INSERT INTO `warehouseStockInPlanDetail` VALUES (12,'plan010','m00102',1,200,0,60,65,0,NULL);

INSERT INTO `warehouseStockInPlanDetail` VALUES (1,'plan001','11101',1,20,0,500000,520000,0,NULL);
INSERT INTO `warehouseStockInPlanDetail` VALUES (2,'plan001','11102',1,30,0,200000,210000,0,NULL);
INSERT INTO `warehouseStockInPlanDetail` VALUES (3,'plan002','21101',2,100,0,10000,10500,0,NULL);
INSERT INTO `warehouseStockInPlanDetail` VALUES (4,'plan002','21102',2,150,0,10000,10500,0,NULL);
INSERT INTO `warehouseStockInPlanDetail` VALUES (5,'plan003','31101',3,200,0,8000,8200,0,NULL);
INSERT INTO `warehouseStockInPlanDetail` VALUES (6,'plan003','31102',3,100,0,6000,6150,0,NULL);
INSERT INTO `warehouseStockInPlanDetail` VALUES (7,'plan004','31101',4,300,0,8000,8200,0,NULL);
INSERT INTO `warehouseStockInPlanDetail` VALUES (8,'plan004','31102',4,150,0,6000,6150,0,NULL);
INSERT INTO `warehouseStockInPlanDetail` VALUES (9,'plan005','31102',4,100,0,6000,6150,0,NULL);
INSERT INTO `warehouseStockInPlanDetail` VALUES (10,'plan006','11101',1,50,0,500000,520000,0,NULL);


-- -- -- ----------------------------
-- -- -- Records of warehouseStockInRecord
-- -- -- ----------------------------
-- INSERT INTO `warehouseStockInRecord` VALUES (1,'entry001',1,'purchase001',1,3331,333111,333001,66601,'2018-10-02 10:00:00',1,NULL);
-- INSERT INTO `warehouseStockInRecord` VALUES (2,'entry002',1,'purchase002',1,3331,333112,333002,66601,'2018-10-03 10:00:00',1,NULL);
-- INSERT INTO `warehouseStockInRecord` VALUES (3,'entry003',1,'purchase003',1,3331,333113,333003,66601,'2018-10-04 10:00:00',1,NULL);
-- INSERT INTO `warehouseStockInRecord` VALUES (4,'entry004',1,'purchase004',1,3332,333111,333001,66602,'2018-10-05 10:00:00',1,NULL);
-- INSERT INTO `warehouseStockInRecord` VALUES (5,'entry005',1,'purchase005',1,3332,333112,333002,66602,'2018-10-06 10:00:00',1,NULL);
-- INSERT INTO `warehouseStockInRecord` VALUES (6,'entry006',1,'purchase006',1,3332,333113,333003,66601,'2018-10-07 10:00:00',1,NULL);
-- -- -- ----------------------------
-- -- -- Records of warehouseStockInRecordDetail
-- -- -- ----------------------------
-- INSERT INTO `warehouseStockInRecordDetail` VALUES(1,'entry001','11101','2018001',1,20,500000,520000,NULL);
-- INSERT INTO `warehouseStockInRecordDetail` VALUES(2,'entry001','11102','2018002',1,30,200000,210000,NULL);
-- INSERT INTO `warehouseStockInRecordDetail` VALUES(3,'entry002','21101','2018003',1,100,10000,10500,NULL);
-- INSERT INTO `warehouseStockInRecordDetail` VALUES(4,'entry002','21102','2018004',1,150,10000,10500,NULL);
-- INSERT INTO `warehouseStockInRecordDetail` VALUES(5,'entry003','31101','2017001',1,200,8000,8200,NULL);
-- INSERT INTO `warehouseStockInRecordDetail` VALUES(6,'entry003','31102','2017002',1,100,6000,6150,NULL);
-- INSERT INTO `warehouseStockInRecordDetail` VALUES(7,'entry004','31101','2017001',1,300,8000,8200,NULL);
-- INSERT INTO `warehouseStockInRecordDetail` VALUES(8,'entry004','31102','2017002',1,150,6000,6150,NULL);
-- INSERT INTO `warehouseStockInRecordDetail` VALUES(9,'entry005','31102','2017002',1,100,6000,6150,NULL);
-- INSERT INTO `warehouseStockInRecordDetail` VALUES(10,'entry006','11101','2018001',1,50,500000,520000,NULL);
