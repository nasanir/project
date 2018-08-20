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

 Date: 20/08/2018 18:42:34
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for fountain_manager_field
-- ----------------------------
DROP TABLE IF EXISTS `fountain_manager_field`;
CREATE TABLE `fountain_manager_field`  (
  `FIELD_ID` bigint(19) NOT NULL,
  `FUNCTION_CODE` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `FIELD_CODE` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `FIELD_NAME` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `FIELD_TYPE` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `FIELD_LEN` int(4) DEFAULT NULL,
  `FIELD_ORDER` int(3) DEFAULT NULL,
  `ISVAILD` bit(1) DEFAULT NULL,
  `DESCRIPTION` varchar(4000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `CREATED_DT` datetime(0) DEFAULT NULL,
  `CREATED_BY` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `CHANGE_DT` datetime(0) DEFAULT NULL,
  `CHANGE_BY` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`FIELD_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of fountain_manager_field
-- ----------------------------
INSERT INTO `fountain_manager_field` VALUES (1, 'FUNC', 'FUNCTION_ID', '主键', 'BIGINT', 19, 1, b'1', '主键', '2018-08-15 11:26:39', 'admin', '2018-08-15 11:26:45', 'admin');
INSERT INTO `fountain_manager_field` VALUES (2, 'FUNC', 'TABLE_NAME', '表名', 'VACHAR', 50, 2, b'1', '表名', '2018-08-15 11:26:39', 'admin', '2018-08-15 11:26:45', 'admin');
INSERT INTO `fountain_manager_field` VALUES (3, 'FUNC', 'FUNCTION_CODE', '功能编码', 'VACHAR', 50, 3, b'1', '功能编码', '2018-08-15 11:26:39', 'admin', '2018-08-15 11:26:45', 'admin');
INSERT INTO `fountain_manager_field` VALUES (4, 'FUNC', 'FUNCTION_NAME', '功能名称', 'VACHAR', 50, 4, b'1', '功能编码', '2018-08-15 11:26:39', 'admin', '2018-08-15 11:26:45', 'admin');
INSERT INTO `fountain_manager_field` VALUES (5, 'FUNC', 'FUNCTION_ENTITY', '实体类', 'VACHAR', 50, 5, b'1', '实体类', '2018-08-15 11:26:39', 'admin', '2018-08-15 11:26:45', 'admin');
INSERT INTO `fountain_manager_field` VALUES (6, 'FUNC', 'FUNC_WHERE', '过滤条件', 'VACHAR', 50, 6, b'1', '过滤条件', '2018-08-15 11:26:39', 'admin', '2018-08-15 11:26:45', 'admin');
INSERT INTO `fountain_manager_field` VALUES (7, 'FUNC', 'ORDER_BY', '排序字段', 'VACHAR', 50, 7, b'1', '排序字段', '2018-08-15 11:26:39', 'admin', '2018-08-15 11:26:45', 'admin');
INSERT INTO `fountain_manager_field` VALUES (8, 'FUNC', 'ISVAILD', '是否有效', 'BIT', 1, 8, b'1', '是否有效', '2018-08-15 11:26:39', 'admin', '2018-08-15 11:26:45', 'admin');
INSERT INTO `fountain_manager_field` VALUES (9, 'FUNC', 'DESCRIPTION', '描述', 'VACHAR', 4000, 9, b'1', '描述', '2018-08-15 11:26:39', 'admin', '2018-08-15 11:26:45', 'admin');
INSERT INTO `fountain_manager_field` VALUES (10, 'FUNC', 'CREATED_DT', '创建时间', 'DATETIME', NULL, 10, b'1', '创建时间', '2018-08-15 11:26:39', 'admin', '2018-08-15 11:26:45', 'admin');
INSERT INTO `fountain_manager_field` VALUES (11, 'FUNC', 'CREATED_BY', '创建人', 'VARCHAR', 50, 11, b'1', '创建人', '2018-08-15 11:26:39', 'admin', '2018-08-15 11:26:45', 'admin');
INSERT INTO `fountain_manager_field` VALUES (12, 'FUNC', 'CHANGE_DT', '更改时间', 'DATETIME', NULL, 12, b'1', '更改时间', '2018-08-15 11:26:39', 'admin', '2018-08-15 11:26:45', 'admin');
INSERT INTO `fountain_manager_field` VALUES (13, 'FUNC', 'CHANGE_BY', '更改人', 'VARCHAR', 50, 13, b'1', '更改人', '2018-08-15 11:26:39', 'admin', '2018-08-15 11:26:45', 'admin');

SET FOREIGN_KEY_CHECKS = 1;
