/*
 Navicat Premium Data Transfer

 Source Server         : 121.41.19.236
 Source Server Type    : MySQL
 Source Server Version : 50719
 Source Host           : 121.41.19.236:3306
 Source Schema         : groovy

 Target Server Type    : MySQL
 Target Server Version : 50719
 File Encoding         : 65001

 Date: 10/11/2020 11:12:38
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_groovy_rule
-- ----------------------------
DROP TABLE IF EXISTS `tb_groovy_rule`;
CREATE TABLE `tb_groovy_rule` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `name` varchar(64) CHARACTER SET utf8mb4 NOT NULL COMMENT '规则名称',
  `rule` text CHARACTER SET utf8mb4 NOT NULL COMMENT '规则内容',
  `status` bit(1) NOT NULL DEFAULT b'1' COMMENT '状态(0:禁用 1:启用)',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `idx_name` (`name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC COMMENT='groovy规则表';

-- ----------------------------
-- Records of tb_groovy_rule
-- ----------------------------
BEGIN;
INSERT INTO `tb_groovy_rule` VALUES (6, '2020-11-10 10:18:02', '2020-11-10 11:11:19', 'test', 'package com.aeert.groovy.service.impl;\n\nimport com.aeert.groovy.common.utils.SpringUtils;\nimport com.aeert.groovy.service.GroovyRuleService;\nimport com.aeert.groovy.service.IRule;\n\n/**\n * @Author l\'amour solitaire\n * @Description DbRule\n * @Date 2020/11/10 上午11:10\n **/\npublic class DbRule implements IRule {\n\n    @Override\n    public int getType() {\n        return GROOVY_DB_TYPE;\n    }\n\n    @Override\n    public String printInfo(String parm) {\n        System.out.println(\"hahahahahahahha\");\n        return SpringUtils.getBean(GroovyRuleService.class).getByName(parm).getRule();\n    }\n}\n', b'1');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
