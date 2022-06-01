/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80029
 Source Host           : localhost:3306
 Source Schema         : qingning

 Target Server Type    : MySQL
 Target Server Version : 80029
 File Encoding         : 6500133

 Date: 17/05/2022 06:38:07
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `role_name` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '角色',
  `role_desc` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_rolename` (`role_name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
BEGIN;
INSERT INTO `sys_role` (`id`, `role_name`, `role_desc`) VALUES (1, 'user', 'user');
INSERT INTO `sys_role` (`id`, `role_name`, `role_desc`) VALUES (2, 'admin', 'admin');
COMMIT;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` int NOT NULL,
  `uid` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户唯一id',
  `pwd` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '密码',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_uid` (`uid`) USING BTREE COMMENT 'uid唯一'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
BEGIN;
INSERT INTO `sys_user` (`id`, `uid`, `pwd`) VALUES (1, '10086', '10086');
INSERT INTO `sys_user` (`id`, `uid`, `pwd`) VALUES (2, '10010', '10010');
COMMIT;

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` int NOT NULL,
  `uid` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '账户id',
  `role_name` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_uid_role` (`uid`,`role_name`) USING BTREE COMMENT '同一uid不能有相同role',
  KEY `fk_role` (`role_name`),
  CONSTRAINT `fk_role` FOREIGN KEY (`role_name`) REFERENCES `sys_role` (`role_name`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_uid` FOREIGN KEY (`uid`) REFERENCES `sys_user` (`uid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
BEGIN;
INSERT INTO `sys_user_role` (`id`, `uid`, `role_name`) VALUES (3, '10010', 'user');
INSERT INTO `sys_user_role` (`id`, `uid`, `role_name`) VALUES (2, '10086', 'admin');
INSERT INTO `sys_user_role` (`id`, `uid`, `role_name`) VALUES (1, '10086', 'user');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
