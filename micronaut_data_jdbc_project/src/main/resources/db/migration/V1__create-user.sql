DROP TABLE IF EXISTS user;

CREATE TABLE user (
    id bigint auto_increment,
    name varchar(255) DEFAULT NULL,
    city varchar(255) DEFAULT NULL,
    state varchar(255) DEFAULT NULL,
    email varchar(255) DEFAULT NULL,
    country varchar(255) DEFAULT NULL,
    pincode varchar(255) DEFAULT NULL,
    PRIMARY KEY(id)
);