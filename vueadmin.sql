/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50729
Source Host           : localhost:3306
Source Database       : vueadmin

Target Server Type    : MYSQL
Target Server Version : 50729
File Encoding         : 65001

Date: 2022-01-16 21:06:35
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for feature
-- ----------------------------
DROP TABLE IF EXISTS `feature`;
CREATE TABLE `feature` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `leave_id` int(11) NOT NULL,
  `type` varchar(30) DEFAULT NULL,
  `property_type` int(2) DEFAULT NULL,
  `property_ratio` double(12,0) DEFAULT NULL,
  `property_linewidthratio` double DEFAULT NULL,
  `geometry_type` varchar(30) DEFAULT NULL,
  `geometry_coordinates` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of feature
-- ----------------------------
INSERT INTO `feature` VALUES ('1', '1', 'Feature', '0', '0', '1', 'LineString', '114.604703,36.650070');
INSERT INTO `feature` VALUES ('2', '1', 'Feature', '0', '0', '1', 'LineString', '116.405285,39.904989');
INSERT INTO `feature` VALUES ('3', '1', 'Feature', '0', '0', '1', 'LineString', '117.190182,39.125596');
INSERT INTO `feature` VALUES ('4', '1', 'Feature', '0', '0', '1', 'LineString', '121.472644,31.231706');
INSERT INTO `feature` VALUES ('5', '1', 'Feature', '0', '0', '1', 'LineString', '114.884091,40.811901');
INSERT INTO `feature` VALUES ('6', '2', 'Feature', '0', '0', '1', 'LineString', '113.746262,23,046237');
INSERT INTO `feature` VALUES ('7', '2', 'Feature', '0', '0', '1', 'LineString', '104.065735,30.659462');
INSERT INTO `feature` VALUES ('8', '3', 'Feature', '0', '0', '1', 'LineString', '114.502461,38.045474');
INSERT INTO `feature` VALUES ('9', '4', 'Feature', '0', '0', '1', 'LineString', '118.175393,39.635113');
INSERT INTO `feature` VALUES ('10', '4', 'Feature', '0', '0', '1', 'LineString', '118.767413,32.041544');
INSERT INTO `feature` VALUES ('11', '5', 'Feature', '0', '0', '1', 'LineString', '120.153576,30.287459');
INSERT INTO `feature` VALUES ('12', '6', 'Feature', '0', '0', '1', 'LineString', '116.857461,38.310582');
INSERT INTO `feature` VALUES ('13', '7', 'Feature', '0', '0', '1', 'LineString', '117.939152,40.976204');
INSERT INTO `feature` VALUES ('14', '7', 'Feature', '0', '0', '1', 'LineString', '116.405285,36.612273');
INSERT INTO `feature` VALUES ('15', '7', 'Feature', '0', '0', '1', 'LineString', '113.665412,34.757975');
INSERT INTO `feature` VALUES ('16', '8', 'Feature', '0', '0', '1', 'LineString', '114.085947,22.547000');
INSERT INTO `feature` VALUES ('17', '8', 'Feature', '0', '0', '1', 'LineString', '120.619585,31.299379');
INSERT INTO `feature` VALUES ('18', '8', 'Feature', '0', '0', '1', 'LineString', '108.948024,34.263161');
INSERT INTO `feature` VALUES ('19', '9', 'Feature', '0', '0', '1', 'LineString', '117.000923,36.675807');
INSERT INTO `feature` VALUES ('20', '8', 'Feature', '0', '0', '1', 'LineString', '114.508851,37.068200');
INSERT INTO `feature` VALUES ('21', '8', 'Feature', '0', '0', '1', 'LineString', '115.665993,37.735097');
INSERT INTO `feature` VALUES ('22', '9', 'Feature', '0', '0', '1', 'LineString', '120.355173,36.082982');
INSERT INTO `feature` VALUES ('23', '9', 'Feature', '0', '0', '1', 'LineString', '116.307428,37.453968');
INSERT INTO `feature` VALUES ('24', '10', 'Feature', '0', '0', '1', 'LineString', '115.469381,35.246531');
INSERT INTO `feature` VALUES ('25', '11', 'Feature', '0', '0', '1', 'LineString', '117.283042,31.86119');
INSERT INTO `feature` VALUES ('26', '13', 'Feature', '0', '0', '1', 'LineString', '112.434468,34.663041');
INSERT INTO `feature` VALUES ('27', '12', 'Feature', '0', '0', '1', 'LineString', '115.980367,36.456013');
INSERT INTO `feature` VALUES ('28', '13', 'Feature', '0', '0', '1', 'LineString', '121.549792,29.868388');
INSERT INTO `feature` VALUES ('29', '13', 'Feature', '0', '0', '1', 'LineString', '113.883991,35.302616');
INSERT INTO `feature` VALUES ('30', '14', 'Feature', '0', '0', '1', 'LineString', '113.295259,40.090310');
INSERT INTO `feature` VALUES ('31', '15', 'Feature', '0', '0', '1', 'LineString', '116.587245,35.415393');
INSERT INTO `feature` VALUES ('32', '67', 'Feature', '0', '0', '1', 'LineString', '114.492897,36.636410');
INSERT INTO `feature` VALUES ('33', '68', 'Feature', '0', '0', '1', 'LineString', '116.838834,38.304477');

