/*
Navicat MySQL Data Transfer

Source Server         : databaselink
Source Server Version : 50527
Source Host           : 127.0.0.1:3306
Source Database       : nwpushop

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2018-10-11 22:17:29
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for buyer
-- ----------------------------
DROP TABLE IF EXISTS `buyer`;
CREATE TABLE `buyer` (
  `bid` int(11) NOT NULL AUTO_INCREMENT,
  `brealname` varchar(10) NOT NULL,
  `bpassword` varchar(32) NOT NULL,
  `bonlinename` varchar(32) NOT NULL,
  `bschool` varchar(20) NOT NULL,
  `bsex` varchar(5) NOT NULL,
  `btel` varchar(20) NOT NULL,
  `bemail` varchar(32) NOT NULL,
  PRIMARY KEY (`bid`)
) ENGINE=InnoDB AUTO_INCREMENT=2018263279 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of buyer
-- ----------------------------
INSERT INTO `buyer` VALUES ('2018263277', '刘东', 'liu199507300001', '赵东来', '西北工业大学', '男', '15735104050', '527128168@qq.com');
INSERT INTO `buyer` VALUES ('2018263278', '帐篷', 'liu199507300001', '安', '西北工业大学', '男', '18509247217', '527128168@qq.com');

-- ----------------------------
-- Table structure for commodity
-- ----------------------------
DROP TABLE IF EXISTS `commodity`;
CREATE TABLE `commodity` (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `sid` int(11) NOT NULL,
  `cname` varchar(32) NOT NULL,
  `price` float NOT NULL,
  `picture` varchar(200) NOT NULL,
  `cdescribe` varchar(200) NOT NULL,
  `type` varchar(20) NOT NULL,
  `remark` int(1) DEFAULT '1',
  PRIMARY KEY (`cid`),
  KEY `fk` (`sid`),
  CONSTRAINT `fk` FOREIGN KEY (`sid`) REFERENCES `seller` (`sid`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of commodity
-- ----------------------------
INSERT INTO `commodity` VALUES ('3', '2', 'C++ Primer plus', '30', '1539090118325.jpg', '毕业啦，书籍转让', '书籍', '1');
INSERT INTO `commodity` VALUES ('4', '2', 'ipone7', '1000', '1539170184937.jpg', '去年买的，转让', '电器', '1');
INSERT INTO `commodity` VALUES ('5', '2', '计算机网络', '10', '1539244524959.jpg', '毕业啦，转让计算机网络', '书籍', '1');
INSERT INTO `commodity` VALUES ('6', '2', '考研英语', '5', '1539244568508.jpg', '考研记单词必备', '书籍', '1');
INSERT INTO `commodity` VALUES ('7', '2', 'c++程序设计', '5', '1539244600400.jpg', '毕业转让', '书籍', '1');
INSERT INTO `commodity` VALUES ('8', '2', 'linux学习', '30', '1539244633953.jpg', '毕业转让', '书籍', '1');
INSERT INTO `commodity` VALUES ('9', '2', '粉色上衣', '150', '1539244686513.jpg', '在淘宝上，尺码买大了，转让', '书籍', '1');
INSERT INTO `commodity` VALUES ('10', '2', 'only女装', '300', '1539244718291.jpg', '尺码不合适，转让', '衣服', '1');
INSERT INTO `commodity` VALUES ('11', '2', '女装', '100', '1539244752632.jpg', '尺码不合适，转让', '衣服', '1');
INSERT INTO `commodity` VALUES ('12', '2', '蓝色线衣', '150', '1539244817067.jpg', '转让，买了就穿过一次', '衣服', '1');
INSERT INTO `commodity` VALUES ('13', '2', '女式靴子', '150', '1539244873901.jpg', '尺码不合适，转让', '鞋', '1');
INSERT INTO `commodity` VALUES ('14', '2', '女式帆布鞋', '200', '1539245783272.jpg', '尺码不合适，转让', '鞋', '0');
INSERT INTO `commodity` VALUES ('15', '2', '帆布鞋', '100', '1539245826639.jpg', '尺码不合适，转让', '鞋', '0');
INSERT INTO `commodity` VALUES ('16', '2', '山地车', '100', '1539245861993.jpg', '骑了两年，毕业转让', '自行车', '1');
INSERT INTO `commodity` VALUES ('17', '2', '自行车', '100', '1539245943697.jpg', '骑了两年，转让', '自行车', '0');
INSERT INTO `commodity` VALUES ('18', '2', '自行车', '150', '1539245980162.jpg', '毕业啦，骑了一年，转让', '自行车', '0');
INSERT INTO `commodity` VALUES ('19', '2', '吹风机', '20', '1539246019185.jpg', '毕业转让', '书籍', '1');
INSERT INTO `commodity` VALUES ('20', '2', '锅', '20', '1539252918171.jpg', '毕业转让', '电器', '1');
INSERT INTO `commodity` VALUES ('21', '2', '衣架', '5', '1539257928096.jpg', '毕业转让', '其它', '1');
INSERT INTO `commodity` VALUES ('22', '2', '衣柜', '30', '1539258119390.jpg', '毕业转让', '其它', '0');
INSERT INTO `commodity` VALUES ('23', '2', '衣柜', '40', '1539259156278.jpg', '毕业转让', '其它', '0');
INSERT INTO `commodity` VALUES ('24', '2', '晾衣架', '10', '1539259798693.jpg', '毕业转让', '其它', '1');

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `orderid` int(11) NOT NULL AUTO_INCREMENT,
  `bid` int(11) NOT NULL,
  `btel` varchar(32) NOT NULL,
  `baddress` varchar(200) NOT NULL,
  `sid` int(11) NOT NULL,
  `stel` varchar(32) NOT NULL,
  `saddress` varchar(200) NOT NULL,
  `cid` int(11) NOT NULL,
  PRIMARY KEY (`orderid`),
  KEY `fk_orders_id` (`sid`),
  KEY `fk_orders_bid` (`bid`),
  KEY `fk_orders_cid` (`cid`),
  CONSTRAINT `fk_orders_bid` FOREIGN KEY (`bid`) REFERENCES `buyer` (`bid`),
  CONSTRAINT `fk_orders_cid` FOREIGN KEY (`cid`) REFERENCES `commodity` (`cid`),
  CONSTRAINT `fk_orders_id` FOREIGN KEY (`sid`) REFERENCES `seller` (`sid`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('9', '2018263277', '1590353329', '西北工业大学星A', '2', '15735104050', '西北工业大学', '3');
INSERT INTO `orders` VALUES ('10', '2018263277', '13233530587', '西北工业大学星A113', '2', '15735104050', '西北工业大学', '4');
INSERT INTO `orders` VALUES ('11', '2018263277', '15735104050', '星A113B', '2', '15735104050', '西北工业大学', '5');
INSERT INTO `orders` VALUES ('12', '2018263278', '18509247217', '星A113B', '2', '15735104050', '西北工业大学', '11');
INSERT INTO `orders` VALUES ('13', '2018263278', '15735104050', '教西', '2', '15735104050', '西北工业大学', '15');
INSERT INTO `orders` VALUES ('14', '2018263278', '15735104050', '星A113C', '2', '15735104050', '西北工业大学', '11');
INSERT INTO `orders` VALUES ('15', '2018263277', '15735104050', '教西', '2', '15735104050', '西北工业大学', '23');

-- ----------------------------
-- Table structure for seller
-- ----------------------------
DROP TABLE IF EXISTS `seller`;
CREATE TABLE `seller` (
  `sid` int(11) NOT NULL AUTO_INCREMENT,
  `stel` varchar(32) NOT NULL,
  `spassword` varchar(32) NOT NULL,
  `sonlinename` varchar(32) NOT NULL,
  `srank` int(11) NOT NULL DEFAULT '0',
  `sschool` varchar(20) NOT NULL,
  `srealname` varchar(32) NOT NULL,
  `sstudentid` varchar(32) NOT NULL,
  `ssex` varchar(3) NOT NULL,
  `semail` varchar(32) NOT NULL,
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of seller
-- ----------------------------
INSERT INTO `seller` VALUES ('2', '15735104050', 'liu199507300001', '刘东', '0', '西北工业大学', '刘东', '2018263276', '男', '527128168@qq.com');
INSERT INTO `seller` VALUES ('3', '15735104050', 'liu199507300001', 'APEX-LD', '0', '西北工业大学', '刘东', '2018263276', '男', '527128168@qq.com');
INSERT INTO `seller` VALUES ('4', '15735104050', 'liu199507300001', 'APEX-LD', '0', '西北工业大学', '刘东', '2018263276', '男', '527128168@qq.com');
INSERT INTO `seller` VALUES ('5', '15735104050', 'liu199507300001', 'APEX-LD', '0', '西北工业大学', '刘东', '2018263276', '男', '527128168@qq.com');

-- ----------------------------
-- Table structure for shoppingcart
-- ----------------------------
DROP TABLE IF EXISTS `shoppingcart`;
CREATE TABLE `shoppingcart` (
  `carid` int(11) NOT NULL AUTO_INCREMENT,
  `cid` int(11) DEFAULT NULL,
  `sid` int(11) DEFAULT NULL,
  `bid` int(11) DEFAULT NULL,
  PRIMARY KEY (`carid`),
  KEY `fk_cid` (`cid`),
  KEY `fk_id` (`sid`),
  KEY `fk_bid` (`bid`),
  CONSTRAINT `fk_bid` FOREIGN KEY (`bid`) REFERENCES `buyer` (`bid`),
  CONSTRAINT `fk_cid` FOREIGN KEY (`cid`) REFERENCES `commodity` (`cid`),
  CONSTRAINT `fk_id` FOREIGN KEY (`sid`) REFERENCES `seller` (`sid`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shoppingcart
-- ----------------------------
INSERT INTO `shoppingcart` VALUES ('17', '3', '2', '2018263277');
INSERT INTO `shoppingcart` VALUES ('18', '4', '2', '2018263277');
INSERT INTO `shoppingcart` VALUES ('19', '4', '2', '2018263277');
INSERT INTO `shoppingcart` VALUES ('20', '3', '2', '2018263277');
INSERT INTO `shoppingcart` VALUES ('21', '5', '2', '2018263277');
INSERT INTO `shoppingcart` VALUES ('22', '5', '2', '2018263277');
INSERT INTO `shoppingcart` VALUES ('23', '3', '2', '2018263277');
INSERT INTO `shoppingcart` VALUES ('24', '14', '2', '2018263278');
INSERT INTO `shoppingcart` VALUES ('25', '11', '2', '2018263278');
INSERT INTO `shoppingcart` VALUES ('26', '15', '2', '2018263278');
INSERT INTO `shoppingcart` VALUES ('27', '3', '2', '2018263277');
INSERT INTO `shoppingcart` VALUES ('28', '23', '2', '2018263277');
