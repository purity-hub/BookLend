
# 1、设计目的

1. 掌握数据库系统的基本概念、关系数据库的基本理论、SQL语言及数据库编程，掌握数据库设计方法。
2. 能够合理组织数据，有效存储和处理数据，掌握关系数理论，正确设计和评价关系数据库模式，掌握关系查询处理和优化技术，为数据库应用系统提供高效率性能打下基础。
3. 掌握数据库管理系统的基本知识和数据库系统的设计方法，熟悉数据库恢复技术和并发控制技术，掌握保证数据库安全性和实现完整性约束的方法。

# 2、任务背景
## 2.1、需求
**简单学校在线图书借阅管理系统**要求提供下述服务：
该系统分为三个模块：
### 1)	用户管理模块
该子模块中主要包括用户和借阅室的管理：
①　系统中有管理员和读者两类用户，用户有登录用户和密码可以登录系统，不同的用户有不同的权限，管理员可以管理书籍，包括书籍入库，对图书进行管理，读者用户可以根据需求查询书籍、借书情况等功能。
②　每个借阅室有多个图书管理员管理，每个图书管理员可以负责管理多个借阅室。借阅室有借阅室编号、电话、库存量等信息等。
③　读者中分为学生读者和教师读者，不同类型读者借阅时限不一样。学生借阅期限为2个月，教师借阅期限为3个月。学生读者办理学生证时要记录登记身份证号、姓名、性别、出生年月日，所在学院。教师办理借阅证要登记身份证、姓名、出生年月、所在部门等信息。
### 2)	图书入库管理模块：
该模块主要涉及到图书信息，借阅室管理以及图书在借阅室的存放等关系。
④　对所有图书进行编目，每一书目包括ISBN号、书名、类别、出版社、作者、排名， 其中一部书可以有多名作者，每名作者有唯一的一个排名；
⑤　对每本图书进行编号，包括书号、ISBN号、破损情况、存放位置和定价，其中每一本书有唯一的编号，相同ISBN号的书集中存放，有相同的存储位置，相同ISBN号的书或因不同印刷批次而定价不同；
### 3)	读者借阅模块
该模块主要包括图书，读者以及读者借书情况：
⑥　读者可以查找自己借阅状态，书库里有的书籍可以借走，可随时查阅书籍的借还情况，包括借书人单位、姓名、借书证号、借书日期和还书日期。每位读者可以借多本书，每本书可以被多次借阅。（读者：书籍m:n）每个读者拥有唯一借书号。
⑦　读者借书时如果存在未还的书籍并且超出借书数量或者有罚款没有交清的不能借书。
⑧　读者还书时，要登记还书日期，如果超出借书时长，要缴纳相应的罚款；如果所还图书由借书者在持有期间造成破损，也要进行登记并进行相应的罚款处罚。
### 4)	图书采购管理（可选模块）
⑨　可通过出版社的名称、电报编号、电话、邮编及地址等信息增购有关书籍。一个出版社可出版多种书籍，同一本书仅为一个出版社出版，(出版社：书籍1：m)出版社名具有唯一性。
根据以上情况找出该系统中涉及的所有实体、实体的属性及实体间的各种联系。各个模块并不是相互独立的，有些实体数据是共享的。
# 3、设计任务
## 3.1、功能模块图
![在这里插入图片描述](https://img-blog.csdnimg.cn/fe5b3216ad1948a19c83099c3ffb16fb.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAcHVyaXR5LWdvb2Q=,size_20,color_FFFFFF,t_70,g_se,x_16)

## 3.2、用例图
![在这里插入图片描述](https://img-blog.csdnimg.cn/198cadfb94df46e5932a4d46917273a4.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAcHVyaXR5LWdvb2Q=,size_20,color_FFFFFF,t_70,g_se,x_16)

## 3.3、数据流图(顶层)
![在这里插入图片描述](https://img-blog.csdnimg.cn/a2198b5112554ae7a48ee7397cd7b621.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAcHVyaXR5LWdvb2Q=,size_20,color_FFFFFF,t_70,g_se,x_16)
## 3.4、E-R图
![在这里插入图片描述](https://img-blog.csdnimg.cn/a0f6b19de5394e46b661696fbff3712c.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAcHVyaXR5LWdvb2Q=,size_20,color_FFFFFF,t_70,g_se,x_16)

# 4、关系模式

- 用户(id,姓名,密码,注册时间,类型)
- 读者(读者编号,身份证,姓名,性别,生日,电话,类型)
- 管理员(姓名,性别,电话)
- 出版社(出版社名,电报编号,电话,邮编,地址)
- 借阅室(室名,电话,图书数量)
- 书目(ISBN号,书名,类别,出版社,作者,排名)
- 图书(书号,ISBN号,破损情况,存放位置,数量,定价)
- 借阅(借书人单位,姓名,借书证号,借书日期,还书日期,罚款,破损情况)

# 5、MYSQL语句

```sql
DROP TABLE IF EXISTS `administrator`;
CREATE TABLE `administrator`  (
  `name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `sex` int NULL DEFAULT NULL,
  `phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '管理员' ROW_FORMAT = Dynamic;

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

DROP TABLE IF EXISTS `booklist`;
CREATE TABLE `booklist`  (
  `ISBN` varchar(13) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `bName` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `bClass` varchar(14) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `bPublic` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `bAuthor` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`ISBN`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '书目' ROW_FORMAT = Dynamic;

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

DROP TABLE IF EXISTS `lendroom`;
CREATE TABLE `lendroom`  (
  `lNo` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `phone` char(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `nums` int NULL DEFAULT 0,
  PRIMARY KEY (`lNo`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '借阅室' ROW_FORMAT = Dynamic;

DROP TABLE IF EXISTS `public`;
CREATE TABLE `public`  (
  `pName` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `telegraph` int NULL DEFAULT NULL,
  `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `zip` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `address` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`pName`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '出版社' ROW_FORMAT = Dynamic;

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

```
IDEA生成图：
![在这里插入图片描述](https://img-blog.csdnimg.cn/f432f59f1c434d959b6a1832f5d4685c.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAcHVyaXR5LWdvb2Q=,size_20,color_FFFFFF,t_70,g_se,x_16)
# 6、部分页面截图

![在这里插入图片描述](https://img-blog.csdnimg.cn/f0e64d9a1579465e88974f336a03704b.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAcHVyaXR5LWdvb2Q=,size_20,color_FFFFFF,t_70,g_se,x_16)
![在这里插入图片描述](https://img-blog.csdnimg.cn/b981ab851b4c435facdffbf61da596e5.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAcHVyaXR5LWdvb2Q=,size_20,color_FFFFFF,t_70,g_se,x_16)
![在这里插入图片描述](https://img-blog.csdnimg.cn/7d977c88c0bd424e828f9ff7ee5ecd0a.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAcHVyaXR5LWdvb2Q=,size_20,color_FFFFFF,t_70,g_se,x_16)
![在这里插入图片描述](https://img-blog.csdnimg.cn/35ff0de71d4540ab98feba9cd9a63b97.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAcHVyaXR5LWdvb2Q=,size_20,color_FFFFFF,t_70,g_se,x_16)
# 7、项目代码
[gitee点击跳转BookLend](https://gitee.com/luo-hongyun/book-lend.git)

项目所用技术:springboot,mybatis,javafx