-- ----------------------------
-- Table structure for leave
-- ----------------------------
DROP TABLE IF EXISTS `leave`;
CREATE TABLE `leave` (
  `id` int(15) NOT NULL AUTO_INCREMENT,
  `student_id` int(15) NOT NULL,
  `startdate` varchar(60) DEFAULT NULL,
  `enddate` varchar(60) DEFAULT NULL,
  `isleave` varchar(5) DEFAULT NULL,
  `destination` varchar(255) DEFAULT NULL,
  `reason` varchar(30) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `evidence` varchar(10) DEFAULT NULL,
  `statues` varchar(10) DEFAULT NULL,
  `examine` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of leave
-- ----------------------------
INSERT INTO `leave` VALUES ('1', '190310110', '2021-09-01 19:37:00', '2021-09-01 21:00:00', 'true', '河北省邯郸市丛台区', '生病', '无', 'false', '已出校', '未审批');
INSERT INTO `leave` VALUES ('2', '190310110', '2021-09-01 21:00:00', '2021-09-01 24:00:00', 'true', '河北省邯郸市丛台区', '生病', '无', 'false', '已出校', '已审批');
INSERT INTO `leave` VALUES ('3', '190310110', '2021-11-25 23:00:00', '2021-11-25 23:44:00', 'true', '河北省邯郸市丛台区', '生病', '无', 'false', '已出校', '已审批');
INSERT INTO `leave` VALUES ('4', '190310110', '2021-11-25 11:00:00', '2021-11-25 19:00:00', 'true', '山东省泰安市东平县', '生病', '无', 'true', '已出校', '已审批');
INSERT INTO `leave` VALUES ('5', '190310110', '2021-11-25 02:00:00', '2021-11-25 11:00:00', 'true', '河北省邯郸市丛台区', null, null, null, '未出校', '未审批');
INSERT INTO `leave` VALUES ('6', '190310110', '2021-11-27 18:45:00', '2021-11-27 19:00:00', 'true', '河北省邯郸市丛台区', null, null, null, '未出校', '已拒绝');
INSERT INTO `leave` VALUES ('8', '190000000', '2021-12-24 20:23:00', '2021-12-25 16:00:00', null, '河北省邯郸市丛台区', null, null, null, null, null);
INSERT INTO `leave` VALUES ('9', '190000000', '2021-12-24 20:23:00', '2021-12-25 16:00:00', null, '河北省邯郸市丛台区', null, null, null, null, null);
INSERT INTO `leave` VALUES ('10', '190000001', '2021-12-25 20:23:00', '2021-12-25 23:00:00', null, '河北省保定市易县紫荆关镇', null, null, null, null, null);
INSERT INTO `leave` VALUES ('11', '190000002', '2021-12-25 20:23:00', '2021-12-25 23:00:00', null, '河北省保定市易县紫荆关镇', null, null, null, null, null);
INSERT INTO `leave` VALUES ('12', '190000003', '2021-12-25 01:23:00', '2021-12-25 08:00:00', null, '河北省保定市易县紫荆关镇', null, null, null, null, null);
INSERT INTO `leave` VALUES ('13', '190000002', '2021-12-25 02:23:00', '2021-12-25 08:00:00', null, '河北省邯郸市丛台区', null, null, null, null, null);
INSERT INTO `leave` VALUES ('14', '190000002', '2021-12-25 02:23:00', '2021-12-25 08:00:00', null, '河北省保定市易县紫荆关镇', null, null, null, null, null);
INSERT INTO `leave` VALUES ('15', '190000002', '2021-12-25 02:23:00', '2021-12-25 08:00:00', null, '河北省邯郸市丛台区', null, null, null, null, null);
INSERT INTO `leave` VALUES ('16', '190000003', '2021-12-25 03:23:00', '2021-12-25 08:00:00', null, '河北省邯郸市丛台区', null, null, null, null, null);
INSERT INTO `leave` VALUES ('17', '190000004', '2021-12-25 04:23:00', '2021-12-25 08:00:00', null, '北京市海淀区', null, null, null, null, null);
INSERT INTO `leave` VALUES ('18', '190000005', '2021-12-25 05:23:00', '2021-12-25 08:00:00', null, '河北省邯郸市邯山区', null, null, null, null, null);
INSERT INTO `leave` VALUES ('19', '190000002', '2021-12-25 06:23:00', '2021-12-25 08:00:00', null, '河北省邯郸市邯山区', null, null, null, null, null);
INSERT INTO `leave` VALUES ('20', '190000006', '2021-12-26 08:23:00', '2021-12-26 12:00:00', null, '河北省邯郸市复兴区', null, null, null, null, null);
INSERT INTO `leave` VALUES ('21', '190000007', '2021-12-27 08:23:00', '2021-12-27 12:00:00', null, '北京市海淀区', null, null, null, null, null);
INSERT INTO `leave` VALUES ('22', '190000008', '2021-12-28 08:23:00', '2021-12-28 12:00:00', null, '河北省邯郸市复兴区', null, null, null, null, null);
INSERT INTO `leave` VALUES ('23', '190000009', '2021-12-29 08:23:00', '2021-12-29 12:00:00', null, '河北省邯郸市邯山区', null, null, null, null, null);
INSERT INTO `leave` VALUES ('24', '190000010', '2021-12-29 09:23:00', '2021-12-29 12:00:00', null, '河北省邯郸市邯山区', null, null, null, null, null);
INSERT INTO `leave` VALUES ('25', '190000011', '2021-12-30 09:23:00', '2021-12-30 12:00:00', null, '河北省邯郸市复兴区', null, null, null, null, null);
INSERT INTO `leave` VALUES ('26', '190000012', '2021-12-31 09:23:00', '2021-12-31 12:00:00', null, '河北省邯郸市复兴区', null, null, null, null, null);
INSERT INTO `leave` VALUES ('27', '190000013', '2021-12-31 09:23:00', '2021-12-31 12:00:00', null, '河北省邯郸市邯山区', null, null, null, null, null);
INSERT INTO `leave` VALUES ('28', '190000014', '2021-12-31 09:23:00', '2021-12-31 12:00:00', null, '河北省邯郸市复兴区', null, null, null, null, null);
INSERT INTO `leave` VALUES ('29', '190000015', '2021-12-31 10:23:00', '2021-12-31 12:00:00', null, '河北省邯郸市邯山区', null, null, null, null, null);
INSERT INTO `leave` VALUES ('30', '190000016', '2021-12-31 10:23:00', '2021-12-31 12:00:00', null, '河北省邯郸市邯山区', null, null, null, null, null);
INSERT INTO `leave` VALUES ('31', '190000017', '2021-12-31 11:23:00', '2021-12-31 21:00:00', null, '河北省邯郸市复兴区', null, null, null, null, null);
INSERT INTO `leave` VALUES ('32', '190000018', '2021-12-31 12:23:00', '2021-12-31 21:00:00', null, '河北省邯郸市邯山区', null, null, null, null, null);
INSERT INTO `leave` VALUES ('33', '190000019', '2021-12-31 13:23:00', '2021-12-31 21:00:00', null, '河北省邯郸市邯山区', null, null, null, null, null);
INSERT INTO `leave` VALUES ('34', '190000020', '2021-12-31 14:23:00', '2021-12-31 21:00:00', null, '河北省邯郸市邯山区', null, null, null, null, null);
INSERT INTO `leave` VALUES ('35', '190000020', '2021-12-31 15:23:00', '2021-12-31 21:00:00', null, '北京市海淀区', null, null, null, null, null);
INSERT INTO `leave` VALUES ('36', '190000020', '2021-12-31 16:23:00', '2021-12-31 21:00:00', null, '河北省邯郸市邯山区', null, null, null, null, null);
INSERT INTO `leave` VALUES ('37', '190000020', '2021-12-31 17:23:00', '2021-12-31 21:00:00', null, '北京市海淀区', null, null, null, null, null);
INSERT INTO `leave` VALUES ('38', '190000020', '2021-12-31 18:23:00', '2021-12-31 20:00:00', null, '河北省邯郸市邯山区', null, null, null, null, null);
INSERT INTO `leave` VALUES ('39', '190000020', '2021-12-31 19:23:00', '2021-12-31 22:00:00', null, '河北省邯郸市复兴区', null, null, null, null, null);
INSERT INTO `leave` VALUES ('40', '190000020', '2021-12-31 20:23:00', '2021-12-31 23:00:00', null, '河北省邯郸市邯山区', null, null, null, null, null);
INSERT INTO `leave` VALUES ('41', '190310110', '2021-11-31 11:00:00', '2021-11-31 19:00:00', 'true', '山东省泰安市东平县', '生病', '无', 'true', '已出校', '已审批');
INSERT INTO `leave` VALUES ('42', '190000020', '2021-12-08 11:00:00', '2021-12-08 14:00:00', null, '河北省保定市竞秀区', null, null, null, null, null);
INSERT INTO `leave` VALUES ('43', '190000020', '2021-12-08 11:00:00', '2021-12-08 14:00:00', null, '北京市海淀区', null, null, null, null, null);
INSERT INTO `leave` VALUES ('44', '190000020', '2021-12-08 11:00:00', '2021-12-08 14:00:00', null, '北京市海淀区', null, null, null, null, null);
INSERT INTO `leave` VALUES ('45', '190000021', '2021-12-09 11:00:00', '2021-12-09 14:00:00', null, '北京市海淀区', null, null, null, null, null);
INSERT INTO `leave` VALUES ('46', '190000021', '2021-12-08 11:00:00', '2021-12-08 14:00:00', null, '北京市海淀区', null, null, null, null, null);
INSERT INTO `leave` VALUES ('47', '190000022', '2021-12-09 11:00:00', '2021-12-09 14:00:00', null, '天津市河东区', null, null, null, null, null);
INSERT INTO `leave` VALUES ('48', '190000022', '2021-12-10 11:00:00', '2021-12-10 14:00:00', null, '山东省济南市', null, null, null, null, null);
INSERT INTO `leave` VALUES ('49', '190000024', '2021-12-11 11:00:00', '2021-12-11 14:00:00', null, '山东省济南市', null, null, null, null, null);
INSERT INTO `leave` VALUES ('50', '190000025', '2021-12-12 11:00:00', '2021-12-12 14:00:00', null, '山东省济南市', null, null, null, null, null);
INSERT INTO `leave` VALUES ('55', '190310110', '2021-09-01 19:00:00', '2021-09-01 19:00:00', '是', '中国河北省保定市易县', '无', '无', '有', '已归校', '未审批');
INSERT INTO `leave` VALUES ('56', '190310110', '2021-09-09 00:00:00', '2021-10-26 00:00:00', '是', '中国河北省保定市易县', '无', '家里有事', '有', '未出校', '已审批');
INSERT INTO `leave` VALUES ('57', '190310110', '2021-09-17 00:00:00', '2021-10-29 00:00:00', '是', '无', '无', '急需一种急支糖浆', '无', '已出校', '未审批');
INSERT INTO `leave` VALUES ('58', '190310110', '2021-09-01 19:00:00', '2021-09-01 19:00:00', null, '无', '无', '无', null, null, '未审批');
INSERT INTO `leave` VALUES ('59', '192030725', null, null, null, '中国河北省保定市易县', '无', '无', null, null, '未审批');
INSERT INTO `leave` VALUES ('60', '192030725', null, null, null, '中国河北省保定市易县', '无', '无', null, null, '未审批');
INSERT INTO `leave` VALUES ('61', '192030725', null, null, null, '中国河北省邯郸市', '无', '无', null, null, '未审批');
INSERT INTO `leave` VALUES ('62', '192030722', '2020-02-01 19:00:00', '2020-02-01 20:00:00', null, '中国河北省邯郸市', '无', '无', null, null, '未审批');
INSERT INTO `leave` VALUES ('65', '190310110', '2021-12-08 11:00:00', '2021-12-08 11:00:00', null, '河北省邯郸市丛台', '无', '无', null, null, '未审批');
INSERT INTO `leave` VALUES ('66', '190310110', '2021-12-08 11:00:00', '2021-12-08 11:00:00', null, '河北省邯郸市丛台', '无', '无', null, null, '未审批');
INSERT INTO `leave` VALUES ('67', '190310110', null, null, null, '河北省邯郸市丛台', '无', '无', null, null, '未审批');
INSERT INTO `leave` VALUES ('68', '192030726', '2021-12-01 00:00:00', '2022-01-03 00:00:00', null, '中国河北省沧州市', '生病', '无', null, null, '未审批');

-- ----------------------------
-- Table structure for position
-- ----------------------------
DROP TABLE IF EXISTS `position`;
CREATE TABLE `position` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `province` varchar(30) DEFAULT NULL,
  `city` varchar(30) DEFAULT NULL,
  `district` varchar(30) DEFAULT NULL,
  `township` varchar(30) DEFAULT NULL,
  `longitude` varchar(12) DEFAULT NULL,
  `laitude` varchar(12) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of position
-- ----------------------------

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(15) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  `grade` varchar(30) DEFAULT NULL,
  `sex` varchar(5) DEFAULT NULL,
  `college` varchar(50) DEFAULT NULL,
  `phone` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=192030727 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('190310110', '袁坤', '软件1902', '男', '信息与电气工程学院', '17631566271');
INSERT INTO `student` VALUES ('192030704', '黄海', '软件1902', '男', '信息与电气工程学院', '12345678900');
INSERT INTO `student` VALUES ('192030722', '史树汗', '软件1902', '男', '信息与电气工程学院', '12345678900');
INSERT INTO `student` VALUES ('192030725', '尹睿智', '软件1901', '男', '信息与电气工程学院', '12345678901');
INSERT INTO `student` VALUES ('192030726', '小明', '软件1901', '男', '机械与装备学院', '12345678901');

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父菜单ID，一级菜单为0',
  `name` varchar(64) NOT NULL,
  `path` varchar(255) DEFAULT NULL COMMENT '菜单URL',
  `perms` varchar(255) DEFAULT NULL COMMENT '授权(多个用逗号分隔，如：user:list,user:create)',
  `component` varchar(255) DEFAULT NULL,
  `type` int(5) NOT NULL COMMENT '类型     0：目录   1：菜单   2：按钮',
  `icon` varchar(32) DEFAULT NULL COMMENT '菜单图标',
  `orderNum` int(11) DEFAULT NULL COMMENT '排序',
  `created` datetime NOT NULL,
  `updated` datetime DEFAULT NULL,
  `statu` int(5) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('1', '0', '系统管理', '', 'sys:manage', '', '0', 'el-icon-s-operation', '1', '2021-01-15 18:58:18', '2021-01-15 18:58:20', '1');
INSERT INTO `sys_menu` VALUES ('2', '1', '用户管理', '/home/user', 'sys:user:list', 'sys/User', '1', 'el-icon-s-custom', '1', '2021-01-15 19:03:45', '2021-08-02 11:34:17', '1');
INSERT INTO `sys_menu` VALUES ('3', '1', '角色管理', '/home/role', 'sys:role:list', 'sys/Role', '1', 'el-icon-rank', '2', '2021-01-15 19:03:45', '2021-01-15 19:03:48', '1');
INSERT INTO `sys_menu` VALUES ('4', '1', '菜单管理', '/home/menu', 'sys:menu:list', 'sys/Menu', '1', 'el-icon-menu', '3', '2021-01-15 19:03:45', '2021-01-15 19:03:48', '1');
INSERT INTO `sys_menu` VALUES ('6', '5', '数字字典', '/home/dict', 'sys:dict:list', 'sys/Dict', '1', 'el-icon-s-order', '1', '2021-01-15 19:07:18', '2021-01-18 16:32:13', '1');
INSERT INTO `sys_menu` VALUES ('7', '3', '添加角色', '', 'sys:role:save', '', '2', '', '1', '2021-01-15 23:02:25', '2021-01-17 21:53:14', '0');
INSERT INTO `sys_menu` VALUES ('9', '2', '添加用户', null, 'sys:user:save', null, '2', null, '1', '2021-01-17 21:48:32', null, '1');
INSERT INTO `sys_menu` VALUES ('10', '2', '修改用户', null, 'sys:user:update', null, '2', null, '2', '2021-01-17 21:49:03', '2021-01-17 21:53:04', '1');
INSERT INTO `sys_menu` VALUES ('11', '2', '删除用户', null, 'sys:user:delete', null, '2', null, '3', '2021-01-17 21:49:21', null, '1');
INSERT INTO `sys_menu` VALUES ('12', '2', '分配角色', null, 'sys:user:role', null, '2', null, '4', '2021-01-17 21:49:58', null, '1');
INSERT INTO `sys_menu` VALUES ('13', '2', '重置密码', null, 'sys:user:repass', null, '2', null, '5', '2021-01-17 21:50:36', null, '1');
INSERT INTO `sys_menu` VALUES ('14', '3', '修改角色', null, 'sys:role:update', null, '2', null, '2', '2021-01-17 21:51:14', null, '1');
INSERT INTO `sys_menu` VALUES ('15', '3', '删除角色', null, 'sys:role:delete', null, '2', null, '3', '2021-01-17 21:51:39', null, '1');
INSERT INTO `sys_menu` VALUES ('16', '3', '分配权限', null, 'sys:role:perm', null, '2', null, '5', '2021-01-17 21:52:02', null, '1');
INSERT INTO `sys_menu` VALUES ('17', '4', '添加菜单', null, 'sys:menu:save', null, '2', null, '1', '2021-01-17 21:53:53', '2021-01-17 21:55:28', '1');
INSERT INTO `sys_menu` VALUES ('18', '4', '修改菜单', null, 'sys:menu:update', null, '2', null, '2', '2021-01-17 21:56:12', null, '1');
INSERT INTO `sys_menu` VALUES ('19', '4', '删除菜单', null, 'sys:menu:delete', null, '2', null, '3', '2021-01-17 21:56:36', null, '1');
INSERT INTO `sys_menu` VALUES ('20', '0', '数据管理', '', 'data:manage', null, '0', 'el-icon-pie-chart', '1', '2021-12-01 20:54:52', '2021-12-01 20:54:55', '1');
INSERT INTO `sys_menu` VALUES ('21', '20', '近一周情况', '/data/lastweek', 'data:lastweek:list', 'dataView/LastWeek', '1', 'el-icon-date', '2', '2021-12-01 21:00:52', '2021-12-01 21:00:55', '1');
INSERT INTO `sys_menu` VALUES ('22', '20', '今日流动', '/data/today', 'data:today:list', 'dataView/Today', '1', 'el-icon-data-board', '1', '2021-12-01 21:04:22', '2021-12-01 21:04:25', '1');
INSERT INTO `sys_menu` VALUES ('23', '0', '流动管理', null, 'stream:manage', null, '0', 'el-icon-notebook-1', '1', '2021-12-07 16:27:44', '2021-12-07 16:27:47', '1');
INSERT INTO `sys_menu` VALUES ('24', '23', '审批管理', '/stream/outschool', 'stream:manage:outschool:examine', 'streamManage/OutSchool', '1', 'el-icon-tickets', '1', '2021-12-07 16:29:06', '2021-12-07 16:29:08', '1');
INSERT INTO `sys_menu` VALUES ('25', '23', '学生管理', '/stream/student', 'stream:manage:student', 'streamManage/Student', '1', 'el-icon-school', '2', '2021-12-07 16:31:49', '2021-12-07 16:31:51', '1');
INSERT INTO `sys_menu` VALUES ('26', '24', '修改审批', null, 'stream:manage:outschool:examine:updata', null, '2', '', '1', '2021-12-19 13:19:32', '2021-12-19 13:19:35', '1');
INSERT INTO `sys_menu` VALUES ('27', '25', '请假申请', null, 'stream:manage:outschool:examine:save', null, '2', null, null, '2021-12-29 16:38:45', '2021-12-29 16:38:47', '1');
INSERT INTO `sys_menu` VALUES ('28', '25', '新增学生', null, 'stream:manage:student:save', null, '2', null, null, '2021-12-29 16:40:50', '2021-12-29 16:40:52', '1');
INSERT INTO `sys_menu` VALUES ('29', '25', '删除学生', null, 'stream:manage:student:delete', null, '2', null, null, '2021-12-29 16:41:41', '2021-12-29 16:41:43', '1');
INSERT INTO `sys_menu` VALUES ('30', '25', '修改学生', null, 'stream:manage:student:update', null, '2', null, null, '2021-12-29 16:42:56', '2021-12-29 16:42:57', '1');
INSERT INTO `sys_menu` VALUES ('31', '24', '删除记录', '', 'stream:manage:outschool:examine:delete', '', '2', null, '1', '2021-12-30 14:21:54', '2021-12-30 14:21:54', '1');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) NOT NULL,
  `code` varchar(64) NOT NULL,
  `remark` varchar(64) DEFAULT NULL COMMENT '备注',
  `created` datetime DEFAULT NULL,
  `updated` datetime DEFAULT NULL,
  `statu` int(5) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`) USING BTREE,
  UNIQUE KEY `code` (`code`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('3', '用户', 'normal', '一般用户', null, null, '1');
INSERT INTO `sys_role` VALUES ('6', '超级管理员', 'admin', '系统默认最高权限，不可以编辑和任意修改', '2021-01-16 13:29:03', '2021-01-17 15:50:45', '1');

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `RoleId` bigint(20) NOT NULL,
  `MenuId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=125 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES ('60', '6', '1');
