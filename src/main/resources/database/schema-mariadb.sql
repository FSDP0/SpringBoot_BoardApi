-- Create Database
CREATE DATABASE IF NOT EXISTS boards;

CREATE DATABASE IF NOT EXISTS users;

-- Create board table on boards database
CREATE TABLE IF NOT EXISTS boards.board (
    board_id BIGINT NOT NULL AUTO_INCREMENT,
    board_title VARCHAR(50) NOT NULL,
    board_author VARCHAR(30) NOT NULL,
    board_content VARCHAR(200) NULL,
    created_date DATETIME NOT NULL,
    modified_date DATETIME NULL,
    PRIMARY KEY (board_id)
);

-- Create user table on users database
CREATE TABLE IF NOT EXISTS users.user (
    id BIGINT NOT NULL AUTO_INCREMENT,
    user_id VARCHAR(50) NOT NULL,
    user_name VARCHAR(50) NOT NULL,
    user_password VARCHAR(50) NOT NULL,
    user_tel VARCHAR(50) NOT NULL,
    user_address VARCHAR(100) NOT NULL,
    created_date DATETIME NOT NULL,
    modified_date DATETIME NULL,
    PRIMARY KEY (id, user_id),
    UNIQUE KEY (user_id)
);

CREATE TABLE IF NOT EXISTS users.user_address (
    user_id VARCHAR(50) NOT NULL,
    user_address VARCHAR(100) NOT NULL,
    user_zipcode VARCHAR(30) NOT NULL,
    PRIMARY KEY(user_id),
    FOREIGN KEY(user_id) REFERENCES user (user_id)
);