/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50723
Source Host           : localhost:3306
Source Database       : kuaisuji

Target Server Type    : MYSQL
Target Server Version : 50723
File Encoding         : 65001

Date: 2019-09-16 20:36:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for accounts
-- ----------------------------
DROP TABLE IF EXISTS `accounts`;
CREATE TABLE `accounts` (
  `account_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `account_type` int(11) NOT NULL COMMENT '标注收支类型（支出为0，收入为1）',
  `account_item` int(11) NOT NULL COMMENT '收支项目ID',
  `account_amount` decimal(10,0) NOT NULL COMMENT '收支金额',
  `account_date` datetime DEFAULT NULL COMMENT '账目产生日期',
  `account_remark` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '账单详情备注',
  PRIMARY KEY (`account_id`),
  KEY `accounts_type_name` (`account_type`),
  KEY `user_id_foreignkey` (`user_id`),
  KEY `accouts_item_name` (`account_item`),
  CONSTRAINT `accounts_type_name` FOREIGN KEY (`account_type`) REFERENCES `type` (`account_type`),
  CONSTRAINT `accouts_item_name` FOREIGN KEY (`account_item`) REFERENCES `type` (`account_item`),
  CONSTRAINT `user_id_foreignkey` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of accounts
-- ----------------------------
INSERT INTO `accounts` VALUES ('13', '1', '0', '1', '15', '2019-09-15 16:27:35', 'test1');
INSERT INTO `accounts` VALUES ('14', '1', '0', '2', '55', '2019-09-19 16:28:37', 'test2');
INSERT INTO `accounts` VALUES ('15', '1', '0', '2', '98', '2019-09-19 00:00:00', 'test3');
INSERT INTO `accounts` VALUES ('16', '1', '0', '3', '99', '2019-09-20 00:00:00', 'test4add');
INSERT INTO `accounts` VALUES ('17', '1', '1', '16', '963', '2019-09-15 16:48:25', 'testfinish');
INSERT INTO `accounts` VALUES ('18', '1', '0', '1', '952', '2019-09-15 18:10:06', 'url;aterlogin;test');
INSERT INTO `accounts` VALUES ('19', '1', '0', '1', '952', '2019-09-15 18:10:06', 'url;aterlogin;test2');
INSERT INTO `accounts` VALUES ('20', '1', '1', '16', '100', '2019-09-15 18:12:48', 'url;afterlogin;testfinish');
INSERT INTO `accounts` VALUES ('21', '1', '0', '1', '55', '2019-09-15 18:14:18', 'finish');
INSERT INTO `accounts` VALUES ('22', '4', '0', '1', '99', '2019-09-15 22:00:38', 'ss');
INSERT INTO `accounts` VALUES ('23', '1', '0', '1', '55', '2019-09-15 22:17:40', 'ss');
INSERT INTO `accounts` VALUES ('24', '1', '0', '1', '55', '2019-09-15 22:18:31', '5');
INSERT INTO `accounts` VALUES ('25', '1', '0', '8', '995', '2019-09-16 13:31:07', 'typeMap test');
INSERT INTO `accounts` VALUES ('26', '8', '1', '16', '99', '2019-09-16 19:39:37', 'test1');
INSERT INTO `accounts` VALUES ('27', '8', '0', '2', '99', '2019-09-16 19:39:53', 'test2');
INSERT INTO `accounts` VALUES ('28', '8', '0', '3', '99', '2019-09-16 20:01:08', 'typeMapBy0;test1');
INSERT INTO `accounts` VALUES ('29', '8', '1', '16', '4545', '2019-09-16 20:03:16', 'typeMapBy1;test1');
INSERT INTO `accounts` VALUES ('31', '8', '1', '17', '55', '2019-09-16 20:17:30', '中文');

-- ----------------------------
-- Table structure for type
-- ----------------------------
DROP TABLE IF EXISTS `type`;
CREATE TABLE `type` (
  `account_type` int(11) NOT NULL COMMENT '收支类型（0为支出，1为收入）',
  `account_item` int(10) NOT NULL AUTO_INCREMENT COMMENT '收支项目ID',
  `account_item_name` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '收支项目名称',
  `item_img_src` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`account_item`,`account_type`),
  KEY `accounts_item` (`account_item`),
  KEY `accounts_type` (`account_type`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of type
-- ----------------------------
INSERT INTO `type` VALUES ('0', '1', '交通', 'cat_doprava_1.png');
INSERT INTO `type` VALUES ('0', '2', '电影', 'cat_movies_1.png');
INSERT INTO `type` VALUES ('0', '3', '早餐', 'cat_food_1.png');
INSERT INTO `type` VALUES ('0', '4', '午餐', 'cat_food_1.png');
INSERT INTO `type` VALUES ('0', '5', '晚餐', 'cat_food_1.png');
INSERT INTO `type` VALUES ('0', '6', '娱乐', 'cat_music_1.png');
INSERT INTO `type` VALUES ('0', '7', '教育', 'cat_school_1.png');
INSERT INTO `type` VALUES ('0', '8', '旅游', 'cat_travel_1.png');
INSERT INTO `type` VALUES ('0', '9', '购物', 'cat_shop_1.png');
INSERT INTO `type` VALUES ('0', '10', '油费', 'cat_car_1.png');
INSERT INTO `type` VALUES ('0', '11', '宠物', 'cat_love_1.png');
INSERT INTO `type` VALUES ('0', '12', '看病', 'cat_health_1.png');
INSERT INTO `type` VALUES ('0', '13', '饮料', 'cat_drink_1.png');
INSERT INTO `type` VALUES ('0', '14', '礼物', 'cat_gift_1.png');
INSERT INTO `type` VALUES ('0', '15', '其它', 'cat_otaznik_1.png');
INSERT INTO `type` VALUES ('1', '16', '额外收入 ', 'cat_bills_1.png');
INSERT INTO `type` VALUES ('1', '17', '零碎收入', 'cat_bills_1.png');
INSERT INTO `type` VALUES ('1', '18', '工资', 'cat_bills_1.png');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_email` varchar(255) COLLATE utf8_bin NOT NULL,
  `user_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `user_password` varchar(255) COLLATE utf8_bin NOT NULL,
  `user_ip` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '用户登陆IP',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '123456@163.com', '时', '123456', '127.0.0.1');
INSERT INTO `user` VALUES ('2', '234585@qq.com', 'hhh', '123456', '127.1.1.1');
INSERT INTO `user` VALUES ('3', 'addTest', null, 'addTest', null);
INSERT INTO `user` VALUES ('4', 'addusertest1@qq.com', 'test1', 'test1', '0:0:0:0:0:0:0:1');
INSERT INTO `user` VALUES ('5', 'addusertest2@qq.com', 'test2', 'test2', '0:0:0:0:0:0:0:1');
INSERT INTO `user` VALUES ('6', 'iptest1@qq.com', 'ip', 'ip', '0:0:0:0:0:0:0:1');
INSERT INTO `user` VALUES ('7', 'iptest2@qq.com', 'ip2', 'ip2', '127.0.0.1');
INSERT INTO `user` VALUES ('8', 'shi@qq.com', 'shi', 'shi', '0:0:0:0:0:0:0:1');
INSERT INTO `user` VALUES ('10', 'testend@qq.com', '中文', 'test', '0:0:0:0:0:0:0:1');
INSERT INTO `user` VALUES ('11', '123@qq.com', '123', '123', '0:0:0:0:0:0:0:1');