INSERT INTO `sys_role_menu` VALUES ('61', '6', '2');
INSERT INTO `sys_role_menu` VALUES ('62', '6', '9');
INSERT INTO `sys_role_menu` VALUES ('63', '6', '10');
INSERT INTO `sys_role_menu` VALUES ('64', '6', '11');
INSERT INTO `sys_role_menu` VALUES ('65', '6', '12');
INSERT INTO `sys_role_menu` VALUES ('66', '6', '13');
INSERT INTO `sys_role_menu` VALUES ('67', '6', '3');
INSERT INTO `sys_role_menu` VALUES ('68', '6', '7');
INSERT INTO `sys_role_menu` VALUES ('69', '6', '14');
INSERT INTO `sys_role_menu` VALUES ('70', '6', '15');
INSERT INTO `sys_role_menu` VALUES ('71', '6', '16');
INSERT INTO `sys_role_menu` VALUES ('72', '6', '4');
INSERT INTO `sys_role_menu` VALUES ('73', '6', '17');
INSERT INTO `sys_role_menu` VALUES ('74', '6', '18');
INSERT INTO `sys_role_menu` VALUES ('75', '6', '19');
INSERT INTO `sys_role_menu` VALUES ('76', '6', '5');
INSERT INTO `sys_role_menu` VALUES ('77', '6', '6');
INSERT INTO `sys_role_menu` VALUES ('96', '3', '1');
INSERT INTO `sys_role_menu` VALUES ('97', '3', '2');
INSERT INTO `sys_role_menu` VALUES ('98', '3', '3');
INSERT INTO `sys_role_menu` VALUES ('99', '3', '4');
INSERT INTO `sys_role_menu` VALUES ('102', '6', '20');
INSERT INTO `sys_role_menu` VALUES ('103', '6', '21');
INSERT INTO `sys_role_menu` VALUES ('104', '6', '22');
INSERT INTO `sys_role_menu` VALUES ('105', '6', '23');
INSERT INTO `sys_role_menu` VALUES ('106', '6', '24');
INSERT INTO `sys_role_menu` VALUES ('107', '6', '25');
INSERT INTO `sys_role_menu` VALUES ('108', '6', '26');
INSERT INTO `sys_role_menu` VALUES ('109', '6', '27');
INSERT INTO `sys_role_menu` VALUES ('110', '6', '28');
INSERT INTO `sys_role_menu` VALUES ('111', '6', '29');
INSERT INTO `sys_role_menu` VALUES ('112', '6', '30');
INSERT INTO `sys_role_menu` VALUES ('119', '6', '31');
INSERT INTO `sys_role_menu` VALUES ('120', '8', '1');
INSERT INTO `sys_role_menu` VALUES ('121', '8', '20');
INSERT INTO `sys_role_menu` VALUES ('122', '8', '21');
INSERT INTO `sys_role_menu` VALUES ('123', '3', '20');
INSERT INTO `sys_role_menu` VALUES ('124', '3', '25');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(64) DEFAULT NULL,
  `password` varchar(64) DEFAULT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  `email` varchar(64) DEFAULT NULL,
  `city` varchar(64) DEFAULT NULL,
  `created` datetime DEFAULT NULL,
  `updated` datetime DEFAULT NULL,
  `lastlogin` datetime DEFAULT NULL,
  `statu` int(5) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_USERNAME` (`username`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin', '$2a$10$ySf6rshYKmFDlyIK3uJabus0Ob9xDxtxfY9Qg1UH1IHNQ7tCrbv5S', '', '123@qq.com', '广州', '2021-01-12 22:13:53', '2021-01-16 16:57:32', '2020-12-30 08:38:37', '1');
INSERT INTO `sys_user` VALUES ('5', 'yuankun1', '$2a$10$d/rnA5B8FwLWPvOiQbF3w.QI.gvzVZwcpsDVD0rRvPgOv2ySl0rLa', null, '574131075@qq.com', '邯郸', '2021-08-04 17:31:29', '2021-12-15 16:36:44', null, '1');
INSERT INTO `sys_user` VALUES ('6', 'test', '$2a$10$lKJ1PY/rpAm/wdY12ds7Neq7IzkrYNEBC3NUfijVBTcO1t2O7kLj6', null, '574131075@qq.com', '邯郸', '2021-12-19 13:34:49', '2021-12-19 13:34:49', null, '1');
INSERT INTO `sys_user` VALUES ('7', 'xiaoming', '$2a$10$zuGupZUaTzIsRHzAxp.4F.zGcUK888dvPaS9uDTzO4byUFdfJawLW', null, '1234', '邯郸', '2021-12-29 17:40:11', '2021-12-29 17:40:11', null, '1');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('4', '1', '6');
INSERT INTO `sys_user_role` VALUES ('7', '1', '3');
INSERT INTO `sys_user_role` VALUES ('8', '6', '3');
INSERT INTO `sys_user_role` VALUES ('10', '5', '3');
