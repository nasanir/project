/*
 Navicat Premium Data Transfer

 Source Server         : 1
 Source Server Type    : MySQL
 Source Server Version : 80011
 Source Host           : localhost:3306
 Source Schema         : fountain

 Target Server Type    : MySQL
 Target Server Version : 80011
 File Encoding         : 65001

 Date: 20/08/2018 18:42:21
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for common_sequence
-- ----------------------------
DROP TABLE IF EXISTS `common_sequence`;
CREATE TABLE `common_sequence`  (
  `SEQUENCE_ID` bigint(19) NOT NULL,
  `SEQUENCE_CODE` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `SEQUENCE_NEXT` bigint(19) DEFAULT NULL,
  `SEQUENCE_CACHE` int(3) DEFAULT NULL,
  `CREATE_DT` datetime(0) DEFAULT NULL,
  `CREATE_BY` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `CHANGE_DT` datetime(0) DEFAULT NULL,
  `CHANGE_BY` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`SEQUENCE_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
