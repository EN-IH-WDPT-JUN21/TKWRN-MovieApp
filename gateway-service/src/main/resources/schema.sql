DROP TABLE if exists user;


CREATE TABLE `user` (
    `id` BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    `username` VARCHAR(255),
    `password` VARCHAR(255),
    `role` VARCHAR(255)
);

