-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(255) DEFAULT NULL,
  `lastname` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user`(`firstname`,`lastname`,`username`) VALUES (null, null, 'suemi994');
INSERT INTO `user`(`firstname`,`lastname`,`username`) VALUES (null, null, 'aaa');
INSERT INTO `user`(`firstname`,`lastname`,`username`) VALUES (null, null, 'aaa');
INSERT INTO `user`(`firstname`,`lastname`,`username`) VALUES (null, null, 'aa');
INSERT INTO `user`(`firstname`,`lastname`,`username`) VALUES (null, null, 'aa');
INSERT INTO `user`(`firstname`,`lastname`,`username`) VALUES (null, null, '111999');
