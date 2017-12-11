/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50018
Source Host           : localhost:3306
Source Database       : well

Target Server Type    : MYSQL
Target Server Version : 50018
File Encoding         : 65001

Date: 2017-12-11 08:36:36
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `sys_category`
-- ----------------------------
DROP TABLE IF EXISTS `sys_category`;
CREATE TABLE `sys_category` (
  `id` int(11) NOT NULL,
  `code` varchar(255) default NULL,
  `corder` int(11) default NULL,
  `name` varchar(255) default NULL,
  `pid` int(11) default NULL,
  PRIMARY KEY  (`id`),
  KEY `FK_to1e8525ja2v68g9p51busl2p` (`pid`),
  CONSTRAINT `FK_to1e8525ja2v68g9p51busl2p` FOREIGN KEY (`pid`) REFERENCES `sys_category` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_category
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_image`
-- ----------------------------
DROP TABLE IF EXISTS `sys_image`;
CREATE TABLE `sys_image` (
  `id` int(11) NOT NULL,
  `image1` varchar(255) default NULL,
  `image2` varchar(255) default NULL,
  `image3` varchar(255) default NULL,
  `year` int(11) NOT NULL,
  `WellInfo_Id` int(11) default NULL,
  PRIMARY KEY  (`id`),
  KEY `FK_3ahaop54ltchmc3atq6h0lgwv` (`WellInfo_Id`),
  CONSTRAINT `FK_3ahaop54ltchmc3atq6h0lgwv` FOREIGN KEY (`WellInfo_Id`) REFERENCES `sys_wellinfo` (`WellInfo_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_image
-- ----------------------------
INSERT INTO `sys_image` VALUES ('1', '\\static\\wellImages\\iamgeOne20171111165612.png', null, null, '2016', '5');
INSERT INTO `sys_image` VALUES ('2', '\\static\\wellImages\\iamgeOne20171111165846.bmp', null, null, '2017', '5');

-- ----------------------------
-- Table structure for `sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL auto_increment,
  `checkAuthority` varchar(255) default NULL,
  `deleteAuthority` varchar(255) default NULL,
  `department` varchar(255) default NULL,
  `modifyAuthority` varchar(255) default NULL,
  `password` varchar(255) default NULL,
  `recordAuthority` varchar(255) default NULL,
  `username` varchar(255) default NULL,
  `viewAuthority` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'CHECK', 'DELETE', 'ADMIN', 'MODIFY', '123', 'RECORD', 'admin', null);
INSERT INTO `sys_user` VALUES ('2', null, null, 'TASK1', null, '123', 'RECORD', '张一1', null);
INSERT INTO `sys_user` VALUES ('10', 'CHECK', null, 'TASK1', null, '123', null, '张一2', null);
INSERT INTO `sys_user` VALUES ('11', null, null, 'TASK2', null, '123', 'RECORD', '张二1', null);
INSERT INTO `sys_user` VALUES ('12', 'CHECK', null, 'TASK2', null, '123', null, '张二2', null);
INSERT INTO `sys_user` VALUES ('13', null, null, 'TASK3', null, '123', 'RECORD', '张三1', null);
INSERT INTO `sys_user` VALUES ('14', 'CHECK', null, 'TASK3', null, '123', null, '张三2', null);
INSERT INTO `sys_user` VALUES ('15', null, null, 'MINING', null, '123', 'RECORD', '专1', null);
INSERT INTO `sys_user` VALUES ('16', 'CHECK', null, 'MINING', null, '123', null, '专2', null);
INSERT INTO `sys_user` VALUES ('17', null, null, 'GEOGRAPHY', 'MODIFY', '123', null, '地质1', null);
INSERT INTO `sys_user` VALUES ('18', 'CHECK', 'DELETE', 'GEOGRAPHY', 'MODIFY', '123', null, '地质2', null);
INSERT INTO `sys_user` VALUES ('19', null, null, 'ENGINEERING', 'MODIFY', '123', null, '工程1', null);
INSERT INTO `sys_user` VALUES ('20', 'CHECK', 'DELETE', 'ENGINEERING', 'MODIFY', '123', null, '工程2', null);
INSERT INTO `sys_user` VALUES ('21', null, null, 'GENERAL', null, '123', null, 'general', null);

-- ----------------------------
-- Table structure for `sys_wellinfo`
-- ----------------------------
DROP TABLE IF EXISTS `sys_wellinfo`;
CREATE TABLE `sys_wellinfo` (
  `WellInfo_Id` int(11) NOT NULL,
  `blockUnit` varchar(255) default NULL,
  `casingDeformationType` varchar(255) default NULL,
  `code` varchar(255) default NULL,
  `controlReserves` varchar(255) default NULL,
  `cumulativeGas` varchar(255) default NULL,
  `cumulativeOil` varchar(255) default NULL,
  `cumulativeWater` varchar(255) default NULL,
  `currentControlMethod` varchar(255) default NULL,
  `currentType` varchar(255) default NULL,
  `department` varchar(255) default NULL,
  `environment` varchar(255) default NULL,
  `groundFacility` varchar(255) default NULL,
  `isAbandon` varchar(255) default NULL,
  `isCount` varchar(255) default NULL,
  `isInWellNet` varchar(255) default NULL,
  `isScrap` varchar(255) default NULL,
  `location` varchar(255) default NULL,
  `nextSchema` varchar(255) default NULL,
  `operator` varchar(255) default NULL,
  `positionEndProduct` varchar(255) default NULL,
  `productState` varchar(255) default NULL,
  `remark` varchar(255) default NULL,
  `riskRank` varchar(255) default NULL,
  `shutWellState` varchar(255) default NULL,
  `state` varchar(255) default NULL,
  `structure` varchar(255) default NULL,
  `timeCommission` varchar(255) default NULL,
  `timeDrilling` varchar(255) default NULL,
  `timeShutDown` varchar(255) default NULL,
  `tubular` varchar(255) default NULL,
  `wellCompletion` varchar(255) default NULL,
  `wellheadIntegrity` varchar(255) default NULL,
  `completeDepth` varchar(255) default NULL,
  `coordinateX` varchar(255) default NULL,
  `coordinateY` varchar(255) default NULL,
  `designDepth` varchar(255) default NULL,
  `designType` varchar(255) default NULL,
  `isDownWellFL` varchar(255) default NULL,
  `scrapType` varchar(255) default NULL,
  `geoRisk` varchar(255) default NULL,
  PRIMARY KEY  (`WellInfo_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_wellinfo
-- ----------------------------
INSERT INTO `sys_wellinfo` VALUES ('1', '', '', 'ZY1#2', '', '', '', '', '', '油井', 'TASK1', '', '', '是', '是', '是', '是', '', '', null, '', '生产', '', '', '', 'PASS', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '二级');
INSERT INTO `sys_wellinfo` VALUES ('2', '', '', 'ZY#2', '', '', '', '', '', '油井', 'TASK2', '', '', '是', '是', '是', '是', '', '', 'TASK2', '', '生产', '', '', '', 'COMMIT', '', '', '', '', '', '', '', null, null, null, null, null, null, null, null);
INSERT INTO `sys_wellinfo` VALUES ('3', 'tt', '套管弯曲', 'ZY1#1', 'tt', 'tt', 'tt', 'tt', 'tt', '水井', 'TASK1', 'tt', 'tt', '是', '是', '是', '是', 'tt', '恢复', 'GEOGRAPHY', 'tt', '生产', '', '一级', '未封井', 'COMMIT', 'tt', 'tt', 'tt', 'tt', 'tt', '射孔完井', 'tt', '', '', '', '', '', '', '', '二级');
INSERT INTO `sys_wellinfo` VALUES ('5', '', '', 'ZY3#1', '', '', '', '', '', '水井', 'TASK3', '', '', '是', '是', '是', '是', '', '', 'TASK3', '', '生产', '', '', '', 'COMMIT', '', '', '', '', '', '', '', null, null, null, null, null, null, null, null);
INSERT INTO `sys_wellinfo` VALUES ('6', '', '', 'DDD', '', '', '', '', null, '水井', 'TASK1', '', '', '否', '是', '', '', '', '', 'TASK1', '', '', '', '', '', 'COMMIT', '', '', '', '', '', '', null, '', '', '', '', '预探井', '', '正常报废', '二级');
