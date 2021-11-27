/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80026
 Source Host           : localhost:3306
 Source Schema         : management_system

 Target Server Type    : MySQL
 Target Server Version : 80026
 File Encoding         : 65001

 Date: 27/11/2021 11:22:24
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for administrator
-- ----------------------------
DROP TABLE IF EXISTS `administrator`;
CREATE TABLE `administrator`  (
  `name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `sex` int NULL DEFAULT NULL,
  `phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '管理员' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of administrator
-- ----------------------------
INSERT INTO `administrator` VALUES ('root', 1, '15805752487');

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book`  (
  `bNo` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `ISBN` varchar(13) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `bDamaged` char(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '完好',
  `bPrice` double NULL DEFAULT NULL,
  `bookdate` datetime NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `booknums` int NULL DEFAULT 1,
  `bLocation` varchar(7) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`bNo`) USING BTREE,
  INDEX `book_booklist_ISBN_fk`(`ISBN`) USING BTREE,
  CONSTRAINT `book_booklist_ISBN_fk` FOREIGN KEY (`ISBN`) REFERENCES `booklist` (`ISBN`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '图书' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('b00001', '9787302533733', '破损', 69, '2021-11-27 10:54:24', 2, '301-4-2');
INSERT INTO `book` VALUES ('b00002', '9787302533733', '破损', 70, '2021-11-27 11:17:35', 4, '301-4-2');
INSERT INTO `book` VALUES ('b00003', '9787302533733', '破损', 80, '2021-05-10 00:00:00', 4, '301-4-2');
INSERT INTO `book` VALUES ('b00004', '9787020008728', '破损', 38, '2021-11-27 11:17:13', 1, '301-1-1');
INSERT INTO `book` VALUES ('b00005', '9787302533741', '完好', 38, '2021-11-27 11:12:24', 1, '301-1-1');
INSERT INTO `book` VALUES ('b00006', '9787020008728', '破损', 40, '2021-11-27 11:13:49', 1, '301-1-1');
INSERT INTO `book` VALUES ('b00007', '9787062142145', '破损', 40, '2021-05-10 00:00:00', 1, '301-1-1');
INSERT INTO `book` VALUES ('b00008', '9787040406641', '完好', 49.6, '2021-05-10 00:00:00', 1, '301-2-1');
INSERT INTO `book` VALUES ('b00009', '9787040406641', '完好', 39.6, '2021-05-10 00:00:00', 1, '301-2-1');
INSERT INTO `book` VALUES ('b00010', '9787062142145', '完好', 66.5, '2021-05-10 00:00:00', 1, '301-3-2');
INSERT INTO `book` VALUES ('b00011', '9787062142145', '完好', 67.5, '2021-11-25 09:18:35', 1, '301-3-2');
INSERT INTO `book` VALUES ('b00012', '9787062142145', '完好', 68.5, '2021-11-25 09:18:43', 1, '301-3-2');
INSERT INTO `book` VALUES ('b00013', '9787062142145', '完好', 69.5, '2021-11-27 11:03:34', 1, '301-3-2');
INSERT INTO `book` VALUES ('b00014', '9787062142145', '完好', 71.5, '2021-11-25 09:18:47', 1, '301-3-2');
INSERT INTO `book` VALUES ('b00015', '9787302533740', '完好', 98, '2021-11-25 09:18:48', 14, '301-3-1');
INSERT INTO `book` VALUES ('b00016', '9787302533741', '完好', 75, '2021-11-25 09:18:49', 1, '301-2-1');
INSERT INTO `book` VALUES ('b00017', '9787302533743', '完好', 71.5, '2021-11-27 11:03:32', 1, '301-2-1');
INSERT INTO `book` VALUES ('b00018', '9787302533744', '完好', 77.5, '2021-11-27 11:03:24', 1, '301-2-2');
INSERT INTO `book` VALUES ('b00019', '9787302533746', '破损', 77.5, '2021-11-27 10:19:26', 1, '301-2-2');
INSERT INTO `book` VALUES ('b00020', '9787302533746', '完好', 80, '2021-11-25 09:18:55', 1, '301-2-2');
INSERT INTO `book` VALUES ('b00021', '9787302533747', '完好', 80, '2021-11-25 09:18:56', 1, '301-2-2');
INSERT INTO `book` VALUES ('b00022', '9787302533747', '完好', 90, '2021-11-25 09:18:57', 1, '301-2-2');
INSERT INTO `book` VALUES ('b00023', '9787302533747', '完好', 92, '2021-11-25 09:18:58', 1, '301-2-2');
INSERT INTO `book` VALUES ('b00024', '9787302533748', '完好', 99, '2021-11-25 09:19:00', 1, '301-2-2');
INSERT INTO `book` VALUES ('b00025', '9787020119301', '完好', 12, '2021-11-25 09:19:01', 9, '301-2-3');
INSERT INTO `book` VALUES ('b00026', '9787302533735', '完好', 78, '2021-11-25 09:19:02', 4, '');
INSERT INTO `book` VALUES ('b00027', '9787302533733', '完好', 45, '2021-11-25 09:19:04', 2, '');
INSERT INTO `book` VALUES ('b00028', '9787040406641', '完好', 45, '2021-11-25 09:19:04', 1, '');
INSERT INTO `book` VALUES ('b00029', '9787302533739', '完好', 99, '2021-11-25 09:19:06', 9, '');
INSERT INTO `book` VALUES ('b00030', '9787302533746', '完好', 79.9, '2021-11-25 09:19:08', 1, '');
INSERT INTO `book` VALUES ('b00031', '9787121318016', '完好', 12, '2021-11-25 09:19:07', 1, '');
INSERT INTO `book` VALUES ('b00032', '9787302533745', '完好', 120, '2021-11-25 09:19:09', 1, '');
INSERT INTO `book` VALUES ('b00033', '9787550630970', '完好', 121, '2021-11-25 09:19:10', 1, '');
INSERT INTO `book` VALUES ('b00034', '9787302533740', '完好', 77, '2021-11-27 11:06:21', 1, '');

-- ----------------------------
-- Table structure for booklist
-- ----------------------------
DROP TABLE IF EXISTS `booklist`;
CREATE TABLE `booklist`  (
  `ISBN` varchar(13) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `bName` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `bClass` varchar(14) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `bPublic` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `bAuthor` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`ISBN`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '书目' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of booklist
-- ----------------------------
INSERT INTO `booklist` VALUES ('9787020008728', '三国演义', '文学', '人民教育出版社', '罗贯中');
INSERT INTO `booklist` VALUES ('9787020119301', '泰戈尔经典诗集', '少儿', '人民文学出版社', '拉宾德拉纳特·泰戈尔');
INSERT INTO `booklist` VALUES ('9787040406641', '数据库系统概论', '计算机', '高等教育出版社', '王珊');
INSERT INTO `booklist` VALUES ('9787062142145', '环境科学', '环境', '人民教育出版社', '未知');
INSERT INTO `booklist` VALUES ('9787121318016', '电子产品设计', '工程技术', '电子工业出版社', '李雄杰');
INSERT INTO `booklist` VALUES ('9787302533733', 'SQL server2019数据库原理及应用', '计算机', '清华大学出版社', '胡艳菊');
INSERT INTO `booklist` VALUES ('9787302533734', '高等数学', '数学', '人民教育出版社', '张天德');
INSERT INTO `booklist` VALUES ('9787302533735', '汉字论', '文学', '三联出版社', '子安宣邦');
INSERT INTO `booklist` VALUES ('9787302533736', '逆时针旅行', '文学', '三联出版社', '迈克尔·弗莱恩');
INSERT INTO `booklist` VALUES ('9787302533737', '春秋战国与百家争鸣', '文学', '中华书局出版社', '俞筱尧');
INSERT INTO `booklist` VALUES ('9787302533738', '发现三星堆', '文学', '中华书局出版社', '段渝著');
INSERT INTO `booklist` VALUES ('9787302533739', '北中原', '文学', '作家出版社', '冯杰');
INSERT INTO `booklist` VALUES ('9787302533740', '笑的风', '文学', '作家出版社', '王蒙');
INSERT INTO `booklist` VALUES ('9787302533741', '夜巡', '文学', '长江文艺出版社', '禹风');
INSERT INTO `booklist` VALUES ('9787302533742', '想往火里跳', '文学', '长江文艺出版社', '走走');
INSERT INTO `booklist` VALUES ('9787302533743', '贫穷的本质', '经济', '中信出版社', '阿比吉特·班纳吉、埃斯特·迪弗洛');
INSERT INTO `booklist` VALUES ('9787302533744', '统计学的世界', '数学', '中信出版社', '戴维·穆尔、威廉·诺茨');
INSERT INTO `booklist` VALUES ('9787302533745', '误解的对话', '文学', '新星出版社', '李雪涛');
INSERT INTO `booklist` VALUES ('9787302533746', '星海征程', '科幻', '新星出版社', '北京市科学技术协会');
INSERT INTO `booklist` VALUES ('9787302533747', '孤儿的新年礼物：兰波诗歌集', '文学', '广西师范大学出版社', '阿蒂尔·兰波');
INSERT INTO `booklist` VALUES ('9787302533748', '魔法象·图画书王国 亨利的夜晚', '文学', '广西师范大学出版社', 'D.B.约翰逊');
INSERT INTO `booklist` VALUES ('9787550630970', '中国文学批评散论', '文艺', '凤凰出版社', '刘飞');
INSERT INTO `booklist` VALUES ('9787550634404', '远去的星光', '社科', '凤凰出版社', '李庆');

-- ----------------------------
-- Table structure for borrow
-- ----------------------------
DROP TABLE IF EXISTS `borrow`;
CREATE TABLE `borrow`  (
  `sNumber` varchar(13) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `rNo` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `bNo` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `bdate` date NULL DEFAULT NULL,
  `rdate` date NULL DEFAULT NULL,
  `fine` double NULL DEFAULT NULL,
  `reason` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  INDEX `borrow_book_bNo_fk`(`bNo`) USING BTREE,
  INDEX `borrow_reader_rNo_fk`(`rNo`) USING BTREE,
  CONSTRAINT `borrow_book_bNo_fk` FOREIGN KEY (`bNo`) REFERENCES `book` (`bNo`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `borrow_reader_rNo_fk` FOREIGN KEY (`rNo`) REFERENCES `reader` (`rNo`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of borrow
-- ----------------------------
INSERT INTO `borrow` VALUES ('L202106290933', 'J00001', 'b00001', '2021-06-29', '2021-08-29', 3.1, 'NULL');
INSERT INTO `borrow` VALUES ('L202106290933', 'J00001', 'b00002', '2021-06-29', '2021-08-29', NULL, 'NULL');
INSERT INTO `borrow` VALUES ('L202106290933', 'J00001', 'b00004', '2021-06-29', '2021-09-29', 6.2, '超期');
INSERT INTO `borrow` VALUES ('L202106290933', 'J00001', 'b00007', '2021-06-29', '2021-08-29', NULL, 'NULL');
INSERT INTO `borrow` VALUES ('L202106290933', 'J00001', 'b00009', '2021-06-29', '2021-08-29', NULL, 'NULL');
INSERT INTO `borrow` VALUES ('L202109281012', 'J00005', 'b00001', '2021-06-14', '2021-08-29', NULL, 'NULL');
INSERT INTO `borrow` VALUES ('L202109281020', 'J00002', 'b00002', '2021-09-28', '2021-11-27', 1, 'NULL');
INSERT INTO `borrow` VALUES ('L202109281020', 'J00002', 'b00008', '2021-09-28', '2021-11-27', 0, 'NULL');
INSERT INTO `borrow` VALUES ('L202109281020', 'J00003', 'b00010', '2021-06-25', '2021-07-25', NULL, 'NULL');
INSERT INTO `borrow` VALUES ('L202111260957', 'J00001', 'b00004', '2021-11-26', '2021-11-27', NULL, NULL);
INSERT INTO `borrow` VALUES ('L202111261000', 'J00001', 'b00001', '2021-11-26', '2021-11-27', NULL, NULL);
INSERT INTO `borrow` VALUES ('L202111261001', 'J00001', 'b00017', '2021-11-26', '2021-11-27', NULL, NULL);
INSERT INTO `borrow` VALUES ('L202111261001', 'J00001', 'b00018', '2021-11-26', '2021-11-27', NULL, NULL);
INSERT INTO `borrow` VALUES ('L202111261001', 'J00001', 'b00019', '2021-11-26', '2021-11-27', NULL, NULL);
INSERT INTO `borrow` VALUES ('L202111261001', 'J00001', 'b00020', '2021-11-26', '2021-11-27', NULL, NULL);
INSERT INTO `borrow` VALUES ('L202111261001', 'J00001', 'b00021', '2021-11-26', '2021-11-27', NULL, NULL);
INSERT INTO `borrow` VALUES ('L202111271043', 'J00002', 'b00001', '2021-11-27', '2021-11-27', 1, NULL);
INSERT INTO `borrow` VALUES ('L202111271043', 'J00002', 'b00004', '2021-11-27', '2021-11-27', 1, NULL);
INSERT INTO `borrow` VALUES ('L202111271044', 'J00001', 'b00002', '2021-11-27', '2021-11-27', 0, NULL);
INSERT INTO `borrow` VALUES ('L202111271047', 'J00002', 'b00002', '2021-11-27', '2021-11-27', 1, NULL);
INSERT INTO `borrow` VALUES ('L202111271047', 'J00002', 'b00005', '2021-11-27', '2021-11-27', 1, NULL);
INSERT INTO `borrow` VALUES ('L202111271047', 'J00002', 'b00007', '2021-11-27', '2021-11-27', 1, NULL);
INSERT INTO `borrow` VALUES ('L202111271052', 'J00001', 'b00034', '2021-11-27', '2021-11-27', 0, NULL);
INSERT INTO `borrow` VALUES ('L202111271054', 'J00002', 'b00002', '2021-11-27', '2021-11-27', 1, NULL);
INSERT INTO `borrow` VALUES ('L202111271054', 'J00002', 'b00004', '2021-11-27', '2021-11-27', 1, NULL);
INSERT INTO `borrow` VALUES ('L202111271054', 'J00002', 'b00013', '2021-11-27', '2021-11-27', 0, NULL);
INSERT INTO `borrow` VALUES ('L202111271056', 'J00001', 'b00026', '2021-11-27', NULL, NULL, NULL);
INSERT INTO `borrow` VALUES ('L202111271056', 'J00001', 'b00026', '2021-11-27', NULL, NULL, NULL);
INSERT INTO `borrow` VALUES ('L202111271058', 'J00002', 'b00002', '2021-11-27', '2021-11-27', 0, NULL);
INSERT INTO `borrow` VALUES ('L202111271059', 'J00002', 'b00005', '2021-11-27', '2021-11-27', 0, NULL);
INSERT INTO `borrow` VALUES ('L202111271102', 'J00002', 'b00002', '2021-11-27', '2021-11-27', 0, NULL);
INSERT INTO `borrow` VALUES ('L202111271102', 'J00002', 'b00013', '2021-11-27', '2021-11-27', 0, NULL);
INSERT INTO `borrow` VALUES ('L202111271102', 'J00002', 'b00017', '2021-11-27', '2021-11-27', 0, NULL);
INSERT INTO `borrow` VALUES ('L202111271102', 'J00002', 'b00018', '2021-11-27', '2021-11-27', 0, NULL);
INSERT INTO `borrow` VALUES ('L202111271102', 'J00002', 'b00034', '2021-11-27', '2021-11-27', 0, NULL);
INSERT INTO `borrow` VALUES ('L202111271104', 'J00005', 'b00029', '2021-11-27', '2021-11-27', 0, NULL);
INSERT INTO `borrow` VALUES ('L202111271104', 'J00005', 'b00021', '2021-11-27', '2021-11-27', 0, NULL);
INSERT INTO `borrow` VALUES ('L202111271104', 'J00005', 'b00014', '2021-11-27', '2021-11-27', 0, NULL);
INSERT INTO `borrow` VALUES ('L202111271105', 'J00005', 'b00034', '2021-11-27', '2021-11-27', 0, NULL);
INSERT INTO `borrow` VALUES ('L202111271106', 'J00005', 'b00034', '2021-11-27', '2021-11-27', 0, NULL);
INSERT INTO `borrow` VALUES ('L202111271107', 'J00012', 'b00003', '2021-11-27', '2021-11-27', 0, NULL);
INSERT INTO `borrow` VALUES ('L202111271107', 'J00012', 'b00005', '2021-11-27', '2021-11-27', 0, NULL);
INSERT INTO `borrow` VALUES ('L202111271109', 'J00012', 'b00004', '2021-11-27', '2021-11-27', 0, NULL);
INSERT INTO `borrow` VALUES ('L202111271109', 'J00012', 'b00006', '2021-11-27', '2021-11-27', 0, NULL);
INSERT INTO `borrow` VALUES ('L202111271112', 'J00012', 'b00004', '2021-11-27', '2021-11-27', 0, NULL);
INSERT INTO `borrow` VALUES ('L202111271112', 'J00012', 'b00005', '2021-11-27', '2021-11-27', 0, NULL);
INSERT INTO `borrow` VALUES ('L202111271112', 'J00012', 'b00006', '2021-11-27', '2021-11-27', 0, NULL);
INSERT INTO `borrow` VALUES ('L202111271112', 'J00012', 'b00031', '2021-11-27', NULL, NULL, NULL);
INSERT INTO `borrow` VALUES ('L202111271112', 'J00012', 'b00032', '2021-11-27', NULL, NULL, NULL);
INSERT INTO `borrow` VALUES ('L202111271112', 'J00012', 'b00030', '2021-11-27', NULL, NULL, NULL);
INSERT INTO `borrow` VALUES ('L202111271112', 'J00012', 'b00028', '2021-11-27', NULL, NULL, NULL);
INSERT INTO `borrow` VALUES ('L202111271113', 'J00016', 'b00003', '2021-11-27', NULL, NULL, NULL);
INSERT INTO `borrow` VALUES ('L202111271113', 'J00016', 'b00005', '2021-11-27', '2021-11-27', 0, NULL);
INSERT INTO `borrow` VALUES ('L202111271113', 'J00016', 'b00006', '2021-11-27', '2021-11-27', 1, NULL);
INSERT INTO `borrow` VALUES ('L202111271117', 'J00011', 'b00004', '2021-11-27', '2021-11-27', 1, NULL);
INSERT INTO `borrow` VALUES ('L202111271117', 'J00011', 'b00002', '2021-11-27', '2021-11-27', 1, NULL);
INSERT INTO `borrow` VALUES ('L202111271117', 'J00011', 'b00005', '2021-11-27', '2021-11-27', 0, NULL);
INSERT INTO `borrow` VALUES ('L202111271117', 'J00011', 'b00014', '2021-11-27', '2021-11-27', 0, NULL);
INSERT INTO `borrow` VALUES ('L202111271118', 'J00011', 'b00015', '2021-11-27', '2021-11-27', 0, NULL);
INSERT INTO `borrow` VALUES ('L202111271118', 'J00011', 'b00026', '2021-11-27', '2021-11-27', 0, NULL);

-- ----------------------------
-- Table structure for lendroom
-- ----------------------------
DROP TABLE IF EXISTS `lendroom`;
CREATE TABLE `lendroom`  (
  `lNo` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `phone` char(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `nums` int NULL DEFAULT 0,
  PRIMARY KEY (`lNo`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '借阅室' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of lendroom
-- ----------------------------
INSERT INTO `lendroom` VALUES ('301-1-1', '15825411452', 4);
INSERT INTO `lendroom` VALUES ('301-1-2', '14555451245', 0);
INSERT INTO `lendroom` VALUES ('301-1-3', '12444512896', 0);
INSERT INTO `lendroom` VALUES ('301-2-1', '14451422214', 2);
INSERT INTO `lendroom` VALUES ('301-2-2', '11254412547', 0);
INSERT INTO `lendroom` VALUES ('301-2-3', '22541225412', 0);
INSERT INTO `lendroom` VALUES ('301-3-1', '11454785412', 1);
INSERT INTO `lendroom` VALUES ('301-3-2', '12547896321', 0);
INSERT INTO `lendroom` VALUES ('301-3-3', '14444114411', 0);
INSERT INTO `lendroom` VALUES ('301-4-1', '11111111111', 0);
INSERT INTO `lendroom` VALUES ('301-4-2', '22222222222', 3);
INSERT INTO `lendroom` VALUES ('301-4-3', '33333333333', 0);

-- ----------------------------
-- Table structure for public
-- ----------------------------
DROP TABLE IF EXISTS `public`;
CREATE TABLE `public`  (
  `pName` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `telegraph` int NULL DEFAULT NULL,
  `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `zip` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `address` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`pName`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '出版社' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of public
-- ----------------------------
INSERT INTO `public` VALUES ('三联出版社', NULL, '555555', '342304', '北京市东城区美术馆东街22号');
INSERT INTO `public` VALUES ('中信出版社', NULL, '999999', '342308', '北京朝阳区新源南路六号京城大厦');
INSERT INTO `public` VALUES ('中华书局出版社', NULL, '666666', '342305', '北京市东城区朝阳门内大街甲55号');
INSERT INTO `public` VALUES ('人民教育出版社', NULL, '111111', '342300', '北京市海淀区中关村南大街17号院1号楼');
INSERT INTO `public` VALUES ('人民文学出版社', NULL, '454545', '342313', '北京市朝内大街166号');
INSERT INTO `public` VALUES ('作家出版社', NULL, '777777', '100125', '北京市朝阳区农展馆南里10号');
INSERT INTO `public` VALUES ('凤凰出版社', NULL, '232323', '342311', '南京市中央路165号');
INSERT INTO `public` VALUES ('广西师范大学出版社', NULL, '121212', '342310', '北京市东城区灯市口大街33号12层1207');
INSERT INTO `public` VALUES ('新星出版社', NULL, '333333', '342309', '北京市西城区车公庄大街丙3-1');
INSERT INTO `public` VALUES ('清华大学出版社', NULL, '010-62770175', '100084', '清华大学东门外学研大厦B座6层');
INSERT INTO `public` VALUES ('电子工业出版社', NULL, '343434', '342312', '北京市万寿路南口金家村288号华信大厦');
INSERT INTO `public` VALUES ('长江文艺出版社', NULL, '888888', '342307', '武汉市武昌区雄楚大街268号湖北出版文化城');
INSERT INTO `public` VALUES ('高等教育出版社', NULL, '222222', '100029', '北京市朝阳区惠新东街4号富盛大厦1座22层');

-- ----------------------------
-- Table structure for reader
-- ----------------------------
DROP TABLE IF EXISTS `reader`;
CREATE TABLE `reader`  (
  `rNo` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `rIdcard` char(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `rName` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `rSex` char(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `rBirthday` date NULL DEFAULT NULL,
  `rTel` char(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `enabled` int NULL DEFAULT NULL,
  `category` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`rNo`) USING BTREE,
  UNIQUE INDEX `reader_rIdcard_uindex`(`rIdcard`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '读者表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of reader
-- ----------------------------
INSERT INTO `reader` VALUES ('J00001', '360101200109020934', '刘晨', '女', '2001-09-02', '18189039843', NULL, '教师');
INSERT INTO `reader` VALUES ('J00002', '360101200212020943', '王敏', '男', '2002-12-02', '18932424564', NULL, '学生');
INSERT INTO `reader` VALUES ('J00003', '360101201904020944', '李勇', '男', '2019-04-02', '18979324738', NULL, '学生');
INSERT INTO `reader` VALUES ('J00004', '360101201904020945', '罗达', '男', '2018-12-12', '18979324738', NULL, '教师');
INSERT INTO `reader` VALUES ('J00005', '360101201904020946', '小明', '女', '2015-11-11', '13954121245', NULL, '学生');
INSERT INTO `reader` VALUES ('J00006', '360101201904020947', '宗庭舟', '男', '2010-11-10', '15807529242', NULL, '学生');
INSERT INTO `reader` VALUES ('J00007', '360102199003079297', '经俭泓', '男', '2021-11-01', '18768272534', NULL, '教师');
INSERT INTO `reader` VALUES ('J00008', '360102199003071441', '井霁月', '女', '2021-11-01', '18259544908', NULL, '学生');
INSERT INTO `reader` VALUES ('J00009', '360102199003078614', '韩芬灵', '女', '2021-11-01', '15961681932', NULL, '学生');
INSERT INTO `reader` VALUES ('J00010', '360102199003072837', '程玮连', '男', '2013-11-06', '19820988447', NULL, '学生');
INSERT INTO `reader` VALUES ('J00011', '360102199003073776', '解果玫', '男', '2016-11-09', '15261803649', NULL, '学生');
INSERT INTO `reader` VALUES ('J00012', '360102199003072714', '宋理羿', '女', '2004-11-11', '18307107324', NULL, '学生');
INSERT INTO `reader` VALUES ('J00013', '360102199003078497', '潘旺杉', '男', '2002-11-07', '18895657401', NULL, '教师');
INSERT INTO `reader` VALUES ('J00014', '360102199003071455', '滕学昀', '男', '1995-11-09', '17803083029', NULL, '学生');
INSERT INTO `reader` VALUES ('J00015', '360102199003075878', '幸朵菲', '女', '2006-11-08', '18275544422', NULL, '学生');
INSERT INTO `reader` VALUES ('J00016', '360102199003072853', '高涓椒', '女', '2009-11-12', '13963447659', NULL, '学生');
INSERT INTO `reader` VALUES ('J00017', '36010219900307391X', '舒丽丽', '女', '2008-06-18', '15924138774', NULL, '学生');
INSERT INTO `reader` VALUES ('J00018', '360102199003074293', '晏潜宽', '男', '2013-05-09', '19817678784', NULL, '学生');
INSERT INTO `reader` VALUES ('J00019', '360102199003076176', '巫风凡', '女', '2007-02-13', '13726271120', NULL, '教师');
INSERT INTO `reader` VALUES ('J00020', '360102199003077777', '嵇杉崧', '男', '2008-01-16', '14790665362', NULL, '教师');
INSERT INTO `reader` VALUES ('J00021', '360102199003073354', '穆运渤', '男', '2010-07-07', '14747571952', NULL, '教师');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `enabled` int NULL DEFAULT 1 COMMENT '用户状态1-激活中0-已注销 -1管理员',
  `registeredTime` datetime NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '注册时间',
  `type` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `user_id_uindex`(`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 33 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (0, 'root', 'root', -1, '2021-11-19 17:19:06', '管理员');
INSERT INTO `user` VALUES (1, '刘晨', '123456', 1, '2021-11-19 17:19:06', '读者');
INSERT INTO `user` VALUES (2, '王敏', '111111', 1, '2021-11-19 17:19:06', '读者');
INSERT INTO `user` VALUES (3, '李勇', '114412', 1, '2021-11-19 17:19:06', '读者');
INSERT INTO `user` VALUES (4, '罗达', '112233', 1, '2021-11-19 17:19:06', '读者');
INSERT INTO `user` VALUES (5, '小明', '125412', 1, '2021-11-19 17:19:06', '读者');
INSERT INTO `user` VALUES (6, '宗庭舟', '222222', 1, '2021-11-25 09:11:22', '读者');
INSERT INTO `user` VALUES (7, '经俭泓', '255241', 1, '2021-11-25 09:11:22', '读者');
INSERT INTO `user` VALUES (8, '井霁月', '112145', 1, '2021-11-25 09:11:22', '读者');
INSERT INTO `user` VALUES (9, '韩芬灵', '444544', 1, '2021-11-25 09:11:22', '读者');
INSERT INTO `user` VALUES (10, '程玮连', '114412', 1, '2021-11-25 09:11:22', '读者');
INSERT INTO `user` VALUES (11, '解果玫', '778541', 1, '2021-11-25 09:11:22', '读者');
INSERT INTO `user` VALUES (12, '宋理羿', '998562', 1, '2021-11-25 09:11:22', '读者');
INSERT INTO `user` VALUES (13, '潘旺杉', '445786', 1, '2021-11-25 09:11:22', '读者');
INSERT INTO `user` VALUES (14, '滕学昀', '444778', 1, '2021-11-25 09:11:22', '读者');
INSERT INTO `user` VALUES (15, '幸朵菲', '114552', 1, '2021-11-25 09:11:22', '读者');
INSERT INTO `user` VALUES (16, '高涓椒', '111111', 1, '2021-11-25 09:11:22', '读者');
INSERT INTO `user` VALUES (17, '舒丽丽', '222222', 1, '2021-11-25 09:11:22', '读者');
INSERT INTO `user` VALUES (18, '晏潜宽', '333333', 1, '2021-11-25 09:11:22', '读者');
INSERT INTO `user` VALUES (19, '巫风凡', '444444', 1, '2021-11-25 09:11:22', '读者');
INSERT INTO `user` VALUES (20, '嵇杉崧', '555555', 1, '2021-11-25 09:11:22', '读者');
INSERT INTO `user` VALUES (21, '穆运渤', '777777', 1, '2021-11-25 09:11:22', '读者');

SET FOREIGN_KEY_CHECKS = 1;
