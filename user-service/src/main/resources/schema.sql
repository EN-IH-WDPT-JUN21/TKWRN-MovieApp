DROP TABLE if exists user;


CREATE TABLE `user` (
    `id` BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    `username` VARCHAR(255),
    `email` VARCHAR(255),
    `password` VARCHAR(255),
    `user_type` VARCHAR(255)
);

