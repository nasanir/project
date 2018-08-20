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

 Date: 20/08/2018 18:42:38
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for fountain_manager_function
-- ----------------------------
DROP TABLE IF EXISTS `fountain_manager_function`;
CREATE TABLE `fountain_manager_function`  (
  `FUNCTION_ID` bigint(19) NOT NULL,
  `TABLE_NAME` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `FUNCTION_CODE` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `FUNCTION_NAME` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `FUNCTION_ENTITY` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `FUNC_WHERE` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `ORDER_BY` int(2) DEFAULT NULL,
  `ISVAILD` bit(1) DEFAULT NULL,
  `DESCRIPTION` varchar(4000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `CREATED_DT` datetime(0) DEFAULT NULL,
  `CREATED_BY` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `CHANGE_DT` datetime(0) DEFAULT NULL,
  `CHANGE_BY` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`FUNCTION_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of fountain_manager_function
-- ----------------------------
INSERT INTO `fountain_manager_function` VALUES (1, 'FOUNTAIN_MANAGER_FUNCTION', 'FUNC', '功能', 'pers.nasanir.fountain.common.function.entity.FuncVO', 'FUNCTION_CODE not like  \'%FUNC%\'', NULL, b'1', '测试', '2018-08-14 13:47:42', 'admin', '2018-08-14 13:47:48', 'admin');
INSERT INTO `fountain_manager_function` VALUES (2, 'FOUNTAIN_MANAGER_FUNCTION2', 'FUNC2', '功能2', 'pers.nasanir.fountain.common.function.entity.FuncVO', '', NULL, b'1', '测试', '2018-08-14 13:47:42', 'admin', '2018-08-14 13:47:48', 'admin');
INSERT INTO `fountain_manager_function` VALUES (3, 'FOUNTAIN_MANAGER_FUNCTION', 'FUNC3', '功能3', 'pers.nasanir.fountain.common.function.entity.FuncVO', '', NULL, b'1', '测试', '2018-08-14 13:47:42', 'admin', '2018-08-14 13:47:48', 'admin');
INSERT INTO `fountain_manager_function` VALUES (4, 'FOUNTAIN_MANAGER_FUNCTION', 'FUNC4', '功能4', 'pers.nasanir.fountain.common.function.entity.FuncVO', '', NULL, b'1', '测试', '2018-08-14 13:47:42', 'admin', '2018-08-14 13:47:48', 'admin');
INSERT INTO `fountain_manager_function` VALUES (5, 'FOUNTAIN_MANAGER_FIELD', 'FIELD', '字段', 'pers.nasanir.fountain.common.function.entity.FieldVO', NULL, NULL, b'1', NULL, '2018-08-15 14:21:45', 'admin', '2018-08-15 14:21:45', 'admin');

SET FOREIGN_KEY_CHECKS = 1;
